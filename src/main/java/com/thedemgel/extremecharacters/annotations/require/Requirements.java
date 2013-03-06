
package com.thedemgel.extremecharacters.annotations.require;

import com.thedemgel.extremecharacters.annotations.require.requirements.RequireAbility;
import com.thedemgel.extremecharacters.annotations.require.requirements.RequireClass;
import com.thedemgel.extremecharacters.annotations.require.requirements.RequireRace;
import com.thedemgel.extremecharacters.annotations.require.requirements.RequireStat;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
public @interface Requirements {
	RequireClass[] classes() default {};
	RequireRace[] races() default {};
	RequireStat[] stats() default {};
	RequireAbility[] abilities() default {};
}
