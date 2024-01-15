package de.devlucas.jeremyessentials.commands.admin.commandspy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.jetbrains.annotations.NotNull;

public class CommandSpyListener implements Listener {
    private CommandSpyCommand commandSpyCommand = new CommandSpyCommand();

    @EventHandler
    public void onCommandPreProcess(@NotNull PlayerCommandPreprocessEvent playerCommandPreprocessEvent) {
        String playerName = playerCommandPreprocessEvent.getPlayer().getName();

        if (commandSpyCommand.cmdSpyMap.containsKey(playerName)) {
            String command = playerCommandPreprocessEvent.getMessage().split(" ")[0];

            if(commandSpyCommand.shouldSpy(playerName, command)){
                Bukkit.broadcastMessage(ChatColor.GRAY + playerName + " used the command: " + ChatColor.WHITE + playerCommandPreprocessEvent.getMessage());
            }
        }
    }
}