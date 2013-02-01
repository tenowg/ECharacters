
package com.thedemgel.extremecharacters.components.classes;

import com.thedemgel.extremecharacters.components.BasicComponent;
import com.thedemgel.extremecharacters.components.StatComponent;
import com.thedemgel.extremecharacters.data.ECharacterData;
import com.thedemgel.extremecharacters.data.EffectTypes;


public class FighterComponent extends BasicComponent {

	public FighterComponent() {
		addStatReq(ECharacterData.STAT_STRENGTH, 3);
		addComponentReq(MageComponent.class, -1);
	}
	
	@Override
	public void onAttached() {
		addType(EffectTypes.CLASS);
		super.onAttached();
	}
}
