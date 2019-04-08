
import org.newdawn.slick.opengl.Texture;

public enum TowerType {

	sTower(new Texture[]{Graphics.QuickLoad("sTower"), Graphics.QuickLoad("sCannon")}, ProjectileType.sProjectile, 10, 10, 30, 50), 
	schulichTower(new Texture[]{Graphics.QuickLoad("engTower"), Graphics.QuickLoad("engCannon")}, ProjectileType.engProjectile, 20, 10, 30, 30),
	haskTower(new Texture[]{Graphics.QuickLoad("haskTower"), Graphics.QuickLoad("haskCannon")}, ProjectileType.haskProjectile, 10, 10, 30, 10);
	
	Texture[] texture;
	int damage, range, amount;
	float rateOfFire;
	ProjectileType pType;
	
	TowerType(Texture[] texture, ProjectileType pType, int damage, int range, float rateOfFire, int amount)
	{
		this.texture = texture;
		this.pType = pType;
		this.damage = damage;
		this.range = range;
		this.rateOfFire = rateOfFire;
		this.amount = amount;
	}
}
