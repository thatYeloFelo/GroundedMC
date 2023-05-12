package net.thesyellow.groundedmc.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.thesyellow.groundedmc.GroundedMC;
import net.thesyellow.groundedmc.entity.custom.silkSpinnerEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.DataTicket;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class silkSpinnerModel extends GeoModel<silkSpinnerEntity> {
    @Override
    public ResourceLocation getModelResource(silkSpinnerEntity animatable) {
        return new ResourceLocation(GroundedMC.MOD_ID, "geo/silkspinnerbare.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(silkSpinnerEntity animatable) {
        return new ResourceLocation(GroundedMC.MOD_ID, "textures/entity/silkspinnerbare.png");
    }

    @Override
    public ResourceLocation getAnimationResource(silkSpinnerEntity animatable) {
        return new ResourceLocation(GroundedMC.MOD_ID, "animations/silkspinnerbare.animations.json");
    }

    @Override
    public void setCustomAnimations(silkSpinnerEntity animatable, long instanceId, AnimationState<silkSpinnerEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
