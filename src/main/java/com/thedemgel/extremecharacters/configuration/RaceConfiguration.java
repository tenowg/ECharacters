package com.thedemgel.extremecharacters.configuration;

import com.thedemgel.extremecharacters.components.race.Race;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.spout.api.exception.ConfigurationException;
import org.spout.api.util.config.yaml.YamlConfiguration;

public class RaceConfiguration extends YamlConfiguration {

	private final Map<String, RaceConfigurationNode> raceNodes = new HashMap<String, RaceConfigurationNode>();
	public static RaceConfigurationNode HUMAN;
	public static RaceConfigurationNode ELF;
	public static RaceConfigurationNode GIANT;
	public static RaceConfigurationNode HALFLING;

	public RaceConfiguration(File dataFolder) {
		super(new File(dataFolder, "races.yml"));

		HUMAN = get("human");
		ELF = get("elf");
		GIANT = get("giant");
		HALFLING = get("halfling");
	}

	public Collection<RaceConfigurationNode> getAll() {
		return raceNodes.values();
	}

	/**
	 * Gets the race configuration of a certain race<br> Creates a new one
	 * if it doesn't exist
	 *
	 * @param race of the configuration
	 * @return the Race configuration node
	 */
	public RaceConfigurationNode get(Race race) {
		return get(race.getName());
	}

	/**
	 * Gets the race configuration of a certain race<br> Creates a new one
	 * if it doesn't exist
	 *
	 * @param racename of the configuration
	 * @return the Race configuration node
	 */
	public final RaceConfigurationNode get(String racename) {
		synchronized (raceNodes) {
			RaceConfigurationNode node = raceNodes.get(racename);
			if (node == null) {
				node = new RaceConfigurationNode(this, racename);
				raceNodes.put(racename, node);
			}
			return node;
		}
	}

	@Override
	public void load() throws ConfigurationException {
		super.load();
		for (RaceConfigurationNode node : getAll()) {
			node.load();
		}
	}

	@Override
	public void save() throws ConfigurationException {
		for (RaceConfigurationNode node : getAll()) {
			node.save();
		}
		super.save();
	}
}
