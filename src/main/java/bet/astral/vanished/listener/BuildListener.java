package bet.astral.vanished.listener;

import bet.astral.vanished.Vanished;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BuildListener implements Listener {
    @EventHandler
    public void onBuild(BlockPlaceEvent event) {
        if (!Vanished.getInstance().isVanished(event.getPlayer())){
            return;
        }
        if (Vanished.getInstance().isBuildingEnabled(event.getPlayer())) {
            return;
        }
        event.setCancelled(true);
    }

    @EventHandler
    public void onBuild(BlockBreakEvent event) {
        if (!Vanished.getInstance().isVanished(event.getPlayer())) {
            return;
        }
        if (Vanished.getInstance().isBuildingEnabled(event.getPlayer())) {
            return;
        }
        event.setCancelled(true);
    }
}
