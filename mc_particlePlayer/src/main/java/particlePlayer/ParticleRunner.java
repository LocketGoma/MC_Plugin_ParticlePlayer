package particlePlayer;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ParticleRunner extends BukkitRunnable {
	private Player pPlayer = null;
	private boolean bPlayState = false;
	
	
	public ParticleRunner(Player pPlayer)
	{
		this.pPlayer = pPlayer;
	}
	
	public ParticleRunner() {
		// TODO Auto-generated constructor stub
	}

	public void SetPlayer(Player pPlayer)
	{
		this.pPlayer = pPlayer;
	}
	
	@SuppressWarnings("deprecation")
	public void PlayParticle()
	{
		if (bPlayState == true )
		{
			//pPlayer.performCommand("particle minecraft:explosion ~ ~ ~ 0.1 0.1 0.1 1 1000");
			
			Location loc = pPlayer.getLocation();
			loc.getWorld().spawnParticle(Particle.ASH,loc,1);
		 //pPlayer.playEffect(pPlayer.getLocation(), Effect.FIREWORK_SHOOT, 1);
		           
			
			
		}
	}
	//https://www.spigotmc.org/threads/particles.313819/
	//https://bukkit.fandom.com/wiki/Plugin_Tutorial_(Eclipse)#Creating_plugin.yml
	//https://bukkit.org/threads/creating-a-helix-3d-spiral-out-of-particles.314312/
	//https://www.spigotmc.org/threads/make-command-output-not-visible-in-console.404927/
	//https://www.spigotmc.org/threads/particles.127552/
	public void SetPlayState(boolean state)
	{
		bPlayState = state;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (pPlayer != null)
			PlayParticle();	
	}
	
}
