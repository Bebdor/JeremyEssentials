package de.devlucas.jeremyessentials.commands.admin.commandspy;

import de.devlucas.jeremyessentials.JeremyEssentials;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.jetbrains.annotations.NotNull;

public class CommandSpyListener implements Listener {

    @EventHandler
    public void onCommandPreProcess(@NotNull PlayerCommandPreprocessEvent playerCommandPreprocessEvent) {

        for (final Player player : JeremyEssentials.commandspyList)
        {
            player.sendMessage(JeremyEssentials.pre + playerCommandPreprocessEvent.getPlayer().getName() + " used command: §6" + playerCommandPreprocessEvent.getMessage());
        }

    }
}