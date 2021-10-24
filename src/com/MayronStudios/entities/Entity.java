package com.MayronStudios.entities;

import java.awt.Color;
//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Comparator;


import com.MayronStudios.main.Game;
import com.MayronStudios.main.SwtchEvents;
import com.MayronStudios.world.Camera;

public class Entity {
	public static BufferedImage MAPA_EN = Game.spritesheetMapa.getSprite(0, 0, 640, 640);
	public static BufferedImage MAPALAYER1_EN = Game.spritesheetMapaLayer1.getSprite(0, 0, 640, 640);
	public static BufferedImage LIFEPACK_EN = Game.spritesheet.getSprite(6 * 16, 0, 16, 16);
	public static BufferedImage WEAPON_EN = Game.spritesheet.getSprite(7 * 16, 0, 16, 16);
	public static BufferedImage BULLET_EN = Game.spritesheet.getSprite(6 * 16, 16, 16, 16);
	public static BufferedImage ENEMY_EN = Game.spritesheet.getSprite(7 * 16, 16, 16, 16);
	public static BufferedImage ENEMY_FEEDBACK = Game.spritesheet.getSprite(144, 16, 16, 16);
	
	public static BufferedImage POSTE_EN = Game.spritesheet.getSprite(240, 32, 16, 16);
	public static BufferedImage POSTE1_EN = Game.spritesheet.getSprite(256, 32, 16, 48);
	
	public static BufferedImage GRASS_EN = Game.spritesheet.getSprite(352, 0, 32, 32);

	public static BufferedImage CERCA_EN = Game.spritesheet.getSprite(0, 560, 160, 32);
	public static BufferedImage CERCA1_EN = Game.spritesheet.getSprite(160, 560, 32, 32);
	public static BufferedImage CERCA2_EN = Game.spritesheet.getSprite(208, 480, 16,112);
	public static BufferedImage TREE_EN = Game.spritesheet.getSprite(400, 0, 64, 64);
	public static BufferedImage TREE1_EN = Game.spritesheet.getSprite(416, 64, 48, 64);
	public static BufferedImage TREE2_EN = Game.spritesheet.getSprite(384, 32, 16, 32);
	public static BufferedImage STORE1_EN = Game.spritesheet.getSprite(192, 112, 80, 80);
	public static BufferedImage HOUSE_EN = Game.spritesheet.getSprite(0, 64, 128, 128);
	public static BufferedImage HOUSEPT2_EN = Game.spritesheet.getSprite(0, 192, 128, 16);
	public static BufferedImage CAR0_EN = Game.spritesheet.getSprite(240, 0, 80, 32);
	public static BufferedImage CARRO_EN = Game.spritesheet.getSprite(0, 208, 48, 64);
	
    //QUARTO
	public static BufferedImage TELHADO_EN = Game.spritesheetTelhado.getSprite(0, 0, 97, 102);
	public static BufferedImage QUARTOWALL_EN = Game.spritesheet.getSprite(496, 560, 104, 40);
	public static BufferedImage QUARTOWALL2_EN = Game.spritesheet.getSprite(352, 528, 160, 32);
	public static BufferedImage QUARTOWALL3_EN = Game.spritesheet.getSprite(544, 512, 55, 48);
	public static BufferedImage QUARTOWALL1_EN = Game.spritesheet.getSprite(352, 560, 144, 40);
	public static BufferedImage PORTA_EN = Game.spritesheetMoved.getSprite(0, 48, 1, 1);
	public static BufferedImage ESTANTE_EN = Game.spritesheet.getSprite(48+64, 208, 32, 32);
	public static BufferedImage GUARDA_ROUPA_EN = Game.spritesheet.getSprite(48+32, 256, 32, 32);
	public static BufferedImage CAMA_EN = Game.spritesheet.getSprite(48+32, 208, 32, 32);
	public static BufferedImage PRIVADA_EN = Game.spritesheet.getSprite(112, 272, 16, 16);
	public static BufferedImage CAMA2_EN = Game.spritesheet.getSprite(48, 256, 32, 48);
	public static BufferedImage PENTEADEIRA_EN = Game.spritesheet.getSprite(48, 208, 32, 32);
	public static BufferedImage CADEIRA_EN = Game.spritesheet.getSprite(80, 240, 16, 16);
	public static BufferedImage MESINHA_EN = Game.spritesheet.getSprite(96, 240, 16,16);
	public static BufferedImage PLANTA_EN = Game.spritesheet.getSprite(112, 240, 16,16);
	public static BufferedImage PLANTA1_EN = Game.spritesheet.getSprite(128, 240, 16,16);
	
	
	// Posição da Arma
	public static BufferedImage GUN_LEFT = Game.spritesheet.getSprite(128 + 16, 0, 16, 16);
	public static BufferedImage GUN_RIGHT = Game.spritesheet.getSprite(128, 0, 16, 16);
	public static BufferedImage GUN_DAMAGE_LEFT = Game.spritesheet.getSprite(16, 32, 16, 16);
	public static BufferedImage GUN_DAMAGE_RIGHT = Game.spritesheet.getSprite(0, 32, 16, 16);

