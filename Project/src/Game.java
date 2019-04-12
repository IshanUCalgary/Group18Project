import java.awt.Font;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;

public class Game {

	private Map grid;
	private Player player;
	private Enemy e;
	private WaveManager wave;
	private UI pickTower;
	public static final int TILE_SIZE = 64;
	private TrueTypeFont font;
	private Font awtFont;
	private Texture selectorBackground;
	private Texture Label;
	//private ScienceTower tower;
	
	public Game(Map map)
	{
		this.grid = map;
		e = new Enemy(Graphics.QuickLoad("enemy"), grid.getTile(0, 2), grid, 64, 64, 90, 150);
		selectorBackground = Graphics.QuickLoad("selectorBackground");
		//Label = Graphics.QuickLoad("Label");
		wave = new WaveManager(e, 1, 5);
		player = new Player(grid, wave);
		player.setup();
		setupUI();
		//tower = new ScienceTower(Graphics.QuickLoad("cannonBase"), grid.GetTile(3, 3), 10);
		awtFont = new Font("Verdana", Font.BOLD | Font.ITALIC, 30);
		font = new TrueTypeFont(awtFont, false);
	}
	
	public void drawString(float x, float y, String text, Color c) {
		font.drawString(x, y, text, c);
	}
	
	//Change
	private void setupUI()
	{
		pickTower = new UI();
		//pickTower.addButton("SchulichTower", "sTower", 0, 0);
		pickTower.createMenu("TowerPicker", 1360, 0, 0, 0);
		pickTower.getMenu("TowerPicker").addButton("ScienceTower", "sTowerIcon", 1375, 142);
		pickTower.getMenu("TowerPicker").addButton("EngTower", "engTowerIcon", 1375, 362);
		pickTower.getMenu("TowerPicker").addButton("HaskTower", "haskTowerIcon", 1375, 582);
	}
	
	private void updateUI()
	{
		pickTower.draw();
		//Graphics.DrawQuadTex(Label, 1310, 275, 448, 64);
		pickTower.drawString(620, 10, "Wave " + wave.getWaveNumber(), Color.black, "font1");
		pickTower.drawString(1300, 810, String.valueOf("Lives: " + player.getLives()), Color.red, "font1");
		pickTower.drawString(1300, 880, String.valueOf("Cash: " + player.getCash()), Color.green, "font1");
		pickTower.drawString(1330, 290,"Science  Tower, $50", Color.white, "font");
		pickTower.drawString(1330, 510,"Schulich Tower, $35", Color.white, "font");
		pickTower.drawString(1320, 730,"Haskayne Tower, $20", Color.white, "font");
		//System.out.println("This is the size " + wave.getCurrentWave().getEnemyList().size());
		
		if(Mouse.next())
		{
			boolean mouseClicked = Mouse.isButtonDown(0);
			if(mouseClicked)
			{	
				if(pickTower.getMenu("TowerPicker").isButtonClicked("ScienceTower"))
				{
					if (player.getCash() >= 50) {
						player.pickTower(new ScienceTower(TowerType.sTower, grid.getTile(0, 0), 1000, wave.getCurrentWave().getEnemyList()));

					}
				} else if(pickTower.getMenu("TowerPicker").isButtonClicked("EngTower")) {
					if (player.getCash() >= 35) {
						player.pickTower(new SchulichTower(TowerType.schulichTower, grid.getTile(0, 0), 1000,wave.getCurrentWave().getEnemyList()));

					}
				}
				else if(pickTower.getMenu("TowerPicker").isButtonClicked("HaskTower"))
				{
					if (player.getCash() >= 20)
					player.pickTower(new HaskyaneTower(TowerType.haskTower, grid.getTile(0, 0),1000,wave.getCurrentWave().getEnemyList()));
				}
			}	
		}
	}
	
	public void update()
	{
		Graphics.DrawQuadTex(selectorBackground, 1280, 0, 520, 1025);
		grid.Draw();
		player.Update();
		Time.Update();
		wave.update();
		updateUI();
		//tower.draw();
		
	}
	
	
}
