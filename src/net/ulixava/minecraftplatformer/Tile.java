package net.ulixava.minecraftplatformer;

import java.awt.Image;

import javax.imageio.*;

import java.io.*;

public class Tile {
	public static int tileSize = 20;
	
	public static int air = 0;
	public static int earth = 1;
	public static int grass = 2;
	public static int stone = 3;
	public static int diamond = 4;
	public static int iron = 5;
	public static int wood = 6;
	public static int coal = 7;
	public static int treasure = 8;
	public static int chest = 9;
	public static int bedrock = 10;
	public static int girlspawn = 11;
	public static int girl = 12;
	public static int ruby = 13;
	public static int barite = 15;
	public static int character = 14;
	public static int gold = 16;
	
	
	
	public static Image[] tileset_terrain;
	
	public Tile() {
		Tile.tileset_terrain = new Image[17];
		try {
			Tile.tileset_terrain[earth] = ImageIO.read(new File("res/earth_tile.png"));
			Tile.tileset_terrain[grass] = ImageIO.read(new File("res/grass_tile.png"));
			Tile.tileset_terrain[stone] = ImageIO.read(new File("res/stone_tile.png"));
			Tile.tileset_terrain[diamond] = ImageIO.read(new File("res/diamond_tile.png"));
			Tile.tileset_terrain[iron] = ImageIO.read(new File("res/iron_tile.png"));
			Tile.tileset_terrain[wood] = ImageIO.read(new File("res/wood_tile.png"));
			Tile.tileset_terrain[coal] = ImageIO.read(new File("res/coal_tile.png"));
			Tile.tileset_terrain[treasure] = ImageIO.read(new File("res/treasure_tile.png"));
			Tile.tileset_terrain[chest] = ImageIO.read(new File("res/chest_tile.png"));
			Tile.tileset_terrain[character] = ImageIO.read(new File("BeanCharacter/character_default.png"));
			Tile.tileset_terrain[bedrock] = ImageIO.read(new File("res/bedrock_tile.png"));
			Tile.tileset_terrain[girlspawn] = ImageIO.read(new File("res/girlspawn_tile.png"));
			Tile.tileset_terrain[girl] = ImageIO.read(new File("GirlCompanion/girl_default.png"));
			Tile.tileset_terrain[ruby] = ImageIO.read(new File("res/ruby_tile.png"));
			Tile.tileset_terrain[barite] = ImageIO.read(new File("res/bluebarite_tile.png"));
			Tile.tileset_terrain[gold] = ImageIO.read(new File("res/gold_tile.png"));
		} catch(Exception e) { }
	}
}
