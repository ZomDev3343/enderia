package fr.zom.enderia.data.loottable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import fr.zom.enderia.init.ModObjects;
import net.minecraft.data.loot.EntityLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class ModEntityLootTable extends EntityLoot {

    private final Map<ResourceLocation, LootTable.Builder> map = Maps.newHashMap();
    private final List<EntityType<?>> KNOWN_ENTITIES = Lists.newArrayList();

    @Override
    protected void addTables() {
        add(ModObjects.FIRE_ENDERMAN.get(), new LootTable.Builder().setParamSet(LootContextParamSets.ENTITY)
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.ENDER_PEARL)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0f, 2f)))
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0f, 1f))))));

        add(ModObjects.END_ZOMBIE.get(), new LootTable.Builder().setParamSet(LootContextParamSets.ENTITY)
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.CHORUS_FRUIT)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0f, 3f)))
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0f, 1f))))));
    }

    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        this.addTables();
        map.forEach((consumer::accept));
    }

    @Override
    protected Iterable<EntityType<?>> getKnownEntities() {
        return KNOWN_ENTITIES;
    }

    @Override
    protected void add(EntityType<?> pEntityType, LootTable.Builder pLootTableBuilder) {
        this.map.put(pEntityType.getDefaultLootTable(), pLootTableBuilder);
    }
}
