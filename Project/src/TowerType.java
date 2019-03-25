
import org.newdawn.slick.opengl.Texture;

public enum TowerType {

	sTower(new Texture[]{Graphics.QuickLoad("sTower"), Graphics.QuickLoad("sCannon")}, ProjectileType.sProjectile, 10, 10, 30), 
	schulichTower(new Texture[]{Graphics.QuickLoad("engTower"), Graphics.QuickLoad("engCannon")}, ProjectileType.engProjectile, 20, 10, 30),
	haskTower(new Texture[]{Graphics.QuickLoad("haskTower"), Graphics.QuickLoad("haskCannon")}, ProjectileType.haskProjectile, 10, 10, 30);
	
	Texture[] texture;
	int damage, range;
	float rateOfFire;
	ProjectileType pType;
	
	TowerType(Texture[] texture, ProjectileType pType, int damage, int range, float rateOfFire)
	{
		this.texture = texture;
		this.pType = pType;
		this.damage = damage;
		this.range = range;
		this.rateOfFire = rateOfFire;
	}
}
