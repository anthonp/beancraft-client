package net.ulixava.minecraftplatformer;

import java.awt.*;

import javax.swing.ImageIcon;

public class Character extends Rectangle {
	public static int gravity = 1;
	public static ImageIcon icon = new ImageIcon("res/anthonycraft.png");
	
	public int fallingSpeed = 1;
	public int jumpSpeed = 0;
	public int movementSpeed = 0;
	public boolean isWalkingLeft = false;
	public Level level;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Character(Level level) {
		this.level = level;
		setBounds(new Rectangle(0, 0, Tile.tileSize, Tile.tileSize * 2));
	}
	
	public void moveRight() {
		movementSpeed = 4;
	}
	
	public void moveLeft() {
		movementSpeed = -4;
	}
	
	public void dig() {
		Block block = blockUnderMyFeet();
		
		if (block.id == Tile.bedrock) {
			return;
		}

		if (block.id == Tile.diamond) {
			System.out.println("You found a diamond!");
			Component.component.textoutput.showMessage("You found a dimond!", 50);
		}
		
		if (block.id == Tile.barite) {
			System.out.println("You found blue barite!");
			Component.component.textoutput.showMessage("You found blue barite chunks!", 50);
		}
		
		if (block.id == Tile.ruby) {
			System.out.println("You found a ruby!");
			Component.component.textoutput.showMessage("You found a ruby!", 50);
		}
		
		if (block.id == Tile.gold) {
			System.out.println("You found some gold!");
			Component.component.textoutput.showMessage("You found gold chunks!", 50);
		}
		
		if (block.id == Tile.treasure) {
			System.out.println("You found a weapon!");
			Component.component.textoutput.showMessage("You have found the way to get to new levels!", 50);
			Component.component.goToLevel(2);
		}
		
		if (block.id == Tile.iron) {
			System.out.println("You found iron.");
			Component.component.textoutput.showMessage("You have found some iron", 50);
		}
		
		if (block.id == Tile.coal) {
			System.out.println("You found coal.");
			Component.component.textoutput.showMessage("You have found some coal", 50);
		}
		
		if (block.id == Tile.girlspawn) {
			System.out.println("You found a girl.");
			Component.component.textoutput.showMessage("You have found a girl", 50);
			Component.component.createCompanion();
		}
		
		block.id = Tile.air;
	}
	
	public void jump() {
		Block block = blockUnderMyFeet();
		
		if (block.id != Tile.air) {
			jumpSpeed = -15;
			if (jumpSpeed < -30) jumpSpeed = -30;
		}
	}
	
	public Block blockUnderMyFeet() {
		//what block is under my feet?
		int xBlock = (x + Tile.tileSize/2) / Tile.tileSize;
		int yBlock = y / Tile.tileSize + 2;
		
		if (xBlock < 0 || yBlock < 0 || xBlock >= level.block.length || yBlock >= level.block[0].length) {
			return null;
		}
		
		Block block = level.block[xBlock][yBlock];
		
		return block;
	}
	
	public void tick() {
		Block block = blockUnderMyFeet();
		
		// adjust jumpSpeed for gravity
		jumpSpeed += gravity;
		if (jumpSpeed > 0) jumpSpeed = 0;
		
		//is is air?
		if (block == null || block.id == Tile.air) {
			//if it's air, then
			// adjust fallingSpeed for gravity
			fallingSpeed += gravity;
			if (fallingSpeed > 100) fallingSpeed = 100;
		} else {
			fallingSpeed = 0;
		}
		
		y += fallingSpeed;
		x += movementSpeed;
		y += jumpSpeed;
		
		if (fallingSpeed == 0) {
			y = ((int)y/Tile.tileSize)*Tile.tileSize;
		}
		
		if (movementSpeed < 0) {
			isWalkingLeft = true;
		} else if (movementSpeed > 0) {
			isWalkingLeft = false;
		}
	}
	
	public Image getSkin() {
		return Tile.tileset_terrain[Tile.character];
	}
	
	public void render(Graphics g) {
		if (isWalkingLeft) {
			g.drawImage(getSkin(), x + width, y, -width, height, null);
		} else {
			g.drawImage(getSkin(), x, y, width, height, null);
		}
	}
}
