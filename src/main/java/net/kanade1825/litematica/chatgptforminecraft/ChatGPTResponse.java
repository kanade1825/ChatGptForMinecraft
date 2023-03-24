package net.kanade1825.litematica.chatgptforminecraft;

import com.lilittlecat.chatgpt.offical.ChatGPT;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ChatGPTResponse implements CommandExecutor {

    private final ChatGptForMinecraft chatGptForMinecraft;

    public ChatGPTResponse(ChatGptForMinecraft chatGptForMinecraft) {
        this.chatGptForMinecraft = chatGptForMinecraft;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length < 1) {
            commandSender.sendMessage("Don't use this commands with no args!");
            return true;
        }

        String request = strings[0];

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            ChatGPT chatGPT = new ChatGPT("");
            return chatGPT.ask(request);
        });
        Bukkit.getScheduler().runTaskAsynchronously(chatGptForMinecraft,()->{try {
            String response = future.get();
            commandSender.sendMessage(response);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }});

        return false;
    }
}