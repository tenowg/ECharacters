
package com.thedemgel.extremecharacters.skill.skills.mining;

import com.thedemgel.extremecharacters.annotations.skills.Skill;
import com.thedemgel.extremecharacters.components.effect.effects.TimedHealEffect;
import com.thedemgel.extremecharacters.components.stat.stats.Strength;
import com.thedemgel.extremecharacters.skill.AnnotatedSkill;

@Skill(name = "Excavating", base = Strength.class, effect = TimedHealEffect.class)
public class Excavating implements AnnotatedSkill {

	@Override
	public void use() {
	}

}
