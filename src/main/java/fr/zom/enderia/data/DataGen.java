package fr.zom.enderia.data;

import com.google.common.collect.Sets;
import fr.zom.enderia.Enderia;
import fr.zom.enderia.data.loottable.LootTablesGenerator;
import fr.zom.enderia.data.models.BlockstateGenerator;
import fr.zom.enderia.data.models.ItemModelGen;
import fr.zom.enderia.data.other.LangGenerator;
import fr.zom.enderia.data.other.tags.BlockTagGenerator;
import fr.zom.enderia.data.other.tags.ItemTagGenerator;
import fr.zom.enderia.data.recipes.RecipeGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

import java.util.Collections;

@Mod.EventBusSubscriber(modid = Enderia.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DataGen {

    public static final ExistingFileHelper DISABLED_FH = new ExistingFileHelper(Collections.emptyList(), Sets.newHashSet(), false, null, null);

    @SubscribeEvent
    public static void dataGen(final GatherDataEvent e) {

        DataGenerator gen = e.getGenerator();

        if (e.includeServer()) {
            gen.addProvider(new RecipeGenerator(gen));
            BlockTagsProvider blockTags = new BlockTagGenerator(gen);
            gen.addProvider(blockTags);
            gen.addProvider(new ItemTagGenerator(gen, blockTags));
            gen.addProvider(new LootTablesGenerator(gen));
        }

        if (e.includeClient()) {
            gen.addProvider(new ItemModelGen(gen));
            gen.addProvider(new LangGenerator(gen));
            gen.addProvider(new BlockstateGenerator(gen));
        }
    }
}
