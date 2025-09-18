package net.azilcoff.azizmod.datagen;

import net.azilcoff.azizmod.AzizMod;
import net.azilcoff.azizmod.block.ModBlocks;
import net.azilcoff.azizmod.tag.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(DataGenerator p_126511_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126511_, AzizMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.Block.RUDIUM_ORES).add(ModBlocks.RUDIUM_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL).addTag(ModTags.Block.RUDIUM_ORES);
        tag(BlockTags.MINEABLE_WITH_PICKAXE).addTag(ModTags.Block.RUDIUM_ORES);

        super.addTags();
    }
}

