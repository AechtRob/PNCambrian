
package net.pncambrian.world.biome.cambrian;

import net.lepidodendron.block.*;
import net.lepidodendron.util.EnumBiomeTypeCambrian;
import net.lepidodendron.world.biome.ChunkGenSpawner;
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
public class BiomeCambrianSeaOesia extends ElementsPNCambrianMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:cambrian_sea_oesia")
	public static final BiomeGenCustom biome = null;
	public BiomeCambrianSeaOesia(ElementsPNCambrianMod instance) {
		super(instance, 1591);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.OCEAN);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.WATER);
	}

	static class BiomeGenCustom extends BiomeCambrian {
		public BiomeGenCustom() {
			super(new BiomeProperties("Cambrian Colonies").setRainfall(0.9F).setBaseHeight(-0.15F).setHeightVariation(0.255F).setTemperature(0.9F));
			setRegistryName("lepidodendron:cambrian_sea_oesia");
			topBlock = Blocks.SAND.getStateFromMeta(0);
			fillerBlock = BlockSandstoneBlack.block.getDefaultState();
			decorator.treesPerChunk = -999;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 2;
			decorator.gravelPatchesPerChunk = 1;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
		}


		protected static final WorldGenStromatoliteReefCambrian REEF_GENERATOR = new WorldGenStromatoliteReefCambrian();
		protected static final WorldGenThrombolite THROMBOLITE_GENERATOR = new WorldGenThrombolite();
		protected static final WorldGenReef REEF_GENERATOR_ARCHAEOCYATHA = new WorldGenReef();
		protected static final WorldGenSingleStaticInWaterUpwards STATIC_GENERATOR = new WorldGenSingleStaticInWaterUpwards();
		protected static final WorldGenSingleStaticInWaterRotational STATIC_ROTATIONAL_GENERATOR = new WorldGenSingleStaticInWaterRotational();
		protected static final WorldGenSingleStaticInWaterSideways STATIC_SIDEWAYS_GENERATOR = new WorldGenSingleStaticInWaterSideways();
		protected static final WorldGenSingleAnemoneSea ANEMONE_GENERATOR = new WorldGenSingleAnemoneSea();
		protected static final WorldGenSingleSponge SPONGE_GENERATOR = new WorldGenSingleSponge();
		protected static final WorldGenSingleSpongeSideways SPONGE_SIDEWAYS_GENERATOR = new WorldGenSingleSpongeSideways();
		protected static final WorldGenChaunograptus CHAUNOGRAPTUS_GENERATOR = new WorldGenChaunograptus();

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	    {
	        return null;
	    }

		@Override
	    public void decorate(World worldIn, Random rand, BlockPos pos)
	    {

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 58; ++ii) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_GENERATOR.generate(BlockAllonnia.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 30, 0, 255);
					}
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 12; ++ii) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						ANEMONE_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), 1, 30, 0, 255, -1);
					}
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 32; ++ii) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_SIDEWAYS_GENERATOR.generate(BlockBrachiopodOrthid.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 2, 24, 0, 255);
					}
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 22; ++ii) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						SPONGE_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), 1, 30, 0, 255, BlockRedSponge.block);
					}
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 22; ++ii) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						SPONGE_SIDEWAYS_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), 1, 30, 0, 255, BlockRedSponge.block);
					}
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 22; ++ii) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						SPONGE_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), 1, 30, 0, 255, BlockDarkOrangeSponge.block);
					}
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 22; ++ii) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						SPONGE_SIDEWAYS_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), 1, 30, 0, 255, BlockDarkOrangeSponge.block);
					}
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 22; ++ii) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						SPONGE_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), 1, 30, 0, 255, BlockDarkPinkSponge.block);
					}
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 22; ++ii) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						SPONGE_SIDEWAYS_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), 1, 30, 0, 255, BlockDarkPinkSponge.block);
					}
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 11; ++ii) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = ChunkGenSpawner.getTopSolidBlock(pos.add(j, 0, k), worldIn).getY() + 1;
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_GENERATOR.generate(BlockRedAlgaeMat.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 30, 0, 255);
					}
				}

//			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
//				for (int ii = 0; ii < 12; ++ii)
//				{
//					int j = rand.nextInt(16) + 8;
//					int k = rand.nextInt(16) + 8;
//					int l = ChunkGenSpawner.getTopSolidBlock(pos.add(j, 0, k), worldIn).getY() + 1;
//					STATIC_GENERATOR.generate(BlockGreenAlgaeMat.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 0, 255);
//				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 27; ++ii) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_GENERATOR.generate(BlockGreenSproutingAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 0, 255);
					}
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 30; ++ii) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_GENERATOR.generate(BlockBrachiopodMicromitra.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 12, 0, 255);
					}
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 30; ++ii) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_SIDEWAYS_GENERATOR.generate(BlockBrachiopodMicromitra.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 12, 0, 255);
					}
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 30; ++ii) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = ChunkGenSpawner.getTopSolidBlock(pos.add(j, 0, k), worldIn).getY() + 1;
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_GENERATOR.generate(BlockOesia.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 100, 0, 255);
					}
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 50; ++ii) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_GENERATOR.generate(BlockConulariidBrown.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 100, 0, 255);
					}
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 50; ++ii) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_GENERATOR.generate(BlockConulariidMagenta.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 100, 0, 255);
					}
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 20; ++ii) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_GENERATOR.generate(BlockDictyonema.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 100, 0, 255);
					}
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 20; ++ii) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					if (worldIn.getBiome(pos.add(j, l, k)) == this) {
						STATIC_SIDEWAYS_GENERATOR.generate(BlockDictyonema.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 100, 0, 255);
					}
				}

			super.decorate(worldIn, rand, pos);
	    }

		@Override
		public EnumBiomeTypeCambrian getBiomeType() {
			return EnumBiomeTypeCambrian.Ocean;
		}

	}
}
