package fr.zom.enderia.data.other;

import fr.zom.enderia.Enderia;
import fr.zom.enderia.init.ModObjects;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fmllegacy.RegistryObject;
import org.apache.commons.lang3.StringUtils;

public class LangGenerator extends LanguageProvider {

    public LangGenerator(DataGenerator gen) {
        super(gen, Enderia.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {

        add("itemGroup.enderia.blocks_group", "Enderia Blocks");
        add("itemGroup.enderia.items_group", "Enderia Items");

        for (RegistryObject<Item> item :
                ModObjects.ITEMS.getEntries()) {
            add(item.get(), formatName(item.get().getRegistryName().getPath()));
        }
    }

    private String formatName(String name)
    {
        String a = name.replace('_' , ' ');
        String[] b = a.split("[ ]");
        for(String c : b)
        {
            a = a.replace(c, StringUtils.capitalize(c));
        }
        return a;
    }
}
