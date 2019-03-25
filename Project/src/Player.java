import java.util.ArrayList;
import java.util.Scanner;

import org.lwjgl.input.Mouse;

public class Player {
	
	private Map grid;
	private boolean leftClick, holdingTower;
	private ArrayList<Tower> towerList;
	private Tower tTower;
	private WaveManager waveManager;
	
	
	public Player(Map grid, WaveManager waveManager) {
		this.grid = grid;
		this.leftClick = false;
		this.towerList = new ArrayList<Tower>();
		this.holdingTower = false;
		this.tTower = null;
		this.waveManager = waveManager;
		
	}
	
	/*
	public void SetTile(int x, int y) {
		if (grid.GetTile(x, y).getType() == TileType.Buildable) {
			grid.SetTile(x, y, TileType.Tower);
		}
		else {
			System.out.println("You cannot build here because this tile is not buildable.");
			Update();
		}
		
		
	}*/
	
	
	
	public void Update()
    {
		//Update Holding Tower
		if(holdingTower)
		{
			tTower.setX(getMouseTile().getX());
			tTower.setY(getMouseTile().getY());
			tTower.draw();
		}
		
		for (Tower t : towerList)
		{
			t.update();
			t.updateList(waveManager.getCurrentWave().getEnemyList());
			t.draw();
		}
		/*
        System.out.print("Where do you want to build a tower? (Input x value, then y value.)");
        int x = keyboard.nextInt();
        int y = keyboard.nextInt();
        if (x < 10 && x > -1 && y < 10 && y > -1)
        	SetTile(x, y);
        else {
        	System.out.println("Please enter two integers within the bounds of the grid.");
        	Update();
        }*/
		

		if(Mouse.isButtonDown(0) && !leftClick && grid.GetTile(Mouse.getX() / 64, (Graphics.HEIGHT - Mouse.getY() -1) / 64).getType().canBuild == true)
		{
			placeTower();
		}
	
		leftClick = Mouse.isButtonDown(0);
    }
	
	private void placeTower()
	{
		if(holdingTower)
		{
			towerList.add(tTower);
		}
		holdingTower = false;
		tTower = null;
	}
	
	public void pickTower(Tower t)
	{
		tTower = t;
		holdingTower = true;
	}
	
	private Tile getMouseTile()
	{
		return grid.GetTile(Mouse.getX() / 64, (Graphics.HEIGHT - Mouse.getY() -1) / 64);
	}
    
}
