package iou.ink.iOUMC.tools;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class NotifyTool {

    public void serverLog(String content) {
        ChatColor red = ChatColor.RED;
        Bukkit.getConsoleSender().sendMessage(red + "[serverLog]" + content);
    }

    public void systemLog(String content) {
        System.out.println("[systemLog]" + content);
    }
}
