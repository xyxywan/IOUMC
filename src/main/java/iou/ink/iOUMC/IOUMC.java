package iou.ink.iOUMC;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;

import iou.ink.iOUMC.tools.NotifyTool;

import iou.ink.iOUMC.event.UserEvent;

import iou.ink.iOUMC.commands.TestCommand;


public final class IOUMC extends JavaPlugin {
    public NotifyTool notify = new NotifyTool();

    @Override
    public void onEnable() {
        // Plugin startup logic
        var config = getPluginConfig();

        registerEventListeners();
        registerCommands();

        String hello = config.getString("hello");
        notify.serverLog(hello);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerEventListeners(){
        Bukkit.getPluginManager().registerEvents(new UserEvent(), this);
    }

    public void registerCommands(){
        Bukkit.getPluginCommand("test").setExecutor(new TestCommand());
    }

    public FileConfiguration getPluginConfig(){
        FileConfiguration config = this.getConfig();  // 读取插件内置的配置文件和外部配置文件并合并
        this.saveDefaultConfig();
        return config;
    }


    public void pluginLog() {
        this.getLogger().info("test pluginLog");
    }

}
