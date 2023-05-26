package net.kanade1825.litematica.chatgptforminecraft;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.trait.SkinTrait;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

import org.json.JSONObject;

public class ChatGPTOriginalMob implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("プレイヤーからのみ実行可能です。");
            return false;
        }

        String npcname = args[0];

        String jsonFilePath = "plugins/ChatGPTForMinecraft/CharacterData/SkinData/"+ npcname + "SkinData.json";  // Assume the JSON file path is passed as the second argument

        // Read the JSON file and get the skin data
        String data = "";
        String skinname = "";
        String signeture = "";
        try {
            String content = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            JSONObject json = new JSONObject(content);
            data = json.getString("TextureValue");
            skinname = json.getString("SkinName");
            signeture = json.getString("Signeture");
        } catch (IOException e) {
            e.printStackTrace();
            sender.sendMessage("ファイルの読み込みに失敗しました。");
            return false;
        }

        //プレイヤーの位置を取得
        Player player = (Player) sender;
        Location location = player.getLocation();

        // CitizensAPIを使用してNPCを作成する
        var npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, npcname);
        var SkinTrait =  npc.getOrAddTrait(SkinTrait.class);

        SkinTrait.setSkinPersistent(skinname, signeture, data);

        // NPCをプレイヤーの位置にスポーンさせる
        npc.spawn(location);
        player.sendMessage("NPCが出現しました。");

        return true;
    }
}
