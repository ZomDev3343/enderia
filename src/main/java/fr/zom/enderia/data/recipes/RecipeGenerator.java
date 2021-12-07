package fr.zom.enderia.data.recipes;

import fr.zom.enderia.Enderia;
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

    private void oreSmelting(Consumer<FinishedRecipe> consumer, String name, Tag<Item> ore, ItemLike result, float experience, int cookingTime)
    {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ore), result, experience, cookingTime)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ore).build()))
                .save(consumer, new ResourceLocation(Enderia.MODID, name));
    }

    private void oreSmelting(Consumer<FinishedRecipe> consumer, String name, Tag<Item> ore, ItemLike result, float experience)
    {
        oreSmelting(consumer, name, ore, result, experience, 200);
    }

    private void oreSmelting(Consumer<FinishedRecipe> consumer, String name, Tag<Item> ore, ItemLike result)
    {
        oreSmelting(consumer, name, ore, result, 0.1f, 200);
    }

}
