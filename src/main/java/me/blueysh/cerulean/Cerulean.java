package me.blueysh.cerulean;

import games.negative.framework.BasePlugin;
import lombok.Getter;
import lombok.Setter;
import me.blueysh.cerulean.commands.*;
import me.blueysh.cerulean.listeners.ChatListener;
import me.blueysh.cerulean.listeners.PlayerLoggingListener;
import me.blueysh.cerulean.utils.ConfigPaths;
import me.blueysh.cerulean.utils.Logger;
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
