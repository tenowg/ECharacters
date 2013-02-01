
package com.thedemgel.extremecharacters.components;

import java.lang.reflect.TypeVariable;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import org.spout.api.Spout;
import org.spout.api.component.Component;
import org.spout.api.component.type.EntityComponent;
import org.spout.api.entity.Entity;
import org.spout.api.event.player.PlayerInteractEvent.Action;
import org.spout.api.util.list.concurrent.ConcurrentList;


public class ComponentComponent extends EntityComponent {
	private ConcurrentHashMap<Class<? extends BasicComponent>, BasicComponent> components = new ConcurrentHashMap<Class<? extends BasicComponent>, BasicComponent>();
	@SuppressWarnings("MapReplaceableByEnumMap")
	private ConcurrentHashMap<Enum<?>, ConcurrentList<Class<? extends BasicComponent>>> typeComponents = new ConcurrentHashMap<Enum<?>, ConcurrentList<Class<? extends BasicComponent>>>();
	
	public <T extends BasicComponent> void add(Class<T> clazz) {		
		T component = getOwner().add(clazz);
		
		if (component != null) {
			if (component.passRequirements()) {
				components.put(clazz, component);
				//for (Enum<?> type : component.getTypes().getTypes()) {
				for (Enum<?> type : getOwner().get(clazz).getTypes().getTypes()) {	
					if (!typeComponents.containsKey(type)) {
						typeComponents.put(type, new ConcurrentList<Class<? extends BasicComponent>>());
					}
					if (!typeComponents.get(type).contains(clazz)) {
						typeComponents.get(type).add(clazz);
					}
				}
			} else {
				remove(clazz);
			}
		}
	}
	
	public <T extends BasicComponent> T get(Class<T> clazz) {
		return (T) components.get(clazz);
	}
	
	public <T extends BasicComponent> void remove(Class<T> clazz) {
		if (components.containsKey(clazz)) {
			for (Enum<?> type : getOwner().get(clazz).getTypes().getTypes()) {
				if (typeComponents.containsKey(type)) {
					typeComponents.get(type).remove(clazz);
				}
			}
		}
		getOwner().detach(clazz);
	}
	
	@Override
	public void onInteract(Action action, Entity source) {
		for (BasicComponent component : components.values()) {
			component.onInteract(action, source);
		}
	}
}