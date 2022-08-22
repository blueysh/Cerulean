package me.itstotallyjan.cerulean.listeners;

import me.itstotallyjan.cerulean.Cerulean;
import me.itstotallyjan.cerulean.UnsignedChatMessage;
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

        // Handle unsigned chat messages
        if (Cerulean.getPluginConfig().getBoolean(ConfigPaths.Features.Chat.UNSIGNED_CHAT_MESSAGES)) {
            e.setCancelled(true);
            UnsignedChatMessage unsignedChatMessage;
            if (format != null) {
                unsignedChatMessage = new UnsignedChatMessage(String.format(format, e.getPlayer().getName(), e.getMessage()), e.getPlayer());
            } else {
                unsignedChatMessage = new UnsignedChatMessage("<%> #".replace("%", e.getPlayer().getName()).replace("#", e.getMessage()), e.getPlayer());
            }
            unsignedChatMessage.send();
        }
    }
}
