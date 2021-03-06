
package com.thedemgel.extremecharacters.annotations.types;

import com.thedemgel.extremecharacters.data.EffectTypes;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Types {
	EffectTypes[] value() default {};
}
