package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.KeyHandler;
import main.MyPanel;

public class Player extends Entity{

	
	MyPanel mp;
	KeyHandler keyH;
	
	boolean currentlyAttacking = false;
	
	
	public Player(MyPanel mp, KeyHandler keyH) {
		this.mp = mp;
		this.keyH = keyH;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	
	public void setDefaultValues() {
		x = 100;
		y = 100;
		speed = 4;
		direction = "none";
	}
	
	
	public void getPlayerImage() {
		try {
			idle1 = ImageIO.read(getClass().getResourceAsStream("/player1/Idle0.png"));
			idle2 = ImageIO.read(getClass().getResourceAsStream("/player1/Idle1.png"));
			
			down1 = ImageIO.read(getClass().getResourceAsStream("/player1/frontRun1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player1/frontRun2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/player1/frontRun3.png"));
			down4 = ImageIO.read(getClass().getResourceAsStream("/player1/frontRun4.png"));
			down5 = ImageIO.read(getClass().getResourceAsStream("/player1/frontRun5.png"));
			down6 = ImageIO.read(getClass().getResourceAsStream("/player1/frontRun6.png"));
			down7 = ImageIO.read(getClass().getResourceAsStream("/player1/frontRun7.png"));
			down8 = ImageIO.read(getClass().getResourceAsStream("/player1/frontRun8.png"));

		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	public void update() {
		
		
		if(keyH.spacePressed && !currentlyAttacking) {
			currentlyAttacking = true;
			spriteCounter = 0;
		
		}
		
		else if((keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) && !currentlyAttacking) {
			if(keyH.upPressed == true){
				direction = "up";
	            y -= speed;
	        }
			if(keyH.downPressed == true){
	        	direction = "down";
	            y += speed;
	        }
			if(keyH.leftPressed == true){
	        	direction = "left";
	            x -= speed;
	        }
			if(keyH.rightPressed == true){
	        	direction = "right";
	            x += speed;
	        }
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	        
	        spriteCounter++;
	        if(spriteCounter > 12) {
	        	if(spriteNum ==1) {
	        		spriteNum = 2;
	        	}
	        	else if(spriteNum ==2) {
	        		spriteNum = 3;
	        	}
	        	else if(spriteNum == 3) {
	        		spriteNum = 1;
	        	}
	        	spriteCounter = 0;
	        }
		}
		
		else if(currentlyAttacking) {
			spriteCounter++;
	        if(spriteCounter > 6) {
	        	if(spriteNum ==1) {
	        		spriteNum = 2;
	        	}
	        	else if(spriteNum ==2) {
	        		spriteNum = 3;
	        	}
	        	else if(spriteNum == 3) {
	        		spriteNum = 4;
	        	}
	        	else if(spriteNum == 4) {
	        		spriteNum = 1;
	        	}
	        	spriteCounter = 0;
	        }
		}
		
		else {
			spriteCounter++;
	        if(spriteCounter > 12) {
	        	if(spriteNum ==1) {
	        		spriteNum = 2;
	        	}
	        	else if(spriteNum ==2) {
	        		spriteNum = 3;
	        	}
	        	else if(spriteNum == 3) {
	        		spriteNum = 1;
	        	}
	        	spriteCounter = 0;
	        }
		}
/////////////////////////////////////////////////////////////////////////////////////////////
		
	}
	
	
	public void draw(Graphics2D g2) {
		BufferedImage image = idle1;
		
		if(!currentlyAttacking) {
			
		
			switch(direction) {
			case "up":
				if(spriteNum == 1) {
					image = up1;
				}
				else if(spriteNum == 2) {
					image = up2;
				}
				else if(spriteNum == 3) {
					image = up3;
				}
				
				break;
				
			case "down":
				if(spriteNum == 1) {
					image = down1;
				}
				else if(spriteNum == 2) {
					image = down2;
				}
				else if(spriteNum == 3) {
					image = down3;
				}
				break;
				
			case "left":
				if(spriteNum == 1) {
					image = left1;
				}
				else if(spriteNum == 2) {
					image = left2;
				}
				else if(spriteNum == 3) {
					image = left2;
				}
				break;
				
			case "right":
				if(spriteNum == 1) {
					image = right1;
				}
				else if(spriteNum == 2) {
					image = right2;
				}
				else if(spriteNum == 3) {
					image = right2;
				}
				break;
				
			case "none":
				if(spriteNum == 1) {
					image = idle1;
					
				}
				else if(spriteNum == 2) {
					image = idle2;
					
				}
				else if(spriteNum == 3) {
					image = idle2;
				}
				System.out.println(spriteNum);
				break;
			}
			
		g2.drawImage(image, x, y, mp.tileSize * 2, mp.tileSize * 2, null);
	}
}
}
