import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

public class Game {

	private Map grid;
	private Player player;
	private Enemy e;
	private WaveManager wave;
	private UI pickTower;
	private Texture menuBackground;
	public static final int TILE_SIZE = 64;
	//private ScienceTower tower;
	
	public Game(Map map)
	{
		this.grid = map;
		e = new Enemy(Graphics.QuickLoad("enemy"), grid.getTile(0, 2), grid, 64, 64, 70, 50);
		wave = new WaveManager(e, 0, 5);
		player = new Player(grid, wave);
		player.setup();
		this.menuBackground = Graphics.QuickLoad("selectorBackground");
		setupUI();
		//tower = new ScienceTower(Graphics.QuickLoad("cannonBase"), grid.GetTile(3, 3), 10);
	}
	
	
	
	//Change
	private void setupUI()
	{
		pickTower = new UI();
		//pickTower.addButton("SchulichTower", "sTower", 0, 0);
		pickTower.createMenu("TowerPicker", 1344, 0, 2, 0);
		pickTower.getMenu("TowerPicker").addButton(new Button("ScienceTower", Graphics.QuickLoad("sTower"), 0, 192));
		pickTower.getMenu("TowerPicker").addButton(new Button("EngTower", Graphics.QuickLoad("engTower"), 0, 192));
		pickTower.getMenu("TowerPicker").addButton(new Button("HaskTower", Graphics.QuickLoad("haskTower"), 0, 192));
	}
	
	private void updateUI()
	{
		pickTower.draw();
		//System.out.println("This is the size " + wave.getCurrentWave().getEnemyList().size());
		
		if(Mouse.next())
		{
			boolean mouseClicked = Mouse.isButtonDown(0);
			if(mouseClicked)
			{	
				if(pickTower.getMenu("TowerPicker").isButtonClicked("ScienceTower"))
				{
					player.pickTower(new ScienceTower(TowerType.sTower, grid.getTile(0, 0), 1000, wave.getCurrentWave().getEnemyList()));
				}else if(pickTower.getMenu("TowerPicker").isButtonClicked("EngTower"))
				{
					player.pickTower(new SchulichTower(TowerType.schulichTower, grid.getTile(0, 0), 1000,wave.getCurrentWave().getEnemyList()));
				}
				else if(pickTower.getMenu("TowerPicker").isButtonClicked("HaskTower"))
				{
					player.pickTower(new HaskyaneTower(TowerType.haskTower, grid.getTile(0, 0),1000,wave.getCurrentWave().getEnemyList()));
				}
			}	
		}	
		
	}
	
	public void update()
	{
		if(Player.Lives >= 1)
		{	
			Graphics.DrawQuadTex(menuBackground, 1280, 0, 520, 960);
			grid.Draw();
			player.Update();
			Time.Update();
			wave.update();
			updateUI();
		}else{
			StateManager.gameState = StateManager.GameState.EDITOR;
		}	
		//tower.draw();
		
	}
	
	
}
