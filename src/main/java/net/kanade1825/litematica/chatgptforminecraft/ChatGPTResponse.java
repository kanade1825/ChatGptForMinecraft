package net.kanade1825.litematica.chatgptforminecraft;


import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public class ChatGPTResponse implements CommandExecutor {
    private final ChatGPTForMinecraft plugin;

    public ChatGPTResponse(ChatGPTForMinecraft plugin) {
        this.plugin = plugin;
    }



    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length < 1) {
            commandSender.sendMessage("Don't use this commands with no args!");
            return true;
        }

        String request = strings[0];

        // LinkedList<>()がpythonでいうところのchatMessages = []

        List <ChatMessage> chatMessages = new LinkedList<>();


        // チャットメッセージのリストの中に、新しいチャットメッセージを入れてる

        chatMessages.add(new ChatMessage("user",request));


        final var completionRequest = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .messages(chatMessages)
                .build();

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                return plugin.getService().createChatCompletion(completionRequest).getChoices().get(0).getMessage().getContent();
            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
                return null;
            }
        });

        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            try {
                String response = future.get();
                if (response == null){
                    response = "Response is null ! please try again";
                }
                commandSender.sendMessage(response);
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        });

        return false;
    }
}
