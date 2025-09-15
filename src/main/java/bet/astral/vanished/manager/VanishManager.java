package bet.astral.vanished.manager;

import bet.astral.vanished.Vanished;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class VanishManager {
    private static final NamespacedKey VANISHED = new NamespacedKey("vanished", "bVanished");
    private static final NamespacedKey CAN_BUILD = new NamespacedKey("vanished", "bBuild");
    private static final NamespacedKey CAN_ATTACK = new NamespacedKey("vanished", "bAttack");
    public boolean isVanished(@NotNull Player player) {
        return player.getPersistentDataContainer().getOrDefault(VANISHED, PersistentDataType.BOOLEAN, false);
    }

    public void toggleVanish(@NotNull Player player, boolean connectionMessage, boolean toggleMessage) {
        boolean isVanished = isVanished(player);
        setVanished(player, !isVanished, connectionMessage, toggleMessage);
    }

    public void setVanished(@NotNull Player player, boolean value, boolean connectionMessage, boolean toggleMessage) {
        player.getPersistentDataContainer().set(VANISHED, PersistentDataType.BOOLEAN, value);

        Bukkit.getOnlinePlayers().forEach(p -> {
            if (value){
                if (!p.hasPermission("vanished.see")) {
                    p.hidePlayer(Vanished.getInstance().getPlugin(), player);
                }
            } else {
                p.showPlayer(Vanished.getInstance().getPlugin(), player);
            }
        });
        // TODO
    }

    public void toggleFlight(Player player, boolean toggleMessage) {
        boolean isFlightEnabled = !player.getAllowFlight();
        player.setAllowFlight(isFlightEnabled);

        // TODO
    }

    public void toggleBuilding(Player player, boolean toggleMessage) {
        boolean canBuild = isBuildingEnabled(player);
        setBuildingEnabled(player, !canBuild, toggleMessage);
    }

    public boolean isBuildingEnabled(@NotNull Player player) {
        return player.getPersistentDataContainer().getOrDefault(CAN_BUILD, PersistentDataType.BOOLEAN, false);
    }

    public void setBuildingEnabled(@NotNull Player player, boolean value, boolean toggleMessage) {
        player.getPersistentDataContainer().set(CAN_BUILD, PersistentDataType.BOOLEAN, value);

        // TODO
    }

    public boolean isAttackingEnabled(@NotNull Player player) {
        return player.getPersistentDataContainer().getOrDefault(CAN_ATTACK, PersistentDataType.BOOLEAN, false);
    }

    public void toggleAttacking(@NotNull Player player, boolean toggleMessage) {
        boolean isVanished = isAttackingEnabled(player);
        setAttackingEnabled(player, !isVanished, toggleMessage);
    }

    public void setAttackingEnabled(@NotNull Player player, boolean value, boolean toggleMessage) {
        player.getPersistentDataContainer().set(CAN_ATTACK, PersistentDataType.BOOLEAN, value);
        // TODO
    }
}
