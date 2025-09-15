package bet.astral.vanished;

import bet.astral.vanished.manager.VanishManager;
import bet.astral.vanished.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Vanished {
    private static Vanished instance;
    private Plugin plugin;
    private final VanishManager vanishManager = new VanishManager();

    public static Vanished getInstance() {
        if (instance == null) {
            setup();
        }
        return instance;
    }

    public static void setup() {
        instance = new Vanished();
    }

    public Plugin getPlugin() {
        if (plugin == null) {
            plugin = (Plugin) Bukkit.getPluginManager().getPlugin("Vanished");
        }
        return plugin;
    }

    public boolean isVanished(Player player) {
        return vanishManager.isVanished(player);
    }

    public void toggleVanish(@NotNull Player player, boolean connectionMessage, boolean toggleMessage) {
        vanishManager.toggleVanish(player, connectionMessage, toggleMessage);
    }

    public void setVanished(@NotNull Player player, boolean value, boolean connectionMessage, boolean toggleMessage) {
        vanishManager.setVanished(player, value, connectionMessage, toggleMessage);
    }

    public void toggleFlight(Player player, boolean toggleMessage) {
        vanishManager.toggleFlight(player, toggleMessage);
    }

    public void toggleBuilding(Player player, boolean toggleMessage) {
        vanishManager.toggleBuilding(player, toggleMessage);
    }

    public boolean isBuildingEnabled(@NotNull Player player) {
        return vanishManager.isBuildingEnabled(player);
    }

    public boolean canAttack(Player player) {
        return vanishManager.isAttackingEnabled(player);
    }
    public void toggleAttacking(Player player, boolean toggleMessage) {
        vanishManager.toggleAttacking(player, toggleMessage);
    }
}
