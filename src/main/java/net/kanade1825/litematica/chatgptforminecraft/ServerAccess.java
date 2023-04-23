package net.kanade1825.litematica.chatgptforminecraft;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.*;
import java.net.Socket;

public class ServerAccess implements CommandExecutor {
    private final ChatGPTForMinecraft chatGptForMinecraft;
    private static final String SERVER_NAME = "localhost";
    private static final int PORT = 8001;

    public ServerAccess(ChatGPTForMinecraft chatGptForMinecraft) {
        this.chatGptForMinecraft = chatGptForMinecraft;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        new BukkitRunnable() {
            @Override
            public void run() {
                try (Socket clientSocket = new Socket(SERVER_NAME, PORT);
                     BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter writer = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true)
                ) {
                    String request = "Hello, Server!";
                    writer.println(request);

                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    // レスポンスをプレイヤーに送信
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            commandSender.sendMessage("Server Response: " + response.toString());
                        }
                    }.runTask(chatGptForMinecraft);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.runTaskAsynchronously(chatGptForMinecraft);

        return true;
    }
}
