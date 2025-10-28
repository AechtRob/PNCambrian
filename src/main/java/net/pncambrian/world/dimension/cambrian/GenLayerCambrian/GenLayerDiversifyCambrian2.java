package net.pncambrian.world.dimension.cambrian.GenLayerCambrian;

import net.lepidodendron.util.EnumBiomeTypeCambrian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pncambrian.world.biome.cambrian.BiomeCambrianBiome;

public class GenLayerDiversifyCambrian2 extends GenLayer {

    public Biome CAMBRIAN_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_sea_shore"));
    public int CAMBRIAN_OCEAN_ID = Biome.getIdForBiome(CAMBRIAN_OCEAN);
    public Biome CAMBRIAN_FORESHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_sea_reefs"));
    public int CAMBRIAN_FORESHORE_ID = Biome.getIdForBiome(CAMBRIAN_FORESHORE);

    public Biome CAMBRIAN_DUSTY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_dusty"));
    public int CAMBRIAN_DUSTY_ID = Biome.getIdForBiome(CAMBRIAN_DUSTY);
    public Biome CAMBRIAN_MOIST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_moist"));
    public int CAMBRIAN_MOIST_ID = Biome.getIdForBiome(CAMBRIAN_MOIST);

    public GenLayerDiversifyCambrian2(long seed, GenLayer genLayer) {
        super(seed);
        this.parent = genLayer;
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight) {
        int[] aint = this.parent.getInts(areaX - 1, areaY - 1, areaWidth + 2, areaHeight + 2);
        int[] aint1 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i = 0; i < areaHeight; ++i) {
            for (int j = 0; j < areaWidth; ++j) {
                this.initChunkSeed((long) (j + areaX), (long) (i + areaY));
                int k = aint[j + 1 + (i + 1) * (areaWidth + 2)];

                if (k == CAMBRIAN_DUSTY_ID || k == CAMBRIAN_MOIST_ID) {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (isOcean(l1) || isOcean(k2) || isOcean(j3) || isOcean(i4)) {
                        aint1[j + i * areaWidth] = CAMBRIAN_FORESHORE_ID;
                    } else {
                        aint1[j + i * areaWidth] = k;
                    }
                } else {
                    aint1[j + i * areaWidth] = k;
                }
            }
        }

        return aint1;
    }

    private boolean isOcean(int biomeID) {
        if (biomeID == CAMBRIAN_OCEAN_ID) {
            return true;
        }
        return false;
    }
}