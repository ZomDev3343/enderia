package fr.zom.enderia.init;

import fr.zom.enderia.Enderia;
import fr.zom.enderia.blocks.BaseBlock;
import fr.zom.enderia.blocks.TeleportingTntBlock;
import fr.zom.enderia.entity.EndCreeper;
import fr.zom.enderia.entity.EndZombie;
import fr.zom.enderia.entity.FireEnderman;
import fr.zom.enderia.entity.PrimedTPTnt;
import fr.zom.enderia.items.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.awt.*;
import java.util.function.Supplier;

public class ModObjects {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Enderia.MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Enderia.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BE = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Enderia.MODID);
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Enderia.MODID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Enderia.MODID);

    ///////////////////////////////////////////////////////////////////////////
    // ENTITIES
    ///////////////////////////////////////////////////////////////////////////

    public static final RegistryObject<EntityType<PrimedTPTnt>> PRIMED_TP_TNT = ENTITIES.register("primed_tp_tnt",
            () -> EntityType.Builder.<PrimedTPTnt>of(PrimedTPTnt::new, MobCategory.MISC).fireImmune().sized(0.98F, 0.98F).clientTrackingRange(10).updateInterval(10).build(Enderia.MODID + ":primed_tp_tnt"));

    public static final RegistryObject<EntityType<FireEnderman>> FIRE_ENDERMAN = ENTITIES.register("fire_enderman",
            () -> EntityType.Builder.of(FireEnderman::new, MobCategory.MONSTER).fireImmune().sized(0.6F, 2.9F).clientTrackingRange(8).build(Enderia.MODID + ":fire_enderman"));

    public static final RegistryObject<EntityType<EndZombie>> END_ZOMBIE = ENTITIES.register("end_zombie",
            () -> EntityType.Builder.<EndZombie>of(EndZombie::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(Enderia.MODID + ":end_zombie"));

    public static final RegistryObject<EntityType<EndCreeper>> END_CREEPER = ENTITIES.register("end_creeper",
            () -> EntityType.Builder.of(EndCreeper::new, MobCategory.MONSTER).sized(0.6F, 1.7F).clientTrackingRange(8).build(Enderia.MODID + ":end_creeper"));


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
    public static final RegistryObject<Item> ENDERITE_HORSE_ARMOR = ITEMS.register("enderite_horse_armor", () -> new HorseArmorItem(13,
            new ResourceLocation(Enderia.MODID, "textures/entity/horse/armor/enderite_horse_armor.png"),
            new Item.Properties().tab(Enderia.ITEMS)));

    public static final RegistryObject<Item> FIRE_ENDERMAN_SPAWN_EGG = ITEMS.register("fire_enderman_spawn_egg", () -> new ForgeSpawnEggItem(FIRE_ENDERMAN,
            Color.ORANGE.getRGB(),
            Color.DARK_GRAY.getRGB(),
            new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> END_ZOMBIE_SPAWN_EGG = ITEMS.register("end_zombie_spawn_egg", () -> new ForgeSpawnEggItem(END_ZOMBIE,
            new Color(119, 41, 193).getRGB(),
            new Color(60, 13, 97).getRGB(),
            new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> END_CREEPER_SPAWN_EGG = ITEMS.register("end_creeper_spawn_egg", () -> new ForgeSpawnEggItem(END_CREEPER,
            new Color(147, 108, 186).getRGB(),
            new Color(67, 31, 104).getRGB(),
            new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> DRAGON_SKIN = ITEMS.register("dragon_skin", BaseItem::new);
    public static final RegistryObject<Item> DRAGON_HELMET = ITEMS.register("dragon_helmet", () -> new BaseItemArmor(ModArmorMaterial.DRAGON, EquipmentSlot.HEAD));
    public static final RegistryObject<Item> DRAGON_CHESTPLATE = ITEMS.register("dragon_chestplate", () -> new BaseItemArmor(ModArmorMaterial.DRAGON, EquipmentSlot.CHEST));
    public static final RegistryObject<Item> DRAGON_LEGGINGS = ITEMS.register("dragon_leggings", () -> new BaseItemArmor(ModArmorMaterial.DRAGON, EquipmentSlot.LEGS));
    public static final RegistryObject<Item> DRAGON_BOOTS = ITEMS.register("dragon_boots", () -> new BaseItemArmor(ModArmorMaterial.DRAGON, EquipmentSlot.FEET));

    ///////////////////////////////////////////////////////////////////////////
    // BLOCKS
    ///////////////////////////////////////////////////////////////////////////
    public static final RegistryObject<Block> ENDERITE_ORE = createBlock("enderite_ore", () -> new BaseBlock(Material.STONE, 3f, 10f, SoundType.STONE));
    public static final RegistryObject<Block> ENDERITE_BLOCK = createBlock("enderite_block", () -> new BaseBlock(Material.STONE, 5f, 20f, SoundType.METAL));

    public static final RegistryObject<Block> TELEPORTING_TNT = createBlock("teleporting_tnt", TeleportingTntBlock::new);


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
    public static final Tag.Named<Item> DRAGON_SKIN_TAG = ItemTags.bind("dragon_skin");

    private static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supp, CreativeModeTab group) {
        RegistryObject<Block> block = BLOCKS.register(name, supp);
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(group)));
        return block;
    }

    private static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supp) {
        return createBlock(name, supp, Enderia.BLOCKS);
    }


}
