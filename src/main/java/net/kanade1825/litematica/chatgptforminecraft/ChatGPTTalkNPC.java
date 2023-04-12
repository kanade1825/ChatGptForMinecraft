package net.kanade1825.litematica.chatgptforminecraft;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.LinkedList;
import java.util.List;

public class ChatGPTTalkNPC implements Listener {


    private final ChatGPTForMinecraft chatGptForMinecraft;

    public ChatGPTTalkNPC(ChatGPTForMinecraft chatGptForMinecraft) {
        this.chatGptForMinecraft = chatGptForMinecraft;
    }

    List<ChatMessage> chatMessages = new LinkedList<>();


    @EventHandler
    public void onNPCRightClick(NPCRightClickEvent event) {

        chatMessages.add(new ChatMessage("user","こんにちは！"));


        final var completionRequest = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .messages(chatMessages)
                .build();
        Player player = event.getClicker();
        NPC npc = event.getNPC();
        if (npc.getName().equals("ChatGPT")) {
            Bukkit.getScheduler().runTaskAsynchronously(chatGptForMinecraft, new Runnable() {
                @Override
                public void run() {
                    String answer = String.valueOf(chatGptForMinecraft.getService().createChatCompletion(completionRequest).getChoices().get(0).getMessage().getContent());
                    player.sendMessage(answer);
                    // ここに非同期処理を記述する
                }
            });
            }
    }

}

