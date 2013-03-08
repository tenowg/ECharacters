package com.thedemgel.extremecharacters.components.effect.effects;

import com.thedemgel.extremecharacters.annotations.require.Requirements;
import com.thedemgel.extremecharacters.annotations.require.requirements.RequireAbility;
import com.thedemgel.extremecharacters.annotations.types.Types;
import com.thedemgel.extremecharacters.components.ability.abilities.TimedHealAbility;
import com.thedemgel.extremecharacters.components.effect.EffectComponent;
import com.thedemgel.extremecharacters.data.ECharacterData;
import com.thedemgel.extremecharacters.data.EffectTypes;
import org.spout.api.entity.Player;

@Types({EffectTypes.BUFF, EffectTypes.HEALTH, EffectTypes.HEAL})
@Requirements(
	abilities = {
		@RequireAbility(required = TimedHealAbility.class)})
public class TimedHealEffect extends EffectComponent {

	@Override
	public void onTick(float dt) {
		super.onTick(dt);

		if (getData().get(ECharacterData.EFFECT_INTERVAL_COUNT) % getData().get(ECharacterData.EFFECT_INTERVAL) == 0) {
			getData().put(ECharacterData.EFFECT_INTERVAL_COUNT, 0L);
			// Execute Heal Effect
			((Player) getOwner()).sendMessage("Healed");
		}
		getData().put(ECharacterData.EFFECT_INTERVAL_COUNT, getData().get(ECharacterData.EFFECT_INTERVAL_COUNT) + 1);
	}

	@Override
	public void onDetached() {
		Player player = (Player) getOwner();
		player.sendMessage("One Last Heal");
		super.onDetached();
	}

	public void setInterval(long ticks) {
		getData().put(ECharacterData.EFFECT_INTERVAL, ticks);
	}
}
