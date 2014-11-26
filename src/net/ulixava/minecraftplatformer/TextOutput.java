package net.ulixava.minecraftplatformer;

import java.awt.Color;
import java.awt.Graphics;

public class TextOutput {
	public String message = "";
	public int numberOfTicks;
	
	public void showMessage(String message, int numberOfTicks) {
		this.message = message;
		this.numberOfTicks = numberOfTicks;
	}
	
	public void tick() {
		if (numberOfTicks > 0) {
			numberOfTicks--;
		} else {
			message = "";
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString(message, 5, 15);
	}
}
