package me.blueysh.cerulean;

import games.negative.framework.BasePlugin;
import lombok.Getter;
import lombok.Setter;
import me.blueysh.cerulean.commands.*;
import me.blueysh.cerulean.listeners.PlayerLoggingListener;
import me.blueysh.cerulean.utils.Logger;
import org.bukkit.configuration.file.FileConfiguration;

public final class Cerulean extends BasePlugin {

    @Getter
    @Setter
    private static Cerulean instance;

    private static FileConfiguration config;

    @Getter
    private static final String version = "1.0";

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
        
        if (getPluginConfig().getBoolean("commands.fly.enable")) registerCommands( new FlyCommand() );
        if (getPluginConfig().getBoolean("commands.invsee.enable")) registerCommands( new InvseeCommand() );
        if (getPluginConfig().getBoolean("commands.damage.enable")) registerCommands( new DamageCommand() );
        if (getPluginConfig().getBoolean("commands.short-gamemode.enable")) registerCommands( new ShortGamemodeCommand() );

        registerListeners(
            new PlayerLoggingListener()
        );

        long endTime = System.currentTimeMillis();
        Logger.log(Logger.Level.INFO, "Hello from Cerulean! Successfully loaded in %.".replace("%", (endTime - startTime) + " milliseconds"));
    }

    @Override
    public void onDisable() {}

    public static FileConfiguration getPluginConfig() {
        return config;
    }
}
