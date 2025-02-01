package iou.ink.IOUMC.event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import iou.ink.IOUMC.tools.NotifyTool;

public class PlayerEvent implements Listener{

    @EventHandler(priority = EventPriority.HIGH)
    public void userPlace(BlockPlaceEvent e){
        var notify = new NotifyTool();
        notify.serverLog(e.getBlockPlaced().toString());
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void userLogin(PlayerLoginEvent e){
        var notify = new NotifyTool();
        var player = e.getPlayer();
        // 获取玩家账号（用户名）
        String username = player.getName();
        // 获取玩家 IP 地址
        String ipAddress = e.getAddress().getHostAddress();

        notify.serverLog(e.getPlayer().toString());
//        e.disallow(KICK_WHITELIST, "not allow");
    }

}
