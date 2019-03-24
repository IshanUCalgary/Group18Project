
import org.newdawn.slick.opengl.Texture;

public enum TowerType {

	sTower(new Texture[]{Graphics.QuickLoad("sTower")}, 10, 10), 
	schulichTower(new Texture[]{Graphics.QuickLoad("engTower")}, 20, 10),
	haskTower(new Texture[]{Graphics.QuickLoad("haskTower")}, 10, 10);
	
	Texture[] texture;
	int damage, range;
	
	TowerType(Texture[] texture, int damage, int range)
	{
		this.texture = texture;
		this.damage = damage;
		this.range = range;
	}
}
