package net.kanade1825.litematica.chatgptforminecraft;

import com.lilittlecat.chatgpt.offical.ChatGPT;
import okhttp3.OkHttpClient;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ChatGPTResponse implements CommandExecutor {

    private final ChatGPTForMinecraft chatGptForMinecraft;


    public ChatGPTResponse(ChatGPTForMinecraft chatGptForMinecraft) {
        this.chatGptForMinecraft = chatGptForMinecraft;
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(3,TimeUnit.DAYS)
                .callTimeout(3,TimeUnit.DAYS)
                .connectTimeout(3, TimeUnit.DAYS).build();
        chatGptForMinecraft.chatGPT = new ChatGPT("",okHttpClient);
    }




    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length < 1) {
            commandSender.sendMessage("Don't use this commands with no args!");
            return true;
        }

        String request = strings[0];

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> chatGptForMinecraft.chatGPT.ask(request));

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