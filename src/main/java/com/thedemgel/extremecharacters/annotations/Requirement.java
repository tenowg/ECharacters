
package com.thedemgel.extremecharacters.annotations;

import com.thedemgel.extremecharacters.annotations.require.Requirements;
import com.thedemgel.extremecharacters.annotations.require.requirements.RequireAbility;
import com.thedemgel.extremecharacters.annotations.require.requirements.RequireClass;
import com.thedemgel.extremecharacters.annotations.require.requirements.RequireRace;
import com.thedemgel.extremecharacters.annotations.require.requirements.RequireStat;
import com.thedemgel.extremecharacters.components.EComponent;
import java.util.HashMap;
import java.util.Map;
import org.spout.api.entity.Player;


/**
 * Used to parse requirements for Components before they are added
 * to any character.
 */
public class Requirement {
	public static <T extends EComponent> Map parse(Player player, Class<T> component) {
		Map<Class<? extends EComponent>, String> err = new HashMap<>();
		
		if (component.isAnnotationPresent(Requirements.class)) {
			// First check class requirements
			RequireClass[] reqClass = component.getAnnotation(Requirements.class).classes();
			RequireRace[] reqRace = component.getAnnotation(Requirements.class).races();
			RequireStat[] reqStat = component.getAnnotation(Requirements.class).stats();
			RequireAbility[] reqAbility = component.getAnnotation(Requirements.class).abilities();
			
			for (RequireClass reqclass : reqClass) {
				if (player.get(reqclass.required()) != null) {
					if (player.get(reqclass.required()).getLevel() < reqclass.level()) {
						err.put(reqclass.required(), "Level to low");
					}
				} else {
					err.put(reqclass.required(), "Required class not found.");
				}
			}
			
			for (RequireRace reqrace : reqRace) {
				if (player.get(reqrace.required()) == null) {
					err.put(reqrace.required(), "Required race not found.");
				}
			}
			
			for (RequireStat reqstat : reqStat) {
				if (player.get(reqstat.required()) != null) {
					if (player.get(reqstat.required()).getStat() < reqstat.stat()) {
						err.put(reqstat.required(), "Stat is to low.");
					}
				} else {
					err.put(reqstat.required(), "Does not have required Stat.");
				}
			}
			
			for (RequireAbility reqability : reqAbility) {
				if (player.get(reqability.required()) != null) {
					if (player.get(reqability.required()).getLevel() < reqability.level()) {
						err.put(reqability.required(), "Level to low");
					}
				} else {
					err.put(reqability.required(), "Required Ability not found.");
				}
			}
		}
		
		
		return err;
	}
}
