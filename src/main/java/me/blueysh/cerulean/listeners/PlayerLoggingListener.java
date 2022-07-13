package me.blueysh.cerulean.listeners;

import me.blueysh.cerulean.Cerulean;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLoggingListener implements Listener {
    private final boolean isFeatureEnabled;

    public PlayerLoggingListener() {
        this.isFeatureEnabled = Cerulean.getPluginConfig().getBoolean("features.player-logging.enable");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (isFeatureEnabled) {
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', Cerulean.getPluginConfig().getString("features.player-logging.join-message").replace("%player%", e.getPlayer().getName())));
        } else {
            e.setJoinMessage(null);
        }
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        if (isFeatureEnabled) {
            e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', Cerulean.getPluginConfig().getString("features.player-logging.quit-message").replace("%player%", e.getPlayer().getName())));
        } else {
            e.setQuitMessage(null);
        }
    }
}
