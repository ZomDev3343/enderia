package fr.zom.enderia.entity;

import fr.zom.enderia.init.ModObjects;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class PrimedTPTnt extends PrimedTnt {

    public PrimedTPTnt(EntityType<? extends PrimedTPTnt> p_32076_, Level p_32077_) {
        super(p_32076_, p_32077_);
    }

    public PrimedTPTnt(Level p_32079_, double p_32080_, double p_32081_, double p_32082_, @Nullable LivingEntity p_32083_) {
        this(ModObjects.PRIMED_TP_TNT.get(), p_32079_);
        this.setPos(p_32080_, p_32081_, p_32082_);
        double d0 = p_32079_.random.nextDouble() * (double) ((float) Math.PI * 2F);
        this.setDeltaMovement(-Math.sin(d0) * 0.02D, (double) 0.2F, -Math.cos(d0) * 0.02D);
        this.setFuse(40);
        this.xo = p_32080_;
        this.yo = p_32081_;
        this.zo = p_32082_;
    }

    @Override
    protected void explode() {
        AABB box = new AABB(blockPosition()).inflate(5D);
        List<Entity> entities = level.getEntities((Entity) null, box, entity -> true);
        if (entities.isEmpty()) return;

        entities.forEach(ent ->
        {
            Random r = new Random();
            int xOffset = r.nextInt(32) - 16;
            int yOffset = r.nextInt(16);
            int zOffset = r.nextInt(32) - 16;
            ent.teleportTo(ent.getX() + xOffset, ent.getY() + yOffset, ent.getZ() + zOffset);
        });

        level.playSound(null, blockPosition(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.BLOCKS, 1f, 1f);
    }
}
