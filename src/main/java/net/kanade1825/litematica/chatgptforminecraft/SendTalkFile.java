package net.kanade1825.litematica.chatgptforminecraft;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SendTalkFile extends JavaPlugin implements CommandExecutor {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 8001;


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        new BukkitRunnable() {
            @Override
            public void run() {
                try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
                     InputStream input = socket.getInputStream();
                     OutputStream output = socket.getOutputStream()) {

                    getLogger().info("サーバーに接続しました: " + socket.getRemoteSocketAddress());

                    boolean success = false;
                    int retryCount = 0;

                    while (!success && retryCount < 5) {
                        success = sendJsonFile(output, input);

                        if (!success) {
                            getLogger().info("再送を試みます...");
                            retryCount++;
                            Thread.sleep(3000);
                        }
                    }

                    if (success) {
                        getLogger().info("JSONファイルの送信に成功しました");
                    } else {
                        getLogger().info("JSONファイルの送信に失敗しました");
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.runTaskAsynchronously(this);

        return true;
    }

    private boolean sendJsonFile(OutputStream output, InputStream input) throws IOException {
        Path jsonFilePath = Paths.get("H:\\ChatGPTForMinecraftClientSide\\src\\main\\resources\\talk.json");
        byte[] fileData = Files.readAllBytes(jsonFilePath);

        if (fileData.length > 0) {
            output.write(fileData);
            output.flush();
            getLogger().info("JSONファイルをサーバーに送信: " + jsonFilePath);

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String serverResponse = reader.readLine();

            if ("SUCCESS".equals(serverResponse)) {
                return true;
            } else if ("EMPTY_DATA_RECEIVED".equals(serverResponse)) {
                getLogger().info("サーバーが空のデータを受信しました");
            } else {
                getLogger().info("サーバーから予期しない応答がありました: " + serverResponse);
            }
        } else {
            getLogger().info("空のJSONファイルが検出されました: " + jsonFilePath);
        }

        return false;
    }
}
