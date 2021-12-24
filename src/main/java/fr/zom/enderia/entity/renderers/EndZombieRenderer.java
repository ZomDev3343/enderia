package fr.zom.enderia.entity.renderers;

import fr.zom.enderia.Enderia;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Zombie;

public class EndZombieRenderer extends ZombieRenderer {

    public EndZombieRenderer(EntityRendererProvider.Context p_174456_) {
        super(p_174456_);
    }

    @Override
    public ResourceLocation getTextureLocation(Zombie pEntity) {
        return new ResourceLocation(Enderia.MODID, "textures/entity/zombie/end_zombie.png");
    }
}
