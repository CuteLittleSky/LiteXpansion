package dev.j3fftw.litexpansion.machine.multiblock;

import dev.j3fftw.litexpansion.Items;
import dev.j3fftw.litexpansion.LiteXpansion;
import dev.j3fftw.litexpansion.machine.extensions.CraftingMultiBlock;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;

public class MetalForge extends CraftingMultiBlock {

    public static final RecipeType RECIPE_TYPE = new RecipeType(
        new NamespacedKey(LiteXpansion.getInstance(), "metal_forge"),
        Items.METAL_FORGE,
        "",
        "&7用于冶炼工业金属",
        "&6每次冶炼时会消耗完全氧化的涂蜡切制铜块"
    );

    private static final ItemStack anvil = new ItemStack(Material.ANVIL);
    private static final ItemStack ironBlock = new ItemStack(Material.IRON_BLOCK);
    private static final ItemStack diamondBlock = new ItemStack(Material.DIAMOND_BLOCK);

    public MetalForge() {
        super(Items.LITEXPANSION, Items.METAL_FORGE, new ItemStack[] {
            anvil, new ItemStack(Material.STONE_BRICK_WALL), anvil,
            diamondBlock, new ItemStack(Material.DISPENSER), ironBlock,
            null, new ItemStack(Material.WAXED_OXIDIZED_CUT_COPPER), null
        }, new ItemStack[0], BlockFace.DOWN);
    }

    @Override
    public Block getSpecialBlock(Block dispenser) {
        return dispenser.getRelative(BlockFace.DOWN);
    }

    @Override
    public boolean removeSpecialBlock() {
        return true;
    }
}
