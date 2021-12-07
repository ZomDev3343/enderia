package fr.zom.enderia.data.loottable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class ModBlockLootTable extends BlockLoot {

    private final Map<ResourceLocation, LootTable.Builder> map = Maps.newHashMap();
    private final List<Block> KNOWN_BLOCKS = Lists.newArrayList();

    @Override
    protected void addTables() {

    }

    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        this.addTables();
        map.forEach((consumer::accept));

    }



    @Override
    protected Iterable<Block> getKnownBlocks() {
        return KNOWN_BLOCKS;
    }

    @Override
    protected void add(Block pBlock, LootTable.Builder pLootTableBuilder) {
        this.map.put(pBlock.getLootTable(), pLootTableBuilder);
    }
}
