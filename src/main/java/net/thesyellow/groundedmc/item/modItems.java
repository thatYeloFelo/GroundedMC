package net.thesyellow.groundedmc.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.extensions.IForgePackResources;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thesyellow.groundedmc.GroundedMC;

public class modItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GroundedMC.MOD_ID);
    public static final RegistryObject<Item> TEALWIDOW_FANG = ITEMS.register("tealwidow_fang", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEALWIDOW_VENOM = ITEMS.register("tealwidow_venom", () -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
