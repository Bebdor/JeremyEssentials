package de.devlucas.jeremyessentials;

import de.devlucas.jeremyessentials.commands.admin.*;
import de.devlucas.jeremyessentials.commands.admin.commandspy.CommandSpyCommand;
import de.devlucas.jeremyessentials.commands.admin.commandspy.CommandSpyListener;
import de.devlucas.jeremyessentials.commands.user.*;
import de.devlucas.jeremyessentials.commands.user.tpa.TpDenyCommand;
import de.devlucas.jeremyessentials.commands.user.tpa.TpaCommand;
import de.devlucas.jeremyessentials.commands.user.tpa.TpacceptCommand;
import de.devlucas.jeremyessentials.commands.support.SupportCommand;
import de.devlucas.jeremyessentials.events.CommandBlockerEvent;
import de.devlucas.jeremyessentials.events.ConsoleExecuteEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * The JeremyEssentials class is a plugin for a Minecraft server that provides essential functionalities.
 * <p>
 * This class is responsible for handling player commands and events related to the plugin.
 */

public final class JeremyEssentials extends JavaPlugin {

    public static String pre = "§8[§bEssentials§8] §7";
    public static String mustBeAPlayer = pre + "You have to be a player to execute the command!";
    public static String noRights = pre + "You do not have permission to execute this command!";

    public static HashMap<Player, Player> tpa = new HashMap<>();
    public static final List<Player> commandspyList = new ArrayList<>();

    public static String playerNotFound(String playerName) {
        return pre + "Player §6" + playerName + "§7 not found";
    }

    @Override
    public void onEnable() {

        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new ConsoleExecuteEvent(), this);
        pluginManager.registerEvents(new CommandBlockerEvent(), this);
        pluginManager.registerEvents(new CommandSpyListener(), this);
        pluginManager.registerEvents(new GlobalMuteListener(), this);

        Objects.requireNonNull(getCommand("gm")).setExecutor(new ChangeGamemodeCommand());

        Objects.requireNonNull(getCommand("cmdspy")).setExecutor(new CommandSpyCommand());

        Objects.requireNonNull(getCommand("help")).setExecutor(new HelpCommand());

        Objects.requireNonNull(getCommand("heal")).setExecutor(new HealCommand());

        Objects.requireNonNull(getCommand("msg")).setExecutor(new MessageCommand());

        Objects.requireNonNull(getCommand("support")).setExecutor(new SupportCommand());

        Objects.requireNonNull(getCommand("godmode")).setExecutor(new ChangeGodModeCommand());

        Objects.requireNonNull(getCommand("cc")).setExecutor(new ChatClearCommand());

        Objects.requireNonNull(getCommand("globalmute")).setExecutor(new GlobalMuteCommand());

        Objects.requireNonNull(getCommand("fly")).setExecutor(new FlyCommand());

        Objects.requireNonNull(getCommand("tp")).setExecutor(new TeleportCommand());

        Objects.requireNonNull(getCommand("feed")).setExecutor(new FeedCommand());

        Objects.requireNonNull(getCommand("ec")).setExecutor(new EnderchestCommand());

        Objects.requireNonNull(getCommand("wb")).setExecutor(new WorkbenchCommand());

        Objects.requireNonNull(getCommand("invsee")).setExecutor(new InvSeeCommand());

        Objects.requireNonNull(getCommand("repair")).setExecutor(new RepairCommand());

        Objects.requireNonNull(getCommand("whois")).setExecutor(new WhoIsCommand());

        Objects.requireNonNull(getCommand("tpa")).setExecutor(new TpaCommand());

        Objects.requireNonNull(getCommand("tpaccept")).setExecutor(new TpacceptCommand());

        Objects.requireNonNull(getCommand("tpdeny")).setExecutor(new TpDenyCommand());

        Objects.requireNonNull(getCommand("kick")).setExecutor(new KickCommand());

        Objects.requireNonNull(getCommand("head")).setExecutor(new HeadCommand());

    }

}
