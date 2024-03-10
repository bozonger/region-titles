package com.github.bozonger.region_titles.events;

import com.github.bozonger.region_titles.RegionTitle;
import com.github.bozonger.region_titles.commands.RTitlesCreate;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;
import org.codehaus.plexus.util.cli.Commandline;

@Mod.EventBusSubscriber(modid = RegionTitle.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event){
        new RTitlesCreate(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

}
