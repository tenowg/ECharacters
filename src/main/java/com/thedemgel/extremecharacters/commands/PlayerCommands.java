package com.thedemgel.extremecharacters.commands;

import com.thedemgel.extremecharacters.ECharacters;
import com.thedemgel.extremecharacters.components.ComponentComponent;
import com.thedemgel.extremecharacters.components.StatComponent;
import com.thedemgel.extremecharacters.components.abilities.TimedHealAbility;
import com.thedemgel.extremecharacters.components.effects.TimedHealEffect;
import com.thedemgel.extremecharacters.data.ECharacterData;
import org.spout.api.command.CommandContext;
import org.spout.api.command.CommandSource;
import org.spout.api.command.annotated.Command;
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

	@Command(aliases = "stats", usage = "", desc = "Lists players stats.", min = 0, max = 0)
	public void stats(CommandContext args, CommandSource source) throws CommandException {
		Player player = (Player) source;

		StatComponent comp = player.get(StatComponent.class);

		player.sendMessage("STR: ", comp.getStat(ECharacterData.STAT_STRENGTH));
		player.sendMessage("DEX: ", comp.getStat(ECharacterData.STAT_DEXTERITY));
		player.sendMessage("BOD: ", comp.getStat(ECharacterData.STAT_BODY));
		player.sendMessage("INT: ", comp.getStat(ECharacterData.STAT_INTELLIGENCE));
		player.sendMessage("WIS: ", comp.getStat(ECharacterData.STAT_WISDOM));
		player.sendMessage("CHA: ", comp.getStat(ECharacterData.STAT_CHARISMA));
	}

	@Command(aliases = "addstat", usage = "[stat]", desc = "Add to a players stats.", min = 1, max = 1)
	public void addStat(CommandContext args, CommandSource source) throws CommandException {
		Player player = (Player) source;

		StatComponent comp = player.get(StatComponent.class);

		comp.setStat(ECharacterData.STAT_BODY, comp.getStat(ECharacterData.STAT_BODY) + 1);
	}

	@Command(aliases = "test", usage = "", desc = "Test effect", min = 0, max = 0)
	public void test(CommandContext args, CommandSource source) throws CommandException {
		Player player = (Player) source;
		player.add(TimedHealAbility.class).execute();
	}

	@Command(aliases = "pause", usage = "", desc = "Test effect", min = 0, max = 0)
	public void pause(CommandContext args, CommandSource source) throws CommandException {
		Player player = (Player) source;
		player.get(TimedHealEffect.class).pause();
	}

	@Command(aliases = "remove", usage = "", desc = "Test effect", min = 0, max = 0)
	public void remove(CommandContext args, CommandSource source) throws CommandException {
		Player player = (Player) source;
		player.get(ComponentComponent.class).remove(TimedHealEffect.class);
	}
}
