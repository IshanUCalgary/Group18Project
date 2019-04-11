import java.io.*;

public class Levels
{
	public static int startTileX;
	public static int startTileY;
	
	public static int[][] LoadMap(String fileName) throws FileNotFoundException
	{	
		int[][] list = new int[20][15];
		try{
			BufferedReader input = new BufferedReader(new FileReader(fileName));
			startTileX = Integer.parseInt(input.readLine());
			startTileY = Integer.parseInt(input.readLine());
			for(int i = 0; i < list.length; i++)
			{
				for(int j = 0; i < list[i].length; i++)
				{
					list[i][j] = Integer.parseInt(input.readLine());
				}
			}
			return list;
		}catch(FileNotFoundException f)
		{
			
		}catch(Exception e)
		{
			
		}
		return list;
	}
}