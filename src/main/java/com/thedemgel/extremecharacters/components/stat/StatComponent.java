
package com.thedemgel.extremecharacters.components.stat;

import com.thedemgel.extremecharacters.components.EComponent;
import org.spout.api.map.DefaultedKey;
import org.spout.api.map.DefaultedKeyImpl;


public class StatComponent extends EComponent {
	
	public Integer getBonus() {
		return 0;
	}
	
	public Integer getStat() {
		return getDatatable().get(getDataKey() + "stat", Integer.class);
	}
}
