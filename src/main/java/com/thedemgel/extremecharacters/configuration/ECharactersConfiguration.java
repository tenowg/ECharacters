package com.thedemgel.extremecharacters.configuration;

import com.thedemgel.extremecharacters.ECharacters;
import java.io.File;
import java.util.logging.Level;
import org.spout.cereal.config.ConfigurationException;
import org.spout.cereal.config.ConfigurationHolder;
import org.spout.cereal.config.ConfigurationHolderConfiguration;
import org.spout.cereal.config.yaml.YamlConfiguration;

public class ECharactersConfiguration extends ConfigurationHolderConfiguration {
	
	public static final ConfigurationHolder RESIST_TICK = new ConfigurationHolder(120, "resist", "tick");
	
	public static final RaceConfiguration RACES = new RaceConfiguration(ECharacters.getInstance().getDataFolder());
	
	public ECharactersConfiguration(File dataFolder) {
		super(new YamlConfiguration(new File(dataFolder, "config.yml")));
	}

	@Override
	public void load() {
		try {
			RACES.load();
			RACES.save();
			super.load();
			super.save();
		} catch (ConfigurationException e) {
			ECharacters.getInstance().getLogger().log(Level.WARNING, "Error loading ECharacters configuration: ", e);
		}
	}

	@Override
	public void save() {
		try {
			super.save();
		} catch (ConfigurationException e) {
			ECharacters.getInstance().getLogger().log(Level.WARNING, "Error saving ECharacters configuration: ", e);
		}
	}
}
