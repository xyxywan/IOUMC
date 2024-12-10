package iou.ink.iOUMC.event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import iou.ink.iOUMC.tools.NotifyTool;
import static org.bukkit.event.player.PlayerLoginEvent.Result.KICK_WHITELIST;

public class UserEvent implements Listener{

    @EventHandler(priority = EventPriority.HIGH)
    public void userPlace(BlockPlaceEvent e){
        var notify = new NotifyTool();
        notify.serverLog(e.getBlockPlaced().toString());
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void userLogin(PlayerLoginEvent e){
        var notify = new NotifyTool();
        notify.serverLog(e.getPlayer().toString());
//        e.disallow(KICK_WHITELIST, "not allow");
    }

}
