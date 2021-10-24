package com.MayronStudios.entities;

import java.awt.Color;
//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import com.MayronStudios.graficos.UI;
import com.MayronStudios.main.Game;
import com.MayronStudios.world.Camera;
import com.MayronStudios.world.EntityColision;
import com.MayronStudios.world.EntityColision2;
import com.MayronStudios.world.EntityColision3;
import com.MayronStudios.world.World;

public class Enemy3 extends Entity {

	public  double speed = 0.5;
    public boolean down, up, left;
    public boolean  right = true;
    public boolean  Removed = false;
    static int Vision = 80;

    //hITBOX
	
	private int frames = 0, maxFrames = 5, index = 0, maxIndex = 2;

	private int Stopframes = 0, StopmaxFrames = 10, Stopindex = 0, StopmaxIndex = 2;
	
	
	public  int right_dir = 0, left_dir = 1, down_dir = 2, up_dir = 3;
	public  int dir = 1;
	public static int Cdir = 10;

	public static boolean Stop;
	


	//private BufferedImage[] sprites;
	private int life = 3;
	private boolean moved = false;
	private boolean See = false;
	
	
	
	
	//CONTAGEM
	Timer timer = new Timer();
	//DEFINIR QUNATO TEMPO
	
	final long SEGUNDOS = (1200 * 2);
	
	TimerTask contagem = new TimerTask() {

		@Override
		//OQ VAI ACONTECER
		public void run() {
			System.out.println("rodando");
			if(dir == left_dir) {
				dir = right_dir;
			}else {
				dir = left_dir;
			}
			
			
			
			
			
		}
		
		
	};
	
	//Imagens
	
		
	private BufferedImage[] StoprightEnemy;
	private BufferedImage[] StopleftEnemy;
	private BufferedImage[] StopupEnemy;
	private BufferedImage[] StopdownEnemy;
	private BufferedImage EnemyEfectGreen;
	private BufferedImage EnemyEfectRed;
	private BufferedImage[] SeePlayer;
	
	
	

	public Enemy3(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		timer.scheduleAtFixedRate(contagem, 0, SEGUNDOS);
		//HITBOX DOS INIMIGOS
		this.maskx = 12;
		this.masky = 22;
		this.mwidth = 9;
		this.mheight = 5;
		
		this.depthX = 12;
		this.depthY = 6;
		this.mwidthDepth = 9;
		this.mheightDepth = 8;
		
		
		this.RangeY = 0;
		this.Rangewidth = 80;
		this.Rangeheight = 40;
			
		
		
		// Frames de Animação
		// Animações quantidade

				StopupEnemy = new BufferedImage[3];
				StopdownEnemy = new BufferedImage[3];
				StoprightEnemy = new BufferedImage[3];
				StopleftEnemy = new BufferedImage[3];
				SeePlayer = new BufferedImage[3];
				
						
				
				for (int i = 0; i < 3; i++) {
					StopupEnemy[i] = Game.spritesheetEnemy.getSprite(0 + (i * 32), 224, 32, 32);
				}for (int i = 0; i < 3; i++) {
					StopdownEnemy[i] = Game.spritesheetEnemy.getSprite(0 + (i * 32), 192, 32, 32);
				}for (int i = 0; i < 3; i++) {
					StoprightEnemy[i] = Game.spritesheetEnemy.getSprite(0 + (i * 32), 192, 32, 32);
				}for (int i = 0; i < 3; i++) {
					StopleftEnemy[i] = Game.spritesheetEnemy.getSprite(0 + (i * 32), 224,32, 32);
				}
				
				for (int i = 0; i < 3; i++) {
					SeePlayer[i] = Game.spritesheetEfeitoInimigo.getSprite(160 + (i * 16), 0,16, 16);
				}
				EnemyEfectRed = Game.spritesheetEfeitoInimigo.getSprite(80, 0,80, 40);
				EnemyEfectGreen = Game.spritesheetEfeitoInimigo.getSprite(0, 0,80, 40);
					
	}

