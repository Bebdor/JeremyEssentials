package de.devlucas.jeremyessentials.events;

import de.devlucas.jeremyessentials.JeremyEssentials;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.HashSet;
import java.util.Set;

public class CommandBlockerEvent implements Listener
{
    private static final Set<String> blockedCommands;

    static {
        blockedCommands = new HashSet<>();
        blockedCommands.add("pl");
        blockedCommands.add("plugins");
        blockedCommands.add("version");
        blockedCommands.add("ver");
        blockedCommands.add("icanhasbukkit");
        blockedCommands.add("help");
        blockedCommands.add("?");
        blockedCommands.add("bukkit:pl");
        blockedCommands.add("bukkit:plugins");
        blockedCommands.add("bukkit:version");
        blockedCommands.add("bukkit:ver");
        blockedCommands.add("bukkit:icanhasbukkit");
        blockedCommands.add("bukkit:help");
        blockedCommands.add("bukkit:?");
    }

    @EventHandler
    public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent playerCommandPreprocessEvent)
    {
        if ((playerCommandPreprocessEvent.getPlayer().hasPermission("command.bypass")))
        {
            String command = playerCommandPreprocessEvent.getMessage().split(" ")[0].toLowerCase();
            if (blockedCommands.contains(command)) {
                playerCommandPreprocessEvent.setCancelled(true);
                playerCommandPreprocessEvent.getPlayer().sendMessage(JeremyEssentials.noRights);
            }
        }
    }
}