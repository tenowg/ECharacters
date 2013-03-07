package com.thedemgel.extremecharacters.commands;

import com.thedemgel.extremecharacters.ECharacters;
import com.thedemgel.extremecharacters.components.ability.abilities.TimedHealAbility;
import com.thedemgel.extremecharacters.skill.skills.Mining;
import org.spout.api.command.CommandContext;
import org.spout.api.command.CommandSource;
import org.spout.api.command.annotated.Command;
import org.spout.api.entity.Player;
import org.spout.api.exception.CommandException;

/**
 *
 * @author Craig <tenowg at thedemgel.com>
 */
public class AdminCommands {
	private final ECharacters plugin;
	
	public AdminCommands(ECharacters instance) {
		this.plugin = instance;
	}
    
	@Command(aliases = "skilltest", usage = "[Skill name]", desc = "List a skill name", min = 0, max = 1)
	public void test(CommandContext args, CommandSource source) throws CommandException {
		Player player = (Player) source;
		
		player.sendMessage(plugin.getSkills().getSkill(Mining.EXCAVATING).name());
	}
}
