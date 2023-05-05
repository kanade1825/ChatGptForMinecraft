package net.kanade1825.litematica.chatgptforminecraft;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.*;
import java.net.Socket;

public class GetTalkFile implements CommandExecutor {
    private final ChatGPTForMinecraft chatGptForMinecraft;
    private static final String SERVER_NAME = "localhost";
    private static final int PORT = 8001;

    public GetTalkFile(ChatGPTForMinecraft chatGptForMinecraft) {
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

                    // Save the received JSON file to a specified relative directory
                    String directory = "H:\\paper1.19.3\\"; // Specify the relative directory to save the JSON file
                    String fileName = "TalkData.json"; // Specify the file name for the received JSON file
                    File receivedFile = new File(directory + fileName);
                    try (FileOutputStream fos = new FileOutputStream(receivedFile)) {
                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        InputStream input = clientSocket.getInputStream();

                        while ((bytesRead = input.read(buffer)) != -1) {
                            fos.write(buffer, 0, bytesRead);
                        }
                    }

                    // Notify the player about the received JSON file
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            commandSender.sendMessage("JSONファイルを受信しました: " + directory + fileName);
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
