import org.newdawn.slick.opengl.Texture;

public class Editor {

	private Texture background;
	private Texture win;
	
	public Editor()
	{
		background = Graphics.QuickLoad("endGame");
		win = Graphics.QuickLoad("win");
		// = new UI();
		//menuUI.addButton("Play", "playButton", Graphics.WIDTH / 2 -128, (int) (Graphics.HEIGHT * 0.45f));
		//menuUI.addButton("Editor", "editorButton", Graphics.WIDTH / 2 -128, (int) (Graphics.HEIGHT * 0.55f));
		//menuUI.addButton("Quit", "quitButton", Graphics.WIDTH / 2 -128, (int) (Graphics.HEIGHT * 0.55f));
	}
	
	public void update()
	{
		if(WaveManager.waveNumber >= 11)
			Graphics.DrawQuadTex(win, 0, 0, 2048, 1024);
		else if(Player.Lives <= 0)
			Graphics.DrawQuadTex(background, 0, 0, 2048, 1024);
	}
	
}
