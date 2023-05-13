package net.kanade1825.litematica.chatgptforminecraft;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class SendTalkFile implements CommandExecutor {
    private final ChatGPTForMinecraft chatGptForMinecraft;
    private static final String SERVER_URL = "http://localhost:8080/json";

    public SendTalkFile(ChatGPTForMinecraft chatGptForMinecraft) {
        this.chatGptForMinecraft = chatGptForMinecraft;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        new BukkitRunnable() {
            @Override
            public void run() {
                String fileName = "TalkData.json"; // 送信するJSONファイル名を指定
                File file = new File(fileName);
                if (!file.exists() || file.length() == 0) {
                    commandSender.sendMessage("送信するJSONファイルが存在しないか、空です: " + fileName);
                    return;
                }

                try {
                    String jsonString = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
                    URL url = new URL(SERVER_URL);
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

                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Notify the player about the sent JSON file
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        commandSender.sendMessage("JSONファイルを送信しました: " + fileName);
                    }
                }.runTask(chatGptForMinecraft);

            }
        }.runTaskAsynchronously(chatGptForMinecraft);

        return true;
    }
}
