package me.blueysh.cerulean.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Logger {
    public enum Level {
        INFO,
        WARN,
        ERR
    }

    public static void log(Level level, String message) {
        switch (level) {
            case INFO:
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&3[Cerulean::INFO]&r&f " + message));
                break;
            case WARN:
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&3[Cerulean::WARN]&r&e " + message));
                break;
            case ERR:
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&3[Cerulean::ERR]&r&c " + message));
                break;
        }
    }
}
