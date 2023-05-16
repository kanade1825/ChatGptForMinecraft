package net.kanade1825.litematica.chatgptforminecraft;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ChatGPTTalkNPC implements Listener {

    private final ChatGPTForMinecraft chatGptForMinecraft;

    public ChatGPTTalkNPC(ChatGPTForMinecraft chatGptForMinecraft) {
        this.chatGptForMinecraft = chatGptForMinecraft;
    }

    @EventHandler
    public void onNPCRightClick(NPCRightClickEvent event) {
            Bukkit.getScheduler().runTaskAsynchronously(chatGptForMinecraft, () -> {
                try {

                JSONParser parser = new JSONParser();

                Player player = event.getClicker();
                NPC npc = event.getNPC();
                String npcName = npc.getName();



                File file = new File(npcName + ".json");
                if (!file.exists() || file.isDirectory()) {
                    Bukkit.getLogger().info(npcName+"というキャラクターの構成ファイルは見つかりませんでした。" +
                            "\nもし貴方が構成ファイルを持っていても少なくともこのシステムが想定している検知場所にはありません。");
                    return;
                }

                JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(npcName + ".json"));;


                List<ChatMessage> chatMessages = new LinkedList<>();
                chatMessages.add(new ChatMessage("user", (String) jsonObject.get(npcName) ));
                chatMessages.add(new ChatMessage("user", "こんにちは！"));
                final var completionRequest = ChatCompletionRequest.builder()
                        .model("gpt-4")
                        .messages(chatMessages)
                        .build();
                String answer = String.valueOf(chatGptForMinecraft.getService().createChatCompletion(completionRequest).getChoices().get(0).getMessage().getContent());
                player.sendMessage(answer);



                } catch (IOException | ParseException e) {
                    throw new RuntimeException(e);
                }
            });
    }
}
