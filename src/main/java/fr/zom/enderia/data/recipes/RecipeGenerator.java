package fr.zom.enderia.data.recipes;

import fr.zom.enderia.Enderia;
import fr.zom.enderia.init.ModObjects;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider {

    public RecipeGenerator(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        oreSmelting(consumer, "enderite_ingot", ModObjects.ENDERITE_RAW_TAG, ModObjects.ENDERITE_INGOT.get());

        sword(consumer, "enderite_sword", ModObjects.ENDERITE_INGOT_TAG, ModObjects.STICKS, ModObjects.ENDERITE_SWORD.get());
        pickaxe(consumer, "enderite_pickaxe", ModObjects.ENDERITE_INGOT_TAG, ModObjects.STICKS, ModObjects.ENDERITE_PICKAXE.get());
        axe(consumer, "enderite_axe", ModObjects.ENDERITE_INGOT_TAG, ModObjects.STICKS, ModObjects.ENDERITE_AXE.get());
        shovel(consumer, "enderite_shovel", ModObjects.ENDERITE_INGOT_TAG, ModObjects.STICKS, ModObjects.ENDERITE_SHOVEL.get());
        hoe(consumer, "enderite_hoe", ModObjects.ENDERITE_INGOT_TAG, ModObjects.STICKS, ModObjects.ENDERITE_HOE.get());

        fullArmor(consumer,
                "enderite",
                ModObjects.ENDERITE_INGOT_TAG,
                ModObjects.ENDERITE_HELMET.get(),
                ModObjects.ENDERITE_CHESTPLATE.get(),
                ModObjects.ENDERITE_LEGGINGS.get(),
                ModObjects.ENDERITE_BOOTS.get());

    }

    private void ingotsToBlock(Consumer<FinishedRecipe> consumer, String name, ItemLike ingots, ItemLike block) {
        ShapedRecipeBuilder.shaped(block)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ingots)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ingots))
                .save(consumer, new ResourceLocation(Enderia.MODID, name));
    }

    private void blockToIngots(Consumer<FinishedRecipe> consumer, String name, ItemLike ingots, ItemLike block) {
        ShapelessRecipeBuilder.shapeless(ingots, 9)
                .requires(block)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(block))
                .save(consumer, new ResourceLocation(Enderia.MODID, name));
    }

    private void sword(Consumer<FinishedRecipe> consumer, String name, Tag<Item> material, Tag<Item> stick, ItemLike result) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("A")
                .pattern("A")
                .pattern("S")
                .define('A', material)
                .define('S', stick)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(material).build()))
                .save(consumer, new ResourceLocation(Enderia.MODID, name));
    }

    private void pickaxe(Consumer<FinishedRecipe> consumer, String name, Tag<Item> material, Tag<Item> stick, ItemLike result) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("AAA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', material)
                .define('S', stick)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(material).build()))
                .save(consumer, new ResourceLocation(Enderia.MODID, name));
    }

    private void axe(Consumer<FinishedRecipe> consumer, String name, Tag<Item> material, Tag<Item> stick, ItemLike result) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("AA")
                .pattern("AS")
                .pattern(" S")
                .define('A', material)
                .define('S', stick)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(material).build()))
                .save(consumer, new ResourceLocation(Enderia.MODID, name));
    }

    private void shovel(Consumer<FinishedRecipe> consumer, String name, Tag<Item> material, Tag<Item> stick, ItemLike result) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("A")
                .pattern("S")
                .pattern("S")
                .define('A', material)
                .define('S', stick)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(material).build()))
                .save(consumer, new ResourceLocation(Enderia.MODID, name));
    }

    private void hoe(Consumer<FinishedRecipe> consumer, String name, Tag<Item> material, Tag<Item> stick, ItemLike result) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("AA")
                .pattern(" S")
                .pattern(" S")
                .define('A', material)
                .define('S', stick)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(material).build()))
                .save(consumer, new ResourceLocation(Enderia.MODID, name));
    }

    private void helmet(Consumer<FinishedRecipe> consumer, String name, Tag<Item> material, ItemLike result) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("MMM")
                .pattern("M M")
                .define('M', material)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(material).build()))
                .save(consumer, new ResourceLocation(Enderia.MODID, name + "_helmet"));
    }

    private void chestplate(Consumer<FinishedRecipe> consumer, String name, Tag<Item> material, ItemLike result) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("M M")
                .pattern("MMM")
                .pattern("MMM")
                .define('M', material)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(material).build()))
                .save(consumer, new ResourceLocation(Enderia.MODID, name + "_chestplate"));
    }

    private void leggings(Consumer<FinishedRecipe> consumer, String name, Tag<Item> material, ItemLike result) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("MMM")
                .pattern("M M")
                .pattern("M M")
                .define('M', material)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(material).build()))
                .save(consumer, new ResourceLocation(Enderia.MODID, name + "_leggings"));
    }

    private void boots(Consumer<FinishedRecipe> consumer, String name, Tag<Item> material, ItemLike result) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("M M")
                .pattern("M M")
                .define('M', material)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(material).build()))
                .save(consumer, new ResourceLocation(Enderia.MODID, name + "_boots"));
    }

    private void fullArmor(Consumer<FinishedRecipe> consumer, String name, Tag<Item> material, ItemLike helmet, ItemLike chestplate, ItemLike leggings, ItemLike boots) {
        helmet(consumer, name, material, helmet);
        chestplate(consumer, name, material, chestplate);
        leggings(consumer, name, material, leggings);
        boots(consumer, name, material, boots);
    }

    private void oreSmelting(Consumer<FinishedRecipe> consumer, String name, Tag<Item> ore, ItemLike result, float experience, int cookingTime) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ore), result, experience, (int) (cookingTime * 0.75f))
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ore).build()))
                .save(consumer, new ResourceLocation(Enderia.MODID, name + "_blasting"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ore), result, experience, cookingTime)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ore).build()))
                .save(consumer, new ResourceLocation(Enderia.MODID, name + "_smelting"));
    }

    private void oreSmelting(Consumer<FinishedRecipe> consumer, String name, Tag<Item> ore, ItemLike result, float experience) {
        oreSmelting(consumer, name, ore, result, experience, 200);
    }

    private void oreSmelting(Consumer<FinishedRecipe> consumer, String name, Tag<Item> ore, ItemLike result) {
        oreSmelting(consumer, name, ore, result, 0.1f, 200);
    }

}
