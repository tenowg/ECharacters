package com.thedemgel.extremecharacters;

import com.thedemgel.extremecharacters.components.player.HUD;
import com.thedemgel.extremecharacters.components.player.PlayerLevel;
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
import com.thedemgel.extremecharacters.components.stat.stats.Charisma;
import com.thedemgel.extremecharacters.components.stat.stats.Constitution;
import com.thedemgel.extremecharacters.components.stat.stats.Dexterity;
import com.thedemgel.extremecharacters.components.stat.stats.Intelligence;
import com.thedemgel.extremecharacters.components.stat.stats.Strength;
import com.thedemgel.extremecharacters.components.stat.stats.Wisdom;
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
	
	player.add(Strength.class);
	player.add(Dexterity.class);
	player.add(Constitution.class);
	player.add(Wisdom.class);
	player.add(Intelligence.class);
	player.add(Charisma.class);
	
	player.add(HUD.class);
	player.add(PlayerLevel.class);
	
    }
}
