package me.itstotallyjan.cerulean.utils;

public class ConfigPaths {
    public interface Commands {
        interface Fly {
            String ENABLED = "commands.fly.enable";
        }
        interface Invsee {
            String ENABLED = "commands.invsee.enable";
        }
        interface Damage {
            String ENABLED = "commands.damage.enable";
        }
        interface ShortGameMode {
            String ENABLED = "commands.short-gamemode.enable";
        }
        interface HelpOverride {
            String ENABLED = "commands.help-override.enable";
            String MESSAGE = "commands.help-override.message";
        }
        interface FindPlayer {
            String ENABLED = "commands.find-player.enable";
        }
        interface Nick {
            String ENABLED = "commands.nick.enable";
        }
        interface OpenGui {
            String ENABLED = "commands.opengui.enable";
        }
        interface Heal {
            String ENABLED = "commands.heal.enable";
        }
        interface Rules {
            String ENABLED = "commands.rules.enable";
            String MESSAGE = "commands.rules.message";
        }
    }
    public interface Features {
        interface Chat {
            String ENABLED = "features.chat.enable";
            String CHAT_FORMAT = "features.chat.chat-format";
            String UNSIGNED_CHAT_MESSAGES = "features.chat.unsigned-chat-messages";
        }
        interface PlayerLogging {
            String ENABLED = "features.player-logging.enable";
            String JOIN_MESSAGE = "features.player-logging.join-message";
            String QUIT_MESSAGE = "features.player-logging.quit-message";
        }
    }
}
