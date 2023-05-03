package net.thesyellow.groundedmc.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thesyellow.groundedmc.GroundedMC;
import net.thesyellow.groundedmc.item.modItems;

import javax.swing.*;
import java.util.function.Supplier;

public class modBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, GroundedMC.MOD_ID);
    public static final RegistryObject<Block> TIGHTLYWOVENWEB = registerBlock("tightlywovenweb", () -> new Block(BlockBehaviour.Properties.of(Material.BARRIER).destroyTime(-1)));
    public static final RegistryObject<Block> LOOSELYWOVENWEB = registerBlock("looselywovenweb", () -> new Block(BlockBehaviour.Properties.of(Material.WEB).strength(6f).requiresCorrectToolForDrops()));
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return modItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
