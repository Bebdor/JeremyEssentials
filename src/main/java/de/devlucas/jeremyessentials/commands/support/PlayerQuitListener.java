package de.devlucas.jeremyessentials.commands.support;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {
    private final SupportChatManager supportChatManager;

    public PlayerQuitListener(SupportChatManager supportChatManager) {
        this.supportChatManager = supportChatManager;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        if (supportChatManager.isInSupportChat(event.getPlayer())) {
            supportChatManager.endSupportChat(event.getPlayer());
        }
    }
}