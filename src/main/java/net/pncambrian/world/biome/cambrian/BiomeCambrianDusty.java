
package net.pncambrian.world.biome.cambrian;

import net.lepidodendron.block.BlockLavaRock;
import net.lepidodendron.block.BlockVolcanicAshLight;
import net.lepidodendron.util.EnumBiomeTypeCambrian;
import net.lepidodendron.world.biome.cambrian.BiomeCambrian;
import net.lepidodendron.world.gen.*;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.pncambrian.ElementsPNCambrianMod;

import java.util.Random;

@ElementsPNCambrianMod.ModElement.Tag
public class BiomeCambrianDusty extends ElementsPNCambrianMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:cambrian_dusty")
	public static final BiomeGenCustom biome = null;
	public BiomeCambrianDusty(ElementsPNCambrianMod instance) {
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
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.DRY);
	}

	static class BiomeGenCustom extends BiomeCambrian {
		public BiomeGenCustom() {
			super(new BiomeProperties("Cambrian Dusty Wastes").setRainfall(0.0F).setBaseHeight(0.0F).setHeightVariation(0.0F).setTemperature(0.9F).setRainDisabled().setWaterColor(16758578));
			setRegistryName("lepidodendron:cambrian_dusty");
			topBlock = BlockVolcanicAshLight.block.getDefaultState();
			fillerBlock = Blocks.STONE.getStateFromMeta(0);
			decorator.treesPerChunk = -999;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 1;
			decorator.gravelPatchesPerChunk = 1;
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
			return EnumBiomeTypeCambrian.Dusty;
		}

	}
}
