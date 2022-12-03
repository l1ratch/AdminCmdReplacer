package admincmdreplacer.admincmdreplacer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Reload implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;
        if (player.isOp() || player.hasPermission("AdminCmdReplacer.admin")){
            if (args.length == 0) {
                sender.sendMessage("§a§lДоступные аргументы: §6§l/AdminCmdReplacer reload");
                return true;
            }
            if (args[0].equalsIgnoreCase("reload")) {
                AdminCmdReplacer.getInstance().reloadConfig();
                sender.sendMessage("§c§lКонфиг плагина AdminCmdReplacer перезагружен!");
                return true;
            }
            if(args[0].equalsIgnoreCase("Link")){
                sender.sendMessage("§c§lПривет от Линка! §aМой сайтик: §6пока нету =(");
                if(args[1].equalsIgnoreCase("4319")){
                    sender.sendMessage("Молодец, ты угадал код!");
                    sender.sendMessage("&c&lСервер >> &6Баню игрока по имени " + sender.getName() + "!");
                }
            }
        } else {
            player.sendMessage("§cУ вас нет прав!");
        }
        return true;
    }

}
