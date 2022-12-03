package admincmdreplacer.admincmdreplacer;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.TabCompleteEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public final class AdminCmdReplacer extends JavaPlugin implements Listener {
    private static final String prefix = "§7[§cAdminCmdReplacer§7]§a ";
    private static AdminCmdReplacer instance;
    public static ArrayList<String> help_block;
    public static ArrayList<String> about_block;
    public static ArrayList<String> ver_block;
    public static ArrayList<String> pl_block;
    public static ArrayList<String> op_block;
    public static ArrayList<String> all_block;

    @Override
    public void onEnable() {
        log("---------------------------------");
        log("Запускаю плагин...               ");
        final File f = new File(this.getDataFolder() + File.separator + "config.yml");
        if (!f.exists()) {
            saveDefaultConfig();
            log("Файл конфигурации не был найден! Создаю новый...");
        }
        instance = this;
        loadConfig(getConfig());
        registerCommands();
        getServer().getPluginManager().registerEvents(this, this);
        log("+++++++++++++++++++++++++++++++++");
        log("Плагин AdminCmdReplacer включен! ");
        log("Написал: AdminCmdReplacer        ");
        log("---------------------------------");

    }

    public static AdminCmdReplacer getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        log("----------------------------------");
        log("Выключаю плагин...                ");
        log("++++++++++++++++++++++++++++++++++");
        log("Плагин AdminCmdReplacer выключен! ");
        log("Написал: Link_play                ");
        log("----------------------------------");
    }

    public void registerCommands() {
        getCommand("AdminCmdReplacer").setExecutor((CommandExecutor)new Reload());
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        if (getConfig().getBoolean("Help.Allow") && !e.getPlayer().hasPermission("AdminCmdReplacer.admin")){
            if (help_block.contains(e.getMessage().split(" ")[0].replace("/", ""))) {
                e.setCancelled(true);
                List<String> list;
                list = getConfig().getStringList("Help.msg");
                for (String s : list)
                    p.sendMessage(s.replaceAll("&", "§").replaceAll("%player%", p.getName()));
            }
        }
        if (getConfig().getBoolean("About.Allow") && !e.getPlayer().hasPermission("AdminCmdReplacer.admin")){
            if (about_block.contains(e.getMessage().split(" ")[0].replace("/", ""))) {
                e.setCancelled(true);
                List<String> list;
                list = getConfig().getStringList("About.msg");
                for (String s : list)
                    p.sendMessage(s.replaceAll("&", "§").replaceAll("%player%", p.getName()));
            }
        }
        if (getConfig().getBoolean("Version.Allow") && !e.getPlayer().hasPermission("AdminCmdReplacer.admin")){
            if (ver_block.contains(e.getMessage().split(" ")[0].replace("/", ""))) {
                e.setCancelled(true);
                List<String> list;
                list = getConfig().getStringList("Version.msg");
                for (String s : list)
                    p.sendMessage(s.replaceAll("&", "§").replaceAll("%player%", p.getName()));
            }
        }
        if (getConfig().getBoolean("Plugins.Allow") && !e.getPlayer().hasPermission("AdminCmdReplacer.admin")){
            if (pl_block.contains(e.getMessage().split(" ")[0].replace("/", ""))) {
                e.setCancelled(true);
                List<String> list;
                list = getConfig().getStringList("Plugins.msg");
                for (String s : list)
                    p.sendMessage(s.replaceAll("&", "§").replaceAll("%player%", p.getName()));
            }
        }
        if (getConfig().getBoolean("Op.Allow") && !e.getPlayer().hasPermission("AdminCmdReplacer.admin")){
            if (op_block.contains(e.getMessage().split(" ")[0].replace("/", ""))) {
                e.setCancelled(true);
                List<String> list;
                list = getConfig().getStringList("Op.msg");
                for (String s : list)
                    p.sendMessage(s.replaceAll("&", "§").replaceAll("%player%", p.getName()));
            }
        }
        if (getConfig().getBoolean("BlockCMD.Allow") && !e.getPlayer().hasPermission("AdminCmdReplacer.admin")){
            if (all_block.contains(e.getMessage().split(" ")[0].replace("/", ""))) {
                e.setCancelled(true);
                List<String> list;
                list = getConfig().getStringList("BlockCMD.msg");
                for (String s : list)
                    p.sendMessage(s.replaceAll("&", "§").replaceAll("%player%", p.getName()));
            }
        }
    }

    @EventHandler
    public void onTab(TabCompleteEvent e) {
        if (getConfig().getBoolean("TabComplete.Allow")){
            e.getCompletions().clear();
        }
    }

    public static void log(String message) {
        Bukkit.getConsoleSender().sendMessage(getPrefix() + message);
    }

    public static void loadConfig(FileConfiguration cfg) {
        help_block = (ArrayList<String>)cfg.getStringList("Help.cmd");
        about_block = (ArrayList<String>)cfg.getStringList("About.cmd");
        ver_block = (ArrayList<String>)cfg.getStringList("Version.cmd");
        pl_block = (ArrayList<String>)cfg.getStringList("Plugins.cmd");
        op_block = (ArrayList<String>)cfg.getStringList("Op.cmd");
        all_block = (ArrayList<String>)cfg.getStringList("BlockCMD.cmd");
    }

    public static String getPrefix() {
        return prefix;
    }

}
