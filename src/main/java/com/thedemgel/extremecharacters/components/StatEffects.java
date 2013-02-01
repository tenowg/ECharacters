package com.thedemgel.extremecharacters.components;

import java.io.Serializable;
import org.spout.api.map.DefaultedKey;

/**
 * Simple class to monitor and adjust stats
 * @author Craig <tenowg at thedemgel.com>
 */
public class StatEffects implements Serializable {
    private DefaultedKey<Integer> effected;
    private String component;
    private Integer effect;
    private String reason; 
    
    public StatEffects(DefaultedKey<Integer> effected, String component, Integer effect, String reason) {
        this.effected = effected;
        this.component = component;
        this.effect = effect;
        this.reason = reason;
    }    
}
