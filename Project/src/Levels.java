import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Levels {
	
	public static void SaveMap(String mapName, Map grid) {
		String mapData = "";
		for (int i = 0; i < grid.getTilesWide(); i++) {
			for (int j = 0; j < grid.getTilesHigh(); j++) {
				mapData += getTileID(grid.getTile(i, j));
			}
		}
		try {
			File file = new File(mapName);
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(mapData);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Map LoadMap(String mapName) {
		Map grid = new Map();
		try {
			BufferedReader br = new BufferedReader(new FileReader(mapName));
			String data = br.readLine();
			for (int i = 0; i < grid.getTilesWide(); i++) {
				for (int j = 0; j < grid.getTilesHigh(); j++) {
					grid.setTile(i, j, getTileType(data.substring(i * grid.getTilesHigh() + j, i * grid.getTilesHigh() + j + 1)));
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return grid;
	}
	
	public static TileType getTileType(String ID) {
		TileType type = TileType.NULL;
		switch (ID) {
		case "0":
			type = TileType.Snow;
			break;
		case "1":
			type = TileType.Path;
			break;
		case "2":
			type = TileType.Ice;
			break;
		case "3":	
			type = TileType.Tree;
			break;
		case "4":	
			type = TileType.Snowman;
			break;	
		case "5":
			type = TileType.NULL;
			break;
		}
		return type;
	}
	
	public static String getTileID(Tile t) {
		String ID = "E";
		switch (t.getType()) {
		case Snow:
			ID = "0";
			break;
		case Path:
			ID = "1";
			break;
		case Ice:
			ID = "2";
			break;
		case Tree:
			ID = "3";
			break;
		case Snowman:
			ID = "4";
			break;	
		case NULL:
			ID = "5";
			break;
		}
		return ID;
	}

}

