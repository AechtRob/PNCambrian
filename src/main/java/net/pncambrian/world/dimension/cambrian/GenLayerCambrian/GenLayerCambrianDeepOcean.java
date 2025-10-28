package net.pncambrian.world.dimension.cambrian.GenLayerCambrian;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCambrianDeepOcean extends GenLayer
{


    public Biome CAMBRIAN_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_sea"));
    public  int CAMBRIAN_OCEAN_ID =  Biome.getIdForBiome(CAMBRIAN_OCEAN);
    public  Biome CAMBRIAN_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_sea_shore"));
    public  int CAMBRIAN_OCEAN_SHORE_ID =  Biome.getIdForBiome(CAMBRIAN_OCEAN_SHORE);
    public Biome CAMBRIAN_PULSATING = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_sea_siphusauctum"));
    public int CAMBRIAN_PULSATING_ID =  Biome.getIdForBiome(CAMBRIAN_PULSATING);
    public Biome CAMBRIAN_OESIA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_sea_oesia"));
    public int CAMBRIAN_OESIA_ID =  Biome.getIdForBiome(CAMBRIAN_OESIA);
    public Biome CAMBRIAN_ABYSS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cambrian_abyssal"));
    public int CAMBRIAN_ABYSS_ID =  Biome.getIdForBiome(CAMBRIAN_ABYSS);

    public GenLayerCambrianDeepOcean(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        return this.getIntsOcean(areaX, areaY, areaWidth, areaHeight);
    }

    private final int CambrianSeaBiomes[] = new int[] {
            CAMBRIAN_OCEAN_ID,
            CAMBRIAN_OCEAN_ID,
            CAMBRIAN_OCEAN_ID,
            CAMBRIAN_OCEAN_ID,
            CAMBRIAN_OCEAN_ID,
            CAMBRIAN_OCEAN_ID,
            CAMBRIAN_PULSATING_ID,
            CAMBRIAN_OESIA_ID,
            CAMBRIAN_PULSATING_ID,
            CAMBRIAN_OESIA_ID,
            CAMBRIAN_ABYSS_ID
    };

    private int[] getIntsOcean(int p_151626_1_, int p_151626_2_, int p_151626_3_, int p_151626_4_)
    {
        int i = p_151626_1_ - 1;
        int j = p_151626_2_ - 1;
        int k = 1 + p_151626_3_ + 1;
        int l = 1 + p_151626_4_ + 1;
        int[] aint = this.parent.getInts(i, j, k, l);
        int[] aint1 = IntCache.getIntCache(p_151626_3_ * p_151626_4_);

        for (int i1 = 0; i1 < p_151626_4_; ++i1)
        {
            for (int j1 = 0; j1 < p_151626_3_; ++j1)
            {
                this.initChunkSeed((long)(j1 + p_151626_1_), (long)(i1 + p_151626_2_));
                int k1 = aint[j1 + 1 + (i1 + 1) * k];

                if (k1 == CAMBRIAN_OCEAN_SHORE_ID)
                {
                    int l1 = aint[j1 + 1 + (i1 + 1 - 1) * k];
                    int i2 = aint[j1 + 1 + 1 + (i1 + 1) * k];
                    int j2 = aint[j1 + 1 - 1 + (i1 + 1) * k];
                    int k2 = aint[j1 + 1 + (i1 + 1 + 1) * k];
                    boolean flag = (
                        (l1 == CAMBRIAN_OCEAN_SHORE_ID || l1 == CAMBRIAN_ABYSS_ID || l1 == CAMBRIAN_PULSATING_ID || l1 == CAMBRIAN_OESIA_ID)
                        && (i2 == CAMBRIAN_OCEAN_SHORE_ID || i2 == CAMBRIAN_ABYSS_ID || i2 == CAMBRIAN_PULSATING_ID || i2 == CAMBRIAN_OESIA_ID)
                        && (j2 == CAMBRIAN_OCEAN_SHORE_ID || j2 == CAMBRIAN_ABYSS_ID  || j2 == CAMBRIAN_PULSATING_ID || j2 == CAMBRIAN_OESIA_ID)
                        && (k2 == CAMBRIAN_OCEAN_SHORE_ID || k2 == CAMBRIAN_ABYSS_ID || k2 == CAMBRIAN_PULSATING_ID || k2 == CAMBRIAN_OESIA_ID)
                    );
                    if (flag)
                    {
                        k1 = CambrianSeaBiomes[nextInt(CambrianSeaBiomes.length)];
                    }
                }

                aint1[j1 + i1 * p_151626_3_] = k1;
            }
        }

        return aint1;
    }
    
}
