package net.mat0u5.focusedwardens.command;

import com.mojang.brigadier.CommandDispatcher;
import net.mat0u5.focusedwardens.Main;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Player;

import static net.minecraft.commands.Commands.literal;


public class Command {

    public static void register(CommandDispatcher<CommandSourceStack> serverCommandSourceCommandDispatcher,
                                CommandBuildContext commandRegistryAccess,
                                Commands.CommandSelection registrationEnvironment) {
        serverCommandSourceCommandDispatcher.register(
            literal("focusedwardens")
                .then(literal("enable")
                    .executes(context -> Command.setConfigValue(
                        context.getSource(),"enabled","true")
                    )
                )
                .then(literal("disable")
                    .executes(context -> Command.setConfigValue(
                        context.getSource(),"enabled","false")
                    )
                )
                .then(literal("settings")
                    /*
                    .then(literal("ignoreWardenSounds")
                        .then(literal("enable")
                            .executes(context -> Command.setConfigValue(
                                context.getSource(),"ignoreWardenSounds","true")
                            )
                        )
                        .then(literal("disable")
                            .executes(context -> Command.setConfigValue(
                                context.getSource(),"ignoreWardenSounds","false")
                            )
                        )
                    )*/
                    .then(literal("ignoreNonEntitySounds")
                        .then(literal("enable")
                            .executes(context -> Command.setConfigValue(
                                context.getSource(),"ignoreNonEntitySounds","true")
                            )
                        )
                        .then(literal("disable")
                            .executes(context -> Command.setConfigValue(
                                context.getSource(),"ignoreNonEntitySounds","false")
                            )
                        )
                    )
                    .then(literal("ignoreNonPlayerSounds")
                        .then(literal("enable")
                            .executes(context -> Command.setConfigValue(
                                context.getSource(),"ignoreNonPlayerSounds","true")
                            )
                        )
                        .then(literal("disable")
                            .executes(context -> Command.setConfigValue(
                                context.getSource(),"ignoreNonPlayerSounds","false")
                            )
                        )
                    )
                )
        );
    }
    public static int setConfigValue(CommandSourceStack source, String configName, String value) {
        MinecraftServer server = source.getServer();
        final Player self = source.getPlayer();
        Main.config.setProperty(configName,value);
        return 1;
    }
}
