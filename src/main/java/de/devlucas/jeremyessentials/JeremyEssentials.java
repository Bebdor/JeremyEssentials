package de.devlucas.jeremyessentials;

import de.devlucas.jeremyessentials.commands.*;
import de.devlucas.jeremyessentials.commands.support.SupportCommand;
import de.devlucas.jeremyessentials.events.CommandBlockerEvent;
import de.devlucas.jeremyessentials.events.ConsoleExecuteEvent;
import de.devlucas.jeremyessentials.events.CookieClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * The JeremyEssentials class is a plugin for a Minecraft server that provides essential functionalities.
 * <p>
 * This class is responsible for handling player commands and events related to the plugin.
 */

public final class JeremyEssentials extends JavaPlugin {

    public static String pre = "§8[§bEssentials§8] §7";
    public static String mustBeAPlayer = pre + "You have to be a player to execute the command!";
    public static String noRights = pre + "You do not have permission to execute this command!";

    public static String playerNotFound(String playerName) {
        return pre + "Player §6" + playerName + "§7 not found";
    }

    public static Map<UUID, Integer> clickCounts;

    @Override
    public void onEnable() {
        loadClickCounts();
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new CookieClickEvent(), this);
        pluginManager.registerEvents(new ConsoleExecuteEvent(), this);
        pluginManager.registerEvents(new CommandBlockerEvent(), this);
        pluginManager.registerEvents(new CommandSpyCommand(), this);
        pluginManager.registerEvents(new GlobalMuteListener(), this);

        Objects.requireNonNull(getCommand("gm")).setExecutor(new ChangeGamemodeCommand());

        Objects.requireNonNull(getCommand("cookie")).setExecutor(new CookieClickerCommand());

        Objects.requireNonNull(getCommand("cmdspy")).setExecutor(new CommandSpyCommand());

        Objects.requireNonNull(getCommand("help")).setExecutor(new HelpCommand());

        Objects.requireNonNull(getCommand("heal")).setExecutor(new HealCommand());

        Objects.requireNonNull(getCommand("msg")).setExecutor(new MsgCommand());

        Objects.requireNonNull(getCommand("support")).setExecutor(new SupportCommand());

        Objects.requireNonNull(getCommand("godmode")).setExecutor(new ChangeGodModeCommand());

        Objects.requireNonNull(getCommand("cc")).setExecutor(new ChatClearCommand());

        Objects.requireNonNull(getCommand("globalmute")).setExecutor(new GlobalMuteCommand());
    }

    @Override
    public void onDisable() {
        saveClickCounts();
    }

    private void loadClickCounts() {
        clickCounts = new HashMap<>();
        FileConfiguration config = getConfig();
        if (config.contains("clickCounts")) {
            for (String playerIdString : Objects.requireNonNull(config.getConfigurationSection("clickCounts")).getKeys(false)) {
                UUID playerId = UUID.fromString(playerIdString);
                int count = config.getInt("clickCounts." + playerIdString);
                clickCounts.put(playerId, count);
            }
        }
    }

    private void saveClickCounts() {
        FileConfiguration config = getConfig();
        for (Map.Entry<UUID, Integer> entry : clickCounts.entrySet()) {
            config.set("clickCounts." + entry.getKey().toString(), entry.getValue());
        }
        saveConfig();
    }

}
