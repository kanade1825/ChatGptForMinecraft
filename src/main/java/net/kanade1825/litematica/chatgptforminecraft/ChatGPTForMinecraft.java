package net.kanade1825.litematica.chatgptforminecraft;


import com.theokanning.openai.service.OpenAiService;
import dev.jorel.commandapi.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.Duration;
import java.util.Objects;



public final class ChatGPTForMinecraft extends JavaPlugin {

    public static final String Server_URL = "http://localhost:8080/json";

    //変数定義
    //多分グローバル変数ってやつじゃなーい？
    public OpenAiService service;

    @Override
    public void onLoad() {
        CommandAPI.onLoad(new CommandAPIBukkitConfig(this).verboseOutput(true)); // Load with verbose output

        new CommandAPICommand("ping")
                .executes((sender, args) -> {
                    sender.sendMessage("pong!");
                })
                .register();
    }




    @Override
    public void onEnable() {
        String apiKey = "";
        service = new OpenAiService(apiKey, Duration.ofMinutes(5));
        CommandAPI.onEnable();

        new CommandAPICommand("chatgptnpc")

                .withSubcommand(new CommandAPICommand("Ellis"))
                .executes((sender, args) -> {
                    var ChatGPTPriginalMob =  new ChatGPTOriginalMob(this);
                    ChatGPTPriginalMob.SummonMob(sender, String.valueOf(args));
                })

                .withSubcommand(new CommandAPICommand("Marshier"))
                .withSubcommand(new CommandAPICommand("Mirai"))
                .withSubcommand(new CommandAPICommand("Raisers"))
                .withSubcommand(new CommandAPICommand("Rasvaan"))
                .withSubcommand(new CommandAPICommand("Rina"))
                .withSubcommand(new CommandAPICommand("Wagner"))

                .withPermission(CommandPermission.OP)
                .register();

        // Plugin startup logic
        Objects.requireNonNull(getCommand(("chatgpt-setup"))).setExecutor(new SetUP(this));
        Objects.requireNonNull(getCommand("sendtalkfile")).setExecutor(new SendTalkFile(this));
        Objects.requireNonNull(getCommand("gettalkfile")).setExecutor(new GetTalkFile(this));
        Objects.requireNonNull(getCommand("chatgpt")).setExecutor(new ChatGPTResponse(this));
        getServer().getPluginManager().registerEvents(new ChatGPTTalkNPC(this), this);
        getLogger().info("loadied chatgpt for minecraft!");
    }


    @Override
    public void onDisable() {
        CommandAPI.onDisable();
        // Plugin shutdown logic
        getLogger().info("stopped chatgpt for minecraft!");
    }

    public OpenAiService getService() {
        return service;
    }
}