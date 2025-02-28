package net.Cruderdragon835.the_medical_devices.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.Cruderdragon835.the_medical_devices.the_medical_devices;
import net.minecraftforge.registries.RegistryObject;

import java.util.UUID;

public class AdvancedGemItem extends Item{
    public static final DeferredRegister<Item> ITEMS =DeferredRegister.create(ForgeRegistries.ITEMS, the_medical_devices.MOD_ID);
    UUID uuidSpeedRaising = UUID.randomUUID();
    UUID uuidAttackReduction = UUID.randomUUID();

    public AdvancedGemItem(Properties pProperties) {
        super(pProperties);
    }

    public static void init(IEventBus iEventBus){ ITEMS.register(iEventBus);}

    public static final RegistryObject<Item>  ADVANCED_GEM_ITEM = ITEMS.register("advanced_gem_item",
            () -> new AdvancedGemItem(new Item.Properties()
                    .stacksTo(1)
                    .rarity(Rarity.EPIC)));

    //按 ctrl+o 查找方法，找isFoil，该方法为附魔光效，将super.isFoil(pStack)改为true
    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }

    //获得属性更改
    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> changeAttribute = HashMultimap.create();
        if (slot==EquipmentSlot.OFFHAND){
            changeAttribute.put(Attributes.MOVEMENT_SPEED,
                    new AttributeModifier(uuidSpeedRaising, "speed_raising",
                            0.07, AttributeModifier.Operation.ADDITION));

            changeAttribute.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(uuidAttackReduction, "attack_damage",
                            -4, AttributeModifier.Operation.ADDITION));
        }
        return changeAttribute;
    }
}
