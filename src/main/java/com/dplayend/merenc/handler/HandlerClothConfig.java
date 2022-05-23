package com.dplayend.merenc.handler;

import com.dplayend.merenc.MergeEnchantments;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = MergeEnchantments.MOD_ID)
public class HandlerClothConfig implements ConfigData {
    @ConfigEntry.Category("General")
    @ConfigEntry.Gui.CollapsibleObject
    public boolean protection = true;

    @ConfigEntry.Category("General")
    @ConfigEntry.Gui.CollapsibleObject
    public boolean bow = true;

    @ConfigEntry.Category("General")
    @ConfigEntry.Gui.CollapsibleObject
    public boolean crossbow = true;

    @ConfigEntry.Category("General")
    @ConfigEntry.Gui.CollapsibleObject
    public boolean weapon = true;

    @ConfigEntry.Category("General")
    @ConfigEntry.Gui.CollapsibleObject
    public boolean trident = true;

    @ConfigEntry.Category("General")
    @ConfigEntry.Gui.CollapsibleObject
    public boolean boots = true;

    //@ConfigEntry.Category("General")
    //@ConfigEntry.Gui.CollapsibleObject
    //public boolean silkTouch = true;
}
