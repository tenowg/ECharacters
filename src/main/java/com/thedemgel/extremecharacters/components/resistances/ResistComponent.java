
package com.thedemgel.extremecharacters.components.resistances;

import com.thedemgel.extremecharacters.ECharacters;
import com.thedemgel.extremecharacters.components.EComponent;
import com.thedemgel.extremecharacters.configuration.ECharactersConfiguration;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class ResistComponent extends EComponent {
	protected Set<Class<? extends EComponent>> resists = Collections.newSetFromMap(new ConcurrentHashMap<Class<? extends EComponent>, Boolean>());

	protected double maxResist;
	protected double currentResist;
	// Number of ticks to refresh.
	protected int refreshInterval;
	// The default refreshRate
	protected double refreshRate;
	// The modified refreshRate
	protected double modRefreshRate;
	
	// Tick count for onTicks
	private int tickcount = 1;
	private int refreshtickcount = 1;
	
	public ResistComponent(int refreshInterval, double refreshRate) {
		this.refreshInterval = refreshInterval;
		this.refreshRate = refreshRate;
	}
	
	public <T extends Resist> void addResist(Class<T> clazz) {
		
	}
	
	@Override
	public void onTick(float dt) {
		if (tickcount % ECharactersConfiguration.RESIST_TICK.getInt() == 0) {
			Thread thread = new Thread(new ValidateResists());
			thread.start();
			tickcount = 1;
		} else {
			tickcount++;
		}
		
		if (refreshtickcount % refreshInterval == 0) {
			// Add amount to resist unless it is greater, than = max
			refreshtickcount = 1;
		} else {
			refreshtickcount++;
		}
	}
	
	private class ValidateResists implements Runnable {
		@Override
		public void run() {
			ECharacters.getInstance().getLogger().info(Thread.currentThread().getName());
		}
	}
}
