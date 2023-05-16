package net.kanade1825.litematica.chatgptforminecraft;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ChatGPTOriginalMob implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("プレイヤーからのみ実行可能です。");
            return false;
        }
        else if (args.length != 1){
            sender.sendMessage("Please NPCname!");
            return false;
        }




        String npcname = args[0];

        //プレイヤーの位置を取得
        Player player = (Player) sender;
        Location location = player.getLocation();

        // CitizensAPIを使用してNPCを作成する
        NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, npcname);

        // NPCをプレイヤーの位置にスポーンさせる
        npc.spawn(location);
        player.sendMessage("NPCが出現しました。");

        return false;
    }
}
