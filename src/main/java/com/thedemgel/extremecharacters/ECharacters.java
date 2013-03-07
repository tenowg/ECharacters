package com.thedemgel.extremecharacters;

import com.thedemgel.extremecharacters.annotations.Requirement;
import com.thedemgel.extremecharacters.commands.AdminCommands;
import com.thedemgel.extremecharacters.commands.PlayerCommands;
import com.thedemgel.extremecharacters.components.EComponent;
import com.thedemgel.extremecharacters.configuration.ECharactersConfiguration;
import com.thedemgel.extremecharacters.skill.Skills;
import java.util.Map;
import java.util.logging.Level;
import org.spout.api.Engine;
import org.spout.api.chat.ChatArguments;
import org.spout.api.chat.style.ChatStyle;
import org.spout.api.command.CommandRegistrationsFactory;
import org.spout.api.command.RootCommand;
import org.spout.api.command.annotated.AnnotatedCommandRegistrationFactory;
import org.spout.api.command.annotated.SimpleAnnotatedCommandExecutorFactory;
import org.spout.api.command.annotated.SimpleInjector;
import org.spout.api.entity.Player;
import org.spout.api.plugin.CommonPlugin;
import org.spout.api.plugin.PluginLogger;

/**
 *
 * @author Craig <tenowg at thedemgel.com>
 */
public class ECharacters extends CommonPlugin {

	private Engine engine;
	private static ECharacters instance;
	private ECharactersConfiguration config;
	private Skills skills;

	@Override
	public void onLoad() {
		setInstance(this);
		((PluginLogger) getLogger()).setTag(new ChatArguments(ChatStyle.RESET, "[", ChatStyle.GOLD, "ECharacters", ChatStyle.RESET, "] "));
		engine = getEngine();
		config = new ECharactersConfiguration(getDataFolder());
		config.load();
		getLogger().info("loaded");
	}

	@Override
	public void onEnable() {
		skills = new Skills();
		//Commands
		final CommandRegistrationsFactory<Class<?>> commandRegFactory = new AnnotatedCommandRegistrationFactory(getEngine(), new SimpleInjector(this), new SimpleAnnotatedCommandExecutorFactory());
		final RootCommand root = engine.getRootCommand();
		root.addSubCommands(this, PlayerCommands.class, commandRegFactory);
		root.addSubCommands(this, AdminCommands.class, commandRegFactory);

		engine.getEventManager().registerEvents(new PlayerListener(this), this);

		getLogger().log(Level.INFO, "v{0} enabled. Protocol: {1}", new Object[]{getDescription().getVersion(), getDescription().getData("protocol")});
	}

	@Override
	public void onDisable() {
		instance = null;
		getLogger().info("disabled");
	}

	private static void setInstance(ECharacters plugin) {
		instance = plugin;
	}

	public static ECharacters getInstance() {
		return instance;
	}
	
	public Skills getSkills() {
		return skills;
	}

	public static <T extends EComponent> Map<Class<? extends EComponent>, String> addComponent(Player player, Class<T> component) {
		Map<Class<? extends EComponent>, String> passReq = Requirement.parse(player, component);
		if (passReq.isEmpty()) {
			player.add(component);
			return passReq;
		}

		return passReq;
	}
}
