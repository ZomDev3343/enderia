package fr.zom.enderia.events;

import fr.zom.enderia.Enderia;
import fr.zom.enderia.entity.FireEnderman;
import fr.zom.enderia.init.ModObjects;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Enderia.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityAttributesEvent {

    @SubscribeEvent
    public static void onEntityAttributeCreation(EntityAttributeCreationEvent e) {
        e.put(ModObjects.FIRE_ENDERMAN.get(), FireEnderman.createAttributes().build());
    }

}
