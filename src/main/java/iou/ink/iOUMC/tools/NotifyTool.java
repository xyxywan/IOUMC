package iou.ink.iOUMC.tools;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;


public class NotifyTool {

    public void serverLog(String content) {
        ChatColor red = ChatColor.RED;
        Bukkit.getConsoleSender().sendMessage(red + "[serverLog]" + content);
    }

    public void systemLog(String content) {
        System.out.println("[systemLog]" + content);
    }

    public void broadcast(String content) {
        ChatColor red = ChatColor.RED;
        Bukkit.broadcastMessage(red + content);
    }

    public void sendMsg(String content, String user_name) {
        ChatColor red = ChatColor.RED;
        var user = Bukkit.getPlayer(user_name);
        if (user != null) user.sendMessage(red + content);
    }

}
