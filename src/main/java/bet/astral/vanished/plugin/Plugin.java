package bet.astral.vanished.plugin;

import bet.astral.cloudplusplus.minecraft.paper.bootstrap.InitAfterBootstrap;
import bet.astral.messenger.v2.Messenger;
import bet.astral.vanished.listener.BuildListener;
import bet.astral.vanished.listener.ConnectionListener;
import bet.astral.vanished.listener.DamageListener;
import lombok.AccessLevel;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

@Getter
public class Plugin extends JavaPlugin {
    private Messenger messenger;
    @Getter(AccessLevel.NONE)
    private List<InitAfterBootstrap> initAfterBootstrapList;

    public Plugin(Bootstrap bootstrapHandler) {
        this.messenger = bootstrapHandler.getMessenger();
        for (InitAfterBootstrap initAfterBootstrap : bootstrapHandler) {
            initAfterBootstrapList.add(initAfterBootstrap);
        }
    }

    @Override
    public void onEnable() {
        initAfterBootstrapList.forEach(InitAfterBootstrap::init);

        getServer().getPluginManager().registerEvents(new ConnectionListener(), this);
        getServer().getPluginManager().registerEvents(new BuildListener(), this);
        getServer().getPluginManager().registerEvents(new DamageListener(), this);
    }
    @Override
    public void onDisable() {
    }
    @Override
    public void onLoad() {

    }
}
