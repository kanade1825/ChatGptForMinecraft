package net.kanade1825.litematica.chatgptforminecraft;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ChatGPTForMinecraft extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Objects.requireNonNull(getCommand("chatgpt")).setExecutor(new ChatGPTResponse(this));
        Objects.requireNonNull(getCommand("chatgptnpc")).setExecutor(new ChatGPTOriginalMob());
        getLogger().info("loadied chatgpt for minecraft!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("stopped chatgpt for minecraft!");
    }
}
