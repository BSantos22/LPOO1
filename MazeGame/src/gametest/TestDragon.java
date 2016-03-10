package gametest;

import static org.junit.Assert.*;
import org.junit.Test;
import gamelogic.*;


public class TestDragon {
	char[][] m1 = {
			{ 'X', 'X', 'X', 'X', 'X' },
			{ 'X', ' ', ' ', ' ', 'S' },
			{ 'X', ' ', 'D', ' ', 'X' }, 
			{ 'X', 'E', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', 'X', 'X' } };
	
	@Test (timeout=1000)
	public void testDragonMoves() { // Check if every direction
		Game game = new Game();
		
		game.maze.board = m1;
		
		game.maze.sword.x = 1;
		game.maze.sword.y = 3;
		
		game.dragon.x = 2;
		game.dragon.y = 2;
		
		boolean move_left = false;
		boolean move_right = false;
		boolean move_down = false;
		boolean move_up = false;
		
		while (!move_left || !move_right || !move_down || !move_up) {
			int tmp_x = game.dragon.x;
			int tmp_y = game.dragon.y;
			
			game.dragon.move(game.maze);
			
			if (game.dragon.x - tmp_x == 1) {
				move_right = true;
			}
			else if (game.dragon.x - tmp_x == -1) {
				move_left = true;
			}
			else if (game.dragon.y - tmp_y == 1) {
				move_down = true;
			}
			else if (game.dragon.y - tmp_y == -1) {
				move_up = true;
			}
		}
	}
	
	@Test
	public void testDragonSleep() {
		Game game = new Game();
		
		game.maze.board = m1;
		game.dragon.x = 2;
		game.dragon.y = 2;
		
		boolean sleep = false;
		boolean wake_up = false;
		
		while (!sleep || !wake_up) {
			if (game.dragon.is_sleeping == 'D') {
				if (game.dragon.mode(game.maze) == 1) {
					game.dragon.fallAsleep(game.maze);
					sleep = true;
				}
			}
			else if (game.dragon.is_sleeping == 'd') {
				if (game.dragon.mode(game.maze) == 0) {
					game.dragon.wakeUp(game.maze);
					wake_up = true;
				}
			}
		}
	}
}