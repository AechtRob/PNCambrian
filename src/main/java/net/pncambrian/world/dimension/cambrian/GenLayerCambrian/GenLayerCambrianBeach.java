package net.pncambrian.world.dimension.cambrian.GenLayerCambrian;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCambrianBeach extends GenLayer
{

    public Biome CAMBRIAN_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_sea"));
    public int CAMBRIAN_OCEAN_ID =  Biome.getIdForBiome(CAMBRIAN_OCEAN);
    public Biome CAMBRIAN_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_sea_shore"));
    public int CAMBRIAN_OCEAN_SHORE_ID =  Biome.getIdForBiome(CAMBRIAN_OCEAN_SHORE);
    public Biome CAMBRIAN_BARREN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_hills"));
    public int CAMBRIAN_BARREN_ID =  Biome.getIdForBiome(CAMBRIAN_BARREN);

    public Biome CAMBRIAN_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_beach"));
    public int CAMBRIAN_BEACH_ID =  Biome.getIdForBiome(CAMBRIAN_BEACH);
    public Biome CAMBRIAN_LAGOON_HELPER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_estuary_helper"));
    public int CAMBRIAN_LAGOON_HELPER_ID =  Biome.getIdForBiome(CAMBRIAN_LAGOON_HELPER);
    public Biome CAMBRIAN_ESTUARY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_estuary"));
    public int CAMBRIAN_ESTUARY_ID =  Biome.getIdForBiome(CAMBRIAN_ESTUARY);
    public Biome CAMBRIAN_PULSATING = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_sea_siphusauctum"));
    public int CAMBRIAN_PULSATING_ID =  Biome.getIdForBiome(CAMBRIAN_PULSATING);
    public Biome CAMBRIAN_OESIA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_sea_reefs"));
    public int CAMBRIAN_OESIA_ID =  Biome.getIdForBiome(CAMBRIAN_OESIA);
    public Biome CAMBRIAN_FORESHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_foreshore_dry"));
    public int CAMBRIAN_FORESHORE_ID =  Biome.getIdForBiome(CAMBRIAN_FORESHORE);
    public Biome CAMBRIAN_ABYSS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_abyssal"));
    public int CAMBRIAN_ABYSS_ID =  Biome.getIdForBiome(CAMBRIAN_ABYSS);


    public GenLayerCambrianBeach(long seed, GenLayer genLayer)
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

                if ((k != CAMBRIAN_BARREN_ID) && (k != CAMBRIAN_FORESHORE_ID)
                )
                {
                    if (!isOcean(k))
                    {
                        int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                        int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                        int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                        int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                        if (!isOcean(l1) && !isOcean(k2) && !isOcean(j3) && !isOcean(i4))
                        {
                            aint1[j + i * areaWidth] = k;
                        }
                        else
                        {
                            if (isLagoon(l1) || isLagoon(k2) || isLagoon(j3) || isLagoon(i4)) {
                                aint1[j + i * areaWidth] = CAMBRIAN_LAGOON_HELPER_ID;
                            }
                            else {
                                if (isOcean(l1) || isOcean(k2) || isOcean(j3) || isOcean(i4)) {
                                    aint1[j + i * areaWidth] = CAMBRIAN_BEACH_ID;
                                }
                                else {
                                    aint1[j + i * areaWidth] = k;
                                }
                            }
                        }
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

    private boolean isOcean(int biomeID) {
        if (biomeID == CAMBRIAN_OCEAN_ID || biomeID == CAMBRIAN_OCEAN_SHORE_ID
                || biomeID == CAMBRIAN_PULSATING_ID || biomeID == CAMBRIAN_OESIA_ID
                || biomeID == CAMBRIAN_ABYSS_ID) {
            return true;
        }
        return false;
    }

    private boolean isLagoon(int biomeID) {
        if (biomeID == CAMBRIAN_LAGOON_HELPER_ID || biomeID == CAMBRIAN_ESTUARY_ID) {
            return true;
        }
        return false;
    }

}
