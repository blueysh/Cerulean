package me.itstotallyjan.cerulean.listeners;

import me.itstotallyjan.cerulean.Cerulean;
import me.itstotallyjan.cerulean.utils.ConfigPaths;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        String format = Cerulean.getPluginConfig().getString(ConfigPaths.Features.Chat.CHAT_FORMAT);
        if (format != null) {
            e.setFormat(format);
        }
    }
}
