package net.kanade1825.litematica.chatgptforminecraft;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class GetTalkFile implements CommandExecutor {
    private final ChatGPTForMinecraft chatGptForMinecraft;

    public GetTalkFile(ChatGPTForMinecraft chatGptForMinecraft) {
        this.chatGptForMinecraft = chatGptForMinecraft;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, String[] strings) {

        //非同期
        Bukkit.getScheduler().runTaskAsynchronously(chatGptForMinecraft, () -> {
            try {
                if (strings.length != 1) {
                    commandSender.sendMessage("Please Character name!");
                    return;
                }

                String characternamae = strings[0];


                URL url = new URL(ChatGPTForMinecraft.Server_URL);
                HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
                httpCon.setDoOutput(true);
                httpCon.setRequestMethod("GET");
                httpCon.setRequestProperty("Content-Type", "application/json; utf-8");
                httpCon.setRequestProperty("Accept", "application/json");

                InputStream in = httpCon.getInputStream();

                String directory = "plugins/ChatGPTForMinecraft/TalkData/"; // Specify the relative directory to save the JSON file
                String fileName = characternamae + "TalkData.json"; // Specify the file name for the received JSON file
                File receivedFile = new File(directory + fileName);

                int responseCode = httpCon.getResponseCode();

                Files.copy(in, receivedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                commandSender.sendMessage("JSONファイルを受信しました: " + directory + fileName);
                commandSender.sendMessage("ResponseCode" + responseCode);

                // Notify the player about the received JSON file
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return true;
    }
}
