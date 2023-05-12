package net.thesyellow.groundedmc.entity.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.thesyellow.groundedmc.GroundedMC;
import net.thesyellow.groundedmc.entity.custom.silkSpinnerEntity;
import net.thesyellow.groundedmc.entity.modEntities;

@Mod.EventBusSubscriber(modid = GroundedMC.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class modEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(modEntities.SILKSPINNER.get(), silkSpinnerEntity.setAttributes());
    }
}
