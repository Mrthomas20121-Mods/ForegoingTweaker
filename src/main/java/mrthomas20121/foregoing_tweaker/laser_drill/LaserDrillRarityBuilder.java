package mrthomas20121.foregoing_tweaker.laser_drill;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.buuz135.industrial.recipe.LaserDrillRarity;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Arrays;
import java.util.Set;

@ZenCodeType.Name("mods.foregoing_tweaker.laser_drill.LaserDrillRarityBuilder")
@ZenRegister
public class LaserDrillRarityBuilder {
    private ResourceKey<Biome>[] whitelist = new ResourceKey[] {};
    private ResourceKey<Biome>[] blacklist = new ResourceKey[] {};
    private int depth_min = 0;
    private int depth_max = 255;
    private int weight = 0;

    @ZenCodeType.Constructor
    public LaserDrillRarityBuilder() {}

    @ZenCodeType.Method
    public LaserDrillRarityBuilder setDepthMin(int depth_min) {
        this.depth_min = depth_min;
        return this;
    }

    @ZenCodeType.Method
    public LaserDrillRarityBuilder setDepthMax(int depth_max) {
        this.depth_max = depth_max;
        return this;
    }

    @ZenCodeType.Method
    public LaserDrillRarityBuilder setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    @ZenCodeType.Method
    public LaserDrillRarityBuilder addBiomeDictToWhitelist(String dictionary) {
        Set<ResourceKey<Biome>> keys = BiomeDictionary.getBiomes(BiomeDictionary.Type.getType(dictionary));
        int length = whitelist.length;
        this.whitelist = Arrays.copyOf(this.whitelist, keys.size()+length);
        int i = length;
        for(ResourceKey<Biome> key : keys) {
            whitelist[i] = key;
            i++;
        }
        return this;
    }

    @ZenCodeType.Method
    public LaserDrillRarityBuilder addBiomeDictToBlacklist(String dictionary) {
        Set<ResourceKey<Biome>> keys = BiomeDictionary.getBiomes(BiomeDictionary.Type.getType(dictionary));
        int length = blacklist.length;
        this.blacklist = Arrays.copyOf(this.blacklist, keys.size()+length);
        int i = length;
        for(ResourceKey<Biome> key : keys) {
            blacklist[i] = key;
            i++;
        }
        return this;
    }

    @ZenCodeType.Method
    public LaserDrillRarityBuilder addBiomeToWhitelist(String biome) {
        int length = whitelist.length;
        if(length == 0) {
            this.whitelist = new ResourceKey[] {this.getBiome(biome)};
        }
        else {
            this.whitelist = Arrays.copyOf(whitelist, length+1);
            this.whitelist[length] = this.getBiome(biome);
        }
        return this;
    }

    @ZenCodeType.Method
    public LaserDrillRarityBuilder addBiomeToBlacklist(String biome) {
        int length = blacklist.length;
        if(length == 0) {
            this.blacklist = new ResourceKey[] {this.getBiome(biome)};
        }
        else {
            this.blacklist = Arrays.copyOf(blacklist, length+1);
            this.blacklist[length] = this.getBiome(biome);
        }
        return this;
    }

    @ZenCodeType.Method
    public LaserDrillRarityInterface build() {
        return new CTLaserDrillRarity(new LaserDrillRarity(whitelist, blacklist, this.depth_min, this.depth_max, this.weight));
    }

    private ResourceKey<Biome> getBiome(String name) {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(name));
    }
}
