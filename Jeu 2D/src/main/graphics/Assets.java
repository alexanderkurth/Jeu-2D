package main.graphics;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage dirt, grass, stone, tree, rock;
	public static BufferedImage[] player_down, player_up, player_left, player_right, player_idle, player_rightAttack, player_leftAttack;
	public static BufferedImage[] zombie_down, zombie_up, zombie_left, zombie_right;
	public static BufferedImage wood;

	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		
		SpriteSheet sheetFace = new SpriteSheet(ImageLoader.loadImage("/textures/LinfFace.png"));
		SpriteSheet sheetDos = new SpriteSheet(ImageLoader.loadImage("/textures/LinkDos.png"));
		SpriteSheet sheetDroite = new SpriteSheet(ImageLoader.loadImage("/textures/LinkDroite.png"));
		SpriteSheet sheetGauche = new SpriteSheet(ImageLoader.loadImage("/textures/LinkGauche.png"));
		
		SpriteSheet idle = new SpriteSheet(ImageLoader.loadImage("/textures/idle.png"));
		
		SpriteSheet attaqueDroite = new SpriteSheet(ImageLoader.loadImage("/textures/attaquedroite.png"));
		SpriteSheet attaqueGauche = new SpriteSheet(ImageLoader.loadImage("/textures/attaquegauche.png"));  
		
		
		wood = sheet.crop(width, height, width, height);
		
		
		player_down = new BufferedImage[8];
		player_up = new BufferedImage[8];
		player_left = new BufferedImage[9];
		player_right = new BufferedImage[9];
		player_idle = new BufferedImage[5];
		player_rightAttack = new BufferedImage[6];
		player_leftAttack = new BufferedImage[6];
		
		player_rightAttack[0] = attaqueDroite.crop(0,0,width, height);
		player_rightAttack[1] = attaqueDroite.crop(width,0,width, height);
		player_rightAttack[2] = attaqueDroite.crop(0,width,width, height);
		player_rightAttack[3] = attaqueDroite.crop(width,height,width, height);
		player_rightAttack[4] = attaqueDroite.crop(0,2*height,width, height);
		player_rightAttack[5] = attaqueDroite.crop(width,2*height,width, height);
		
		player_leftAttack[0] = attaqueGauche.crop(0,0,width, height);
		player_leftAttack[1] = attaqueGauche.crop(width,0,width, height);
		player_leftAttack[2] = attaqueGauche.crop(0,width,width, height);
		player_leftAttack[3] = attaqueGauche.crop(width,height,width, height);
		player_leftAttack[4] = attaqueGauche.crop(0,2*height,width, height);
		player_leftAttack[5] = attaqueGauche.crop(width,2*height,width, height);
		
		
		player_idle[0] = idle.crop(0, 0, width, height);
		player_idle[1] = idle.crop(width, 0, width, height);
		player_idle[2] = idle.crop(0, height, width, height);
		player_idle[3] = idle.crop(height, width, width, height);
		player_idle[4] = idle.crop(0, 0, width, height);

		
		player_down[0] = sheetFace.crop(0, 0, width, height);
		player_down[1] = sheetFace.crop(width, 0, width, height);
		player_down[2] = sheetFace.crop(2*width, 0, width, height);
		player_down[3] = sheetFace.crop(3*width, 0, width, height);
		player_down[4] = sheetFace.crop(0, width, width, height);
		player_down[5] = sheetFace.crop(width, width, width, height);
		player_down[6] = sheetFace.crop(2*width, width, width, height);
		player_down[7] = sheetFace.crop(3*width, width, width, height);
		
		player_up[0] = sheetDos.crop(0, 0, width, height);
		player_up[1] = sheetDos.crop(width, 0, width, height);
		player_up[2] = sheetDos.crop(2*width, 0, width, height);
		player_up[3] = sheetDos.crop(3*width, 0, width, height);
		player_up[4] = sheetDos.crop(0, width, width, height);
		player_up[5] = sheetDos.crop(width, width, width, height);
		player_up[6] = sheetDos.crop(2*width, width, width, height);
		player_up[7] = sheetDos.crop(3*width, width, width, height);
		
		player_right[0] = sheetDroite.crop(0, 0, width, height);
		player_right[1] = sheetDroite.crop(width, 0, width, height);
		player_right[2] = sheetDroite.crop(2*width, 0, width, height);
		player_right[3] = sheetDroite.crop(3*width, 0, width, height);
		player_right[4] = sheetDroite.crop(0, width, width, height);
		player_right[5] = sheetDroite.crop(width, width, width, height);
		player_right[6] = sheetDroite.crop(2*width, width, width, height);
		player_right[7] = sheetDroite.crop(3*width, width, width, height);
		player_right[8] = sheetDroite.crop(0, 2*width, width, height);
		
		player_left[0] = sheetGauche.crop(0, 0, width, height);
		player_left[1] = sheetGauche.crop(width, 0, width, height);
		player_left[2] = sheetGauche.crop(2*width, 0, width, height);
		player_left[3] = sheetGauche.crop(3*width, 0, width, height);
		player_left[4] = sheetGauche.crop(0, width, width, height);
		player_left[5] = sheetGauche.crop(width, width, width, height);
		player_left[6] = sheetGauche.crop(2*width, width, width, height);
		player_left[7] = sheetGauche.crop(3*width, width, width, height);
		player_left[8] = sheetGauche.crop(0, 2*width, width, height);
		
		
		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(width * 2, 0, width, height);
		
		stone = sheet.crop(width, width * 2, width, height);
		
		tree = sheet.crop(0, 0, width, height * 2);
		rock = sheet.crop(0, height * 2, width, height);
	}
	
}