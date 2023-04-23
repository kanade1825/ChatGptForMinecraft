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

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ChatGPTTalkNPC implements Listener {


    private final ChatGPTForMinecraft chatGptForMinecraft;

    public ChatGPTTalkNPC(ChatGPTForMinecraft chatGptForMinecraft) {
        this.chatGptForMinecraft = chatGptForMinecraft;
    }

    List<ChatMessage> chatMessages = new LinkedList<>();
    List<ChatMessage> chatMessages1 = new LinkedList<>();
    List<ChatMessage> chatMessages2 = new LinkedList<>();
    List<ChatMessage> chatMessages3 = new LinkedList<>();
    List<ChatMessage> chatMessages4 = new LinkedList<>();
    List<ChatMessage> chatMessages5 = new LinkedList<>();
    List<ChatMessage> chatMessages6 = new LinkedList<>();

    @EventHandler
    public void onNPCRightClick(NPCRightClickEvent event) {


        Player player = event.getClicker();
        NPC npc = event.getNPC();
        if (npc.getName().equals("ChatGPT")) {
            Bukkit.getScheduler().runTaskAsynchronously(chatGptForMinecraft, new Runnable() {
                @Override
                public void run() {
                    JSONParser parser = new JSONParser();
                    try (FileReader reader = new FileReader("Wagner.json")) {
                        // JSONファイルの読み込み
                        JSONObject jsonObject = (JSONObject) parser.parse(reader);

                        // "Wagner" の値を取得
                         String Wagner = (String) jsonObject.get("Wagner");

                         chatMessages.add(new ChatMessage("user",Wagner));

                         chatMessages.add(new ChatMessage("user","こんにちは！"));

                         final var completionRequest = ChatCompletionRequest.builder()
                                .model("gpt-3.5-turbo")
                                .messages(chatMessages)
                                .build();


                         String answer = String.valueOf(chatGptForMinecraft.getService().createChatCompletion(completionRequest).getChoices().get(0).getMessage().getContent());
                         player.sendMessage(answer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    // ここに非同期処理を記述する
                }
            });
            }
        else if (npc.getName().equals("Mirai")){
            chatMessages1.add(new ChatMessage("user",ChatGPTPrompt.Mirai));

            Bukkit.getScheduler().runTaskAsynchronously(chatGptForMinecraft, new Runnable() {
                @Override
                public void run() {


                    chatMessages1.add(new ChatMessage("user","こんにちは！"));

                    final var completionRequest1 = ChatCompletionRequest.builder()
                            .model("gpt-3.5-turbo")
                            .messages(chatMessages1)
                            .build();


                    String answer = String.valueOf(chatGptForMinecraft.getService().createChatCompletion(completionRequest1).getChoices().get(0).getMessage().getContent());
                    player.sendMessage(answer);
                    // ここに非同期処理を記述する
                }
            });
        }
        else if (npc.getName().equals("Ellis")){
            chatMessages2.add(new ChatMessage("user",ChatGPTPrompt.Ellis));

            Bukkit.getScheduler().runTaskAsynchronously(chatGptForMinecraft, new Runnable() {
                @Override
                public void run() {


                    chatMessages2.add(new ChatMessage("user","こんにちは！"));

                    final var completionRequest2 = ChatCompletionRequest.builder()
                            .model("gpt-3.5-turbo")
                            .messages(chatMessages2)
                            .build();


                    String answer = String.valueOf(chatGptForMinecraft.getService().createChatCompletion(completionRequest2).getChoices().get(0).getMessage().getContent());
                    player.sendMessage(answer);
                    // ここに非同期処理を記述する
                }
            });
        }
        else if (npc.getName().equals("Rina")){
            chatMessages3.add(new ChatMessage("user",ChatGPTPrompt.Rina));

            Bukkit.getScheduler().runTaskAsynchronously(chatGptForMinecraft, new Runnable() {
                @Override
                public void run() {


                    chatMessages3.add(new ChatMessage("user","こんにちは！"));

                    final var completionRequest3 = ChatCompletionRequest.builder()
                            .model("gpt-3.5-turbo")
                            .messages(chatMessages3)
                            .build();


                    String answer = String.valueOf(chatGptForMinecraft.getService().createChatCompletion(completionRequest3).getChoices().get(0).getMessage().getContent());
                    player.sendMessage(answer);
                    // ここに非同期処理を記述する
                }
            });
        }
        else if (npc.getName().equals("Rasvaan")){
            chatMessages4.add(new ChatMessage("user",ChatGPTPrompt.Rasvaan));

            Bukkit.getScheduler().runTaskAsynchronously(chatGptForMinecraft, new Runnable() {
                @Override
                public void run() {


                    chatMessages4.add(new ChatMessage("user","こんにちは！"));

                    final var completionRequest4 = ChatCompletionRequest.builder()
                            .model("gpt-3.5-turbo")
                            .messages(chatMessages4)
                            .build();


                    String answer = String.valueOf(chatGptForMinecraft.getService().createChatCompletion(completionRequest4).getChoices().get(0).getMessage().getContent());
                    player.sendMessage(answer);
                    // ここに非同期処理を記述する
                }
            });
        }
        else if (npc.getName().equals("Raisers")){
            chatMessages5.add(new ChatMessage("user",ChatGPTPrompt.Raisers));

            Bukkit.getScheduler().runTaskAsynchronously(chatGptForMinecraft, new Runnable() {
                @Override
                public void run() {


                    chatMessages5.add(new ChatMessage("user","こんにちは！"));

                    final var completionRequest5 = ChatCompletionRequest.builder()
                            .model("gpt-3.5-turbo")
                            .messages(chatMessages5)
                            .build();


                    String answer = String.valueOf(chatGptForMinecraft.getService().createChatCompletion(completionRequest5).getChoices().get(0).getMessage().getContent());
                    player.sendMessage(answer);
                    // ここに非同期処理を記述する
                }
            });
        }
        else if (npc.getName().equals("Marshier")){
            chatMessages6.add(new ChatMessage("user",ChatGPTPrompt.Marshier));

            Bukkit.getScheduler().runTaskAsynchronously(chatGptForMinecraft, new Runnable() {
                @Override
                public void run() {


                    chatMessages6.add(new ChatMessage("user","こんにちは！"));

                    final var completionRequest6 = ChatCompletionRequest.builder()
                            .model("gpt-3.5-turbo")
                            .messages(chatMessages6)
                            .build();


                    String answer = String.valueOf(chatGptForMinecraft.getService().createChatCompletion(completionRequest6).getChoices().get(0).getMessage().getContent());
                    player.sendMessage(answer);
                    // ここに非同期処理を記述する
                }
            });
        }
    }
}

