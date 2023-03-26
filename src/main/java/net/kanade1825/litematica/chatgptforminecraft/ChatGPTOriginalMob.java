package net.kanade1825.litematica.chatgptforminecraft;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ChatGPTOriginalMob implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("chatgptnpc")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location location = player.getLocation();
                spawnNPC(location);
                return true;
            } else {
                sender.sendMessage("This command can only be run by a player.");
                return false;
            }
        }
        return false;
    }

    private void spawnNPC(Location location) {
        World world = location.getWorld();
        EntityType entityType = EntityType.PLAYER;
        Entity entity = world.spawnEntity(location, entityType);
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            livingEntity.setAI(false);
            livingEntity.setInvulnerable(true);
            livingEntity.setCustomName("NPC");
            livingEntity.setCustomNameVisible(true);
            livingEntity.setCanPickupItems(false);
        }
    }
}
