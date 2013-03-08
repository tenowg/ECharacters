
package com.thedemgel.extremecharacters.annotations.require.requirements;

import com.thedemgel.extremecharacters.components.race.RaceComponent;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RequireRace {
	Class<? extends RaceComponent> value();
}
