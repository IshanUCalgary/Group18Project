//Import Statements
import org.lwjgl.opengl.Display;

public class Play {

// Ishan was here
// main constructor	
    public Play(){
    	
    	Graphics.BeginSession();
    	
    	
        
    
        //Game game = new Game(map);
        
        while(!Display.isCloseRequested()) {
        	//game.update();

        	Graphics.DrawPanelTower("Tower1");
        	StateManager.update();
        	Display.update();
			Display.sync(60);
        }
        
        Display.destroy();
    }
    
    
    public static void main(String[] args)
    {
        new Play(); 
    }
    
}



