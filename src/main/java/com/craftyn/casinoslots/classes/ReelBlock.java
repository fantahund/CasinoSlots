package com.craftyn.casinoslots.classes;

import org.bukkit.block.data.BlockData;

/**
 * Representation of the blocks which go into a reel in a slot machine, containing the block's data and the amount.
 *
 * @author graywolf336
 * @since 3.0.0
 * @version 1.0.0
 */
public class ReelBlock {
    private BlockData data;
    private int count;
    
    /**
     * Creates a new {@link ReelBlock} with a default count of 1.
     * 
     * @param data the {@link MaterialData} for the reel's block
     */
    public ReelBlock(BlockData data) {
        this.data = data;
        this.count = 1;
    }
    
    /**
     * The {@link MaterialData} for the reel block.
     * 
     * @return the {@link MaterialData} we are using
     */
    public BlockData getBlockData() {
        return this.data;
    }
    
    /**
     * The amount of blocks.
     * 
     * @return the number of blocks
     */
    public int getCount() {
        return this.count;
    }
}
