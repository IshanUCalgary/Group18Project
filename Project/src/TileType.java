
public enum TileType {
	
	// Name(fileName, canBuild)
	Snow("Snow", true), Path("Path", false), Ice("Ice", false), NULL("Ice",false);
	
	String textureName;
	boolean canBuild;
	
	TileType(String textureName, boolean canBuild){
		this.textureName = textureName;
		this.canBuild = canBuild;
	}
}
