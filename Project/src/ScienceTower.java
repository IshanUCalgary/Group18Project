import java.util.ArrayList;

public class ScienceTower extends Tower{
	
	public ScienceTower(TowerType type, Tile sTile, int range,ArrayList<Enemy> e) {
		super(type, sTile, range, e);
	}
	
	
	@Override
	public void shoot(Enemy target)
	{
		super.projectiles.add(new sProjectile(super.type.pType, super.target, super.getX() + Game.TILE_SIZE / 2 - Game.TILE_SIZE / 4, super.getY() + Game.TILE_SIZE / 2 - Game.TILE_SIZE / 4, 32, 32));
	}
	
}
