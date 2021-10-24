package com.MayronStudios.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.MayronStudios.entities.Entity;
import com.MayronStudios.entities.Player;
import com.MayronStudios.main.Game;

public class EntityColision4 extends Entity{
	
	
	public int Carrf = 0;

    
    
	
    public EntityColision4(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		// TODO Auto-generated constructor stub
	}
	
    public void setMask(int maskx, int masky, int mwidth, int mheight, int depth) {
		this.maskx = maskx;
		this.masky = masky;
		this.mwidth = mwidth;
		this.mheight = mheight;
		this.depth = depth;
	}
	
	public void setX(int newX) {
		this.x = newX;
	}
	public void setY(int newY) {
		this.y = newY;
	}
	
	public int getX() {
		return (int)this.x;
	}
	
	public int getY() {
		return (int)this.y;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	
	public void tick() {
		
			depth = 6;
		
		if(Player.Camada1 == true){
			//depth = 3;
			
		}
		
		
	}
	
	
	
	
	public void render(Graphics g) {
		g.drawImage(sprite, this.getX() - Camera.x, this.getY() - Camera.y, null);
		g.setColor(Color.blue);
		//g.fillRect(this.getX() + depthX - Camera.x, this.getY()+ depthY - Camera.y, mwidthDepth, mheightDepth);
		//g.fillRect(getX() + maskx - Camera.x, getY()+ masky - Camera.y, mwidth, mheight);
		
	}


	
}
