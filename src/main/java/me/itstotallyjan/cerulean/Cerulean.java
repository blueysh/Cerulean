package me.itstotallyjan.cerulean;

import games.negative.framework.BasePlugin;
import lombok.Getter;
import lombok.Setter;
import me.itstotallyjan.cerulean.commands.*;
import me.itstotallyjan.cerulean.listeners.ChatListener;
import me.itstotallyjan.cerulean.listeners.PlayerLoggingListener;
import me.itstotallyjan.cerulean.utils.ConfigPaths;
import me.itstotallyjan.cerulean.utils.Logger;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;

public final class Cerulean extends BasePlugin {

    @Getter
    @Setter
    private static Cerulean instance;

    private static FileConfiguration config;

    @Override
    public void onEnable() {
        super.onEnable();
        long startTime = System.currentTimeMillis();
        setInstance(this);
        saveDefaultConfig();
        config = getConfig();
        loadFiles(this, "config.yml");

        registerCommands(
                new CeruleanCommand()
        );

        if (getPluginConfig().getBoolean(ConfigPaths.Commands.Fly.ENABLED)) registerCommands( new FlyCommand() ); Logger.log(Logger.Level.INFO, "Registered fly command.");
        if (getPluginConfig().getBoolean(ConfigPaths.Commands.Invsee.ENABLED)) registerCommands( new InvseeCommand() ); Logger.log(Logger.Level.INFO, "Registered invsee command.");
        if (getPluginConfig().getBoolean(ConfigPaths.Commands.Damage.ENABLED)) registerCommands( new DamageCommand() ); Logger.log(Logger.Level.INFO, "Registered damage command.");
        if (getPluginConfig().getBoolean(ConfigPaths.Commands.ShortGameMode.ENABLED)) registerCommands( new ShortGamemodeCommand() ); Logger.log(Logger.Level.INFO, "Registered shortgamemode command.");
        if (getPluginConfig().getBoolean(ConfigPaths.Features.Chat.UNSIGNED_CHAT_MESSAGES)) Logger.log(Logger.Level.WARN, "You have enabled unsigned chat messages. Minecraft clients will not be able to verify chat messages, meaning vanilla chat reporting will be disabled."); registerCommands( new MessageCommand() ); Logger.log(Logger.Level.INFO, "Registered unsigned messaging command.");
        if (getPluginConfig().getBoolean(ConfigPaths.Commands.FindPlayer.ENABLED)) registerCommands( new FindPlayerCommand() ); Logger.log(Logger.Level.INFO, "Registered findplayer command.");
        if (getPluginConfig().getBoolean(ConfigPaths.Commands.HelpOverride.ENABLED)) registerCommands( new HelpCommand() ); Logger.log(Logger.Level.INFO, "Registered help override command.");
        if (getPluginConfig().getBoolean(ConfigPaths.Commands.Nick.ENABLED)) registerCommands( new NickCommand() ); Logger.log(Logger.Level.INFO, "Registered nick command.");
        if (getPluginConfig().getBoolean(ConfigPaths.Commands.OpenGui.ENABLED)) registerCommands( new ShowGuiCommand() ); Logger.log(Logger.Level.INFO, "Registered showgui command.");
        if (getPluginConfig().getBoolean(ConfigPaths.Commands.Heal.ENABLED)) registerCommands( new HealCommand() ); Logger.log(Logger.Level.INFO, "Registered heal command.");
        if (getPluginConfig().getBoolean(ConfigPaths.Commands.Rules.ENABLED)) registerCommands( new RulesCommand() ); Logger.log(Logger.Level.INFO, "Registered rules command.");

        registerListeners(
            new PlayerLoggingListener()
        );

        if (getPluginConfig().getBoolean(ConfigPaths.Features.Chat.ENABLED)) registerListeners( new ChatListener() );

        long endTime = System.currentTimeMillis();
        Logger.log(Logger.Level.INFO, "Hello from Cerulean! Successfully loaded in %.".replace("%", (endTime - startTime) + " milliseconds"));
    }

    @Override
    public void onDisable() {}

    public static FileConfiguration getPluginConfig() {
        return config;
    }

    public static LuckPerms getLuckPerms() {
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            return provider.getProvider();
        }
        return null;
    }
}
