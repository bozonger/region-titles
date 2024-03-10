package com.github.bozonger.region_titles.commands;

import com.github.bozonger.region_titles.commands.models.RTitles;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;


public class RTitlesCreate {
    public RTitlesCreate(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("rtitles").then(Commands.literal("create").then(Commands.argument("regionName", StringArgumentType.string())
                .executes((command) -> {
                    return execute(command.getSource(), StringArgumentType.getString(command,"regionName"));
                }
        ))));
    }

    private int execute(CommandSourceStack source, String regionName) throws CommandSyntaxException {
        Player executor = Minecraft.getInstance().player;

        RTitles rtitle = new RTitles(regionName, executor.getOnPos());

        executor.sendSystemMessage(Component.literal("A region with name ").append(rtitle.RegionName).withStyle(ChatFormatting.AQUA).withStyle(ChatFormatting.BOLD).append(" ").append("with starting position of ").append(String.valueOf(rtitle.Pos1.getX()) + " " + String.valueOf(rtitle.Pos1.getY()) + " " + String.valueOf(rtitle.Pos1.getZ())).append(" has been created."));

        return 1;
    }
}
