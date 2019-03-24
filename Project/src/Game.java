import org.lwjgl.input.Mouse;

public class Game {

	private Map grid;
	private Player player;
	private Enemy e;
	private Wave wave;
	private UI pickTower;
	//private ScienceTower tower;
	
	public Game(int[][] map)
	{
		grid = new Map(map);
		player = new Player(grid);
		e = new Enemy(Graphics.QuickLoad("enemy"), grid.GetTile(1, 2), grid, 64, 64, 12, 50);
		wave = new Wave(10, e);
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
		
		if(Mouse.next())
		{
			boolean mouseClicked = Mouse.isButtonDown(0);
			if(mouseClicked)
			{	
				if(pickTower.getMenu("TowerPicker").isButtonClicked("ScienceTower"))
				{
					player.pickTower(new ScienceTower(TowerType.sTower, grid.GetTile(0, 0)));
				}else if(pickTower.getMenu("TowerPicker").isButtonClicked("EngTower"))
				{
					player.pickTower(new ScienceTower(TowerType.schulichTower, grid.GetTile(0, 0)));
				}
				else if(pickTower.getMenu("TowerPicker").isButtonClicked("HaskTower"))
				{
					player.pickTower(new ScienceTower(TowerType.haskTower, grid.GetTile(0, 0)));
				}
			}	
		}	
		
	}
	
	public void update()
	{
		Graphics.DrawQuadTex(Graphics.QuickLoad("selectorBackground"), 1280, 0, 520, 960);
		grid.Draw();
		player.Update();
		Time.Update();
		wave.Update();
		updateUI();
		//tower.draw();
		
	}
	
	
}
