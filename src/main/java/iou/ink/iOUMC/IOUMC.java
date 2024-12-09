package iou.ink.iOUMC;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class IOUMC extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        serverLog();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public void pluginLog() {
        this.getLogger().info("test pluginLog");
    }

    public void serverLog() {
        ChatColor red = ChatColor.RED;
        Bukkit.getConsoleSender().sendMessage(red +"------------------test serverLog");

    }

    public void systemLog() {
        System.out.println("Hello from FileA!");
    }

}
