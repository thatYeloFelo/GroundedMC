package net.thesyellow.groundedmc.entity.custom;


import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class silkEntity extends Arrow {

    public silkEntity(EntityType<? extends Arrow> entityType, Level level) {
        super(entityType, level);
    }
    @Override
    protected void onHitEntity(EntityHitResult ray) {
        int targetX=ray.getEntity().getBlockX();
        int targetY=ray.getEntity().getBlockY();
        int targetZ=ray.getEntity().getBlockZ();
        onHitEntity(ray);
        ray.getEntity();
        this.discard();
    }
    @Override
    protected void onHitBlock(BlockHitResult ray) {
        super.onHitBlock(ray);
        this.discard();
    }
}
