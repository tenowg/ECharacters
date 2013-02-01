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
    public static final DefaultedKey<Integer> STAT_STRENGTH = new DefaultedKeyImpl<Integer>("strength", 3);
    public static final DefaultedKey<Integer> STAT_DEXTERITY = new DefaultedKeyImpl<Integer>("dexterity", 3);
    public static final DefaultedKey<Integer> STAT_BODY = new DefaultedKeyImpl<Integer>("body", 3);
    public static final DefaultedKey<Integer> STAT_INTELLIGENCE = new DefaultedKeyImpl<Integer>("intelligence", 3);
    public static final DefaultedKey<Integer> STAT_WISDOM = new DefaultedKeyImpl<Integer>("wisdon", 3);
    public static final DefaultedKey<Integer> STAT_CHARISMA = new DefaultedKeyImpl<Integer>("charisma", 3);
    public static final DefaultedKey<Integer> STAT_POINTS = new DefaultedKeyImpl<Integer>("points", 0);
    
    public static final DefaultedKey<Float> EXPERIENCE = new DefaultedKeyImpl<Float>("experience", 0f);
    
    public static final DefaultedKey<Float> EFFECT_DURATION = new DefaultedKeyImpl<Float>("effect_duration", 0f);
    public static final DefaultedKey<Boolean> EFFECT_ACTIVE = new DefaultedKeyImpl<Boolean>("effect_active", false);
    public static final DefaultedKey<Long> EFFECT_INTERVAL = new DefaultedKeyImpl<Long>("effect_interval", 0L);
    public static final DefaultedKey<Long> EFFECT_INTERVAL_COUNT = new DefaultedKeyImpl<Long>("effect_interval_count", 0L);
    public static final DefaultedKey<EffectType> EFFECT_TYPE = new DefaultedKeyImpl<EffectType>("effect_type", new EffectType());
}
