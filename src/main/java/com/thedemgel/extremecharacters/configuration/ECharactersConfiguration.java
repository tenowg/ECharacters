package com.thedemgel.extremecharacters.configuration;

import com.thedemgel.extremecharacters.ECharacters;
import java.io.File;
import java.util.logging.Level;
import org.spout.api.exception.ConfigurationException;
import org.spout.api.util.config.ConfigurationHolder;
import org.spout.api.util.config.ConfigurationHolderConfiguration;
import org.spout.api.util.config.yaml.YamlConfiguration;

public class ECharactersConfiguration extends ConfigurationHolderConfiguration {
	
	public static final ConfigurationHolder RESIST_TICK = new ConfigurationHolder(60, "resist", "tick");
	
	public ECharactersConfiguration(File dataFolder) {
		super(new YamlConfiguration(new File(dataFolder, "config.yml")));
	}

	@Override
	public void load() {
		try {
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
