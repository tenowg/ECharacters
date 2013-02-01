package com.thedemgel.extremecharacters.components.effects;

import com.thedemgel.extremecharacters.components.EffectComponent;
import com.thedemgel.extremecharacters.components.abilities.TimedHealAbility;
import com.thedemgel.extremecharacters.data.ECharacterData;
import com.thedemgel.extremecharacters.data.EffectTypes;
import org.spout.api.entity.Player;
import org.spout.vanilla.api.event.cause.DamageCause.DamageType;

/**
 *
 * @author Craig <tenowg at thedemgel.com>
 */
public class TimedHealEffect extends EffectComponent {

	public TimedHealEffect() {
		addComponentReq(TimedHealAbility.class);
	}
	
	@Override
	public void onAttached() {
		addType(EffectTypes.BUFF);
		addType(EffectTypes.HEALTH);
		addType(EffectTypes.HEAL);
		super.onAttached();
	}

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
