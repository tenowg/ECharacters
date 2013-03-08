
package com.thedemgel.extremecharacters.skill;

import com.thedemgel.extremecharacters.annotations.skills.Skill;

public class Skills {
	public <T extends AnnotatedSkill> Skill getSkill(Class<T> skill) {
		return skill.getClass().getAnnotation(Skill.class);
	}
}
