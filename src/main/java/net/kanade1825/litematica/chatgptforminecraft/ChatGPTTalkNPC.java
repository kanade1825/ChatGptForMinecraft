package net.kanade1825.litematica.chatgptforminecraft;

import com.lilittlecat.chatgpt.offical.ChatGPT;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ChatGPTTalkNPC implements Listener {
    private ChatGPT chatGPT ;
    ChatGPTForMinecraft plugin = new ChatGPTForMinecraft();




    @EventHandler
    public boolean onNPCRightClick(NPCRightClickEvent event) {
        Player player = event.getClicker();
        NPC npc = event.getNPC();
        if (npc.getName().equals("ChatGPT")) {
            ChatGPTForMinecraft plugin = new ChatGPTForMinecraft();
            Bukkit.getScheduler().runTaskAsynchronously(plugin, new Runnable() {
                @Override
                public void run() {
                    String answer = chatGPT.ask("こんにちは！");
                    player.sendMessage(answer);
                    // ここに非同期処理を記述する
                }
            });
            }
        return false;
    }

}

