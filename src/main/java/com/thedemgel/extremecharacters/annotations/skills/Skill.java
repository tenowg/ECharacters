
package com.thedemgel.extremecharacters.annotations.skills;

import com.thedemgel.extremecharacters.components.effect.EffectComponent;
import com.thedemgel.extremecharacters.components.effect.effects.NullEffect;
import com.thedemgel.extremecharacters.components.stat.StatComponent;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Skill {
	String name();
	Class<? extends StatComponent> base();
	Class<? extends EffectComponent> effect() default NullEffect.class;
}
