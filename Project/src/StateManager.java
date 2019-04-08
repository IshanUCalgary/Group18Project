public class StateManager {

		public static enum GameState{
			MAINMENU, GAME, EDITOR
		}
		
		public static GameState gameState = GameState.MAINMENU;
		public static MainMenu mainMenu;
		public static Game game;
		public static Editor editor;
		
		static int[][] smth = {
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
		
		static Map map = new Map(smth);
		
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
						game = new Game(map);
					}
					game.update();
					break;
				case EDITOR:
					System.out.println("GAME OVER");
					System.exit(0);
					break;
			}
		}
		
		public static void setState(GameState newState)
		{
			gameState = newState;
		}
}