	protected double x;
	protected double y;
	protected int width;
	protected int height;
	
	

	protected BufferedImage sprite;
	

	public int maskx;
	public int masky;
	public int mwidth;
	public int mheight;
	public int depthX, depthY,mwidthDepth,mheightDepth;
	public int depthX2, depthY2,mwidthDepth2,mheightDepth2;
	public int depthX3, depthY3,mwidthDepth3,mheightDepth3;
	public int RangeX, RangeY,Rangewidth,Rangeheight;
	public int maskx2, masky2, mwidth2, mheight2;
	public int maskx3, masky3, mwidth3, mheight3;
	public int maskx4, masky4, mwidth4, mheight4;
	public int maskx5, masky5, mwidth5, mheight5;
	public int maskx6, masky6, mwidth6, mheight6;
	public int Actmaskx, Actmasky, Actwidth, Actheight, ActNum;
	public int StopActmaskx, StopActmasky, StopActwidth, StopActheight;
	
	
	 
	
	public int depth;

	public Entity(int x, int y, int width, int height, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprite = sprite;

		this.maskx = 0;
		this.masky = 0;
		this.mwidth = width;
		this.mheight = height;
		
		
	}
	public void setAct(int Actmaskx, int Actmasky, int Actwidth, int Actheight, int ActNum) {
		this.Actmaskx = Actmaskx;
		this.Actmasky = Actmasky;
		this.Actwidth = Actwidth;
		this.Actheight = Actheight;
		this.ActNum = ActNum;
		
		
	}public void setStopAct(int StopActmaskx, int StopActmasky, int StopActwidth, int StopActheight) {
		this.StopActmaskx = StopActmaskx;
		this.StopActmasky = StopActmasky;
		this.StopActwidth = StopActwidth;
		this.StopActheight = StopActheight;
		
		
		
	}
	
	
	public void setMask(int maskx, int masky, int mwidth, int mheight) {
		this.maskx = maskx;
		this.masky = masky;
		this.mwidth = mwidth;
		this.mheight = mheight;
		
		
	}
	public void setMask2(int maskx2, int masky2, int mwidth2, int mheight2) {
		this.maskx2 = maskx2;
		this.masky2 = masky2;
		this.mwidth2 = mwidth2;
		this.mheight2 = mheight2;
	}public void setMask3(int maskx3, int masky3, int mwidth3, int mheight3) {
		this.maskx3 = maskx3;
		this.masky3 = masky3;
		this.mwidth3 = mwidth3;
		this.mheight3 = mheight3;
	}public void setMask4(int maskx4, int masky4, int mwidth4, int mheight4) {
		this.maskx4 = maskx4;
		this.masky4 = masky4;
		this.mwidth4 = mwidth4;
		this.mheight4 = mheight4;
	}public void setMask5(int maskx5, int masky5, int mwidth5, int mheight5) {
		this.maskx5 = maskx5;
		this.masky5 = masky5;
		this.mwidth5 = mwidth5;
		this.mheight5 = mheight5;
	}public void setMask6(int maskx6, int masky6, int mwidth6, int mheight6) {
		this.maskx6 = maskx6;
		this.masky6 = masky6;
		this.mwidth6 = mwidth6;
		this.mheight6 = mheight6;
	}
	public void setDepth(int depthX, int depthY, int mwidthDepth, int mheightDepth) {
		this.depthX = depthX;
		this.depthY = depthY;
		this.mwidthDepth = mwidthDepth;
		this.mheightDepth = mheightDepth;
	}public void setDepth2(int depthX2, int depthY2, int mwidthDepth2, int mheightDepth2) {
		this.depthX2 = depthX2;
		this.depthY2 = depthY2;
		this.mwidthDepth2 = mwidthDepth2;
		this.mheightDepth2 = mheightDepth2;
	}public void setDepth3(int depthX3, int depthY3, int mwidthDepth3, int mheightDepth3) {
		this.depthX3 = depthX3;
		this.depthY3 = depthY3;
		this.mwidthDepth3 = mwidthDepth3;
		this.mheightDepth3 = mheightDepth3;
	}
	public void setRangeSwat(int RangeX, int RangeY, int Rangewidth, int Rangeheight) {
		this.RangeX = RangeX;
		this.RangeY = RangeY;
		this.Rangewidth = Rangewidth;
		this.Rangeheight = Rangeheight;
	}
	public static Comparator<Entity> nodeSorter = new Comparator<Entity>(){
		
		@Override
		public int compare(Entity n0, Entity n1) {
			if (n1.depth < n0.depth) 
				return +1;
				
			if (n1.depth > n0.depth)
				return -1;
			return 0;
		}
		
	};
	
	
	
	

