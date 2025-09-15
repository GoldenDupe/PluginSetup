package bet.astral.vanished.command;

import bet.astral.cloudplusplus.CommandRegisterer;
import bet.astral.cloudplusplus.annotations.Cloud;
import bet.astral.vanished.Vanished;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.entity.Player;
import org.incendo.cloud.CommandManager;
import org.incendo.cloud.bukkit.parser.PlayerParser;
import org.incendo.cloud.description.Description;
import org.incendo.cloud.parser.flag.CommandFlag;

@Cloud
public class VanishCommand extends PluginCommand{
    public VanishCommand(CommandRegisterer<CommandSourceStack> registerer, CommandManager<CommandSourceStack> commandManager) {
        super(registerer, commandManager);

        RegistrableCommand<? extends CommandSourceStack> mainCommand =
                command("vanish", (Description) null, b->
                        b
                                .permission("vanished.vanish")
                                .flag(CommandFlag.builder("silent"))
                                .optional(PlayerParser.playerComponent().name("who"))
                                .handler(context->{
                                    Player player = (Player) context.getOrDefault("who", context.sender().getSender());

                                    Vanished.getInstance().toggleVanish(player, context.flags().isPresent("silent"), true);
                                })
                        , "v");

        mainCommand.register();

        command(
                mainCommand.getBuilder()
                        .literal("toggle-building")
                        .permission("vanished.build")
                        .optional(PlayerParser.playerComponent().name("who"))
                        .handler(context->{
                            Player player = (Player) context.getOrDefault("who", context.sender().getSender());

                            Vanished.getInstance().toggleBuilding(player, true);
                        })
        );

        command(
                mainCommand.getBuilder()
                        .literal("toggle-flight")
                        .permission("vanished.fly")
                        .optional(PlayerParser.playerComponent().name("who"))
                        .handler(context->{
                            Player player = (Player) context.getOrDefault("who", context.sender().getSender());

                            Vanished.getInstance().toggleFlight(player, true);
                        })
        );

        command(
                mainCommand.getBuilder()
                        .literal("toggle-attacking")
                        .permission("vanished.attack")
                        .optional(PlayerParser.playerComponent().name("who"))
                        .handler(context->{
                            Player player = (Player) context.getOrDefault("who", context.sender().getSender());

                            Vanished.getInstance().toggleAttacking(player, true);
                        })
        );
    }
}
