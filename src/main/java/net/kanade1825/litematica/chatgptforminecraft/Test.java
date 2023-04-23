package net.kanade1825.litematica.chatgptforminecraft;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Test implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {


        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("greetings.json")) {
            // JSONファイルの読み込み
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            // "greeting" の値を取得
            String greeting = (String) jsonObject.get("greeting");

            // 結果を出力
            commandSender.sendMessage(greeting);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }








        return false;
    }
}
