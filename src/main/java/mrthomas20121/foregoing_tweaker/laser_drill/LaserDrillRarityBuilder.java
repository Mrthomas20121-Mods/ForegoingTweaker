package mrthomas20121.foregoing_tweaker.laser_drill;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.buuz135.industrial.recipe.LaserDrillRarity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Arrays;

@Document(value = "mods/ForegoingTweaker/Api/LaserDrillRarityBuilder")
@ZenCodeType.Name("mods.foregoing_tweaker.laser_drill.LaserDrillRarityBuilder")
@ZenRegister
public class LaserDrillRarityBuilder {

    private RegistryKey<Biome>[] whitelist = new RegistryKey[] {};
    private RegistryKey<Biome>[] blacklist = new RegistryKey[] {};
    private int depth_min = 0;
    private int depth_max = 255;
    private int weight = 0;
    private LaserDrillRarity rarity;

    @ZenCodeType.Constructor
    public LaserDrillRarityBuilder() {

    }

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
    public LaserDrillRarityBuilder build() {
        this.rarity = new LaserDrillRarity(whitelist, blacklist, this.depth_min, this.depth_max, this.weight);
        return this;
    }

    public LaserDrillRarity getRarity() {
        return rarity;
    }

    private RegistryKey<Biome> getBiome(String name) {
        return RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(name));
    }
}
