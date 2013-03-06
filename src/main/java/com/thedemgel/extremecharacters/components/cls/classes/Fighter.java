
package com.thedemgel.extremecharacters.components.cls.classes;

import com.thedemgel.extremecharacters.annotations.require.Requirements;
import com.thedemgel.extremecharacters.annotations.require.requirements.RequireClass;
import com.thedemgel.extremecharacters.annotations.require.requirements.RequireRace;
import com.thedemgel.extremecharacters.annotations.require.requirements.RequireStat;
import com.thedemgel.extremecharacters.components.cls.ClassComponent;
import com.thedemgel.extremecharacters.components.race.races.Human;
import com.thedemgel.extremecharacters.components.stat.stats.Strength;

@Requirements(
	classes = {
		@RequireClass(required = Mage.class, level = 2)},
	races = {
		@RequireRace(required = Human.class)},
	stats = {
		@RequireStat(required = Strength.class, stat = 3)})
public class Fighter extends ClassComponent {

	public Fighter() {
	}
	
	@Override
	public void onAttached() {
		super.onAttached();
	}
}
