package com.MayronStudios.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.MayronStudios.entities.Entity;
import com.MayronStudios.main.Game;
import com.MayronStudios.main.SwtchEvents;

public class EntityColision extends Entity{
	
	
	
	
	
    
	
	
	




	public EntityColision(int x, int y, int width, int height, BufferedImage sprite) {
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
		depth = 2;
		
		
	}
	
	
	
	
	public void render(Graphics g) {
		
		g.drawImage(sprite, this.getX() - Camera.x, this.getY() - Camera.y, null);
		g.setColor(Color.blue);
		//g.fillRect(getX() + Actmaskx - Camera.x, getY()+ Actmasky - Camera.y, Actwidth, Actheight);
		//g.fillRect(getX() + maskx5 - Camera.x, getY()+ masky5 - Camera.y, mwidth5, mheight5);
		//g.fillRect(getX() + maskx4 - Camera.x, getY()+ masky4 - Camera.y, mwidth4, mheight4);
		//g.fillRect(getX() + maskx3 - Camera.x, getY()+ masky3 - Camera.y, mwidth3, mheight3);
		//g.fillRect(getX() + maskx2 - Camera.x, getY()+ masky2 - Camera.y, mwidth2, mheight2);
		//g.fillRect(getX() + maskx - Camera.x, getY()+ masky - Camera.y, mwidth, mheight);
		g.setColor(Color.RED);
		//g.fillRect(this.getX() + depthX - Camera.x, this.getY()+ depthY - Camera.y, mwidthDepth, mheightDepth);
		
	}


	
}