	public void tick() {
		
		if(dir == left_dir) {
			this.RangeX = -65;
		}else if (dir == right_dir) {
			this.RangeX = 14;
		}
		depth = 10;
		
		if(Game.player.action == true) {
			//life = 0;
		}
		//APAGA O DROP
		

		
		
        
		
		
		

		
		

		// Animation
         
		if(See) {
			
			
			frames++;
			if (frames == maxFrames) {
				frames = 0;
				index++;
				if (index > maxIndex) {
					
					index = 2;
					
					
					
				}
			}
			
		}else {
			index = 0;
		}
		if (moved == false) {
			
			
			Stopframes++;
			if (Stopframes == StopmaxFrames) {
				
				Stopframes = 0;
				Stopindex++;
				if (Stopindex > StopmaxIndex) {
					
					
					Stopindex = 0;
				}
			}
		}

		this.CheckCollisionEntityRange();	
	}
	//PEGAR DROP
	public void CheckCollisionEntityRange() {
		for(int i = 0; i < Game.entities.size(); i++) {
            Entity e = Game.entities.get(i);
			
			if(e instanceof Enemy3) {
				
				if(Enemy3.Range(this, Game.player)) {
					
					
					See = true;

				}else {
					System.out.println("aaaa");
					See = false;
				}
				
					
				
				
			}
		}
			
		
	}

	public void destroySelf() {
		Game.enemies.remove(this);
		Game.entities.remove(this);
	}

	public boolean isColliddingWithPlayer() {
		Rectangle enemyCurrent = new Rectangle(this.getX() + maskx, this.getY()+ masky, mwidth, mheight);
		Rectangle player = new Rectangle(Game.player.getX() + Game.player.maskx ,Game.player.getY() + Game.player.masky ,Game.player.mwidth, Game.player.mheight);
		

		return enemyCurrent.intersects(player);
	}

    

	public void render(Graphics g) {
		g.setColor(Color.blue);
		//g.fillRect(this.getX() + RangeX - Camera.x, this.getY()+ RangeY - Camera.y, Rangewidth, Rangeheight);
		if (dir == right_dir) {
			if(See == true) {
				g.drawImage(EnemyEfectRed, this.getX() - Camera.x+14, this.getY() - Camera.y, null);
				g.drawImage(SeePlayer[index], this.getX() - Camera.x+7, this.getY() - Camera.y-10, null);
			}else {
				g.drawImage(EnemyEfectGreen, this.getX() - Camera.x+14, this.getY() - Camera.y, null);
			}
			
		}else {
			if(See == true) {
				g.drawImage(EnemyEfectRed, this.getX() - Camera.x-64, this.getY() - Camera.y, null);
				g.drawImage(SeePlayer[index], this.getX() - Camera.x+8, this.getY() - Camera.y-10, null);
			}else {
				g.drawImage(EnemyEfectGreen, this.getX() - Camera.x-64, this.getY() - Camera.y, null);
			}
		}
		//SPRITES DE MOVIMENTOS
		if(moved == false) {
			if (dir == up_dir) {
				
				   g.drawImage(StopupEnemy[Stopindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				   
		    }else if (dir == down_dir) {
			
			   g.drawImage(StopdownEnemy[Stopindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
			   
	        }else if(dir == left_dir) {
	        	
				g.drawImage(StopleftEnemy[Stopindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				
				
			}else if (dir == right_dir) {
				
				g.drawImage(StoprightEnemy[Stopindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				
		    }
		//SPRITE PARADO	
	    }
			
			
			
		
		
		g.setColor(Color.blue);
		//g.fillRect(this.getX() + maskx - Camera.x, this.getY()+ masky - Camera.y, mwidth, mheight);
		
		//g.fillRect(this.getX() + depthX - Camera.x, this.getY()+ depthY - Camera.y, mwidthDepth, mheightDepth);
       
	}
	
}
