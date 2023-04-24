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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ChatGPTTalkNPC implements Listener {

    private final ChatGPTForMinecraft chatGptForMinecraft;
    private final Map<String, String> npcData = new HashMap<>();

    public ChatGPTTalkNPC(ChatGPTForMinecraft chatGptForMinecraft) {
        this.chatGptForMinecraft = chatGptForMinecraft;
        loadNpcData();
    }

    private void loadNpcData() {
        List<String> npcNames = List.of("Wagner", "Mirai", "Ellis", "Rina", "Rasvaan", "Raisers", "Marshier");

        System.out.println(1);

        for (String npcName : npcNames) {

            try (InputStreamReader reader = new InputStreamReader(new FileInputStream(npcName + ".json"), StandardCharsets.UTF_8)) {

                JSONObject jsonObject = (JSONObject) new JSONParser().parse(reader);

                String data = (String) jsonObject.get(npcName);

                npcData.put(npcName, data);

            } catch (IOException | ParseException e) {

                e.printStackTrace();

            }
        }
    }

    @EventHandler
    public void onNPCRightClick(NPCRightClickEvent event) {

        Player player = event.getClicker();

        NPC npc = event.getNPC();

        String npcName = npc.getName();


        if (npcData.containsKey(npcName)) {

            Bukkit.getScheduler().runTaskAsynchronously(chatGptForMinecraft, () -> {

                List<ChatMessage> chatMessages = new LinkedList<>();

                chatMessages.add(new ChatMessage("user", npcData.get(npcName)));

                chatMessages.add(new ChatMessage("user", "こんにちは！"));


                final var completionRequest = ChatCompletionRequest.builder()
                        .model("gpt-3.5-turbo")
                        .messages(chatMessages)
                        .build();


                String answer = String.valueOf(chatGptForMinecraft.getService().createChatCompletion(completionRequest).getChoices().get(0).getMessage().getContent());

                player.sendMessage(answer);
            });
        }
    }
}
