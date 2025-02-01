package iou.ink.IOUMC.commands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import iou.ink.IOUMC.tools.NotifyTool;
import iou.ink.IOUMC.tools.TestRequest;


public class TestCommand implements CommandExecutor{

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender,@NotNull  Command command,@NotNull String label, String[] args) {
        List<String> arr = Arrays.asList(args);

        var notify = new NotifyTool();
        if (!arr.isEmpty()){
            String content = arr.get(0);
            notify.serverLog("content = " + arr);
            try {
                var resp = TestRequest.get("http://127.0.0.1:8080/" + content);
                notify.serverLog(resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else{
            notify.serverLog("sender:" + commandSender);
            notify.serverLog("command:" + command);
            notify.serverLog("label:" + label);
            notify.serverLog("args:" + arr);

        }


        return true;
    }
}
