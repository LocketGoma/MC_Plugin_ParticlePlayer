package particlePlayer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

public class PlayerCommnds implements CommandExecutor{
	//private final PlayerCore pCore;
	private final ParticleRunner pRunner;
	
	public PlayerCommnds(PlayerCore pCore, ParticleRunner pRunner)
	{
		//this.pCore = pCore;
		this.pRunner = pRunner;
	}
	public PlayerCommnds( ParticleRunner pRunner)
	{
		this.pRunner = pRunner;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		pRunner.SetPlayer((Player) sender);
		if (cmd.getName().equalsIgnoreCase("ppPlay")) { // If the player typed /basic then do the following, note: If you only registered this executor for one command, you don't need this
			// doSomething
			System.out.print("Play Particles");
			if (args.length == 2)
			{
				pRunner.SetPlayState(pRunner.SetParticleType(args[0]));
				pRunner.SetParticleStyle(args[1]);				
			}
			else if (args.length == 0)
			{								
				pRunner.SetPlayState(true);			
			}
			else 
			{
				return false;
			}
			return true;
		}
		else if (cmd.getName().equalsIgnoreCase("ppStop"))
		{
			pRunner.SetPlayState(false);
			return true;
		}
		//If this has happened the function will return true. 
	        // If this hasn't happened the value of false will be returned.
		return false; 
	}

}
