package net.thesyellow.groundedmc.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thesyellow.groundedmc.GroundedMC;
import net.thesyellow.groundedmc.entity.custom.silkSpinnerEntity;

public class modEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, GroundedMC.MOD_ID);

    public static final RegistryObject<EntityType<silkSpinnerEntity>> SILKSPINNER =
            ENTITY_TYPES.register("silkspinner",
                    () -> EntityType.Builder.of(silkSpinnerEntity::new, MobCategory.CREATURE)
                            .sized(3.75f, 2.0f)
                            .build(new ResourceLocation(GroundedMC.MOD_ID, "silkspinner").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register((eventBus));
    }
}
