package me.itstotallyjan.cerulean;

import games.negative.framework.message.Message;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnsignedChatMessage {
    private String message;
    private CommandSender sender;

    /*
     * A chat message that is handled by the plugin, disabling chat reporting.
     * @param message The message to be sent.
     * @param sender The player who sent the message.
     */
    public UnsignedChatMessage(String message, Player sender) {
        this.message = message;
        this.sender = sender;
    }

    public UnsignedChatMessage(String message, CommandSender sender) {
        this.message = message;
        this.sender = sender;
    }

    /*
     * Sends the chat message to the server.
     */
    public void send() {
        Bukkit.getServer().broadcastMessage(message);
    }

    /*
     * Sends the unsigned chat message as a private message to another player.
     * @param player The player to send the message to.
     */
    public void sendPrivately(Player player) {
        new Message(ChatColor.GRAY + "" + ChatColor.ITALIC + "You whisper to %: #".replace("%", player.getName()).replace("#", message)).send(sender);
        new Message(ChatColor.GRAY + "" + ChatColor.ITALIC + "% whispers to you: #".replace("%", sender.getName()).replace("#", message)).send(player);
    }
}
