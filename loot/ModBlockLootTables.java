package net.azilcoff.azizmod.datagen.loot;

import net.azilcoff.azizmod.block.ModBlocks;
import net.azilcoff.azizmod.item.ModItems;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class ModBlockLootTables extends BlockLoot {

    @Override
    protected void addTables() {
        this.add(ModBlocks.RUDIUM_ORE.get(),createOreDrop(ModBlocks.RUDIUM_ORE.get(), ModItems.RAW_RUDIUM.get()));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).filter(block -> {
            ResourceLocation id = ForgeRegistries.BLOCKS.getKey(block);
            return id != null && id.getNamespace().equals("azizmod");
        }).toList();
    }
}