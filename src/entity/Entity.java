package entity;

import java.awt.image.BufferedImage;

//Parent class for the player
public class Entity {

	
	public int x, y;
	public int speed;
	
	public BufferedImage idle1, idle2, down1,down2,down3,down4,down5,down6,down7,down8,up1,up2,up3, left1, left2,right1,right2;
	public String direction;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
}
