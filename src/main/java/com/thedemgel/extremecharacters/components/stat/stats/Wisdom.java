
package com.thedemgel.extremecharacters.components.stat.stats;

import com.thedemgel.extremecharacters.annotations.DataKey;
import com.thedemgel.extremecharacters.components.resistances.Resist;
import com.thedemgel.extremecharacters.components.stat.StatComponent;

@DataKey("wisdom")
public class Wisdom extends StatComponent implements Resist {

	@Override
	public Double getResist() {
		return .12;
	}

}
