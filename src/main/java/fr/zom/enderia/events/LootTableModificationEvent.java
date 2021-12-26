package fr.zom.enderia.events;

import fr.zom.enderia.init.ModObjects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.event.LootTableLoadEvent;

public class LootTableModificationEvent {

    public static void modifyLootTables(final LootTableLoadEvent e) {
        if (e.getName() == EntityType.ENDER_DRAGON.getDefaultLootTable()) {
            e.getTable()
                    .addPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                            .add(LootItem.lootTableItem(ModObjects.DRAGON_SKIN.get())
                                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(3f, 6f)))).build());
        }
    }
}
