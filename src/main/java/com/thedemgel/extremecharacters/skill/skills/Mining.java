package com.thedemgel.extremecharacters.skill.skills;

import com.thedemgel.extremecharacters.annotations.skills.Skill;
import com.thedemgel.extremecharacters.components.effect.effects.TimedHealEffect;
import com.thedemgel.extremecharacters.components.stat.stats.Strength;
import com.thedemgel.extremecharacters.skill.AnnotatedSkill;

public enum Mining implements AnnotatedSkill {
	@Skill(name = "Excavating", base = Strength.class, effect = TimedHealEffect.class)
	EXCAVATING {@Override public void use() {}};
}
