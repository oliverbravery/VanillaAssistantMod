package net.oliverbravery.coda.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.RegistryEntryArgumentType;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.oliverbravery.coda.features.AutoSwapTools;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public class AutoSwapToolsCommand {
    public static LiteralCommandNode register(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess) {
        return dispatcher.register(
                literal("coda")
                        .then(literal("autoswaptools")
                                .executes(AutoSwapToolsCommand::Run)
                                .then(literal("enchantblacklist")
                                        .then(literal("toggle")
                                                .executes(AutoSwapToolsCommand::EnchantBlacklistToggle)))));
    }

    private static Enchantment GetEnchant(CommandContext<FabricClientCommandSource> context){
        RegistryEntry<Enchantment> enchantment = context.getArgument("enchant", RegistryEntry.class);
        Enchantment e = (Enchantment)enchantment.value();
        return e;
    }

    private static int Run(CommandContext<FabricClientCommandSource> context){
        return AutoSwapTools.Toggle();
    }
    private static int EnchantBlacklistDisplay(CommandContext<FabricClientCommandSource> context){return AutoSwapTools.DisplayEnchantBlacklist();}
    private static int EnchantBlacklistToggle(CommandContext<FabricClientCommandSource> context){return AutoSwapTools.ToggleEnchantBlacklist();}
}
