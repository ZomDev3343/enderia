package fr.zom.enderia.data.models;

import fr.zom.enderia.Enderia;
import fr.zom.enderia.data.DataGen;
import fr.zom.enderia.init.ModObjects;
import fr.zom.enderia.items.BaseItem;
import fr.zom.enderia.items.BaseItemArmor;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TieredItem;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.fmllegacy.RegistryObject;

public class ItemModelGen extends ItemModelProvider {

    public ItemModelGen(DataGenerator generator) {
        super(generator, Enderia.MODID, DataGen.DISABLED_FH);
    }

    @Override
    protected void registerModels() {
        for (RegistryObject<Item> itemObject : ModObjects.ITEMS.getEntries()) {
            if (itemObject.get() instanceof BlockItem) {
                blockItem(itemObject.get());
            } else if (itemObject.get() instanceof TieredItem) {
                handheld(itemObject.get());
            } else if (itemObject.get().getClass() == Item.class || itemObject.get().getClass() == BaseItem.class || itemObject.get().getClass() == BaseItemArmor.class) {
                generated(itemObject.get());
            } else if (itemObject.get() instanceof ForgeSpawnEggItem) {
                spawnEgg(itemObject.get());
            }

            generated(ModObjects.ENDERITE_HORSE_ARMOR.get());
        }
    }


    private void blockItem(Item item) {
        withExistingParent(item.getRegistryName().getPath(), modLoc("block/" + item.getRegistryName().getPath()));
    }

    private void generated(Item item) {
        String itemName = item.getRegistryName().getPath();
        withExistingParent(itemName, mcLoc("item/generated"))
                .texture("layer0", modLoc("item/" + itemName));
    }

    private void handheld(Item item) {
        String itemName = item.getRegistryName().getPath();
        withExistingParent(itemName, mcLoc("item/handheld"))
                .texture("layer0", modLoc("item/" + itemName));
    }

    private void spawnEgg(Item item) {
        String itemName = item.getRegistryName().getPath();
        withExistingParent(itemName, mcLoc("item/template_spawn_egg"));
    }
}
