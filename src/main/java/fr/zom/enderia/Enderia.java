package fr.zom.enderia;

import fr.zom.enderia.entity.renderers.FireEndermanRenderer;
import fr.zom.enderia.entity.renderers.TPTntRenderer;
import fr.zom.enderia.init.ModObjects;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Enderia.MODID)
public class Enderia {

    public static final String MODID = "enderia";

    public static final CreativeModeTab ITEMS = new CreativeModeTab("%s.items".formatted(MODID)) {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModObjects.ENDERITE_RAW.get());
        }

    };

    public static final CreativeModeTab BLOCKS = new CreativeModeTab("%s.blocks".formatted(MODID)) {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModObjects.ENDERITE_BLOCK.get());
        }

    };

    public Enderia() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        registerAll(bus);

        bus.addListener(this::setup);
        bus.addListener(this::clientSetup);

    }

    public void setup(final FMLCommonSetupEvent e) {

    }

    public void clientSetup(final FMLClientSetupEvent e) {
        registerEntityRenderers();
    }

    private void registerAll(IEventBus bus) {
        ModObjects.ITEMS.register(bus);
        ModObjects.BLOCKS.register(bus);
        ModObjects.BE.register(bus);
        ModObjects.MENUS.register(bus);
        ModObjects.ENTITIES.register(bus);
    }

    private void registerEntityRenderers() {
        EntityRenderers.register(ModObjects.PRIMED_TP_TNT.get(), TPTntRenderer::new);
        EntityRenderers.register(ModObjects.FIRE_ENDERMAN.get(), FireEndermanRenderer::new);
    }
}
