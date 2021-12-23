package fr.zom.enderia.entity.renderers;

import fr.zom.enderia.Enderia;
import net.minecraft.client.renderer.entity.EndermanRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.EnderMan;

public class FireEndermanRenderer extends EndermanRenderer {

    public FireEndermanRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(EnderMan pEntity) {
        return new ResourceLocation(Enderia.MODID, "textures/entity/fire_enderman/fire_enderman.png");
    }
}
