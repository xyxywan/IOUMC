package iou.ink.iOUMC.commands;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import java.util.List;

import iou.ink.iOUMC.tools.NotifyTool;


public class NotifyCommand implements CommandExecutor{
    public NotifyTool notify = new NotifyTool();

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender,@NotNull  Command command,@NotNull String label, String[] args) {
        List<String> arr = Arrays.asList(args);
        String receiver = arr.get(0);
        String content = arr.get(1);
        String sender = commandSender.getName();
        content = "[" + sender + "]" + content;

        switch (receiver){
            case "all" :
                notify.broadcast(content);
                break; //可选
            case "server" :
                notify.serverLog(content);
                break; //可选
            //你可以有任意数量的case语句
            default : //可选
                if(Bukkit.getPlayer(receiver) != null){
                    notify.sendMsg(content, receiver);
                }else {
                    return false;
                }
        }

        return true;
    }
}
