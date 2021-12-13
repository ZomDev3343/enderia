package fr.zom.enderia.init;

import fr.zom.enderia.Enderia;
import fr.zom.enderia.blocks.BaseBlock;
import fr.zom.enderia.items.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModObjects {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Enderia.MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Enderia.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BE = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Enderia.MODID);
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Enderia.MODID);

    ///////////////////////////////////////////////////////////////////////////
    // ITEMS
    ///////////////////////////////////////////////////////////////////////////

    public static final RegistryObject<Item> ENDERITE_RAW = ITEMS.register("enderite_raw", BaseItem::new);
    public static final RegistryObject<Item> ENDERITE_INGOT = ITEMS.register("enderite_ingot", BaseItem::new);

    public static final RegistryObject<Item> ENDERITE_SWORD = ITEMS.register("enderite_sword", () -> new BaseItemSword(ModTiers.ENDERITE_TIER));
    public static final RegistryObject<Item> ENDERITE_PICKAXE = ITEMS.register("enderite_pickaxe", () -> new BaseItemPickaxe(ModTiers.ENDERITE_TIER));
    public static final RegistryObject<Item> ENDERITE_AXE = ITEMS.register("enderite_axe", () -> new BaseItemAxe(ModTiers.ENDERITE_TIER));
    public static final RegistryObject<Item> ENDERITE_SHOVEL = ITEMS.register("enderite_shovel", () -> new BaseItemShovel(ModTiers.ENDERITE_TIER));
    public static final RegistryObject<Item> ENDERITE_HOE = ITEMS.register("enderite_hoe", () -> new BaseItemHoe(ModTiers.ENDERITE_TIER));

    public static final RegistryObject<Item> ENDERITE_HELMET = ITEMS.register("enderite_helmet", () -> new BaseItemArmor(ModArmorMaterial.ENDERITE, EquipmentSlot.HEAD));
    public static final RegistryObject<Item> ENDERITE_CHESTPLATE = ITEMS.register("enderite_chestplate", () -> new BaseItemArmor(ModArmorMaterial.ENDERITE, EquipmentSlot.CHEST));
    public static final RegistryObject<Item> ENDERITE_LEGGINGS = ITEMS.register("enderite_leggings", () -> new BaseItemArmor(ModArmorMaterial.ENDERITE, EquipmentSlot.LEGS));
    public static final RegistryObject<Item> ENDERITE_BOOTS = ITEMS.register("enderite_boots", () -> new BaseItemArmor(ModArmorMaterial.ENDERITE, EquipmentSlot.FEET));


    ///////////////////////////////////////////////////////////////////////////
    // BLOCKS
    ///////////////////////////////////////////////////////////////////////////

    public static final RegistryObject<Block> ENDERITE_ORE = createBlock("enderite_ore", () -> new BaseBlock(Material.STONE, 3f, 10f, SoundType.STONE));
    public static final RegistryObject<Block> ENDERITE_BLOCK = createBlock("enderite_block", () -> new BaseBlock(Material.STONE, 5f, 20f, SoundType.METAL));

    private static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supp, CreativeModeTab group) {
        RegistryObject<Block> block = BLOCKS.register(name, supp);
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(group)));
        return block;
    }

    private static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supp) {
        return createBlock(name, supp, Enderia.BLOCKS);
    }

    ///////////////////////////////////////////////////////////////////////////
    // BLOCK ENTITIES
    ///////////////////////////////////////////////////////////////////////////


    ///////////////////////////////////////////////////////////////////////////
    // MENUS
    ///////////////////////////////////////////////////////////////////////////


    ///////////////////////////////////////////////////////////////////////////
    // TAGS
    ///////////////////////////////////////////////////////////////////////////


    /* Block Tags */
    public static final Tag.Named<Block> NEEDS_ENDRITE_TOOL = BlockTags.bind("needs_enderite_tool");

    /* Item Tags */
    public static final Tag.Named<Item> ENDERITE_RAW_TAG = ItemTags.bind("enderite_raw");
    public static final Tag.Named<Item> ENDERITE_INGOT_TAG = ItemTags.bind("enderite_ingot");
    public static final Tag.Named<Item> STICKS = ItemTags.bind("sticks");


}
