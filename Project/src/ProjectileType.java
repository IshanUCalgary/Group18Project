
import org.newdawn.slick.opengl.Texture;

public enum ProjectileType {

	
	sProjectile(Graphics.QuickLoad("sProjectile"), 15, 500),
	engProjectile(Graphics.QuickLoad("engProjectile"), 15, 500),
	haskProjectile(Graphics.QuickLoad("haskProjectile"), 10,600);
	
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
