package fr.zom.enderia.blocks;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class BaseBlock extends Block {


    public BaseBlock(Material material, float hardness, float resistance, SoundType st) {
        super(BlockBehaviour.Properties.of(material).strength(hardness, resistance).requiresCorrectToolForDrops().sound(st));
    }

    public BaseBlock(Material material, float hardness, float resistance) {
        super(BlockBehaviour.Properties.of(material).strength(hardness, resistance).requiresCorrectToolForDrops());
    }


}
