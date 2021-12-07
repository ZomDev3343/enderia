package fr.zom.enderia.data.other.tags;

import fr.zom.enderia.Enderia;
import fr.zom.enderia.data.DataGen;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;

public class ItemTagGenerator extends ItemTagsProvider {


    public ItemTagGenerator(DataGenerator gen, BlockTagsProvider blockTagProvider) {
        super(gen, blockTagProvider, Enderia.MODID, DataGen.DISABLED_FH);
    }

    @Override
    public void addTags() {




    }


}
