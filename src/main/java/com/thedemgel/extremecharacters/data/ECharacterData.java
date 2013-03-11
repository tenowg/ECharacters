package com.thedemgel.extremecharacters.data;

import java.util.ArrayList;
import java.util.List;
import org.spout.api.map.DefaultedKey;
import org.spout.api.map.DefaultedKeyImpl;

/**
 *
 * @author Craig <tenowg at thedemgel.com>
 */
public class ECharacterData {
    public static final DefaultedKey<Integer> STAT_STRENGTH = new DefaultedKeyImpl<>("strength", 3);
    public static final DefaultedKey<Integer> STAT_DEXTERITY = new DefaultedKeyImpl<>("dexterity", 3);
    public static final DefaultedKey<Integer> STAT_CONSTITUTION = new DefaultedKeyImpl<>("constitution", 3);
    public static final DefaultedKey<Integer> STAT_INTELLIGENCE = new DefaultedKeyImpl<>("intelligence", 3);
    public static final DefaultedKey<Integer> STAT_WISDOM = new DefaultedKeyImpl<>("wisdon", 3);
    public static final DefaultedKey<Integer> STAT_CHARISMA = new DefaultedKeyImpl<>("charisma", 3);
    public static final DefaultedKey<Integer> STAT_POINTS = new DefaultedKeyImpl<>("points", 0);
    
    public static final DefaultedKey<Float> EXPERIENCE = new DefaultedKeyImpl<>("experience", 0f);
    
    public static final DefaultedKey<Float> EFFECT_DURATION = new DefaultedKeyImpl<>("effect_duration", 0f);
    public static final DefaultedKey<Boolean> EFFECT_ACTIVE = new DefaultedKeyImpl<>("effect_active", false);
    public static final DefaultedKey<Long> EFFECT_INTERVAL = new DefaultedKeyImpl<>("effect_interval", 0L);
    public static final DefaultedKey<Long> EFFECT_INTERVAL_COUNT = new DefaultedKeyImpl<>("effect_interval_count", 0L);
    public static final DefaultedKey<EffectType> EFFECT_TYPE = new DefaultedKeyImpl<>("effect_type", new EffectType());
}
