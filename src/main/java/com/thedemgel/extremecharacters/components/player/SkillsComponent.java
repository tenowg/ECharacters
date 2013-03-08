
package com.thedemgel.extremecharacters.components.player;

import com.thedemgel.extremecharacters.components.EComponent;
import com.thedemgel.extremecharacters.skill.AnnotatedSkill;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class SkillsComponent extends EComponent {
	private Set<Class<? extends AnnotatedSkill>> trainedSkills = Collections.newSetFromMap(new ConcurrentHashMap<Class<? extends AnnotatedSkill>, Boolean>());

	public <T extends AnnotatedSkill> void  addSkill(Class<T> skill) {
		trainedSkills.add(skill);
	}
	
	public <T extends AnnotatedSkill> boolean removeSkill(Class<T> skill) {
		return trainedSkills.remove(skill);
	}
	
	public <T extends AnnotatedSkill> boolean hasSkill(Class<T> skill) {
		return trainedSkills.contains(skill);
	}
}
