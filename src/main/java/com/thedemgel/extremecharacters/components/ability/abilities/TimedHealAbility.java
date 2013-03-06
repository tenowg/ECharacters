package com.thedemgel.extremecharacters.components.ability.abilities;

import com.thedemgel.extremecharacters.ECharacters;
import com.thedemgel.extremecharacters.annotations.require.Requirements;
import com.thedemgel.extremecharacters.annotations.require.requirements.RequireAbility;
import com.thedemgel.extremecharacters.annotations.require.requirements.RequireClass;
import com.thedemgel.extremecharacters.annotations.require.requirements.RequireStat;
import com.thedemgel.extremecharacters.annotations.types.Types;
import com.thedemgel.extremecharacters.components.EComponent;
import com.thedemgel.extremecharacters.components.ability.AbilityComponent;
import com.thedemgel.extremecharacters.components.cls.classes.Cleric;
import com.thedemgel.extremecharacters.components.effect.effects.TimedHealEffect;
import com.thedemgel.extremecharacters.components.stat.stats.Constitution;
import com.thedemgel.extremecharacters.data.EffectTypes;
import org.spout.api.entity.Player;

@Types(types = {EffectTypes.HEAL, EffectTypes.BUFF, EffectTypes.HEALTH})
@Requirements(
	classes = {
		@RequireClass(required = Cleric.class)},
	stats = {
		@RequireStat(required = Constitution.class, stat = 3)})
public class TimedHealAbility extends AbilityComponent {

	public void execute() {
		Player player = (Player) getOwner();
		if(ECharacters.addComponent(player, TimedHealEffect.class).isEmpty()) {
			player.get(TimedHealEffect.class).setDuration(10f);
			player.get(TimedHealEffect.class).setInterval(2 * 20);
			player.get(TimedHealEffect.class).start();
		}
	}
}
