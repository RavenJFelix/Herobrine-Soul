package soul.soulmod;


import soul.util.commands.CommandHandler;
import soul.soulmod.commands.EchoCommand;
import soul.util.collection.NameRegistry;
import soul.util.commands.Command;
import soul.util.collection.Named;

import soul.soulmod.kings.KingRegistry;
import soul.soulmod.routines.RoutineRegistry;
import soul.soulmod.routines.IRoutine;
import soul.soulmod.routines.EchoRoutine;
import soul.soulmod.routines.ListenForKingRoutine;

import java.util.ArrayList;
import java.util.Arrays;
public class ModData
{
	private static CommandHandler commandHandler = new CommandHandler
		(
			new NameRegistry<Command>
			(
				new ArrayList<Named>
				(
				Arrays.asList(new EchoCommand())
				)
			)
		);
	private static KingRegistry kings = new KingRegistry();
	private static ArrayList<IRoutine> rawRoutines = new ArrayList<IRoutine>(
			Arrays.asList(
				new EchoRoutine(),
				new ListenForKingRoutine()
				)
			);
	private static RoutineRegistry routines = new RoutineRegistry(rawRoutines);

	public static KingRegistry getKings()
	{
		return kings;
	}

	public static void setCommandHandler(CommandHandler newCommandHandler)
	{
		commandHandler = newCommandHandler;
	}

	public static CommandHandler getCommandHandler()
	{
		return commandHandler;
	}

	public static RoutineRegistry getRoutines()
	{
		return routines;
	}

}
