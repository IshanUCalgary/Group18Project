
import org.newdawn.slick.opengl.Texture;

public enum ProjectileType {

	
	sProjectile(Graphics.QuickLoad("sProjectile"), 50, 200),
	engProjectile(Graphics.QuickLoad("engProjectile"), 30, 210),
	haskProjectile(Graphics.QuickLoad("haskProjectile"), 20,220);
	
	Texture texture;
	int damage;
	float speed;
	
	ProjectileType(Texture texture, int damage, float speed)
	{
		this.texture = texture;
		this.damage = damage;
		this.speed = speed;
	}
}
