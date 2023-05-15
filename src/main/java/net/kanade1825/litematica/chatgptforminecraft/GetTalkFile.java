package net.kanade1825.litematica.chatgptforminecraft;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class GetTalkFile implements CommandExecutor {
    private final ChatGPTForMinecraft chatGptForMinecraft;
    private static final String SERVER_URL = "http://localhost:8080/json";

    public GetTalkFile(ChatGPTForMinecraft chatGptForMinecraft) {
        this.chatGptForMinecraft = chatGptForMinecraft;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        //非同期
        Bukkit.getScheduler().runTaskAsynchronously(chatGptForMinecraft,() -> {
            try {
                URL url = new URL(SERVER_URL);
                HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
                httpCon.setDoOutput(true);
                httpCon.setRequestMethod("GET");
                httpCon.setRequestProperty("Content-Type", "application/json; utf-8");
                httpCon.setRequestProperty("Accept", "application/json");

                InputStream in = httpCon.getInputStream();

                String directory = "H:\\paper1.19.3\\"; // Specify the relative directory to save the JSON file
                String fileName = "TalkData.json"; // Specify the file name for the received JSON file
                File receivedFile = new File(directory + fileName);

                Files.copy(in, receivedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                commandSender.sendMessage("JSONファイルを受信しました: " + directory + fileName);

                // Notify the player about the received JSON file
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return true;
    }
}
