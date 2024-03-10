package com.github.bozonger.region_titles.commands.models;

import net.minecraft.core.BlockPos;

public class RTitles {
    public String RegionName;
    public BlockPos Pos1;

    public RTitles(String name, BlockPos pos1){
        RegionName = name;
        Pos1 = pos1;
    }
}
