
public class WaveManager {
	private float timeSinceLastWave, timeBtwEnemies;
	private int enemiesPerWave;
	public static int waveNumber;
	private Enemy enemyType;
	private Wave currentWave;
	
	public WaveManager(Enemy enemyType, float timeBtwEnemies, int enemiesPerWave)
	{
		this.enemyType = enemyType;
		this.enemiesPerWave = enemiesPerWave;
		this.timeBtwEnemies = timeBtwEnemies;
		this.timeSinceLastWave = 0;
		this.waveNumber = 0;
		this.currentWave = null;
		newWave();
	}
	
	public void update()
	{
		if(!currentWave.isCompleted())
		{
			currentWave.Update();
		}else{
			newWave();
		}
	}
	
	private void newWave()
	{
		currentWave = new Wave(enemyType, timeBtwEnemies, enemiesPerWave);
		waveNumber++;
	}
	
	public Wave getCurrentWave()
	{
		return currentWave;
	}
	
	public int getWaveNumber()
	{
		return this.waveNumber;
	}
}
