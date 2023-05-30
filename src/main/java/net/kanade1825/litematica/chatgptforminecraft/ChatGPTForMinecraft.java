package net.kanade1825.litematica.chatgptforminecraft;


import com.theokanning.openai.service.OpenAiService;
import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.ArgumentSuggestions;
import dev.jorel.commandapi.arguments.StringArgument;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
                .withArguments(
                        //StringArgumentで引数の数と、名前を指定
                        //そのあとの部分でサジェスト（予測変換）の設定を行っている。
                        new StringArgument("Name")
                                .replaceSuggestions(ArgumentSuggestions.strings(
                            "Ellis",
                                        "Mirai",
                                        "Raisers",
                                        "Rasvaan",
                                        "Rina",
                                        "Wagner",
                                        "Marshier"))
                        )
                .executes((sender, args) -> {

                    var name = args.get(0).toString();
                    if (name == null){
                        sender.sendMessage("引数が有りません。");
                        return;
                    }
                        var ChatGPTPriginalMob =  new ChatGPTOriginalMob(this);
                        //argsの0番目（最初）（argsはリストっぽい）に名前が入っている。
                        //senderはコマンド送信者
                        ChatGPTPriginalMob.SummonMob(sender, (args.get(0)).toString());
                })
                .withPermission(CommandPermission.OP)
                .register();


        new CommandAPICommand("ChatGPT-Set-APIKey")
                .withArguments(
                        //StringArgumentで引数の数と、名前を指定
                        //そのあとの部分でサジェスト（予測変換）の設定を行っている。
                        new StringArgument("API-Key")
                )
                .executes((sender, args) -> {

                    var name = args.get(0).toString();
                    if (name == null){
                        sender.sendMessage("引数が有りません。");
                        return;
                    }

                    Path filePath = Paths.get("plugins/ChatGPTForMinecraft/API/apikey.txt");

                    // 書き込む文字列を作成します

                    try {
                        // ファイルに文字列を書き込みます（UTF-8エンコーディング）
                        Files.writeString(filePath, name, StandardCharsets.UTF_8);
                    } catch (IOException e) {
                        // エラー発生時の処理
                        System.out.println("An error occurred while writing to the file.");
                        e.printStackTrace();
                    }


                })
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