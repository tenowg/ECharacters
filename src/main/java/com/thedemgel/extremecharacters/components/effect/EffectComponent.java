
package com.thedemgel.extremecharacters.components.effect;

import com.thedemgel.extremecharacters.components.EComponent;


public class EffectComponent extends EComponent {
	private boolean pause = true;
	
	public void setDuration(Float duration) {
		if (getDataKey() != null) {
			getDatatable().put(getDataKey() + "-effect-duration", duration);
		}
	}
	
	public void start() {
		pause = false;
	}
	
	public void pause() {
		if (pause) {
			pause = true;
		}
	}
	
	public void resume() {
		if (!pause) {
			pause = false;
		}
	}
	
	@Override
	public final void onTick(float dt) {
		if (canTick()) {
			effectTick(dt);
			getDatatable().put(getDataKey() + "-effect-duration", getDatatable().get(getDataKey() + "-effect-duration", Float.class) - dt);
		}
	}
	
	public void effectTick(float dt) {
		
	}
	
	@Override
	public boolean canTick() {
		return !pause;
	}
}
