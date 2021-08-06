package particlePlayer;

import org.bukkit.scheduler.BukkitTask;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerCore extends JavaPlugin
{
	private final ParticleRunner pRunner = new ParticleRunner();
	
	@Override
	public void onEnable()
	{
		getLogger().info("Setting ParticlePlayer....");
		//this.getCommand("ppPlay").setExecutor(new PlayerCommnds(this,pRunner));
		//this.getCommand("ppStop").setExecutor(new PlayerCommnds(this,pRunner));
		this.getCommand("ppPlay").setExecutor(new PlayerCommnds(pRunner));
		this.getCommand("ppStop").setExecutor(new PlayerCommnds(pRunner));

		BukkitTask playTask = pRunner.runTaskTimer(this, 0L, 10L);
	}
	
	@Override
	public void onDisable()
	{
		getLogger().info("Shuting down ParticlePlayer....");		
	}
	

	
}
