import java.util.ArrayList;

public class HaskyaneTower extends Tower{
	
	public HaskyaneTower(TowerType type, Tile sTile, int range,ArrayList<Enemy> e) {
		super(type, sTile, range, e);
	}
	
	/*
	@Override
	public void shoot(Enemy target)
	{
		super.projectiles.add(new haskProjectile(super.type.pType, super.target, super.getX(), super.getY(), 32, 32));
	}*/
	
}
