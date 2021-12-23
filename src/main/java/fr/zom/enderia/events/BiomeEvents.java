package fr.zom.enderia.events;

import fr.zom.enderia.init.ModObjects;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class BiomeEvents {

    public static void addMobSpawns(final BiomeLoadingEvent e) {

        if (e.getCategory() == Biome.BiomeCategory.THEEND) {
            e.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModObjects.FIRE_ENDERMAN.get(), 10, 1, 4));
        } else if (e.getCategory() == Biome.BiomeCategory.NETHER) {
            e.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModObjects.FIRE_ENDERMAN.get(), 30, 1, 2));
        }
    }
}
