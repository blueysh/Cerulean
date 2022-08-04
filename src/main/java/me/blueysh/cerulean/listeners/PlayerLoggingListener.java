package me.blueysh.cerulean.listeners;

import me.blueysh.cerulean.Cerulean;
import me.blueysh.cerulean.utils.ConfigPaths;
import me.blueysh.cerulean.utils.Logger;
import net.luckperms.api.event.user.track.UserTrackEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLoggingListener implements Listener {
    private final boolean isLoggingFeatureEnabled;
    private final boolean isChatFeatureEnabled;

    public PlayerLoggingListener() {
        this.isLoggingFeatureEnabled = Cerulean.getPluginConfig().getBoolean(ConfigPaths.Features.PlayerLogging.ENABLED);
        this.isChatFeatureEnabled = Cerulean.getPluginConfig().getBoolean(ConfigPaths.Features.Chat.ENABLED);
        Cerulean.getLuckPerms().getEventBus().subscribe(Cerulean.getInstance(), UserTrackEvent.class, e -> {
            Player p = Bukkit.getPlayer(e.getUser().getUniqueId());
            p.setDisplayName(e.getUser().getCachedData().getMetaData().getPrefix() + p.getName());
            Logger.log(Logger.Level.INFO, "Updated display name for player " + p.getName());
        });
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (isLoggingFeatureEnabled) {
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', Cerulean.getPluginConfig().getString(ConfigPaths.Features.PlayerLogging.JOIN_MESSAGE).replace("%player%", e.getPlayer().getName())));
        } else {
            e.setJoinMessage(null);
        }
        if (isChatFeatureEnabled) {
            e.getPlayer().setDisplayName((Cerulean.getLuckPerms().getPlayerAdapter(Player.class).getUser(e.getPlayer()).getCachedData().getMetaData().getPrefix() + e.getPlayer().getName()).replace("&","§"));
            Logger.log(Logger.Level.INFO, "Updated display name for player " + e.getPlayer().getName());
        }
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        if (isLoggingFeatureEnabled) {
            e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', Cerulean.getPluginConfig().getString(ConfigPaths.Features.PlayerLogging.QUIT_MESSAGE).replace("%player%", e.getPlayer().getName())));
        } else {
            e.setQuitMessage(null);
        }
    }
}
