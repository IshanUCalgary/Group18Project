import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Wave {

	private float timeSinceLastSpawn, spawnTime;
	private Enemy enemyType;
	private CopyOnWriteArrayList<Enemy> enemyList;
	private int enemiesPerWave;
	private boolean waveCompleted;
	
	
	public Wave(Enemy enemyType, float spawnTime, int enemiesPerWave) {
		this.enemyType = enemyType;
		this.spawnTime = spawnTime;
		this.enemiesPerWave = enemiesPerWave;
		this.timeSinceLastSpawn = 0;
		enemyList = new CopyOnWriteArrayList<Enemy>();
		this.waveCompleted = false;
		Spawn();
		//System.out.println("The size of enemyList is " + enemyList.size());
	}
	
	
	public void Update() {
		boolean allEnemiesDead = true;
		//System.out.println("Reaches before 1st if condition");
		
		if(enemyList.size() < enemiesPerWave)
		{	
			//System.out.println("Reaches before 2nd if condition");
			timeSinceLastSpawn += Time.Delta();
			if (timeSinceLastSpawn > spawnTime) {
				// spawns a new enemy
				//System.out.println("Reaches before 3rd if condition");
				//Spawn();
				//System.out.println("The size of enemyList is " + enemyList.size());
				timeSinceLastSpawn = 0;
			}
		}	
		for (Enemy e: enemyList) {
			if(e.isAlive())
			{
				allEnemiesDead = false;
				e.Update();
				e.DrawEnemy();
			}else{
				enemyList.remove(e);
			}
		}
		if(allEnemiesDead)
		{
			waveCompleted = true;
		}
		
	}
	
	private void Spawn() {
		enemyList.add(new Enemy(enemyType.getTexture(), enemyType
				.getStartTile(), enemyType.getGrid(), 64, 64, enemyType
				.getSpeed(), enemyType.getHealth()));

	}
	
	public boolean isCompleted()
	{
		return this.waveCompleted;
	}
	
	public CopyOnWriteArrayList<Enemy> getEnemyList()
	{
		return this.enemyList;
	}
	
	
}
