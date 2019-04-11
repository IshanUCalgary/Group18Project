import java.awt.Font;
import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

public class UI {

	private ArrayList<Button> buttonList;
	private ArrayList<Menu> menuList;
	private TrueTypeFont font;
	private Font awtFont;
	private TrueTypeFont font1;
	private Font awtFont1;
	
	public UI()
	{
		buttonList = new ArrayList<Button>();
		menuList = new ArrayList<Menu>();
		awtFont = new Font("Verdana", Font.BOLD | Font.ITALIC, 20);
		font = new TrueTypeFont(awtFont, false);
		awtFont1 = new Font("Verdana", Font.BOLD | Font.ITALIC, 30);
		font1 = new TrueTypeFont(awtFont1, false);
	}
	
	public void drawString(float x, float y, String text, Color c, String fontStyle) {
		if (fontStyle.equals("font")) {
			font.drawString(x, y, text, c); 
			}
		if (fontStyle.equals("font1")) {
			font1.drawString(x, y, text, c); 
			}
	}
	
	public void addButton(String name, String textureName, int x, int y)
	{
		buttonList.add(new Button(name, Graphics.QuickLoad(textureName), x, y));
	}
	
	public boolean isButtonClicked(String buttonName)
	{
		Button b = getButton(buttonName);
		float mouseY = Graphics.HEIGHT - Mouse.getY() -1;
		if(Mouse.getX() > b.getX() && Mouse.getX() < b.getX() + b.getWidth() && mouseY > b.getY() && mouseY < b.getY() + b.getHeight())
		{
			return true;
		}
		return false;
	}
	
	public Button getButton(String buttonName)
	{
		for(Button b: buttonList)
		{
			if(b.getName().equals(buttonName))
			{
				return b;
			}
		}
		return null;
	}
	
	public void createMenu(String name, int x, int y, int oWidth, int oHeight)
	{
		menuList.add(new Menu(name, x, y, oWidth, oHeight));
	}
	
	public Menu getMenu(String name)
	{
		for(Menu m: menuList)
		{
			if(m.getName().equals(name))
			{
				return m;
			}
		}
		return null;
	}
	
	public void draw()
	{
		for(Button b: buttonList)
		{
			Graphics.DrawQuadTex(b.getTexture(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
		}
		for(Menu m: menuList)
		{
			m.draw();
		}
	}
	
	public class Menu{
		private ArrayList<Button> buttonsInMenu;
		private int x, y, buttonAmount, oWidth, oHeight;
		String name;
		
		public Menu(String name, int x, int y, int oWidth, int oHeight)
		{
			this.name = name;
			this.x = x;
			this.y = y;
			this.buttonAmount = 0;
			this.buttonsInMenu = new ArrayList<Button>();
			this.oWidth = oWidth;
			this.oHeight = oHeight;
		}
		
		public void addButton(String name, String textureName, int x, int y)
		{
			buttonsInMenu.add(new Button(name, Graphics.QuickLoad(textureName), x, y));
		}
		
		public boolean isButtonClicked(String buttonName)
		{
			Button b = getButton(buttonName);
			float mouseY = Graphics.HEIGHT - Mouse.getY() -1;
			if(Mouse.getX() > b.getX() && Mouse.getX() < b.getX() + b.getWidth() && mouseY > b.getY() && mouseY < b.getY() + b.getHeight())
			{
				return true;
			}
			return false;
		}
		
		public Button getButton(String buttonName)
		{
			for(Button b: buttonsInMenu)
			{
				if(b.getName().equals(buttonName))
				{
					return b;
				}
			}
			return null;
		}
		
		public void draw()
		{ 
			for(Button b : buttonsInMenu)
			{
				Graphics.DrawQuadTex(b.getTexture(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
			}
		}
		
		public String getName()
		{
			return this.name;
		}
	}
	
}
