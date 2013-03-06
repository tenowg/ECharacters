
package com.thedemgel.extremecharacters.components;

import com.thedemgel.extremecharacters.annotations.Requirement;
import org.spout.api.component.type.EntityComponent;
import org.spout.api.entity.Player;


public class EComponent extends EntityComponent {
	
	public static <T extends EComponent> boolean addComponent(Player player, Class<T> component) {
		if (Requirement.parse()) {
			player.add(component);
			return true;
		}
		return false;
	}
}
