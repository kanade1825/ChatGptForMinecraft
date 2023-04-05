package net.kanade1825.litematica.chatgptforminecraft;

import com.theokanning.openai.completion.CompletionRequest;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ChatGPTTalkNPC implements Listener {


    private final ChatGPTForMinecraft chatGptForMinecraft;

    public ChatGPTTalkNPC(ChatGPTForMinecraft chatGptForMinecraft) {
        this.chatGptForMinecraft = chatGptForMinecraft;
    }




    @EventHandler
    public void onNPCRightClick(NPCRightClickEvent event) {
        final var completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("こんにちは！")
                .build();
        Player player = event.getClicker();
        NPC npc = event.getNPC();
        if (npc.getName().equals("ChatGPT")) {
            Bukkit.getScheduler().runTaskAsynchronously(chatGptForMinecraft, new Runnable() {
                @Override
                public void run() {
                    String answer = String.valueOf(chatGptForMinecraft.service.createCompletion(completionRequest));
                    player.sendMessage(answer);
                    // ここに非同期処理を記述する
                }
            });
            }
    }

}

