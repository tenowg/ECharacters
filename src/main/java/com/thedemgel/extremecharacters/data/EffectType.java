package com.thedemgel.extremecharacters.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Craig <tenowg at thedemgel.com>
 */
public class EffectType implements Serializable {
    private List<Enum<?>> types = new ArrayList<Enum<?>>();
    
    public boolean hasType(Enum<?> type) {
        return types.contains(type);
    }
    
    public void put(Enum<?> type) {
        types.add(type);
    }
    
    public List<Enum<?>> getTypes() {
        return types;
    }
}
