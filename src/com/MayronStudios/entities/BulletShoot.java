package com.MayronStudios.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.MayronStudios.main.Game;
import com.MayronStudios.world.Camera;

public class BulletShoot extends Entity {
	
	private double dx;
	private double dy;
	private double spd = 1;
	
	private int life = 10, currentLife = 0;
	
	
	public BulletShoot(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy) {
		super(x, y, width, height, sprite);
		this.dx = dx;
		this.dy = dy;
	}

	public void tick() {
		
		if(Player.NunAtk == 2) {
			
			life = 15;
			spd = 2;
			
		}else if (Player.NunAtk == 1){
			life = 10;
			spd = 1;
			
		}
		x+=dx*spd;
		y+=dy*spd;
		currentLife++;
		if(currentLife >= life ) {
			Player.NunAtk = 0;
			
			
			Game.bulletShoot.remove(this);
			
			
			return;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		//g.fillRect(this.getX() - Camera.x, this.getY() - Camera.y, width, height);
	}
}
