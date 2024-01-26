package de.devlucas.jeremyessentials.commands.support;

import org.bukkit.entity.Player;

import java.util.Map;
import java.util.WeakHashMap;

public class SupportChatManager {
    private final Map<Player, Player> supportSessions = new WeakHashMap<>();

    public void startSupportChat(Player requester, Player supporter) {
        supportSessions.put(requester, supporter);
    }

    public void endSupportChat(Player requester) {
        supportSessions.remove(requester);
    }

    public Player getSupporter(Player requester) {
        return supportSessions.get(requester);
    }

    public boolean isInSupportChat(Player player) {
        return supportSessions.containsKey(player);
    }
}