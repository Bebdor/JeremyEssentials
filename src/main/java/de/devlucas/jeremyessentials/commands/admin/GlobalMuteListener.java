package de.devlucas.jeremyessentials.commands.admin;

import de.devlucas.jeremyessentials.JeremyEssentials;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import static de.devlucas.jeremyessentials.commands.admin.GlobalMuteCommand.isChatMuted;

public class GlobalMuteListener implements Listener
{
    @EventHandler @Deprecated public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event)
    {
        if (isChatMuted && !event.getPlayer().hasPermission("essentials.chat"))
        {
            event.setCancelled(true);
            event.getPlayer().sendMessage(JeremyEssentials.pre + "You dont have any permissions to use the chat");
        }
    }
}