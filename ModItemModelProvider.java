package net.azilcoff.azizmod.datagen;

import net.azilcoff.azizmod.AzizMod;
import net.azilcoff.azizmod.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, AzizMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.AREA_FLATTENER);
        simpleItem(ModItems.RANDOM_PROJECTILE_THROWER);
        simpleItem(ModItems.RAW_RUDIUM);
        simpleItem(ModItems.RUDIUM);
    }
    private ItemModelBuilder simpleItem (RegistryObject<Item> itemRegistryObject){
        return withExistingParent(itemRegistryObject.getId().getPath(),
            ResourceLocation.tryParse("item/generated")).texture("layer0",ResourceLocation.tryBuild(AzizMod.MOD_ID,"item/"+itemRegistryObject.getId().getPath()));
    }
}
