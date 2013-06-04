
package com.thedemgel.extremecharacters.components;

import com.thedemgel.extremecharacters.annotations.DataKey;
import org.spout.api.component.entity.EntityComponent;

public class EComponent extends EntityComponent {
	
	public String getDataKey() {
		if (this.getClass().isAnnotationPresent(DataKey.class)) {
			return this.getClass().getAnnotation(DataKey.class).value();
		}
		
		return null;
	}
}
