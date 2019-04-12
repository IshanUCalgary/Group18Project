public class StateManager {

		public static enum GameState{
			MAINMENU, GAME, EDITOR
		}
		
		public static GameState gameState = GameState.MAINMENU;
		public static MainMenu mainMenu;
		public static Game game;
		public static Editor editor;
		
		static int[][] smth1 = {
				{0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
				{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2},
				{2, 2, 2, 2, 2,	2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2},
				{0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
				{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 4, 3},
				{0, 0, 1, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0},
				{0, 0, 1, 0, 2, 0, 3, 2, 2, 0, 0, 0, 2, 2, 0, 0, 2, 0, 0, 0},
				{0, 0, 1, 0, 2, 0, 0, 2, 2, 4, 3, 0, 2, 2, 0, 0, 2, 0, 0, 0},
				{0, 3, 1, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 3},
				{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				{0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
	    };
		
		static Map map1 = new Map(smth1);
		
		public static void update()
		{
			switch(gameState)
			{
				case MAINMENU:
					if(mainMenu == null)
					{
						mainMenu = new MainMenu();
					}
					mainMenu.update();
					break;
				case GAME:
					if(game == null)
					{
						game = new Game(map1);
					}
					game.update();
					break;
				case EDITOR:
					if(editor == null)
					{
						editor = new Editor();
					}
					editor.update();
					break;
			}
		}
		
		public static void setState(GameState newState)
		{
			gameState = newState;
		}
}

