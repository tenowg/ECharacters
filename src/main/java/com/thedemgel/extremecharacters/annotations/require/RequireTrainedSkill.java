
package com.thedemgel.extremecharacters.annotations.require;

import com.thedemgel.extremecharacters.skill.AnnotatedSkill;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface RequireTrainedSkill {
	Class<? extends AnnotatedSkill> value();
}
