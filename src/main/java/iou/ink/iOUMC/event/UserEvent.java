package iou.ink.iOUMC.event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import iou.ink.iOUMC.tools.NotifyTool;

public class UserEvent implements Listener{

    @EventHandler(priority = EventPriority.HIGH)
    public void userPlace(BlockPlaceEvent e){
        var notify = new NotifyTool();
        notify.serverLog(e.getBlockPlaced().toString());
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void userLogin(PlayerLoginEvent e){
        var notify = new NotifyTool();
        notify.serverLog(e.getPlayer().toString());
    }

}
