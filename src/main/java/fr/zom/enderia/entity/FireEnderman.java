package fr.zom.enderia.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class FireEnderman extends EnderMan {

    public FireEnderman(EntityType<? extends EnderMan> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 60.0D).add(Attributes.MOVEMENT_SPEED, (double) 0.3F).add(Attributes.ATTACK_DAMAGE, 8.0D).add(Attributes.FOLLOW_RANGE, 64.0D);
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        boolean b = super.doHurtTarget(pEntity);

        if (b) pEntity.setSecondsOnFire(5);

        return b;
    }
}
