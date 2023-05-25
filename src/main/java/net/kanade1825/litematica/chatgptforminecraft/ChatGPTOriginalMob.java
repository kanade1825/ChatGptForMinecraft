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

public class ChatGPTOriginalMob implements CommandExecutor {
    private final String skinname = "ewogICJ0aW1lc3RhbXAiIDogMTY4NTAxMzI0NTQ2NiwKICAicHJvZmlsZUlkIiA6ICIzY2YzYjgzNzhkYjc0ZDZlYmIxMDFjMDYzZmQ1MjVjNyIsCiAgInByb2ZpbGVOYW1lIiA6ICJSeW9yaTE2IiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzJhYTRhNzIyNmQ4YjNkZWE1YTY0M2ZkYTVhODZhYmI3MDA2YWIzYmQ4ZjJmMzFjOWI2Y2RjMTI1NGNiYWVhZTkiLAogICAgICAibWV0YWRhdGEiIDogewogICAgICAgICJtb2RlbCIgOiAic2xpbSIKICAgICAgfQogICAgfQogIH0KfQ==" ;
    private final String signeture = "lWmvfpJapo8zBRSwfmQJgULn1yiCy38sbPdlNMLex9XglixTrHoGPI1+ntispziDTmHPdGWhWGLI0aM9BtnL8F/YCsZYrFySLXI1umycFL9aIJJHrGK46Af3mfsZRFaR7YTUN0E+DTXlASY+fshrshCOU3cIA+4DYQ3nl5kYv5ux4QMC78Yt3KylCS+kbw8oaUl42++d9lK6/EqWeJd4RMsfijbh/p+q4LdpfCDZ1qdN/CC2ZJkxXzwfwFde7cs3KVj40SlUlilC3U6CMPEU9+n5hiO3TGGxoYejOQQ8iybkvdJYxXAo8cY4UtjW5/cnalvWXEoRK5RA/bhhFJoYzd6pft+S9axhhTsYbb/b4XUAKnEWIw54A0q1WFwUMxj2w5IGqLjFGDtRrO5mUiy9TQsJNHT7eXP+CFxDuYwUX5RKMhhMbP/jg1E/xbCQvNBXQHIjQ9yOLOtTBrGSb2FweKBM7XNXDSEqRc87w314jYXrUMk0jihQxyrMWzd1bMbjkOhV6fgPv0zv3ZINXTiFB89UPW2/XJowLvR158xX5YscZCf/fGI3oMyCeNI6/13W2qfKIDwDp4AgrifqzlBkEcTSoyR6lmCVzdWhWpe5m+IYOl00bpjb5ZqPDf4o5yljfOA6f4eu5kl0+S2Mrb24oDraD0xEXniu9/IK0o2/twk=" ;
    private final String data =  "http://textures.minecraft.net/texture/2aa4a7226d8b3dea5a643fda5a86abb7006ab3bd8f2f31c9b6cdc1254cbaeae9";




    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("プレイヤーからのみ実行可能です。");
            return false;
        }

        String npcname = args[0];

        //プレイヤーの位置を取得
        Player player = (Player) sender;
        Location location = player.getLocation();

        // CitizensAPIを使用してNPCを作成する
        var npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, npcname);
        var SkinTrait =  npc.getOrAddTrait(SkinTrait.class);

        SkinTrait.setSkinPersistent(skinname,signeture,data);

        // NPCをプレイヤーの位置にスポーンさせる
        npc.spawn(location);
        player.sendMessage("NPCが出現しました。");

        return true;
    }
}
