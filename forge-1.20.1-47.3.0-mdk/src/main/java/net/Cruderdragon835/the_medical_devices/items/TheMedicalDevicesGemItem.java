package net.Cruderdragon835.the_medical_devices.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.Cruderdragon835.the_medical_devices.the_medical_devices;
import net.minecraftforge.registries.RegistryObject;

public class TheMedicalDevicesGemItem {
    public static final DeferredRegister<Item> ITEMS =DeferredRegister.create(ForgeRegistries.ITEMS, the_medical_devices.MOD_ID);

    public static void init(IEventBus iEventBus){ ITEMS.register(iEventBus);}

    public static final RegistryObject<Item>  THE_MEDICAL_DEVICES_GEM_ITEM = ITEMS.register("the_medical_devices_gem_item",
            () -> new Item(new Item.Properties()));
}
