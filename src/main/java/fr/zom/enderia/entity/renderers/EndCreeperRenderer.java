package fr.zom.enderia.entity.renderers;

import fr.zom.enderia.Enderia;
import net.minecraft.client.renderer.entity.CreeperRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Creeper;

public class EndCreeperRenderer extends CreeperRenderer {

    public EndCreeperRenderer(EntityRendererProvider.Context p_173958_) {
        super(p_173958_);
    }

    @Override
    public ResourceLocation getTextureLocation(Creeper pEntity) {
        return new ResourceLocation(Enderia.MODID, "textures/entity/creeper/end_creeper.png");
    }
}
