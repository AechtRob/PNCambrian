package net.pncambrian.world.dimension.cambrian.GenLayerCambrian;

import net.lepidodendron.util.EnumBiomeTypeCambrian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pncambrian.world.biome.cambrian.BiomeCambrianBiome;
import net.pncambrian.world.biome.cambrian.BiomeCambrianSea;
import net.pncambrian.world.biome.cambrian.BiomeCambrianSeaShore;

public class GenLayerDiversifyOceanCambrian extends GenLayer {

    public Biome CAMBRIAN_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_sea_shore"));
    public int CAMBRIAN_OCEAN_ID =  Biome.getIdForBiome(CAMBRIAN_OCEAN);
    public Biome CAMBRIAN_REEF = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_sea_reefs"));
    public int CAMBRIAN_REEF_ID =  Biome.getIdForBiome(CAMBRIAN_REEF);

    private final int CambrianSeaBiomes[] = new int[] {
            CAMBRIAN_OCEAN_ID,
            CAMBRIAN_OCEAN_ID,
            CAMBRIAN_REEF_ID,
    };

    public GenLayerDiversifyOceanCambrian(long seed, GenLayer genlayer) {
        super(seed);
        this.parent = genlayer;
    }

    @Override
    public int[] getInts(int x, int z, int width, int height) {
        return diversify(x, z, width, height);
    }

    private int[] diversify(int x, int z, int width, int height) {
        int input[] = this.parent.getInts(x, z, width, height);
        int output[] = IntCache.getIntCache(width * height);
        EnumBiomeTypeCambrian type;
        for (int zOut = 0; zOut < height; zOut++) {
            for (int xOut = 0; xOut < width; xOut++) {
                int i = xOut + zOut * width;
                int center = input[i];
                initChunkSeed(xOut + x, zOut + z);
                if (nextInt(2) == 0) {
                    if (Biome.getBiome(center) == BiomeCambrianSeaShore.biome)
                        output[i] = CambrianSeaBiomes[nextInt(CambrianSeaBiomes.length)];
                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}