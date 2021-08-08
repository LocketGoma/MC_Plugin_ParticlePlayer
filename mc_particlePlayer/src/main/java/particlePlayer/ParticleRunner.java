package particlePlayer;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

//사실상 얘가 핵심...?
//해야하는것 (우선순위 순)
//1. 컨피그 파일에서 이펙트 저장해두기
//2. 인벤토리에 특정 아이템 있는지 체크하고 재생시키기
//3. 이펙트들 모양 개선

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
	
	

	
	//파티클 모양
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
	
	//파티클 타입
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
	
	
	//파티클 플레이어
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
		
		//Y가 수직
		pPlayer.getWorld().spawnParticle(pParticle,loc, 10);	//중심
		//pPlayer.getWorld().spawnParticle(pParticle, new Location(pPlayer.getWorld(),loc.getX(),loc.getY(),loc.getZ()).add(backDir), 10);	//중심		
		
		//좌측 날개
		//pPlayer.getWorld().spawnParticle(pParticle,new Location(pPlayer.getWorld(),loc.getX()-0.5,loc.getY()+0.3,loc.getZ()).add(backDir),50,0.1,0.1,0.1,0.1);
		//pPlayer.getWorld().spawnParticle(pParticle,new Location(pPlayer.getWorld(),loc.getX()-1.0,loc.getY()+0.5,loc.getZ()).add(backDir),50,0.1,0.1,0.1,0.1);
		//pPlayer.getWorld().spawnParticle(pParticle,new Location(pPlayer.getWorld(),loc.getX()-1.5,loc.getY()+1.5,loc.getZ()).add(backDir),50,0.1,0.1,0.1,0.1);
		//pPlayer.getWorld().spawnParticle(pParticle,new Location(pPlayer.getWorld(),loc.getX()-2.0,loc.getY()+1.2,loc.getZ()).add(backDir),50,0.1,0.1,0.1,0.1);
		//pPlayer.getWorld().spawnParticle(pParticle,new Location(pPlayer.getWorld(),loc.getX()-2.5,loc.getY()+1.0,loc.getZ()).add(backDir),50,0.1,0.1,0.1,0.1);
		
		//우측 날개
		//pPlayer.getWorld().spawnParticle(pParticle,new Location(pPlayer.getWorld(),loc.getX()+0.5,loc.getY()+0.3,loc.getZ()).add(backDir),50,0.1,0.1,0.1,0.1);
		//pPlayer.getWorld().spawnParticle(pParticle,new Location(pPlayer.getWorld(),loc.getX()+1.0,loc.getY()+0.5,loc.getZ()).add(backDir),50,0.1,0.1,0.1,0.1);
		//pPlayer.getWorld().spawnParticle(pParticle,new Location(pPlayer.getWorld(),loc.getX()+1.5,loc.getY()+1.5,loc.getZ()).add(backDir),50,0.1,0.1,0.1,0.1);
		//pPlayer.getWorld().spawnParticle(pParticle,new Location(pPlayer.getWorld(),loc.getX()+2.0,loc.getY()+1.2,loc.getZ()).add(backDir),50,0.1,0.1,0.1,0.1);
		//pPlayer.getWorld().spawnParticle(pParticle,new Location(pPlayer.getWorld(),loc.getX()+2.5,loc.getY()+1.0,loc.getZ()).add(backDir),50,0.1,0.1,0.1,0.1);
		
		
		//좌측 날개
		pPlayer.getWorld().spawnParticle(pParticle,new Location(pPlayer.getWorld(),Math.cos(Math.toRadians(yaw))*(loc.getX()-0.5)- Math.sin(Math.toRadians(yaw))*(loc.getZ()), loc.getY()+0.1, Math.sin(Math.toRadians(yaw))*(loc.getX()-0.5)+Math.cos(Math.toRadians(yaw))*(loc.getZ())).add(backDir), 50);
		pPlayer.getWorld().spawnParticle(pParticle, new Location(pPlayer.getWorld(),Math.cos(Math.toRadians(yaw))*(loc.getX()-1.0)- Math.sin(Math.toRadians(yaw))*(loc.getZ()), loc.getY()+0.3, Math.sin(Math.toRadians(yaw))*(loc.getX()-1.0)+Math.cos(Math.toRadians(yaw))*(loc.getZ())).add(backDir), 50);
		pPlayer.getWorld().spawnParticle(pParticle, new Location(pPlayer.getWorld(),Math.cos(Math.toRadians(yaw))*(loc.getX()-1.5)- Math.sin(Math.toRadians(yaw))*(loc.getZ()), loc.getY()+0.5, Math.sin(Math.toRadians(yaw))*(loc.getX()-1.5)+Math.cos(Math.toRadians(yaw))*(loc.getZ())).add(backDir), 50);
		pPlayer.getWorld().spawnParticle(pParticle, new Location(pPlayer.getWorld(),Math.cos(Math.toRadians(yaw))*(loc.getX()-2.0)- Math.sin(Math.toRadians(yaw))*(loc.getZ()), loc.getY()+0.4, Math.sin(Math.toRadians(yaw))*(loc.getX()-2.0)+Math.cos(Math.toRadians(yaw))*(loc.getZ())).add(backDir), 50);
		pPlayer.getWorld().spawnParticle(pParticle, new Location(pPlayer.getWorld(),Math.cos(Math.toRadians(yaw))*(loc.getX()-2.5)- Math.sin(Math.toRadians(yaw))*(loc.getZ()), loc.getY()+0.3, Math.sin(Math.toRadians(yaw))*(loc.getX()-2.5)+Math.cos(Math.toRadians(yaw))*(loc.getZ())).add(backDir), 50);
		
		//우측 날개
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
