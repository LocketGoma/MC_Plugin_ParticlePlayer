package particlePlayer;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

//��ǻ� �갡 �ٽ�...?
//�ؾ��ϴ°� (�켱���� ��)
//1. ���Ǳ� ���Ͽ��� ����Ʈ �����صα�
//2. �κ��丮�� Ư�� ������ �ִ��� üũ�ϰ� �����Ű��
//3. ����Ʈ�� ��� ����

public class ParticleRunner extends BukkitRunnable {
	private Player pPlayer = null;
	private boolean bPlayState = false;
	
	private EParticleStyle eParticleStyle = EParticleStyle.Test;
	private Particle pParticle = Particle.CAMPFIRE_COSY_SMOKE;
		
	private ParticlePackData[] enablePackData;
	
	public ParticleRunner(Player pPlayer)
	{
		this.pPlayer = pPlayer;
	}
	
	public ParticleRunner() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (pPlayer != null)
			PlayParticle();	
	}
	
	public void SetPlayer(Player pPlayer)
	{
		this.pPlayer = pPlayer;
	}
	
	public void PlayParticle()
	{
		if (bPlayState == true )
		{
			//pPlayer.performCommand("particle minecraft:explosion ~ ~ ~ 0.1 0.1 0.1 1 1000");
			
			//PlayWing(ParticleTypeTranslator("ash"));
			//PlayBasic(pParticle);
			//PlayTest(pParticle);
			//Location loc = pPlayer.getLocation();
			//loc.getWorld().spawnParticle(Particle.ASH,loc,1);
		 //pPlayer.playEffect(pPlayer.getLocation(), Effect.FIREWORK_SHOOT, 1);          
			PlayParticleSelector();
			
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
	
	

	
	//��ƼŬ ���
	public enum EParticleStyle
	{
		Test, Basic, AngelRing, Wing, FootSteb, MAX 
	}
	
	private EParticleStyle ParticleStyleTranslator(String input)
	{
		input.toLowerCase();
		switch(input)
		{
		case "test" :
			return EParticleStyle.Test;
		case "basic" :
			return EParticleStyle.Basic;
		case "angelring" :
			return EParticleStyle.AngelRing;
		case "wing" :
			return EParticleStyle.Wing;
		case "footsteb" :
			return EParticleStyle.FootSteb;	
		default :
			return EParticleStyle.Test;
		}
	}	
	public void SetParticleStyle(String input)
	{
		eParticleStyle = ParticleStyleTranslator(input);
	}
	public Boolean SetParticleType(String input)
	{
		pParticle = ParticleTypeTranslator(input);
		if (null == pParticle)
			return false;
		else
			return true;
	}
	
	//��ƼŬ Ÿ��
	private Particle ParticleTypeTranslator(String input)
	{
		input.toLowerCase();
		
		switch(input)
		{
		case "ash" :
		return Particle.ASH;
		case "cloud" :
		return Particle.CLOUD;
		case "dragon" :
		return Particle.DRAGON_BREATH;
		default :
		return null;
		}		
	}
	
	
	//��ƼŬ �÷��̾�
	private void PlayParticleSelector()
	{
		switch(eParticleStyle)
		{
		case AngelRing:			
			break;
		case Basic:
			PlayBasic(pParticle);
			break;
		case FootSteb:
			break;
		case Test:
			PlayTest(pParticle);
			break;
		case Wing:
			PlayWing(pParticle);
			break;
		default:
			SetPlayState(false);
			break;
		
		}
	}
	
	private void PlayWing(Particle pParticle)
	{
		Location loc = pPlayer.getLocation();
		loc.setY(loc.getY()+2);
		Vector backDir = pPlayer.getLocation().getDirection().normalize().multiply(-1);
		loc.add(pPlayer.getLocation().getDirection().normalize().multiply(-1));
		
		float yaw = loc.getYaw();
		
		//Y�� ����
		pPlayer.getWorld().spawnParticle(pParticle,loc, 10);	//�߽�
		//pPlayer.getWorld().spawnParticle(pParticle, new Location(pPlayer.getWorld(),loc.getX(),loc.getY(),loc.getZ()).add(backDir), 10);	//�߽�		
		
		//���� ����
		//pPlayer.getWorld().spawnParticle(pParticle,new Location(pPlayer.getWorld(),loc.getX()-0.5,loc.getY()+0.3,loc.getZ()).add(backDir),50,0.1,0.1,0.1,0.1);
		//pPlayer.getWorld().spawnParticle(pParticle,new Location(pPlayer.getWorld(),loc.getX()-1.0,loc.getY()+0.5,loc.getZ()).add(backDir),50,0.1,0.1,0.1,0.1);
		//pPlayer.getWorld().spawnParticle(pParticle,new Location(pPlayer.getWorld(),loc.getX()-1.5,loc.getY()+1.5,loc.getZ()).add(backDir),50,0.1,0.1,0.1,0.1);
		//pPlayer.getWorld().spawnParticle(pParticle,new Location(pPlayer.getWorld(),loc.getX()-2.0,loc.getY()+1.2,loc.getZ()).add(backDir),50,0.1,0.1,0.1,0.1);
		//pPlayer.getWorld().spawnParticle(pParticle,new Location(pPlayer.getWorld(),loc.getX()-2.5,loc.getY()+1.0,loc.getZ()).add(backDir),50,0.1,0.1,0.1,0.1);
		
		//���� ����
		//pPlayer.getWorld().spawnParticle(pParticle,new Location(pPlayer.getWorld(),loc.getX()+0.5,loc.getY()+0.3,loc.getZ()).add(backDir),50,0.1,0.1,0.1,0.1);
		//pPlayer.getWorld().spawnParticle(pParticle,new Location(pPlayer.getWorld(),loc.getX()+1.0,loc.getY()+0.5,loc.getZ()).add(backDir),50,0.1,0.1,0.1,0.1);
		//pPlayer.getWorld().spawnParticle(pParticle,new Location(pPlayer.getWorld(),loc.getX()+1.5,loc.getY()+1.5,loc.getZ()).add(backDir),50,0.1,0.1,0.1,0.1);
		//pPlayer.getWorld().spawnParticle(pParticle,new Location(pPlayer.getWorld(),loc.getX()+2.0,loc.getY()+1.2,loc.getZ()).add(backDir),50,0.1,0.1,0.1,0.1);
		//pPlayer.getWorld().spawnParticle(pParticle,new Location(pPlayer.getWorld(),loc.getX()+2.5,loc.getY()+1.0,loc.getZ()).add(backDir),50,0.1,0.1,0.1,0.1);
		
		
		//���� ����
		pPlayer.getWorld().spawnParticle(pParticle,new Location(pPlayer.getWorld(),Math.cos(Math.toRadians(yaw))*(loc.getX()-0.5)- Math.sin(Math.toRadians(yaw))*(loc.getZ()), loc.getY()+0.1, Math.sin(Math.toRadians(yaw))*(loc.getX()-0.5)+Math.cos(Math.toRadians(yaw))*(loc.getZ())).add(backDir), 50);
		pPlayer.getWorld().spawnParticle(pParticle, new Location(pPlayer.getWorld(),Math.cos(Math.toRadians(yaw))*(loc.getX()-1.0)- Math.sin(Math.toRadians(yaw))*(loc.getZ()), loc.getY()+0.3, Math.sin(Math.toRadians(yaw))*(loc.getX()-1.0)+Math.cos(Math.toRadians(yaw))*(loc.getZ())).add(backDir), 50);
		pPlayer.getWorld().spawnParticle(pParticle, new Location(pPlayer.getWorld(),Math.cos(Math.toRadians(yaw))*(loc.getX()-1.5)- Math.sin(Math.toRadians(yaw))*(loc.getZ()), loc.getY()+0.5, Math.sin(Math.toRadians(yaw))*(loc.getX()-1.5)+Math.cos(Math.toRadians(yaw))*(loc.getZ())).add(backDir), 50);
		pPlayer.getWorld().spawnParticle(pParticle, new Location(pPlayer.getWorld(),Math.cos(Math.toRadians(yaw))*(loc.getX()-2.0)- Math.sin(Math.toRadians(yaw))*(loc.getZ()), loc.getY()+0.4, Math.sin(Math.toRadians(yaw))*(loc.getX()-2.0)+Math.cos(Math.toRadians(yaw))*(loc.getZ())).add(backDir), 50);
		pPlayer.getWorld().spawnParticle(pParticle, new Location(pPlayer.getWorld(),Math.cos(Math.toRadians(yaw))*(loc.getX()-2.5)- Math.sin(Math.toRadians(yaw))*(loc.getZ()), loc.getY()+0.3, Math.sin(Math.toRadians(yaw))*(loc.getX()-2.5)+Math.cos(Math.toRadians(yaw))*(loc.getZ())).add(backDir), 50);
		
		//���� ����
		pPlayer.getWorld().spawnParticle(pParticle, new Location(pPlayer.getWorld(),Math.cos(Math.toRadians(yaw))*(loc.getX()+0.5)- Math.sin(Math.toRadians(yaw))*(loc.getZ()), loc.getY()+0.1, Math.sin(Math.toRadians(yaw))*(loc.getX()+0.5)+Math.cos(Math.toRadians(yaw))*(loc.getZ())).add(backDir), 50);
		pPlayer.getWorld().spawnParticle(pParticle, new Location(pPlayer.getWorld(),Math.cos(Math.toRadians(yaw))*(loc.getX()+1.0)- Math.sin(Math.toRadians(yaw))*(loc.getZ()), loc.getY()+0.3, Math.sin(Math.toRadians(yaw))*(loc.getX()+1.0)+Math.cos(Math.toRadians(yaw))*(loc.getZ())).add(backDir), 50);
		pPlayer.getWorld().spawnParticle(pParticle, new Location(pPlayer.getWorld(),Math.cos(Math.toRadians(yaw))*(loc.getX()+1.5)- Math.sin(Math.toRadians(yaw))*(loc.getZ()), loc.getY()+0.5, Math.sin(Math.toRadians(yaw))*(loc.getX()+1.5)+Math.cos(Math.toRadians(yaw))*(loc.getZ())).add(backDir), 50);
		pPlayer.getWorld().spawnParticle(pParticle, new Location(pPlayer.getWorld(),Math.cos(Math.toRadians(yaw))*(loc.getX()+2.0)- Math.sin(Math.toRadians(yaw))*(loc.getZ()), loc.getY()+0.4, Math.sin(Math.toRadians(yaw))*(loc.getX()+2.0)+Math.cos(Math.toRadians(yaw))*(loc.getZ())).add(backDir), 50);
		pPlayer.getWorld().spawnParticle(pParticle, new Location(pPlayer.getWorld(),Math.cos(Math.toRadians(yaw))*(loc.getX()+2.5)- Math.sin(Math.toRadians(yaw))*(loc.getZ()), loc.getY()+0.3, Math.sin(Math.toRadians(yaw))*(loc.getX()+2.5)+Math.cos(Math.toRadians(yaw))*(loc.getZ())).add(backDir), 50);
				
		
	}
	private void PlayBasic(Particle pParticle)
	{
		Location loc = pPlayer.getLocation();
		
		for (int i = 0 ; i < 100 ; ++i)
		{
			double rand = ((Math.random()%100) / 50)-1.0;
			pPlayer.getWorld().spawnParticle(pParticle,loc.getX()+rand,loc.getY()+(rand/2),loc.getZ()+rand,5 );
		}
	}
	private void PlayFootSteb(Particle pParticle)
	{
		
	}
	private void PlayAngelRing(Particle pParticle)
	{
		
	}
	private void PlayTest(Particle pParticle)
	{
		pPlayer.getWorld().spawnParticle(pParticle, pPlayer.getLocation(),1,1,1,1,0);
	}
	
	
}
