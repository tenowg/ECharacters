
package com.thedemgel.extremecharacters.skill;

import com.thedemgel.extremecharacters.annotations.skills.Skill;
import com.thedemgel.extremecharacters.skill.skills.Mining;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Skills {
	public Skill getSkill(Enum<?> skill) {
		try {
			return skill.getClass().getField(skill.name()).getAnnotation(Skill.class);
		} catch (NoSuchFieldException | SecurityException ex) {
			Logger.getLogger(Skills.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return null;
	}
	
	public void test() {
		getSkill(Mining.EXCAVATING);
	}
}
