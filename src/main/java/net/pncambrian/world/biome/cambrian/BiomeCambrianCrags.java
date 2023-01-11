
package net.pncambrian.world.biome.cambrian;

import net.lepidodendron.block.BlockLavaRock;
import net.lepidodendron.block.BlockSandstoneBlack;
import net.lepidodendron.util.EnumBiomeTypeCambrian;
import net.lepidodendron.world.biome.cambrian.BiomeCambrian;
import net.lepidodendron.world.gen.*;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.pncambrian.ElementsPNCambrianMod;

import java.util.Random;

@ElementsPNCambrianMod.ModElement.Tag
public class BiomeCambrianCrags extends ElementsPNCambrianMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:cambrian_crags")
	public static final BiomeGenCustom biome = null;
	public BiomeCambrianCrags(ElementsPNCambrianMod instance) {
		super(instance, 1591);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.WASTELAND);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.DEAD);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.MOUNTAIN);
	}

	static class BiomeGenCustom extends BiomeCambrian {
		public BiomeGenCustom() {
			super(new BiomeProperties("Cambrian Craggy Wastes").setRainfall(0.4F).setBaseHeight(2.95F).setHeightVariation(0.4F).setTemperature(0.5F));
			setRegistryName("lepidodendron:cambrian_crags");
			topBlock = Blocks.STONE.getStateFromMeta(0);
			fillerBlock = BlockSandstoneBlack.block.getDefaultState();
			decorator.treesPerChunk = -999;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 0;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
		}


		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	    {
	        return null;
	    }

		@Override
	    public void decorate(World worldIn, Random rand, BlockPos pos)
	    {

			super.decorate(worldIn, rand, pos);
	    }

		@Override
		public EnumBiomeTypeCambrian getBiomeType() {
			return EnumBiomeTypeCambrian.BarrenLand;
		}

	}
}
