import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class SchulichTower extends Tower{
	
	public SchulichTower(TowerType type, Tile sTile, int range, CopyOnWriteArrayList<Enemy> e) {
		super(type, sTile, range, e);
	}
	
	
	@Override
	public void shoot(Enemy target)
	{
		super.projectiles.add(new sProjectile(super.type.pType, super.target, super.getX() + Game.TILE_SIZE / 2 - Game.TILE_SIZE / 4, super.getY() + Game.TILE_SIZE / 2 - Game.TILE_SIZE / 4, 32, 32));
		super.target.reduceHiddenHealth(super.type.pType.damage);
	}
	
}
