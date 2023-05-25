package net.kanade1825.litematica.chatgptforminecraft;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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

                String jsonFilePath = "plugins/ChatGPTForMinecraft/TalkData/" + npcName + "TalkData.json";

                try {
                    // JSONファイルをパースする
                    JSONParser jsonParser = new JSONParser();
                    InputStreamReader fileReader = new InputStreamReader(new FileInputStream(jsonFilePath), StandardCharsets.UTF_8);
                    Object obj = jsonParser.parse(fileReader);
                    JSONArray jsonArray = (JSONArray) obj;

                    // 'column2'の値を格納するリスト
                    List<String> column2Values = new ArrayList<>();

                    // JSONオブジェクトから'column2'の値を抽出する
                    for (Object item : jsonArray) {
                        JSONObject jsonObject = (JSONObject) item;
                        String column2Value = (String) jsonObject.get("column2");
                        column2Values.add(column2Value);
                    }

                    // 'column2'の値が一つ以上ある場合
                    if (!column2Values.isEmpty()) {
                        // ランダムに一つの'column2'の値を選び出す
                        Random random = new Random();
                        String randomColumn2Value = column2Values.get(random.nextInt(column2Values.size()));
                        player.sendMessage(randomColumn2Value);
                    }

                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }


                File file = new File("plugins/ChatGPTForMinecraft/CharacterData/" + npcName + ".json");
                if (!file.exists() || file.isDirectory()) {
                    Bukkit.getLogger().info(npcName + "というキャラクターの構成ファイルは見つかりませんでした。" +
                            "\nもし貴方が構成ファイルを持っていても少なくともこのシステムが想定している検知場所にはありません。");
                    return;
                }

                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("plugins/ChatGPTForMinecraft/CharacterData/" + npcName + ".json"), StandardCharsets.UTF_8);

                JSONObject jsonObject = (JSONObject) parser.parse(inputStreamReader);

                List<ChatMessage> chatMessages = new LinkedList<>();
                chatMessages.add(new ChatMessage("user", (String) jsonObject.get(npcName)));
                chatMessages.add(new ChatMessage("user", "こんにちは！"));
                final var completionRequest = ChatCompletionRequest.builder()
                        .model("gpt-4")
                        .messages(chatMessages)
                        .build();
                String answer = String.valueOf(chatGptForMinecraft.getService().createChatCompletion(completionRequest).getChoices().get(0).getMessage().getContent());
                //player.sendMessage(answer);

                try {
                    // JSONファイルをパースする
                    JSONParser jsonParser = new JSONParser();
                    InputStreamReader fileReader = new InputStreamReader(new FileInputStream(jsonFilePath), StandardCharsets.UTF_8);
                    Object obj = jsonParser.parse(fileReader);
                    JSONArray jsonArray = (JSONArray) obj;

                    // 最後の要素（JSONオブジェクト）を取得し、その'id'を取得する
                    JSONObject lastJsonObject = (JSONObject) jsonArray.get(jsonArray.size() - 1);
                    long lastId = (long) lastJsonObject.get("id");

                    // 新しい要素を作成する
                    JSONObject newJsonObject = new JSONObject();
                    newJsonObject.put("id", lastId + 1);  // 管理番号（連番）を設定
                    newJsonObject.put("column1", npcName);
                    newJsonObject.put("column2", answer);

                    // 新しい要素を配列に追加する
                    jsonArray.add(newJsonObject);

                    // 更新されたデータを同じファイルに書き戻す
                    // 更新されたデータを同じファイルに書き戻す
                    try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(jsonFilePath), StandardCharsets.UTF_8)) {
                        outputStreamWriter.write(jsonArray.toJSONString());
                        outputStreamWriter.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
            } catch (IOException | ParseException e) {
                throw new RuntimeException(e);
            }
        });
    }
}



