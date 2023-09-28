package de.devlucas.jeremyessentials.commands.support;

import org.bukkit.entity.Player;

import java.util.Map;
import java.util.WeakHashMap;

public class SupportChatManager {
    // Memory storage for support session
    private final Map<Player, Player> supportSessions = new WeakHashMap<>();

    public void startSupportChat(Player requester, Player supporter) {
        // Start a support session
        supportSessions.put(requester, supporter);
    }

    public void endSupportChat(Player requester) {
        // End a support session
        supportSessions.remove(requester);
    }

    public Player getSupporter(Player requester) {
        // Return the supporter who helps the requester
        return supportSessions.get(requester);
    }

    public boolean isInSupportChat(Player player) {
        // Check if the player is in the support session
        return supportSessions.containsKey(player);
    }
}