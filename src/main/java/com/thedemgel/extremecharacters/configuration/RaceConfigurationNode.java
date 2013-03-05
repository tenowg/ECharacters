package com.thedemgel.extremecharacters.configuration;

import java.util.Map;
import org.spout.api.exception.ConfigurationException;
import org.spout.api.util.config.ConfigurationHolder;
import org.spout.api.util.config.ConfigurationHolderConfiguration;
import org.spout.api.util.config.ConfigurationNode;
import org.spout.api.util.config.MapConfiguration;

public class RaceConfigurationNode extends ConfigurationHolderConfiguration {

	public final ConfigurationHolder LOAD = new ConfigurationHolder(true, "load");
	public final ConfigurationHolder BONUS_STR = new ConfigurationHolder(0, "bonus", "stat", "str");
	public final ConfigurationHolder BONUS_DEX = new ConfigurationHolder(0, "bonus", "stat", "dex");
	public final ConfigurationHolder BONUS_CON = new ConfigurationHolder(0, "bonus", "stat", "con");
	public final ConfigurationHolder BONUS_INT = new ConfigurationHolder(0, "bonus", "stat", "int");
	public final ConfigurationHolder BONUS_WIS = new ConfigurationHolder(0, "bonus", "stat", "wis");
	public final ConfigurationHolder BONUS_CHR = new ConfigurationHolder(0, "bonus", "stat", "chr");
	private final String name;
	private final RaceConfiguration parent;

	public RaceConfigurationNode(RaceConfiguration parent, String racename) {
		super(new MapConfiguration(parent.getNode("races", racename).getValues()));
		this.parent = parent;
		this.name = racename;
	}

	/**
	 * Gets the world name of this world configuration node
	 *
	 * @return the world name
	 */
	public String getRaceName() {
		return this.name;
	}

	/**
	 * Gets the parent configuration of this world configuration node
	 *
	 * @return the parent configuration
	 */
	public RaceConfiguration getParent() {
		return this.parent;
	}

	/**
	 * Changes the default value for the load key.
	 *
	 * @param load True if the world should load by default, false if not.
	 * @return this node
	 */
	public RaceConfigurationNode shouldLoad(boolean load) {
		LOAD.setDefaultValue(load);
		return this;
	}

	@Override
	public void load() throws ConfigurationException {
		this.setConfiguration(new MapConfiguration(this.getParent().getNode("races", this.getRaceName()).getValues()));
		super.load();
	}

	@Override
	public void save() throws ConfigurationException {
		super.save();
		ConfigurationNode node = this.getParent().getNode("races", this.getRaceName());
		for (Map.Entry<String, Object> entry : this.getValues().entrySet()) {
			node.getNode(entry.getKey()).setValue(entry.getValue());
		}
	}
}
