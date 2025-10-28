package net.pncambrian.world.dimension.cambrian.GenLayerCambrian;

import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCambrianRiverMixDeltaSpecial extends GenLayer
{
    private final GenLayer biomePatternGeneratorChain;
    private final GenLayer riverPatternGeneratorChain;

    //Creeks to use:
    public Biome CAMBRIAN_CREEK_ESTUARY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_foreshore"));
    public int CAMBRIAN_CREEK_ESTUARY_ID = Biome.getIdForBiome(CAMBRIAN_CREEK_ESTUARY);
    public Biome CAMBRIAN_ESTUARY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_foreshore_dry"));
    public int CAMBRIAN_ESTUARY_ID = Biome.getIdForBiome(CAMBRIAN_ESTUARY);

    public GenLayerCambrianRiverMixDeltaSpecial(long p_i2129_1_, GenLayer p_i2129_3_, GenLayer p_i2129_4_)
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
                if (aint[i] == CAMBRIAN_ESTUARY_ID
                )
                {
                    aint2[i] = CAMBRIAN_CREEK_ESTUARY_ID;
                }
                else {
                    aint2[i] = aint[i];
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
