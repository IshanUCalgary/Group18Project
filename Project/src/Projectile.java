import org.newdawn.slick.opengl.Texture;

public class Projectile {

	private Texture texture;
	private float x, y, width, height, speed, xVelocity, yVelocity;
	private int damage;
	private Enemy target;
	private boolean alive;
	
	public Projectile(ProjectileType type, Enemy target, float x, float y, float width, float height)
	{
		this.texture = type.texture;
		this.x = x;
		this.y = y;
		//this.speed = speed;
		this.speed = type.speed;
		//this.damage = damage;
		this.damage = type.damage;
		this.target = target;
		this.alive = true;
		this.xVelocity = 0f;
		this.yVelocity = 0f;
		if(target != null)
			calculateDirection();
	}
	
	//Deal damage to Enemy
	public void damage() {
		target.hit(damage);
		alive = false;
	}
	
	private void calculateDirection()
	{
		float tAllowedMovement = 1.0f;
		float xDfromTarget = Math.abs(target.getX() - x - Game.TILE_SIZE / 4 + Game.TILE_SIZE / 2);
		float yDfromTarget = Math.abs(target.getY() - y - Game.TILE_SIZE / 4 + Game.TILE_SIZE / 2);
		float totalDfromTarget = xDfromTarget + yDfromTarget;
		float xPercentMove = xDfromTarget / totalDfromTarget;
		this.xVelocity = xPercentMove;
		this.yVelocity = tAllowedMovement - xPercentMove;
		if(target.getX() < this.x)
		{
			xVelocity *= -1;
		}
		if(target.getY() < this.y)
		{
			yVelocity *= -1;
		}
	}
	public void update()
	{
		if(alive)
		{	
			x += xVelocity * speed * Time.Delta();
			y += yVelocity * speed * Time.Delta();
			if(target != null)
			{
				if(Graphics.CheckCollision(x, y, width, height, target.getX(), target.getY(), target.getWidth(), target.getHeight()))
				{
					target.hit(damage);
					alive = false;
				}
			}	
			draw();
		}	
	}
	
	public void draw()
	{
		Graphics.DrawQuadTex(texture, x, y, 32, 32);
	}
	
}
