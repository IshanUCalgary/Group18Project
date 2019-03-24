import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;



public class Enemy {
	
	private Texture texture, healthBackground, healthForeground, healthBorder;

	private Tile startTile;
	private int width, height, currentCorner;
	private float speed, x, y, health, startHealth;
	private Map grid;
	private boolean first = true;	// for performance issues when game starts
	private ArrayList<CornerCheck> corners;
	private int[] directions;
	
	
	public Enemy (Texture texture, Tile startTile, Map grid, int width, int height, float speed, float health) {
		this.texture = texture;
		this.healthBackground = Graphics.QuickLoad("HealthBackground");
		this.healthForeground = Graphics.QuickLoad("HealthForeground");
		this.healthBorder = Graphics.QuickLoad("HealthBorder");
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.health = health;
		this.startHealth = health;
		this.grid = grid;
		this.corners = new ArrayList<CornerCheck>();
		this.directions = new int[2];
		// x direction
		this.directions[0] = 0;
		// y direction
		this.directions[1] = 0;
		directions = FindNextDirection(startTile);
		this.currentCorner = 0;
		PopulateCornerList();
	}
	
	
	// draws an enemy at a location with given width and height
	public void DrawEnemy() {
		float healthPercentage = this.health / this.startHealth;
		Graphics.DrawQuadTex(texture, x, y, width, height);
		Graphics.DrawQuadTex(healthBackground, x, y - 16, width, 8);
		Graphics.DrawQuadTex(healthForeground, x, y - 16, 64 * healthPercentage, 8);
		Graphics.DrawQuadTex(healthBorder, x, y - 16, width, 8);
		
	}


	public void Update() {
		// need to check first iteration so that the program actually runs
		if (first) {
			first = false;
		}
		else {
			if (CornerReached()) {
				if (currentCorner + 1 == corners.size())
					System.out.println("Enemy cannot go further");
				else 
					currentCorner++;
			} else 
				x += Time.Delta() * corners.get(currentCorner).getXDirection() * speed;
				y += Time.Delta() * corners.get(currentCorner).getYDirection() * speed;
				
		}
	}
	
	
	
	// identifies if the enemy has moved to a corner
	private boolean CornerReached() {
		boolean reached = false;
		Tile tile = corners.get(currentCorner).getTile();
		// check if position reached by enemy on cornerTile is within a variance of an arbitrary number so that it won't go over
		if (x > tile.getX() - 4 && x < tile.getX() + 4 && y > tile.getY() - 4 && y < tile.getY() + 4) {
			reached = true;
			x = tile.getX();
			y = tile.getY();
		}
		return reached;	
	}
	
	// adds all corners on path to arrayList corners
	private void PopulateCornerList() {
		// adds the next corner, relative to the enemy's position, to the arraylist
		corners.add(FindNextCorner(startTile, directions = FindNextDirection(startTile)));
		int counter = 0;
		boolean cont = true;
		while (cont) {
			int[] currentDirection = FindNextDirection(corners.get(counter).getTile());
			// if a next corner exists, end after 20 checkpoints (arbitrary)
			if (currentDirection[0] == 2 || counter == 20) {
				cont = false;
			} else {
				corners.add(FindNextCorner(corners.get(counter).getTile(), directions = FindNextDirection(corners.get(counter).getTile())));
			}
			counter++;
		}
	}
	
	
	// returns the direction to turn to stay on the path of the enxt corner
	private CornerCheck FindNextCorner(Tile current, int[] dir) {
		Tile next = null;
		CornerCheck corner = null;
		
		// checks if next corner is found
		boolean found = false;
		
		int counter = 1;
		
		while (!found) {			
			// if the current tile's type != the tile on the grid next to it that's being checked's type, a corner is found
			if (current.getType() != grid.GetTile(current.getXPlace() + dir[0] * counter, current.getYPlace() + dir[1] * counter).getType()) {
				found = true;
				// Moves counter back 1 to find the tile before the new tiletype
				counter -= 1;
				next = grid.GetTile(current.getXPlace() + dir[0] * counter, current.getYPlace() + dir[1] * counter);
			}
			counter ++;
		}
		corner = new CornerCheck(next, dir[0], dir[1]);
		return corner;
	}
	
	
	
	
	// Tile current is the tile the enemy is currently at, returns an array of integers that tell us what direction to go next
	private int[] FindNextDirection(Tile current) {
		int[] dir = new int[2]; // dir[0] indicates x, dir[1] indicates y
		Tile up    = grid.GetTile(current.getXPlace(),     current.getYPlace() - 1);
		Tile right = grid.GetTile(current.getXPlace() + 1, current.getYPlace());
		Tile down  = grid.GetTile(current.getXPlace(),     current.getYPlace() + 1);
		Tile left  = grid.GetTile(current.getXPlace() - 1, current.getYPlace());
		
		
		if (current.getType() == up.getType() && directions[1] != 1) {
			dir[0] = 0;  
			dir[1] = -1;
		} else if (current.getType() == right.getType() && directions[0] != -1) {
			dir[0] = 1;
			dir[1] = 0;
		} else if (current.getType() == down.getType() && directions[1] != -1) {
			dir[0] = 0;
			dir[1] = 1;
		} else if (current.getType() == left.getType() && directions[0] != 1) {
			dir[0] = -1;
			dir[1] = 0;
		} else {
			dir[0] = 2;
			dir[1] = 2;
			System.out.println("NO DIRECTION FOUND");
		}
		
		return dir;
	}
	
	
	
	
	
	
	
	
	// setters and getters

	public Texture getTexture() {
		return texture;
	}



	public void setTexture(Texture texture) {
		this.texture = texture;
	}



	public Tile getStartTile() {
		return startTile;
	}



	public void setStartTile(Tile startTile) {
		this.startTile = startTile;
	}



	public int getWidth() {
		return width;
	}



	public void setWidth(int width) {
		this.width = width;
	}



	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}



	public float getSpeed() {
		return speed;
	}



	public void setSpeed(float speed) {
		this.speed = speed;
	}



	public float getX() {
		return x;
	}



	public void setX(float x) {
		this.x = x;
	}



	public float getY() {
		return y;
	}



	public void setY(float y) {
		this.y = y;
	}



	public Map getGrid() {
		return grid;
	}



	public void setGrid(Map grid) {
		this.grid = grid;
	}
	
	public float getHealth() {
		return health;
	}
	
	
	public void setHealth(float health) {
		this.health = health;
	}
	
	
	
}
