package net.kanade1825.litematica.chatgptforminecraft;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SetUP implements CommandExecutor {

    private final ChatGPTForMinecraft chatGPTForMinecraft;

    public SetUP(ChatGPTForMinecraft chatGPTForMinecraft) {
        this.chatGPTForMinecraft = chatGPTForMinecraft;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Bukkit.getScheduler().runTaskAsynchronously(chatGPTForMinecraft, () -> {

            Path path = Paths.get("plugins/ChatGPTForMinecraft/TalkData");

            Path path1 = Paths.get("plugins/ChatGPTForMinecraft/CharacterData");

            try {
                if (!Files.exists(path)) {
                    Files.createDirectories(path);
                    commandSender.sendMessage("Directory created at " + path);
                } else {
                    commandSender.sendMessage("Directory already exists at " + path);
                }
            } catch (IOException e) {
                commandSender.sendMessage("Unable to create directory at " + path);
                e.printStackTrace();
            }

            try {
                if (!Files.exists(path1)) {
                    Files.createDirectories(path1);
                    commandSender.sendMessage("Directory created at " + path1);
                } else {
                    commandSender.sendMessage("Directory already exists at " + path1);
                }
            } catch (IOException e) {
                commandSender.sendMessage("Unable to create directory at " + path1);
                e.printStackTrace();
            }

            String[] filenames = {
                    "EllisTalkData.json",
                    "MarshierTalkData.json",
                    "MiraiTalkData.json",
                    "RaisersTalkData.json",
                    "RasvaanTalkData.json",
                    "RinaTalkData.json",
                    "WagnerTalkData.json"
            };

            for (String filename : filenames) {
                try {
                    // ファイルパスを作成
                    File file = new File(path.toFile(), filename);

                    // ディレクトリが存在しない場合は作成

                    file.mkdirs();

                    // FileWriterオブジェクトを作成して空のJSONファイルを生成
                    FileWriter fileWriter = new FileWriter(file);

                    // 空のJSONオブジェクトを書き込み
                    fileWriter.write("{}");

                    // ファイルを閉じる
                    fileWriter.close();

                    commandSender.sendMessage(filename + " was created.");

                } catch (IOException e) {
                    commandSender.sendMessage("An error occurred while creating " + filename);
                    e.printStackTrace();
                }
            }


        });


        return false;
    }
}
