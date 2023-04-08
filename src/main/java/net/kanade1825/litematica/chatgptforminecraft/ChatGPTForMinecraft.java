package net.kanade1825.litematica.chatgptforminecraft;


import com.theokanning.openai.OpenAiApi;
import com.theokanning.openai.OpenAiService;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ChatGPTForMinecraft extends JavaPlugin {

    //多分グローバル変数ってやつじゃなーい？
    public OpenAiService service;
    public OpenAiApi chatGPT;


    @Override
    public void onEnable() {
        String apiKey = "";
        service = new OpenAiService(apiKey);
        // Plugin startup logic
        Objects.requireNonNull(getCommand("chatgpt")).setExecutor(new ChatGPTResponse(this));
        Objects.requireNonNull(getCommand("chatgptnpc")).setExecutor(new ChatGPTOriginalMob());
        getServer().getPluginManager().registerEvents(new ChatGPTTalkNPC(this),this);
        getLogger().info("loadied chatgpt for minecraft!");
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("stopped chatgpt for minecraft!");
    }

    public OpenAiService getService() {
        return service;
    }
}