package com.thedemgel.extremecharacters.components;

import com.thedemgel.extremecharacters.data.ECharacterData;
import com.thedemgel.extremecharacters.data.EffectType;
import com.thedemgel.extremecharacters.data.EffectTypes;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.spout.api.Spout;
import org.spout.api.component.Component;
import org.spout.api.component.ComponentHolder;
import org.spout.api.component.ComponentOwner;
import org.spout.api.component.type.EntityComponent;
import org.spout.api.entity.Entity;
import org.spout.api.entity.Player;
import org.spout.api.event.player.PlayerInteractEvent.Action;
import org.spout.api.map.DefaultedKey;

/**
 *
 * @author Craig <tenowg at thedemgel.com>
 */
public class BasicComponent extends Component {

	private ConcurrentMap<Class<? extends Component>, Integer> reqComp = new ConcurrentHashMap<Class<? extends Component>, Integer>();
	private ConcurrentMap<String, Integer> reqStat = new ConcurrentHashMap<String, Integer>();
	private EffectType types = new EffectType();

	@Override
	public boolean attachTo(ComponentOwner holder) {
		super.attachTo(holder);
		return true;
	}

	@Override
	public void onAttached() {
		// Check to see if required Components are loaded before anything else possibly happens.
		getOwner().get(ComponentComponent.class).add(this.getClass());
	}

	@Override
	public Entity getOwner() {
		return (Entity) super.getOwner();
	}
		
	public boolean passRequirements() {
		boolean meetsReq = true;
		for (Entry<Class<? extends Component>, Integer> comp : reqComp.entrySet()) {
			//((Player)getOwner()).sendMessage(comp.getKey().toString());
			Component co = getOwner().get(comp.getKey());
			if (co == null) {
				meetsReq = false;
			} else {
				if (comp.getValue() == -1) {
					meetsReq = false;
				} else if (getOwner().get(comp.getKey()) instanceof BasicComponent) {
					if (((BasicComponent) getOwner().get(comp.getKey())).getLevel() < comp.getValue()) {
						meetsReq = false;
					}
				}
			}
		}

		for (Entry<String, Integer> stat : reqStat.entrySet()) {
			Integer reqInt = (Integer) getData().get(stat.getKey());
			if (reqInt < stat.getValue()) {
				meetsReq = false;
			}
		}

		return meetsReq;
	}

	/**
	 * Add a Requirement to attach this Class.
	 * 
	 * Set to -1 to disable class.
	 * @param clazz
	 * @param level 
	 */
	public void addComponentReq(Class<? extends Component> clazz, Integer level) {
		reqComp.putIfAbsent(clazz, level);
	}
	
	public void addComponentReq(Class<? extends Component> clazz) {
		addComponentReq(clazz, 0);
	}

	public void addStatReq(DefaultedKey<Integer> stat, Integer value) {
		reqStat.putIfAbsent(stat.getKeyString(), value);
	}

	public void addType(Enum<?> type) {
		if (!types.hasType(type)) {
			types.put(type);
		}
	}

	public EffectType getTypes() {
		return types;
	}

	public Integer getLevel() {
		return 1;
	}

	/**
	 * Called when the entity is interacted with.
	 *
	 * @param action being performed
	 * @param source performing the action
	 */
	public void onInteract(Action action, Entity source) {
		((Player)getOwner()).sendMessage(action.toString());
	}
}
