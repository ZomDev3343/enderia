package fr.zom.enderia.data.models;

import fr.zom.enderia.Enderia;
import fr.zom.enderia.blocks.BaseBlock;
import fr.zom.enderia.data.DataGen;
import fr.zom.enderia.init.ModObjects;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.fmllegacy.RegistryObject;

public class BlockstateGenerator extends BlockStateProvider {

    public BlockstateGenerator(DataGenerator gen) {
        super(gen, Enderia.MODID,  DataGen.DISABLED_FH);
    }

    @Override
    protected void registerStatesAndModels() {

        for(RegistryObject<Block> block : ModObjects.BLOCKS.getEntries())
        {

            Block b = block.get();
            String name = b.getRegistryName().getPath();

            if(b instanceof BaseBlock)
            {
                simpleBlock(b);
            }

        }



    }
}
