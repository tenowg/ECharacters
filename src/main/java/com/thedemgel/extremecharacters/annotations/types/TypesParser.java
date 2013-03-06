
package com.thedemgel.extremecharacters.annotations.types;

import com.thedemgel.extremecharacters.components.EComponent;
import com.thedemgel.extremecharacters.data.EffectTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TypesParser {
	public static <T extends EComponent> EffectTypes[] types(Class<T> component) {
		if (component.isAnnotationPresent(Types.class)) {
			return component.getAnnotation(Types.class).types();
		}
		
		return null;
	}
	
	public static <T extends EComponent> boolean hasType(Class<T> component, EffectTypes type) {
		if (component.isAnnotationPresent(Types.class)) {
			List<EffectTypes> types = Arrays.asList(component.getAnnotation(Types.class).types());
						
			return types.contains(type);
		}
		
		return false;
	}
}
