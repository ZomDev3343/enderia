package fr.zom.enderia;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
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
            return new ItemStack(Items.ENDER_PEARL);
        }

    };

    public static final CreativeModeTab BLOCKS = new CreativeModeTab("%s.blocks".formatted(MODID)) {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Blocks.PURPUR_PILLAR);
        }

    };

    public Enderia() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::setup);
        bus.addListener(this::clientSetup);

    }

    public void setup(final FMLCommonSetupEvent e) {

    }

    public void clientSetup(final FMLClientSetupEvent e) {

    }
}
