
package com.thedemgel.extremecharacters.components.cls.classes;

import com.thedemgel.extremecharacters.annotations.require.Requirements;
import com.thedemgel.extremecharacters.annotations.require.requirements.RequireStat;
import com.thedemgel.extremecharacters.components.cls.ClassComponent;
import com.thedemgel.extremecharacters.components.stat.stats.Wisdom;

@Requirements(
	stats = {
		@RequireStat(required = Wisdom.class, stat = 3)})
public class Cleric extends ClassComponent {

	public Cleric() {
	}
	
	@Override
	public void onAttached() {
		super.onAttached();
	}
}
