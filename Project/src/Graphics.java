import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;
import java.io.InputStream;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Graphics {
	
	
	public static final int WIDTH = 1280+64*5, HEIGHT = 960;
	
	public static void BeginSession() {
		Display.setTitle("Group18 Project");
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		// makes enemy have transparent background
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}
	
	/*
	public static void DrawRect(float x, float y, float width, float height) {
		glBegin(GL_QUADS);
		glVertex2f(x, y); //top left corner
		glVertex2f(x + width, y); //top right corner
		glVertex2f(x + width, y + height); //bottom left corner
		glVertex2f(x, y + height); //bottom right corner
		glEnd();
	}*/
	//new Tile(i*64, j*64, 64, 64, TileType.Snow)
	
	public static boolean CheckCollision(float x1, float y1, float width1, float height1, float x2, float y2, float width2, float height2)
	{
		if(x1 + width1 > x2 && x1 < x2 + width2 && y1 + height1 > y2 && y1 < y2 + height2)
		{	
			return true;
		}			
		return false;	
	}
	
	public static void DrawPanelTower(String texTowerName) {
		Texture tex = Graphics.QuickLoad(texTowerName);
		tex.bind();
		//glTranslatef(WIDTH, 0, 0);
		glTranslatef(1280+64*1,64,0);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(1,0);
		glVertex2f(280,0);
		glTexCoord2f(1, 1);
		glVertex2f(280, 64);
		glTexCoord2f(0, 1);
		glVertex2f(0, 64);
		glEnd();
		glLoadIdentity();	
	}
	
	public static void DrawPanelText(float x, float y, String text) {
		
	}
	
	
	public static void DrawQuadTex(Texture tex, float x, float y, float width, float height) {
		tex.bind();
		//translates the x,y position to be treated as 0,0
		glTranslatef(x, y, 0);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(1,0);
		glVertex2f(width,0);
		glTexCoord2f(1, 1);
		glVertex2f(width, height);
		glTexCoord2f(0, 1);
		glVertex2f(0, height);
		glEnd();
		glLoadIdentity();
	}
	
	public static void DrawQuadTexRot(Texture tex, float x, float y, float width, float height, float angle) {
		tex.bind();
		//translates the x,y position to be treated as 0,0
		glTranslatef(x + width/2, y + height/2, 0);
		glRotatef(angle, 0, 0, 1);
		glTranslatef(-width/2, -height/2, 0);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(1,0);
		glVertex2f(width,0);
		glTexCoord2f(1, 1);
		glVertex2f(width, height);
		glTexCoord2f(0, 1);
		glVertex2f(0, height);
		glEnd();
		glLoadIdentity();
	}
	
	public static Texture LoadTexture(String path, String fileType) {
		Texture tex = null;
		InputStream in = ResourceLoader.getResourceAsStream(path);
		try {
			tex = TextureLoader.getTexture(fileType, in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tex;
	}
	
	public static Texture QuickLoad(String name) {
		Texture tex = null;
		tex = LoadTexture(name + ".png", "PNG");
		return tex;
	}
	
	
	
}
