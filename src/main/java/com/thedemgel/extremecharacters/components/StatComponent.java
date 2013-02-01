package com.thedemgel.extremecharacters.components;

import com.thedemgel.extremecharacters.data.ECharacterData;
import com.thedemgel.extremecharacters.data.EffectTypes;
import org.spout.api.entity.Entity;
import org.spout.api.map.DefaultedKey;

/**
 *
 * @author Craig <tenowg at thedemgel.com>
 */
public class StatComponent extends PassiveComponent {

	@Override
	public void onAttached() {
		addType(EffectTypes.NULL);
		super.onAttached();
	}

	public Integer getStat(DefaultedKey<Integer> stat) {
		return getData().get(stat);
	}

	public void setStat(DefaultedKey<Integer> stat, Integer value) {
		getData().put(stat, value);
	}

	public Integer getPoints() {
		return getData().get(ECharacterData.STAT_POINTS);
	}

	public void addPoints(Integer value) {
		getData().put(ECharacterData.STAT_POINTS, getPoints() + value);
	}

	public void removePoints(Integer value) {
		getData().put(ECharacterData.STAT_POINTS, getPoints() - value);
	}

	public boolean hasPoints(Integer value) {
		if (getData().get(ECharacterData.STAT_POINTS) >= value) {
			return true;
		}
		return false;
	}
}