	public void setX(int newX) {
		this.x = newX;
	}

	public void setY(int newY) {
		this.y = newY;
	}

	public int getX() {
		return (int) this.x;
	}

	public int getY() {
		return (int) this.y;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public void tick() {
		
	}
	
	public static void isColliddingWithObjects() {
		if(Game.player.InEvent == false) {
			if(Game.player.run == false) {
				if(Game.player.right == true) {
					Game.player.x -= Game.player.speed;
					Game.player.run = false;
					
					
				}else if(Game.player.left == true) {
					Game.player.x += Game.player.speed;
					Game.player.run = false;
					
				}if(Game.player.up == true) {
					Game.player.y += Game.player.speed;
					Game.player.run = false;
					
				}else if(Game.player.down == true) {
					Game.player.y -= Game.player.speed;
					Game.player.run = false;
					
				}
			}else {
				if(Game.player.right == true) {
					Game.player.x -= Game.player.speed*1.5;
					
					
					
				}else if(Game.player.left == true) {
					Game.player.x += Game.player.speed*1.5;
					
					
				}if(Game.player.up == true) {
					Game.player.y += Game.player.speed*1.5;
					
					
				}else if(Game.player.down == true) {
					Game.player.y -= Game.player.speed*1.5;
					
					
				}
			}
		}
		
			
			
			
		
		
		
		
	}
	public double calculateDistance(int x1, int y1, int x2, int y2){
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

	//MASCARAS DE COLISÕES
	public static boolean isCollidding00(Entity e1, Entity e2) {
		Rectangle e1Mask = new Rectangle(e1.getX() + e1.maskx, e1.getY() + e1.masky, e1.mwidth, e1.mheight);
		Rectangle e2Mask = new Rectangle(e2.getX() + e2.StopActmaskx, e2.getY() + e2.StopActmasky, e2.StopActwidth, e2.StopActheight);

		return e1Mask.intersects(e2Mask);
	}
	public static boolean isCollidding0(Entity e1, Entity e2) {
		Rectangle e1Mask = new Rectangle(e1.getX() + e1.maskx, e1.getY() + e1.masky, e1.mwidth, e1.mheight);
		Rectangle e2Mask = new Rectangle(e2.getX() + e2.Actmaskx, e2.getY() + e2.Actmasky, e2.Actwidth, e2.Actheight);

		return e1Mask.intersects(e2Mask);
	}
	public static boolean isCollidding(Entity e1, Entity e2) {
		Rectangle e1Mask = new Rectangle(e1.getX() + e1.maskx, e1.getY() + e1.masky, e1.mwidth, e1.mheight);
		Rectangle e2Mask = new Rectangle(e2.getX() + e2.maskx, e2.getY() + e2.masky, e2.mwidth, e2.mheight);

		return e1Mask.intersects(e2Mask);
	}public static boolean isCollidding2(Entity e1, Entity e2) {
		Rectangle e1Mask = new Rectangle(e1.getX() + e1.maskx, e1.getY() + e1.masky, e1.mwidth, e1.mheight);
		Rectangle e2Mask = new Rectangle(e2.getX() + e2.maskx2, e2.getY() + e2.masky2, e2.mwidth2, e2.mheight2);

		return e1Mask.intersects(e2Mask);
	}public static boolean isCollidding3(Entity e1, Entity e2) {
		Rectangle e1Mask = new Rectangle(e1.getX() + e1.maskx, e1.getY() + e1.masky, e1.mwidth, e1.mheight);
		Rectangle e2Mask = new Rectangle(e2.getX() + e2.maskx3, e2.getY() + e2.masky3, e2.mwidth3, e2.mheight3);

		return e1Mask.intersects(e2Mask);
	}public static boolean isCollidding4(Entity e1, Entity e2) {
		Rectangle e1Mask = new Rectangle(e1.getX() + e1.maskx, e1.getY() + e1.masky, e1.mwidth, e1.mheight);
		Rectangle e2Mask = new Rectangle(e2.getX() + e2.maskx4, e2.getY() + e2.masky4, e2.mwidth4, e2.mheight4);

		return e1Mask.intersects(e2Mask);
	}public static boolean isCollidding5(Entity e1, Entity e2) {
		Rectangle e1Mask = new Rectangle(e1.getX() + e1.maskx, e1.getY() + e1.masky, e1.mwidth, e1.mheight);
		Rectangle e2Mask = new Rectangle(e2.getX() + e2.maskx5, e2.getY() + e2.masky5, e2.mwidth5, e2.mheight5);

		return e1Mask.intersects(e2Mask);
	}public static boolean isCollidding6(Entity e1, Entity e2) {
		Rectangle e1Mask = new Rectangle(e1.getX() + e1.maskx, e1.getY() + e1.masky, e1.mwidth, e1.mheight);
		Rectangle e2Mask = new Rectangle(e2.getX() + e2.maskx6, e2.getY() + e2.masky6, e2.mwidth6, e2.mheight6);

		return e1Mask.intersects(e2Mask);
	}
	//ORDEM DE RENDERIZAÇÃO
	public static boolean Depth(Entity e5, Entity e6) {
		Rectangle e5Mask = new Rectangle(e5.getX() + e5.depthX, e5.getY()+e5.depthY, e5.mwidthDepth, e5.mheightDepth);
		Rectangle e6Mask = new Rectangle(e6.getX() + e6.depthX, e6.getY()+e6.depthY, e6.mwidthDepth, e6.mheightDepth);
		
		return e5Mask.intersects(e6Mask);
	}public static boolean Depth2(Entity e5, Entity e6) {
		Rectangle e5Mask = new Rectangle(e5.getX() + e5.depthX, e5.getY()+e5.depthY, e5.mwidthDepth, e5.mheightDepth);
		Rectangle e6Mask = new Rectangle(e6.getX() + e6.depthX2, e6.getY()+e6.depthY2, e6.mwidthDepth2, e6.mheightDepth2);
		
		return e5Mask.intersects(e6Mask);
	}public static boolean Depth3(Entity e5, Entity e6) {
		Rectangle e5Mask = new Rectangle(e5.getX() + e5.depthX, e5.getY()+e5.depthY, e5.mwidthDepth, e5.mheightDepth);
		Rectangle e6Mask = new Rectangle(e6.getX() + e6.depthX3, e6.getY()+e6.depthY3, e6.mwidthDepth3, e6.mheightDepth3);
		
		return e5Mask.intersects(e6Mask);
	}
	public static boolean Range(Entity e5, Entity e6) {
		Rectangle e5Mask = new Rectangle(e5.getX() + e5.RangeX, e5.getY()+e5.RangeY, e5.Rangewidth, e5.Rangeheight);
		Rectangle e6Mask = new Rectangle(e6.getX() + e6.maskx, e6.getY()+e6.masky, e6.mwidth, e6.mheight);
		
		return e5Mask.intersects(e6Mask);
	}

	public void render(Graphics g) {
		g.drawImage(sprite, this.getX() - Camera.x, this.getY() - Camera.y, null);
		g.setColor(Color.red);
		
		//g.fillRect(this.getX() + depthX - Camera.x, this.getY()+ depthY - Camera.y, mwidthDepth, mheightDepth);
		//g.fillRect(this.getX() + maskx - Camera.x, this.getY()+ masky - Camera.y, mwidth, mheight);
	}
	
}
