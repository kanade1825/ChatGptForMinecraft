package net.kanade1825.litematica.chatgptforminecraft;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class SendTalkFile implements CommandExecutor {
    private final ChatGPTForMinecraft chatGptForMinecraft;


    public SendTalkFile(ChatGPTForMinecraft chatGptForMinecraft) {
        this.chatGptForMinecraft = chatGptForMinecraft;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Bukkit.getScheduler().runTaskAsynchronously(chatGptForMinecraft,() -> {

            String fileName = "TalkData.json"; // 送信するJSONファイル名を指定
            File file = new File(fileName);
            if (!file.exists() || file.length() == 0) {
                commandSender.sendMessage("送信するJSONファイルが存在しないか、空です: " + fileName);
                return;
            }

            try {
                String jsonString = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
                URL url = new URL(ChatGPTForMinecraft.Server_URL);
                HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
                httpCon.setDoOutput(true);
                httpCon.setRequestMethod("POST");
                httpCon.setRequestProperty("Content-Type", "application/json; utf-8");
                httpCon.setRequestProperty("Accept", "application/json");


                try (OutputStream os = httpCon.getOutputStream()) {
                    byte[] input = jsonString.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }

                int responseCode = httpCon.getResponseCode();
                commandSender.sendMessage("Response Code: " + responseCode);
                commandSender.sendMessage("JSONファイルを送信しました: " + fileName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return true;
    }
}
