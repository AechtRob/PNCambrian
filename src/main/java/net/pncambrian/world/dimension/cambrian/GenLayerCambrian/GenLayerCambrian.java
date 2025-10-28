package net.pncambrian.world.dimension.cambrian.GenLayerCambrian;

import net.lepidodendron.LepidodendronConfig;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.*;

public class GenLayerCambrian {

    protected GenLayer parent;

    public static GenLayer[] initializeAllBiomeGenerators(long seed, WorldType worldType, String options) {

        GenLayer biomes = new GenLayerCambrianBiomes(1L);
        biomes = new GenLayerFuzzyZoom(2000L, biomes);
        if (!LepidodendronConfig.doShrinkBiomes) {
            biomes = new GenLayerZoom(2001L, biomes);
        }
        biomes = new GenLayerDiversifyCambrian(700L, biomes);
        biomes = new GenLayerZoom(1000L, biomes);
        biomes = new GenLayerDiversifyCambrian2(900L, biomes);
        biomes = new GenLayerFuzzyZoom(2900L, biomes);

        biomes = new GenLayerCambrianEstuary1(1000L, biomes);
        //biomes = new GenLayerDiversifyOceanCambrian(3005L, biomes);

        biomes = new GenLayerZoom(1001L, biomes);
        biomes = new GenLayerCambrianDeepOcean(1109L, biomes);
        biomes = new GenLayerCambrianShallowOcean(1400L, biomes);

        biomes = new GenLayerCambrianEstuary2(1000L, biomes);
        biomes = new GenLayerCambrianHilly(777L, biomes);

        biomes = new GenLayerZoom(1001L, biomes);

        biomes = new GenLayerCambrianEstuary2(1000L, biomes);

        biomes = new GenLayerSmooth(700L, biomes);
        biomes = new GenLayerCambrianHilly(220L, biomes);

        biomes = new GenLayerCambrianBeach(1050L, biomes);
        biomes = new GenLayerZoom(1005L, biomes);

        biomes = new GenLayerCambrianEstuary2(1000L, biomes);
        biomes = new GenLayerCambrianBeachExtra(2869L, biomes);
        biomes = new GenLayerCambrianMoistDustyBorder(354L, biomes);
        biomes = new GenLayerCambrianCraggy(778L, biomes);

        biomes = new GenLayerSmooth(703L, biomes);
        biomes = new GenLayerFuzzyZoom(1000L, biomes);

        biomes = new GenLayerSmooth(705L, biomes);
        biomes = new GenLayerFuzzyZoom(1001L, biomes);
        biomes = new GenLayerZoom(1006L, biomes);

        //Build and superimpose creeks:
        GenLayer genlayercreek = new GenLayerRiverInit(100L, biomes);
        GenLayer genlayercreek2 = GenLayerZoom.magnify(1000L, genlayercreek, 1);
        GenLayer genlayercreek3 = GenLayerZoom.magnify(1000L, genlayercreek2, 2);
        GenLayer genlayercreek4 = GenLayerZoom.magnify(1000L, genlayercreek3, 2);
        GenLayer genlayercreek5 = GenLayerZoom.magnify(1000L, genlayercreek4, 2);
        GenLayer genlayercreek6 = new GenLayerRiver(1L, genlayercreek5);
        GenLayer genlayercreek7 = new GenLayerSmooth(1000L, genlayercreek6);
        GenLayer genlayercreekfinal = new GenLayerCambrianRiverMix(100L, biomes, genlayercreek7);

        //Additional features:
        GenLayer genlayerdeltacreek = new GenLayerRiverInit(200L, biomes);
        GenLayer genlayerdeltacreek2 = GenLayerZoom.magnify(2000L, genlayerdeltacreek, 2);
        GenLayer genlayerdeltacreek3 = GenLayerZoom.magnify(2000L, genlayerdeltacreek2, 2);
        GenLayer genlayerdeltacreek4 = GenLayerZoom.magnify(2000L, genlayerdeltacreek3, 2);
        GenLayer genlayerdeltacreek5 = new GenLayerRiver(2L, genlayerdeltacreek4);
        GenLayer genlayerdeltacreek6 = new GenLayerSmooth(2000L, genlayerdeltacreek5);
        GenLayer genlayerdeltacreekfinal = new GenLayerCambrianRiverMixDeltaSpecial(200L, genlayercreekfinal, genlayerdeltacreek6);

        GenLayer genlayerdeltacreekB = new GenLayerRiverInit(500L, biomes);
        GenLayer genlayerdeltacreekB2 = GenLayerZoom.magnify(5000L, genlayerdeltacreekB, 2);
        GenLayer genlayerdeltacreekB3 = GenLayerZoom.magnify(5000L, genlayerdeltacreekB2, 2);
        GenLayer genlayerdeltacreekB4 = GenLayerZoom.magnify(5000L, genlayerdeltacreekB3, 2);
        GenLayer genlayerdeltacreekB5 = new GenLayerRiver(5L, genlayerdeltacreekB4);
        GenLayer genlayerdeltacreekB6 = new GenLayerSmooth(5000L, genlayerdeltacreekB5);
        GenLayer genlayerdeltacreekBfinal = new GenLayerCambrianRiverMixDeltaSpecial(500L, genlayerdeltacreekfinal, genlayerdeltacreekB6);


        GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, genlayerdeltacreekBfinal);

        genlayerdeltacreekBfinal.initWorldGenSeed(seed);
        genlayervoronoizoom.initWorldGenSeed(seed);
        biomes.initWorldGenSeed(seed);

        genlayervoronoizoom.initWorldGenSeed(seed);
        return (new GenLayer[] { genlayerdeltacreekBfinal, genlayervoronoizoom, genlayerdeltacreekBfinal });
    }

}