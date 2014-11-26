package net.ulixava.minecraftplatformer;

import java.awt.*;
import java.util.Random;

public class Level {
	public Block[][] block = new Block[30][20];
	private static Random rand = new Random();
	
	public Level() {
		for(int x=0;x<block.length;x++) {
			for(int y=0;y<block[x].length;y++) {
				block[x][y] = new Block(new Rectangle(x * Tile.tileSize, y * Tile.tileSize, Tile.tileSize, Tile.tileSize), Tile.air);
			}
		}
		
		
	}
	
	public void generatelevel(int levelNumber) {
		for(int x=0;x<block.length;x++) {
			for(int y=0;y<block[x].length;y++) {
				if (y == 7) {
					block[x][y].id = Tile.grass;
				}
				if (y > 7 && y < 11) {
					block[x][y].id = Tile.earth;
				}
				if (y > 10) {
					block[x][y].id = Tile.stone;
				}
				if (y==19) {
					block[x][y].id = Tile.bedrock;
				}
				if (x==3 && y==6) {
					block[x][y].id = Tile.chest;
				}
			}
		}
		for (int i = 0; i < 19; i++) {
			int x = randInt(0, 29);
			int y = randInt(8, 10);
			block[x][y].id = Tile.coal;
		}
		for (int i = 0; i < 20; i++) {
			int x = randInt(0, 29);
			int y = randInt(11, 18);
			block[x][y].id = Tile.iron;
		}
		for (int i = 0; i < 6; i++) {
			int x = randInt(0, 29);
			int y = randInt(11, 18);
			block[x][y].id = Tile.diamond;
	
		}
		for (int i = 0; i < 4; i++) {
			int x = randInt(0, 29);
			int y = randInt(11, 18);
			block[x][y].id = Tile.barite;
	
		}
		for (int i = 0; i < 6; i++) {
			int x = randInt(0, 29);
			int y = randInt(11, 18);
			block[x][y].id = Tile.ruby;
			
		}
		for (int i = 0; i < 8; i++) {
			int x = randInt(0, 29);
			int y = randInt(11, 18);
			block[x][y].id = Tile.gold;
			
		}
		for (int i = 0; i < 1; i++) {
			int x = randInt(0, 29);
			int y = randInt(8, 10);
			block[x][y].id = Tile.treasure;
		}
		if (levelNumber == 1) {
			for (int i = 0; i < 1; i++) {
				int x = randInt(0, 29);
				int y = randInt(8, 10);
				block[x][y].id = Tile.girlspawn;
				
			}
		}
		
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		for(int x=0;x<block.length;x++) {
			for(int y=0;y<block[x].length;y++) {
				block[x][y].render(g);
			}
		}
		// draw character
		
	}
	
	public static int randInt(int min, int max) {
		int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
}
