
package com.thedemgel.extremecharacters.annotations.require.requirements;

import com.thedemgel.extremecharacters.components.stat.StatComponent;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RequireStat {
	Class<? extends StatComponent> required();
	int stat() default 0;
}
