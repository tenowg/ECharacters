
package com.thedemgel.extremecharacters.components.resistances;

import com.thedemgel.extremecharacters.components.BasicComponent;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.spout.api.component.type.EntityComponent;


public class ResistComponent extends EntityComponent {
	protected Set<Class<? extends BasicComponent>> resists = Collections.newSetFromMap(new ConcurrentHashMap<Class<? extends BasicComponent>, Boolean>());

	protected double maxResist;
	protected double currentResist;
	// Number of ticks to refresh.
	protected int refreshInterval;
	// The default refreshRate
	protected double refreshRate;
	// The modified refreshRate
	protected double modRefreshRate;
	
	public ResistComponent(int refreshInterval, double refreshRate) {
		
	}
	
	private class ValidateResists implements Runnable {
		@Override
		public void run() {
			
		}
	}
}
