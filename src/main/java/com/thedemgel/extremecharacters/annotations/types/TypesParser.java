
package com.thedemgel.extremecharacters.annotations.types;

import com.thedemgel.extremecharacters.components.EComponent;
import com.thedemgel.extremecharacters.data.EffectTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.spout.api.component.Component;
import org.spout.api.entity.Entity;
import org.spout.api.entity.Player;


public class TypesParser {
	public static <T extends EComponent> EffectTypes[] types(Class<T> component) {
		if (component.isAnnotationPresent(Types.class)) {
			return component.getAnnotation(Types.class).value();
		}
		
		return null;
	}
	
	public static <T extends EComponent> boolean hasType(Class<T> component, EffectTypes type) {
		if (component.isAnnotationPresent(Types.class)) {
			List<EffectTypes> types = Arrays.asList(component.getAnnotation(Types.class).value());
						
			return types.contains(type);
		}
		
		return false;
	}
	
	public static Set<EComponent> getComponentsWithType(Entity entity, EffectTypes type) {
		Set<EComponent> comps = Collections.newSetFromMap(new ConcurrentHashMap<EComponent, Boolean>());
		for (Component comp : entity.values()) {
			if (!(comp instanceof EComponent)) {
				continue;
			}
			if (comp.getClass().isAnnotationPresent(Types.class)) {
				List<EffectTypes> effecttype = Arrays.asList(comp.getClass().getAnnotation(Types.class).value());
				if (effecttype.contains(type)) {
					comps.add((EComponent) comp);
				}
			}
		}
		
		return comps;
	}
}
