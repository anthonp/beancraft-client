package net.ulixava.minecraftplatformer;

import java.awt.*;

public class Block extends Rectangle {
	private static final long serialVersionUID = 1L;

	public int id = Tile.air;
	
	public Block(Rectangle size, int id) {
		setBounds(size);
		this.id = id;
	}
	
	public void render(Graphics g) {
		if(id != Tile.air) {
			g.drawImage(Tile.tileset_terrain[id], x, y, width, height, null);
		}	 
	}
}
