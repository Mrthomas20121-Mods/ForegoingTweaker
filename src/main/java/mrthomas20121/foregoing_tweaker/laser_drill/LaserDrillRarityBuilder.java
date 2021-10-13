package mrthomas20121.foregoing_tweaker.laser_drill;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.buuz135.industrial.recipe.LaserDrillRarity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import org.openzen.zencode.java.ZenCodeType;

import java.util.HashSet;
import java.util.Set;

@Document(value = "mods/ForegoingTweaker/Api/LaserDrillRarityBuilder")
@ZenCodeType.Name("mods.foregoing_tweaker.laser_drill.LaserDrillRarityBuilder")
@ZenRegister
public class LaserDrillRarityBuilder {

    private final Set<RegistryKey<Biome>> whitelist = new HashSet<>();
    private final Set<RegistryKey<Biome>> blacklist = new HashSet<>();
    private int depth_min = 0;
    private int depth_max = 255;
    private int weight = 0;
    private LaserDrillRarity rarity;

    /**
     * @docs
     */
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
        this.whitelist.add(this.getBiome(biome));
        return this;
    }

    @ZenCodeType.Method
    public LaserDrillRarityBuilder addBiomeToBlacklist(String biome) {
        this.blacklist.add(this.getBiome(biome));
        return this;
    }

    @ZenCodeType.Method
    public LaserDrillRarityBuilder build() {
        RegistryKey<Biome>[] whitelistedBiomes;
        RegistryKey<Biome>[] blacklistedBiomes;
        if(whitelist.isEmpty()) {
            whitelistedBiomes = new RegistryKey[]{};
        }
        else {
            whitelistedBiomes = (RegistryKey<Biome>[]) whitelist.toArray();
        }
        if(blacklist.isEmpty()) {
            blacklistedBiomes = new RegistryKey[]{};
        }
        else {
            blacklistedBiomes = (RegistryKey<Biome>[]) blacklist.toArray();
        }
        this.rarity = new LaserDrillRarity(whitelistedBiomes, blacklistedBiomes, this.depth_min, this.depth_max, this.weight);
        return this;
    }

    public LaserDrillRarity getRarity() {
        return rarity;
    }

    private RegistryKey<Biome> getBiome(String name) {
        return RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(name));
    }
}
