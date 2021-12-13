package fr.zom.enderia.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class AdvancedBlock extends Block {

    public AdvancedBlock(Material material, float hardness, float resistance, SoundType st) {
        super(Properties.of(material).strength(hardness, resistance).requiresCorrectToolForDrops().sound(st));
    }

    public AdvancedBlock(Material material, float hardness, float resistance) {
        super(Properties.of(material).strength(hardness, resistance).requiresCorrectToolForDrops());
    }


}
