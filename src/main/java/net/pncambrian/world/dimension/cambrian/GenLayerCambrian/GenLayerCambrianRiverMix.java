package net.pncambrian.world.dimension.cambrian.GenLayerCambrian;

import net.lepidodendron.util.EnumBiomeTypeCambrian;
import net.lepidodendron.world.biome.cambrian.BiomeCambrian;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pncambrian.world.biome.cambrian.BiomeCambrianBiome;
import net.pncambrian.world.biome.cambrian.BiomeCambrianForeshoreDry;

public class GenLayerCambrianRiverMix extends GenLayer
{
    private final GenLayer biomePatternGeneratorChain;
    private final GenLayer riverPatternGeneratorChain;

    //Creeks to use:
    public Biome CAMBRIAN_CREEK_DUSTY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_creek_dusty"));
    public int CAMBRIAN_CREEK_DUSTY_ID = Biome.getIdForBiome(CAMBRIAN_CREEK_DUSTY);
    public Biome CAMBRIAN_CREEK_COAST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_creek_coastal"));
    public int CAMBRIAN_CREEK_COAST_ID = Biome.getIdForBiome(CAMBRIAN_CREEK_COAST);
    public Biome CAMBRIAN_CREEK_ESTUARY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_estuary"));
    public int CAMBRIAN_CREEK_ESTUARY_ID =  Biome.getIdForBiome(CAMBRIAN_CREEK_ESTUARY);
    public Biome CAMBRIAN_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_creek"));
    public int CAMBRIAN_CREEK_ID =  Biome.getIdForBiome(CAMBRIAN_CREEK);

    //Biomes to exclude for rivers:
    public Biome CAMBRIAN_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_sea"));
    public int CAMBRIAN_OCEAN_ID =  Biome.getIdForBiome(CAMBRIAN_OCEAN);
    public Biome CAMBRIAN_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_sea_shore"));
    public int CAMBRIAN_OCEAN_SHORE_ID =  Biome.getIdForBiome(CAMBRIAN_OCEAN_SHORE);
    public Biome CAMBRIAN_HILLY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_hills"));
    public int CAMBRIAN_HILLY_ID =  Biome.getIdForBiome(CAMBRIAN_HILLY);
    public Biome CAMBRIAN_CRAGGY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_crags"));
    public int CAMBRIAN_CRAGGY_ID =  Biome.getIdForBiome(CAMBRIAN_CRAGGY);
    public Biome CAMBRIAN_MOIST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_moist"));
    public int CAMBRIAN_MOIST_ID = Biome.getIdForBiome(CAMBRIAN_MOIST);
    public Biome CAMBRIAN_PULSATING = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_sea_siphusauctum"));
    public int CAMBRIAN_PULSATING_ID =  Biome.getIdForBiome(CAMBRIAN_PULSATING);
    public Biome CAMBRIAN_OESIA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_sea_reefs"));
    public int CAMBRIAN_OESIA_ID =  Biome.getIdForBiome(CAMBRIAN_OESIA);
    public Biome CAMBRIAN_FORESHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_foreshore"));
    public int CAMBRIAN_FORESHORE_ID =  Biome.getIdForBiome(CAMBRIAN_FORESHORE);

    public GenLayerCambrianRiverMix(long p_i2129_1_, GenLayer p_i2129_3_, GenLayer p_i2129_4_)
    {
        super(p_i2129_1_);
        this.biomePatternGeneratorChain = p_i2129_3_;
        this.riverPatternGeneratorChain = p_i2129_4_;
    }

    public void initWorldGenSeed(long seed)
    {
        this.biomePatternGeneratorChain.initWorldGenSeed(seed);
        this.riverPatternGeneratorChain.initWorldGenSeed(seed);
        super.initWorldGenSeed(seed);
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int[] aint = this.biomePatternGeneratorChain.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] aint1 = this.riverPatternGeneratorChain.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] aint2 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i = 0; i < areaWidth * areaHeight; ++i)
        {
            if (aint1[i] == Biome.getIdForBiome(Biomes.RIVER))
            {
                //Exclude rivers here:
                if (aint[i] == CAMBRIAN_OCEAN_ID
                        || aint[i] == CAMBRIAN_CRAGGY_ID
                        || aint[i] == CAMBRIAN_OCEAN_SHORE_ID
                        || aint[i] == CAMBRIAN_HILLY_ID
                        || aint[i] == CAMBRIAN_MOIST_ID
                        || aint[i] == CAMBRIAN_PULSATING_ID
                        || aint[i] == CAMBRIAN_OESIA_ID
                        || aint[i] == CAMBRIAN_FORESHORE_ID
                )
                {
                    aint2[i] = aint[i];
                }
                else {
                    //Add the rivers we want:
                    Biome biome = Biome.getBiome(aint[i]);
                    if (biome instanceof BiomeCambrian) {
                        BiomeCambrian biomeCambrian = (BiomeCambrian) biome;
                        if (biome == BiomeCambrianForeshoreDry.biome) {
                            aint2[i] = CAMBRIAN_FORESHORE_ID;
                        }
                        else if (biomeCambrian.getBiomeType() == EnumBiomeTypeCambrian.Dusty) {
                            aint2[i] = CAMBRIAN_CREEK_DUSTY_ID;
                        }
                        else if (biomeCambrian.getBiomeType() == EnumBiomeTypeCambrian.Ocean) {
                            aint2[i] = CAMBRIAN_CREEK_COAST_ID;
                        }
                        else if (biomeCambrian.getBiomeType() == EnumBiomeTypeCambrian.Estuary) {
                            aint2[i] = CAMBRIAN_CREEK_ESTUARY_ID;
                        }
                        else if (biomeCambrian == BiomeCambrianBiome.biome) {
                            aint2[i] = CAMBRIAN_CREEK_ID;
                        }
                        else {
                            aint2[i] = aint[i];
                        }
                    }
                    else {
                        aint2[i] = aint[i];
                    }
                }
            }
            else
            {
                aint2[i] = aint[i];
            }

        }

        return aint2;
    }
}
