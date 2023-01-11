package net.pncambrian.world.dimension.cambrian.GenLayerCambrian;

import net.lepidodendron.util.EnumBiomeTypeCambrian;
import net.lepidodendron.util.EnumBiomeTypeDevonian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pncambrian.world.biome.cambrian.BiomeCambrianBiome;

public class GenLayerDiversifyCambrian extends GenLayer {

    public Biome CAMBRIAN_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_sea"));
    public int CAMBRIAN_OCEAN_ID =  Biome.getIdForBiome(CAMBRIAN_OCEAN);
    public Biome CAMBRIAN_BARREN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_biome"));
    public int CAMBRIAN_BARREN_ID =  Biome.getIdForBiome(CAMBRIAN_BARREN);
    public Biome CAMBRIAN_ESTUARY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_estuary"));
    public int CAMBRIAN_ESTUARY_ID =  Biome.getIdForBiome(CAMBRIAN_ESTUARY);
    public Biome CAMBRIAN_ESTUARY_HELPER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_estuary_helper"));
    public int CAMBRIAN_ESTUARY_HELPER_ID =  Biome.getIdForBiome(CAMBRIAN_ESTUARY_HELPER);
    public Biome CAMBRIAN_DUSTY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_dusty"));
    public int CAMBRIAN_DUSTY_ID =  Biome.getIdForBiome(CAMBRIAN_DUSTY);
    public Biome CAMBRIAN_MOIST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_moist"));
    public int CAMBRIAN_MOIST_ID =  Biome.getIdForBiome(CAMBRIAN_MOIST);

    private final int CambrianLandBiomes[] = new int[] {
            CAMBRIAN_BARREN_ID,
            CAMBRIAN_BARREN_ID,
            CAMBRIAN_DUSTY_ID,
            CAMBRIAN_MOIST_ID
    };

    public GenLayerDiversifyCambrian(long seed, GenLayer genlayer) {
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
                    if (Biome.getBiome(center) == BiomeCambrianBiome.biome)
                        output[i] = CambrianLandBiomes[nextInt(CambrianLandBiomes.length)];
                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}