package net.thesyellow.groundedmc.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.thesyellow.groundedmc.GroundedMC;
import net.thesyellow.groundedmc.entity.custom.silkSpinnerEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class silkSpinnerRenderer extends GeoEntityRenderer<silkSpinnerEntity> {
    public silkSpinnerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new silkSpinnerModel());
    }

    @Override
    public ResourceLocation getTextureLocation(silkSpinnerEntity animatable) {
        return new ResourceLocation(GroundedMC.MOD_ID, "textures/entity/silkspinnerbare.png");
    }
}
