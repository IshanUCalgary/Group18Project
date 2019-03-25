import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

public abstract class Tower implements Default{
	
	private float x, y, timeSinceLastShot, firingSpeed, angle;
	private int width, height, damage, range;
	private Enemy target;
	private ArrayList<Projectile> projectiles;
	private ArrayList<Enemy> enemies;
	private Texture[] textures;
	private boolean targeted;
	
	public Tower(TowerType type, Tile sTile, int range, ArrayList<Enemy> enemies)
	{
		//System.out.println("There is somehint " + (enemies.get(0) != null));
		this.textures = type.texture;
		this.damage = type.damage;
		this.x = sTile.getX();
		this.y = sTile.getY();
		this.range = range;
		this.width = sTile.getWidth();
		this.height = sTile.getHeight();
		this.enemies = enemies;
		this.timeSinceLastShot = 0;
		this.firingSpeed = 3;
		this.targeted = false;
		this.projectiles = new ArrayList<Projectile>();
		//this.target = getTarget();
		//this.angle = calculateAngle();
	}
	
	private Enemy getTarget()
	{
		Enemy closest = null;
		float closestDistance = 10000;
		for(Enemy e : enemies)
		{
			if(isInRange(e) && findDistance(e) < closestDistance)
			{
				closestDistance = findDistance(e);
				closest = e;
			}
		}
		if(closest != null)
		{
			targeted = true;
		}
		return closest;
	}
	
	private boolean isInRange(Enemy e)
	{
		float xDistance = Math.abs(e.getX() - x);
		float yDistance = Math.abs(e.getY() - y);
		if(xDistance < range && yDistance < range)
		{
			return true;
		}
		return false;
	}
	
	private float findDistance(Enemy e)
	{
		float xDistance = Math.abs(e.getX() - x);
		float yDistance = Math.abs(e.getY() - y);
		return xDistance + yDistance;
	}	
	private float calculateAngle()
	{
		double angleTemp = Math.atan2(target.getY() - y, target.getX() - x);
		return (float) Math.toDegrees(angleTemp) - 90;
	}
	
	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return this.x;
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return this.width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return this.height;
	}

	@Override
	public void setX(float x) {
		// TODO Auto-generated method stub
		this.x = x;
		
	}

	@Override
	public void setY(float y) {
		// TODO Auto-generated method stub
		this.y = y;
		
	}

	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub
		this.width = width;
		
	}

	@Override
	public void setHeight(int height) {
		// TODO Auto-generated method stub
		this.height = height;
		
	}
	
	private void shoot()
	{
		timeSinceLastShot = 0;
		projectiles.add(new Projectile(Graphics.QuickLoad("sProjectile"), target, x + Game.TILE_SIZE / 2 - Game.TILE_SIZE / 4, y + Game.TILE_SIZE / 2 - Game.TILE_SIZE / 4, 32,32,900, 10));
	}
	
	public void updateList(ArrayList<Enemy> newList)
	{
		enemies = newList;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(!targeted){
			target = getTarget();
		}else{
			angle = calculateAngle();
			if (timeSinceLastShot > firingSpeed)
			{
				shoot();
			}
		}
		
		if(target == null || target.isAlive() == false)
		{
			targeted = false;
		}
		
		timeSinceLastShot += Time.Delta();
		
		for(Projectile p : projectiles)
		{
			p.update();
		}
			
	}

	@Override
	public void draw() {
		for(int i = 0; i < textures.length; i++)
			if(i % 2 == 0){
				Graphics.DrawQuadTex(textures[i], x, y, width, height);
			}else{
				Graphics.DrawQuadTexRot(textures[i], x, y, width, height, angle);
			}
			
		
	}
	
}
