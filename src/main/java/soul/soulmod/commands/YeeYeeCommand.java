package soul.soulmod.commands;

import soul.soulmod.ModData;
import herobrinesoul.commands.Command;
import herobrinesoul.commands.Cancellable;

import soul.util.wrapper.LocalPlayerWrapper;

public class YeeYeeCommand implements Command, Cancellable
{
	@Override
	public void cancel()
	{
		ModData.getRoutines().getRoutine("yee").deactivate();
	}

	@Override
	public String getInvocation()
	{
		return "yee";
	}

	@Override
	public void execute(String args)
	{
		ModData.getRoutines().getRoutine("yee").activate();
	}

	@Override
	public String getName()
	{
		return "yee";
	}
}
