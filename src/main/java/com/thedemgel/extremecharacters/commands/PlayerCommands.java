package com.thedemgel.extremecharacters.commands;

import com.thedemgel.extremecharacters.ECharacters;
import com.thedemgel.extremecharacters.components.ability.abilities.TimedHealAbility;
import com.thedemgel.extremecharacters.components.effect.effects.TimedHealEffect;
import com.thedemgel.extremecharacters.components.stat.stats.Charisma;
import com.thedemgel.extremecharacters.components.stat.stats.Constitution;
import com.thedemgel.extremecharacters.components.stat.stats.Dexterity;
import com.thedemgel.extremecharacters.components.stat.stats.Intelligence;
import com.thedemgel.extremecharacters.components.stat.stats.Strength;
import com.thedemgel.extremecharacters.components.stat.stats.Wisdom;
import org.spout.api.command.CommandArguments;
import org.spout.api.command.CommandSource;
import org.spout.api.command.annotated.CommandDescription;
import org.spout.api.entity.Player;
import org.spout.api.exception.CommandException;

/**
 *
 * @author Craig <tenowg at thedemgel.com>
 */
public class PlayerCommands {

	private final ECharacters plugin;

	public PlayerCommands(ECharacters instance) {
		this.plugin = instance;
	}

	@CommandDescription(aliases = "stats", usage = "", desc = "Lists players stats.")
	public void stats(CommandSource source, CommandArguments args) throws CommandException {
		Player player = (Player) source;

		player.sendMessage("STR: " + player.get(Strength.class).getStat());
		player.sendMessage("DEX: " + player.get(Dexterity.class).getStat());
		player.sendMessage("BOD: " + player.get(Constitution.class).getStat());
		player.sendMessage("INT: " + player.get(Intelligence.class).getStat());
		player.sendMessage("WIS: " + player.get(Wisdom.class).getStat());
		player.sendMessage("CHA: " + player.get(Charisma.class).getStat());
	}

	@CommandDescription(aliases = "addstat", usage = "[stat]", desc = "Add to a players stats.")
	public void addStat(CommandSource source, CommandArguments args) throws CommandException {
		Player player = (Player) source;;
		
		player.get(Constitution.class);
	}

	@CommandDescription(aliases = "test", usage = "", desc = "Test effect")
	public void test(CommandSource source, CommandArguments args) throws CommandException {
		Player player = (Player) source;
		player.add(TimedHealAbility.class).execute();
	}

	@CommandDescription(aliases = "pause", usage = "", desc = "Test effect")
	public void pause(CommandSource source, CommandArguments args) throws CommandException {
		Player player = (Player) source;
		player.get(TimedHealEffect.class).pause();
	}

	@CommandDescription(aliases = "remove", usage = "", desc = "Test effect")
	public void remove(CommandSource source, CommandArguments args) throws CommandException {
		Player player = (Player) source;
		player.detach(TimedHealEffect.class);
	}
}
