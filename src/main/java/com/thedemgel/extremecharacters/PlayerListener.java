package com.thedemgel.extremecharacters;

import com.thedemgel.extremecharacters.components.ComponentComponent;
import com.thedemgel.extremecharacters.components.StatComponent;
import com.thedemgel.extremecharacters.components.resistances.element.ColdResist;
import com.thedemgel.extremecharacters.components.resistances.element.EarthResist;
import com.thedemgel.extremecharacters.components.resistances.element.FireResist;
import com.thedemgel.extremecharacters.components.resistances.element.SpiritResist;
import com.thedemgel.extremecharacters.components.resistances.element.WaterResist;
import com.thedemgel.extremecharacters.components.resistances.primary.BodyResist;
import com.thedemgel.extremecharacters.components.resistances.primary.CharismaResist;
import com.thedemgel.extremecharacters.components.resistances.primary.DexterityResist;
import com.thedemgel.extremecharacters.components.resistances.primary.IntelligenceResist;
import com.thedemgel.extremecharacters.components.resistances.primary.StrengthResist;
import com.thedemgel.extremecharacters.components.resistances.primary.WisdomResist;
import org.spout.api.entity.Player;
import org.spout.api.event.EventHandler;
import org.spout.api.event.Listener;
import org.spout.api.event.player.PlayerJoinEvent;

/**
 *
 * @author Craig <tenowg at thedemgel.com>
 */
public class PlayerListener implements Listener {
    private final ECharacters plugin;
    
    public PlayerListener(ECharacters instance) {
        this.plugin = instance;
    }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        ComponentComponent comp = player.add(ComponentComponent.class);
	comp.add(StatComponent.class);
	
	player.add(ColdResist.class);
	player.add(FireResist.class);
	player.add(EarthResist.class);
	player.add(SpiritResist.class);
	player.add(WaterResist.class);
	player.add(BodyResist.class);
	player.add(CharismaResist.class);
	player.add(DexterityResist.class);
	player.add(IntelligenceResist.class);
	player.add(StrengthResist.class);
	player.add(WisdomResist.class);
	
    }
}
