package fr.zom.enderia.data.other.tags;

import fr.zom.enderia.Enderia;
import fr.zom.enderia.data.DataGen;
import fr.zom.enderia.init.ModObjects;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;

public class ItemTagGenerator extends ItemTagsProvider {


    public ItemTagGenerator(DataGenerator gen, BlockTagsProvider blockTagProvider) {
        super(gen, blockTagProvider, Enderia.MODID, DataGen.DISABLED_FH);
    }

    @Override
    public void addTags() {

        tag(ModObjects.ENDERITE_RAW_TAG).add(ModObjects.ENDERITE_RAW.get());
        tag(ModObjects.ENDERITE_INGOT_TAG).add(ModObjects.ENDERITE_INGOT.get());
        tag(ModObjects.STICKS).add(Items.STICK);

    }


}
