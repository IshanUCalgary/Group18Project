
import org.newdawn.slick.opengl.Texture;

public enum ProjectileType {

	
	sProjectile(Graphics.QuickLoad("sProjectile"), 10, 500),
	haskProjectile(Graphics.QuickLoad("haskProjectile"), 6,450);
	
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
