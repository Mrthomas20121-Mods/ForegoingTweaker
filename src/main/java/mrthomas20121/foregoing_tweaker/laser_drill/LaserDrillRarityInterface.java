package mrthomas20121.foregoing_tweaker.laser_drill;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.ZenWrapper;
import com.buuz135.industrial.recipe.LaserDrillRarity;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.foregoing_tweaker.laser_drill.LaserDrillRarityInterface")
@ZenWrapper(wrappedClass = "com.buuz135.industrial.recipe.LaserDrillRarity", displayStringFormat = "%.getCommandString()", creationMethodFormat = "new CTLaserDrillRarity(%s)", implementingClass = "mrthomas20121.foregoing_tweaker.laser_drill.CTLaserDrillRarity")
public interface LaserDrillRarityInterface {

    @ZenCodeType.Method
    @ZenCodeType.Caster(implicit = true)
    LaserDrillRarity getInternal();

    @ZenCodeType.Method
    String getCommandString();
}
