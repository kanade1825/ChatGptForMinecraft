package net.kanade1825.litematica.chatgptforminecraft;


import com.theokanning.openai.OpenAiService;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


import com.theokanning.openai.completion.CompletionRequest;


public class ChatGPTResponse implements CommandExecutor {

    ChatGPTForMinecraft chatGptForMinecraft;

    public OpenAiService getChatGptForMinecraft() {
        chatGptForMinecraft.service = new OpenAiService("");
        return chatGptForMinecraft.service;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length < 1) {
            commandSender.sendMessage("Don't use this commands with no args!");
            return true;
        }

        String request = strings[0];

        final var completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt(request)
                .build();




        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> String.valueOf(chatGptForMinecraft.service.createCompletion(completionRequest)));

        Bukkit.getScheduler().runTaskAsynchronously(chatGptForMinecraft,()->{try {
            String response = future.get();
            if (response == null){
                response = "Response is null ! please try again";
            }
            commandSender.sendMessage(response);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }});

        return false;
    }
}