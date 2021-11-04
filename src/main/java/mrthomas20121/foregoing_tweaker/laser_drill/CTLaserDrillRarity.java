package mrthomas20121.foregoing_tweaker.laser_drill;

import com.buuz135.industrial.recipe.LaserDrillRarity;

public class CTLaserDrillRarity implements LaserDrillRarityInterface {

    private final LaserDrillRarity rarity;

    public CTLaserDrillRarity(LaserDrillRarity rarity) {
        this.rarity = rarity;
    }

    @Override
    public LaserDrillRarity getInternal() {
        return rarity;
    }

    @Override
    public String getCommandString() {
        return this.rarity.toString();
    }
}
