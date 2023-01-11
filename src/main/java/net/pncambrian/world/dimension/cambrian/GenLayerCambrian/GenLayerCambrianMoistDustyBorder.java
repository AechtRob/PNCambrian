package net.pncambrian.world.dimension.cambrian.GenLayerCambrian;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCambrianMoistDustyBorder extends GenLayer
{

    public Biome CAMBRIAN_DUSTY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_dusty"));
    public int CAMBRIAN_DUSTY_ID =  Biome.getIdForBiome(CAMBRIAN_DUSTY);
    public Biome CAMBRIAN_MOIST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_moist"));
    public int CAMBRIAN_MOIST_ID =  Biome.getIdForBiome(CAMBRIAN_MOIST);
    public Biome CAMBRIAN_BARREN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_biome"));
    public int CAMBRIAN_BARREN_ID =  Biome.getIdForBiome(CAMBRIAN_BARREN);


    public GenLayerCambrianMoistDustyBorder(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int[] aint = this.parent.getInts(areaX - 1, areaY - 1, areaWidth + 2, areaHeight + 2);
        int[] aint1 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i = 0; i < areaHeight; ++i)
        {
            for (int j = 0; j < areaWidth; ++j)
            {
                this.initChunkSeed((long)(j + areaX), (long)(i + areaY));
                int k = aint[j + 1 + (i + 1) * (areaWidth + 2)];

                if (isDesert(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if ((!isDesert(l1) && !isExemptforDesert(l1))
                        || (!isDesert(k2) && !isExemptforDesert(k2))
                        || (!isDesert(j3) && !isExemptforDesert(j3))
                        || (!isDesert(i4) && !isExemptforDesert(i4))
                    )
                    {
                        aint1[j + i * areaWidth] = CAMBRIAN_BARREN_ID;
                    }
                    else
                    {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else
                {
                    aint1[j + i * areaWidth] = k;
                }
            }
        }

        return aint1;
    }

    private boolean isDesert(int biomeID) {
        if (biomeID == CAMBRIAN_DUSTY_ID) {
            return true;
        }
        return false;
    }

    private boolean isExemptforDesert(int biomeID) {
        if (biomeID != CAMBRIAN_MOIST_ID) {
            return true;
        }
        return false;
    }

}
