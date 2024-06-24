package net.oliverbravery.coda.utilities;

import net.minecraft.client.MinecraftClient;
import net.oliverbravery.coda.features.*;

public class KeybindEvents {
    public static void tick(MinecraftClient client) {
        //Checks for keybindings pressed
        AutoSaveTool.KeybindCheck();
        SlotRandomiser.KeybindCheck();
        ArmorSwap.KeybindCheck();
        FastPlace.KeybindCheck();
        AutoSwapTools.KeybindCheck();
    }

    public static void InitializeKeybinds() {
        ArmorSwap.SetArmorSwapKeybind();
        AutoSaveTool.SetAutoSaveToolKeybind();
        FastPlace.SetKeybind();
        AutoSwapTools.SetKeybind();
    }
}
