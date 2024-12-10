package iou.ink.iOUMC.commands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import java.util.Arrays;

import iou.ink.iOUMC.tools.NotifyTool;


public class TestCommand implements CommandExecutor{
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender,@NotNull  Command command,@NotNull String label, String[] args) {

        var notify = new NotifyTool();
        notify.serverLog("sender:" + commandSender);
        notify.serverLog("command:" + command);
        notify.serverLog("label:" + label);
        notify.serverLog("args:" + Arrays.asList(args));
        return true;
    }
}
