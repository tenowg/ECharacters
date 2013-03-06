
package com.thedemgel.extremecharacters.components.stat;

import com.thedemgel.extremecharacters.components.EComponent;
import org.spout.api.map.DefaultedKey;
import org.spout.api.map.DefaultedKeyImpl;


public class StatComponent extends EComponent {
	private DefaultedKey<Integer> stat = new DefaultedKeyImpl<>("stat", 6);
	// 0 bonus from 6 to 8
	
	public Integer getBonus() {
		return 0;
	}
	
	public Integer getStat() {
		return getData().get(stat);
	}
}
