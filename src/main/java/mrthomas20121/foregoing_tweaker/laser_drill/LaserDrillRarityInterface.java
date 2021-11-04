package mrthomas20121.foregoing_tweaker.laser_drill;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.brackets.CommandStringDisplayable;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.buuz135.industrial.recipe.LaserDrillRarity;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.foregoing_tweaker.laser_drill.LaserDrillRarityInterface")
public interface LaserDrillRarityInterface extends CommandStringDisplayable {

    @ZenCodeType.Method
    @ZenCodeType.Caster(implicit = true)
    LaserDrillRarity getInternal();
}
