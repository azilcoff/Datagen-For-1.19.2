package net.azilcoff.azizmod.datagen;

import net.azilcoff.azizmod.AzizMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AzizMod.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        dataGenerator.addProvider(event.includeServer(), new ModRecipeProvider(dataGenerator));

        dataGenerator.addProvider(event.includeClient(), new ModBlockStateProvider(dataGenerator, existingFileHelper));
        dataGenerator.addProvider(event.includeClient(), new ModItemModelProvider(dataGenerator, existingFileHelper));

        ModBlockTagProvider modBlockTagProvider = new ModBlockTagProvider(dataGenerator, existingFileHelper);
        dataGenerator.addProvider(event.includeServer(), new ModItemTagProvider(dataGenerator, modBlockTagProvider, existingFileHelper));

        dataGenerator.addProvider(event.includeServer(), new ModLootTableProvider(dataGenerator));
    }

}
