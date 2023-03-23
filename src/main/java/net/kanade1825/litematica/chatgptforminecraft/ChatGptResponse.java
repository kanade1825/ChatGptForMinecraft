package net.kanade1825.litematica.chatgptforminecraft;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ChatGptResponse implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(strings.length <1){
            if(strings[0].equalsIgnoreCase("a")){
                commandSender.sendMessage("Don't use this commands with no args!");
                return true;
            }
        }

        String question = strings[0];




        commandSender.sendMessage("main command");
        return false;
    }
}
