import java.util.ArrayList;

public class Wave {

	private float timeSinceLastSpawn, spawnTime;
	private Enemy enemyType;
	private ArrayList<Enemy> enemyList;
	
	
	public Wave(float spawnTime, Enemy enemyType) {
		this.enemyType = enemyType;
		this.spawnTime = spawnTime;
		enemyList = new ArrayList<Enemy>();
	}
	
	
	public void Update() {
		timeSinceLastSpawn += Time.Delta();
		if (timeSinceLastSpawn > spawnTime) {
			// spawns a new enemy
			enemyList.add(new Enemy(enemyType.getTexture(), enemyType.getStartTile(), enemyType.getGrid(), 64, 64, enemyType.getSpeed(),50));
			timeSinceLastSpawn = 0;
		}
		for (Enemy e: enemyList) {
			e.Update();
			e.DrawEnemy();
		}
		
	}
	
	
}
