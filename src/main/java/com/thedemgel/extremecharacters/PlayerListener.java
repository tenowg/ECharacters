package com.thedemgel.extremecharacters;

import com.thedemgel.extremecharacters.components.ComponentComponent;
import com.thedemgel.extremecharacters.components.StatComponent;
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
    }
}
