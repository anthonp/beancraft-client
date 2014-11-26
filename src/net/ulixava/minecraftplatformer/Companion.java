package net.ulixava.minecraftplatformer;

import java.awt.Image;

public class Companion extends Character {
	public Character boyfriend;
	private static final long serialVersionUID = 1L;
	public Companion(Level level, Character boyfriend) {
		super(level);
		this.boyfriend = boyfriend;
	}
	public Image getSkin() {
		return Tile.tileset_terrain[Tile.girl];
	}
	
	public void tick() {
		super.tick();
		if (x < boyfriend.x - 25) {
			x += 2;
			isWalkingLeft = false;
		}
		if (x > boyfriend.x + 25) {
			x -= 2;
			isWalkingLeft = true;
		}
		if (y > boyfriend.y + Tile.tileSize) {
			jump();
		}
	}
	
}
