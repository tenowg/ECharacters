package com.thedemgel.extremecharacters.components.abilities;

import com.thedemgel.extremecharacters.components.ActiveComponent;
import com.thedemgel.extremecharacters.components.ComponentComponent;
import com.thedemgel.extremecharacters.components.StatComponent;
import com.thedemgel.extremecharacters.components.effects.TimedHealEffect;
import com.thedemgel.extremecharacters.data.ECharacterData;
import com.thedemgel.extremecharacters.data.EffectTypes;
import org.spout.api.component.ComponentOwner;
import org.spout.api.entity.Player;

/**
 *
 * @author Craig <tenowg at thedemgel.com>
 */
public class TimedHealAbility extends ActiveComponent {

	public TimedHealAbility() {
		addComponentReq(StatComponent.class);
		addStatReq(ECharacterData.STAT_BODY, 6);
	}
	
	@Override
	public void onAttached() {
		addType(EffectTypes.HEAL);
		addType(EffectTypes.BUFF);
		addType(EffectTypes.HEALTH);
		super.onAttached();
	}

	@Override
	public void execute() {
		Player player = (Player) getOwner();
		player.get(ComponentComponent.class).add(TimedHealEffect.class);
		player.get(TimedHealEffect.class).setDuration(10f);
		player.get(TimedHealEffect.class).setInterval(2 * 20);
		player.get(TimedHealEffect.class).start();
	}
}
