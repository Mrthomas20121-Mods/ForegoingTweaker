package mrthomas20121.foregoing_tweaker.laser_drill;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.buuz135.industrial.recipe.LaserDrillRarity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Arrays;
import java.util.Set;

@ZenCodeType.Name("mods.foregoing_tweaker.laser_drill.LaserDrillRarityBuilder")
@ZenRegister
public class LaserDrillRarityBuilder {
    private RegistryKey<Biome>[] whitelist = new RegistryKey[] {};
    private RegistryKey<Biome>[] blacklist = new RegistryKey[] {};
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
        Set<RegistryKey<Biome>> keys = BiomeDictionary.getBiomes(BiomeDictionary.Type.getType(dictionary));
        int length = whitelist.length;
        this.whitelist = Arrays.copyOf(this.whitelist, keys.size()+length);
        int i = length;
        for(RegistryKey<Biome> key : keys) {
            whitelist[i] = key;
            i++;
        }
        return this;
    }

    @ZenCodeType.Method
    public LaserDrillRarityBuilder addBiomeDictToBlacklist(String dictionary) {
        Set<RegistryKey<Biome>> keys = BiomeDictionary.getBiomes(BiomeDictionary.Type.getType(dictionary));
        int length = blacklist.length;
        this.blacklist = Arrays.copyOf(this.blacklist, keys.size()+length);
        int i = length;
        for(RegistryKey<Biome> key : keys) {
            blacklist[i] = key;
            i++;
        }
        return this;
    }

    @ZenCodeType.Method
    public LaserDrillRarityBuilder addBiomeToWhitelist(String biome) {
        int length = whitelist.length;
        if(length == 0) {
            this.whitelist = new RegistryKey[] {this.getBiome(biome)};
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
            this.blacklist = new RegistryKey[] {this.getBiome(biome)};
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

    private RegistryKey<Biome> getBiome(String name) {
        return RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(name));
    }
}
