package net.ulixava.minecraftplatformer;

import java.applet.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Component extends Applet implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static int pixelSize = 2;
	public static int sX = 0, sY = 0;
	
	public static Dimension size = new Dimension(1080, 800);
	public static Dimension pixel = new Dimension(size.width / pixelSize, size.height / pixelSize);
	public static String name = "Bean Craft, Mineral Run by Anthony";
	
	public static boolean isRunning = false;
	
	private Image screen;
	
	public TextOutput textoutput;
	public static Component component;
	public Level level;
	public Character character;
	public Character companion;
	
	public Component() {
		setPreferredSize(size);
	}
	
	public void start() {
		//Defining objects etc.
		new Tile(); //Loading images.
		level = new Level();
		level.generatelevel(1);
		character = new Character(level);
		textoutput = new TextOutput();
		
		//Starting game loop.
		isRunning = true;
		new Thread(this).start();
	}
	
	public void createCompanion() {
		companion = new Companion(level, character);
	}
	
	public void goToLevel(int levelNumber) {
		level.generatelevel(levelNumber);
	}
	
	public void stop() {
		isRunning = false;
	}
	
	public static void main(String args[]) {
		component = new Component();
		
		JFrame frame = new JFrame();
		frame.add(component);
		frame.pack();
		frame.setTitle(name);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("res/anthonycraft.png").getImage());
		frame.setVisible(true);
		
		component.start();
		BeanSound.startBackgroundMusic();
		component.startListeningForKeys(frame);
	}
	
	public void startListeningForKeys(JFrame f) {
		f.addKeyListener(new KeyListener() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            
	        }

	        @Override
	        public void keyPressed(KeyEvent e) {
	            char key = e.getKeyChar();
	            switch (key) {
		            case 'd':
		            	character.moveRight();
		            	break;
		            case 'a':
		            	character.moveLeft();
		            	break;
		            case 's':
		            	character.dig();
		            	break;
		            case 'w':
		            	character.jump();
		            	break;
		            case 'm':
		            	BeanSound.toggleBackgroundMusic();
		            	break;
		            case 'q':
		            	System.exit(0);
		            	break;
	            }
	        }

	        @Override
	        public void keyReleased(KeyEvent e) {
	            character.movementSpeed = 0;
	        }
	    });
	}
	
	public void tick() {
		level.tick();
		character.tick();
		if(companion != null) {
			companion.tick();
		}
		textoutput.tick();
	}
	
	public void render() {
		Graphics g = screen.getGraphics();
		
		//Drawing things.
		g.setColor(new Color(100, 100, 255));
		g.fillRect(0, 0, pixel.width, pixel.height);
		
		level.render(g);
		if(companion != null) {
			companion.render(g);
		}
		character.render(g);
		textoutput.render(g);
		
		g = getGraphics();
		g.drawImage(screen, 0, 0, size.width, size.height, 0, 0, pixel.width, pixel.height, null);
		g.dispose();
	}
	
	public void run() {
		screen = createVolatileImage(pixel.width, pixel.height);
		
		while(isRunning) {
			tick();
			render();
			
			try {
				Thread.sleep(5);
			} catch(Exception e) { }
		}
	}
}
