package com.thedemgel.extremecharacters.components;

import com.thedemgel.extremecharacters.data.ECharacterData;
import com.thedemgel.extremecharacters.data.EffectType;
import com.thedemgel.extremecharacters.data.EffectTypes;
import java.util.List;
import org.spout.api.component.type.EntityComponent;
import org.spout.api.entity.Player;

/**
 * Effect Components act similar to Active Components but are detached when time
 * expires.
 *
 * @author Craig <tenowg at thedemgel.com>
 */
public class EffectComponent extends BasicComponent {

	@Override
	public void onTick(float dt) {
		if (getData().get(ECharacterData.EFFECT_ACTIVE)) {
			float duration = getData().get(ECharacterData.EFFECT_DURATION);
			// Do Tick stuff.
			duration -= dt;
			getData().put(ECharacterData.EFFECT_DURATION, getData().get(ECharacterData.EFFECT_DURATION) - dt);
			if (duration <= 0) {
				this.doDetach();
			}
		}
	}

	/**
	 * Sets the duration of the effect in seconds.
	 *
	 * @param duration (float seconds)
	 */
	public void setDuration(float duration) {
		getData().put(ECharacterData.EFFECT_DURATION, duration);
	}

	/**
	 * Starts the effect, and sets it to active.
	 */
	public void start() {
		getData().put(ECharacterData.EFFECT_ACTIVE, true);
	}

	/**
	 * Stops and removes the Effect from the player.
	 */
	public void stop() {
		getData().put(ECharacterData.EFFECT_ACTIVE, false);
		this.doDetach();
	}

	/**
	 * Pauses the effect, and sets the effect to inactive.
	 */
	public void pause() {
		getData().put(ECharacterData.EFFECT_ACTIVE, false);
	}

	/**
	 * Detaches the effect directly, and does any final cleanup on the
	 * effect.
	 */
	public void doDetach() {
		Player player = (Player) getOwner();
		player.get(ComponentComponent.class).remove(this.getClass());
	}
}
