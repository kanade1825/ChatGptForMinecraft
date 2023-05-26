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

        //MineSkinのTexture Signatureってとこ（上から三番目）をコピー
        String signeture = "SqT+PiUp7yIcHBqLYqC1eJjhF1GovAwYVOE0uyJ5/Mk91Za/sUoFhdJOR2tBGnRg1QWbSSk9++KhbHZbLu5M0urue6ubn0wXdmY/eCG+80u8Lt982LniqpBQaNDAngNMZRTA47dVwHifBUkHKG7uNCqP+yr2fGSnzosBo36y6XfBPmDgMy3yXZn/e1u8rFjLUvkxQ2W07xX+TMvYOBGRz95GM3DZ4CPXX3WRlwBNh2n4QxjWdNAjqZYjUwKSNVpP0jtrRsihI6JF/JXi2f9GQ9Gm30jaab6pkQWvaqUx0xFbt9aSuNhnsvfVfXQ46cq3bEWXJ+Li5CDc+dMY6YKABSWy3xlDE1H70hr9lEFUvH/WoARgggicj483Jd894r6+RSz6/c3KTl/8sqWR7i4OQeCYzEL/4nHg4PO4EthegY8cGHShlqftdESvc38Lf1ZCGjDgls/WGVZ3wFdUspjrk8y6Bk0DVi0AaF6IvzrU2brdwv9KjJyOvSTQlL9tvVYMspin9OtotGgPLjHOEO/3KxaJLazL61PXYCSKraivpKV3Kmf03h3QbmwZHUIKM9Oxr8aPoH4nRXbo03UihsffvvAigzLt2xgXXL3lydre6LgNHva75peXM4F+R8zSM9TpTlBbO9Zl17ztnirQAYVh6jX/DMRUIa22zsRRFvMEMRo=";
        //一番上に表示されてる名前をコピー
        String skinname = "kanade1825";
        //Texture Valueってやつ（上から二番目のやつ）をコピー
        String data = "ewogICJ0aW1lc3RhbXAiIDogMTY4NTAyMDg3MjQ2OCwKICAicHJvZmlsZUlkIiA6ICI5OTRlY2JmMzdlM2U0NzcwOTc4YmMyMTQ4NTRmYTcwOSIsCiAgInByb2ZpbGVOYW1lIiA6ICJrYW5hZGUxODI1IiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2YyYjNlOWEyM2JlZDMxNWU3OTQwMWFkMGM3OWY2YmU1YTcyYTkyOTQ5NWU5MjczNTRmMjE2MmMwZGU5ZjNjODkiLAogICAgICAibWV0YWRhdGEiIDogewogICAgICAgICJtb2RlbCIgOiAic2xpbSIKICAgICAgfQogICAgfQogIH0KfQ==";
        SkinTrait.setSkinPersistent(skinname, signeture, data);

        // NPCをプレイヤーの位置にスポーンさせる
        npc.spawn(location);
        player.sendMessage("NPCが出現しました。");

        return true;
    }
}
