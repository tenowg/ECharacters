package com.thedemgel.extremecharacters.commands;

import com.thedemgel.extremecharacters.ECharacters;
import com.thedemgel.extremecharacters.skill.skills.mining.Excavating;
import org.spout.api.command.CommandArguments;
import org.spout.api.command.CommandSource;
import org.spout.api.command.annotated.CommandDescription;
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
    
	@CommandDescription(aliases = "skilltest", usage = "[Skill name]", desc = "List a skill name")
	public void test(CommandSource source, CommandArguments args) throws CommandException {
		Player player = (Player) source;
		
		player.sendMessage(plugin.getSkills().getSkill(Excavating.class).name());
	}
}
