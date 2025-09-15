package bet.astral.vanished.listener;

import bet.astral.vanished.Vanished;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageListener implements Listener {
    @EventHandler
    public void onAttack(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player player)){
            return;
        }
        if (!Vanished.getInstance().isVanished(player)){
            return;
        }
        if (Vanished.getInstance().canAttack(player)) {
            return;
        }
        event.setCancelled(true);
    }

    @EventHandler
    public void onDamageReceive(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player player)){
            return;
        }
        if (!Vanished.getInstance().isVanished(player)){
            return;
        }
        event.setCancelled(true);
    }
}
