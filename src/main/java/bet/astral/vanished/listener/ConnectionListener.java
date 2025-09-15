package bet.astral.vanished.listener;

import bet.astral.vanished.Vanished;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        boolean isVanished = Vanished.getInstance().isVanished(player);

        if (isVanished){
            Component message = event.joinMessage();
            event.joinMessage(null);

            if (message != null){
                Bukkit.broadcast(message, "vanished.see");
            }
            Vanished.getInstance().setVanished(player, true, false, true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        boolean isVanished = Vanished.getInstance().isVanished(player);

        if (isVanished){
            Component message = event.quitMessage();
            event.quitMessage(null);

            if (message != null){
                Bukkit.broadcast(message, "vanished.see");
            }
        }
    }
}
