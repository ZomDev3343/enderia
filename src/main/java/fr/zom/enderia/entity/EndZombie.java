package fr.zom.enderia.entity;

import fr.zom.enderia.init.ModObjects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class EndZombie extends Zombie {
    public EndZombie(EntityType<? extends Zombie> p_34271_, Level p_34272_) {
        super(p_34271_, p_34272_);
    }

    public EndZombie(Level p_34274_) {
        this(ModObjects.END_ZOMBIE.get(), p_34274_);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 43.0D).add(Attributes.MOVEMENT_SPEED, (double) 0.23F).add(Attributes.ATTACK_DAMAGE, 5.0D).add(Attributes.ARMOR, 3.3D).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }
}
