
package com.thedemgel.extremecharacters.components.classes;

import com.thedemgel.extremecharacters.components.BasicComponent;
import com.thedemgel.extremecharacters.components.StatComponent;
import com.thedemgel.extremecharacters.data.ECharacterData;
import com.thedemgel.extremecharacters.data.EffectTypes;


public class MageComponent extends BasicComponent {

	public MageComponent() {
		addStatReq(ECharacterData.STAT_INTELLIGENCE, 6);
	}
	
	@Override
	public void onAttached() {
		addType(EffectTypes.CLASS);
		super.onAttached();
	}
}
