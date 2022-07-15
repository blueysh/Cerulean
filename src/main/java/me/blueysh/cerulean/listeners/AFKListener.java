package me.blueysh.cerulean.listeners;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.blueysh.cerulean.managers.AFKManager;

public class AFKListener implements Listener {
    @Override
    public void onPlayerJoin(PlayerJoinEvent e) {
        AFKManager.registerPlayerJoin(e.getPlayer());
    }

    @Override
    public void onPlayerQuit(PlayerQuitEvent e) {
        AFKManager.registerPlayerLeave(e.getPlayer());
    }
}
