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

public class Enemy extends Entity {

	public  double speed = 0.5;
    public boolean right, up, left;
    public boolean  down = true;
    public boolean  Removed = false;
    static int Vision = 80;

    //hITBOX
	private int maskX = 4, maskY = 6, maskW = 7, maskH = 7;
	private int frames = 0, maxFrames = 4, index = 0, maxIndex = 3;

	private int Stopframes = 0, StopmaxFrames = 8, Stopindex = 0, StopmaxIndex = 1;
	private int Hitframes = 0, HitmaxFrames = 8, Hitindex = 0, HitmaxIndex = 2;
	private int Atkframes = 0, AtkmaxFrames = 8, Atkindex = 0, AtkmaxIndex = 1;
	private int Killframes = 0, KillmaxFrames = 4, Killindex = 0, KillmaxIndex = 3;
	private int Kill2frames = 0, Kill2maxFrames = 30, Kill2index = 0, Kill2maxIndex = 60;
	private int Dropframes = 0, DropmaxFrames = 30, Dropindex = 0, DropmaxIndex = 1;
	
	
	public  int right_dir = 0, left_dir = 1, down_dir = 2, up_dir = 3;
	public  int dir = 1;
	public static int Cdir = 10;

	public static boolean Stop;
	


	//private BufferedImage[] sprites;
	private int life = 3;
	private boolean moved = false;
	private boolean Atack = false;
	private boolean pause = false;
	private boolean Kill = false;
	private boolean Destroy = false;
	private boolean Drop = false;
	private boolean DropChance = true;
	public int DropNum = 1;
	//0 = null, 1 = 0.5 life, 2 = 1.0 life
	
	
	
	private boolean completedAtk = false;
	private boolean completedKill = false;
	private boolean completedDestroy = false;
	private boolean isDamage = false;
	private int damageFrames = 10, damageCurrent = 0;
	//CONTAGEM
	Timer timer = new Timer();
	//DEFINIR QUNATO TEMPO
	final long SEGUNDOS = (600 * 2);
	final long SEGUNDOSEEN = (50 * 2);
	
	TimerTask contagem = new TimerTask() {

		@Override
		//OQ VAI ACONTECER
		public void run() {
			Game.player.Yesseen = false;
			if(pause == true) {
				pause = false;
				
				
			}
			
			
			
		}
		
		
	};
	TimerTask Seen = new TimerTask() {

		@Override
		//OQ VAI ACONTECER
		public void run() {
			
			if(pause == true) {
				pause = false;
				
				
			}
			
			
			
		}
		
		
	};
	//Imagens
	private BufferedImage[]Drop1Enemy;
	private BufferedImage[] rightEnemy;
	private BufferedImage[] leftEnemy;
	private BufferedImage[] downEnemy;
	private BufferedImage[] upEnemy;
		
	private BufferedImage[] StoprightEnemy;
	private BufferedImage[] StopleftEnemy;
	private BufferedImage[] StopupEnemy;
	private BufferedImage[] StopdownEnemy;
	
	private BufferedImage[] HitrightEnemy;
	private BufferedImage[] HitleftEnemy;
	private BufferedImage[] HitdownEnemy;
	private BufferedImage[] HitupEnemy;
	
	private BufferedImage[] AtkrightEnemy;
	private BufferedImage[] AtkleftEnemy;
	private BufferedImage[] AtkdownEnemy;
	private BufferedImage[] AtkupEnemy;
	
	private BufferedImage[] KillrightEnemy;
	private BufferedImage[] KillleftEnemy;
	private BufferedImage[] KilldownEnemy;
	private BufferedImage[] KillupEnemy;
		
	private BufferedImage[] Kill2rightEnemy;
	private BufferedImage[] Kill2leftEnemy;
	private BufferedImage[] Kill2downEnemy;
	private BufferedImage[] Kill2upEnemy;
	
	private BufferedImage[] Hp1;
	private BufferedImage[] Hp2;
	

	public Enemy(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		
			
		
		timer.scheduleAtFixedRate(contagem, 0, SEGUNDOS);
		timer.scheduleAtFixedRate(Seen, 0, SEGUNDOSEEN);
		// Frames de Animação
		// Animações quantidade
		
		
		
		
		        Drop1Enemy = new BufferedImage[2];
		
				upEnemy = new BufferedImage[4];
				downEnemy = new BufferedImage[4];
				rightEnemy = new BufferedImage[4];
				leftEnemy = new BufferedImage[4];
				
				
				StopupEnemy = new BufferedImage[2];
				StopdownEnemy = new BufferedImage[2];
				StoprightEnemy = new BufferedImage[2];
				StopleftEnemy = new BufferedImage[2];
				
				HitupEnemy = new BufferedImage[3];
				HitdownEnemy = new BufferedImage[3];
				HitrightEnemy = new BufferedImage[3];
				HitleftEnemy = new BufferedImage[3];
				
				AtkupEnemy = new BufferedImage[2];
				AtkdownEnemy = new BufferedImage[2];
				AtkrightEnemy = new BufferedImage[2];
				AtkleftEnemy = new BufferedImage[2];
				
				KillupEnemy = new BufferedImage[4];
				KilldownEnemy = new BufferedImage[4];
				KillrightEnemy = new BufferedImage[4];
				KillleftEnemy = new BufferedImage[4];
				
				Kill2upEnemy = new BufferedImage[1];
				Kill2downEnemy = new BufferedImage[1];
				Kill2rightEnemy = new BufferedImage[1];
				Kill2leftEnemy = new BufferedImage[1];
				
				Hp1 = new BufferedImage[2];
				Hp2 = new BufferedImage[2];
				
				for (int i = 0; i < 4; i++) {
					upEnemy[i] = Game.spritesheetEnemy.getSprite(32 + (i * 16), 0, 16, 16);
				}for (int i = 0; i < 4; i++) {
					downEnemy[i] = Game.spritesheetEnemy.getSprite(32 + (i * 16), 16, 16, 16);
				}for (int i = 0; i < 4; i++) {
					rightEnemy[i] = Game.spritesheetEnemy.getSprite(32 + (i * 16), 32, 16, 16);
				}for (int i = 0; i < 4; i++) {
					leftEnemy[i] = Game.spritesheetEnemy.getSprite(32 + (i * 16), 48, 16, 16);
				}
				
				for (int i = 0; i < 2; i++) {
					StopupEnemy[i] = Game.spritesheetEnemy.getSprite(0 + (i * 16), 0, 16, 16);
				}for (int i = 0; i < 2; i++) {
					StopdownEnemy[i] = Game.spritesheetEnemy.getSprite(0 + (i * 16), 16, 16, 16);
				}for (int i = 0; i < 2; i++) {
					StoprightEnemy[i] = Game.spritesheetEnemy.getSprite(0 + (i * 16), 32, 16, 16);
				}for (int i = 0; i < 2; i++) {
					StopleftEnemy[i] = Game.spritesheetEnemy.getSprite(0 + (i * 16), 48,16, 16);
				}
				
				for (int i = 0; i < 3; i++) {
					HitupEnemy[i] = Game.spritesheetEnemy.getSprite(96 + (i * 16), 0, 16, 16);
				}for (int i = 0; i < 3; i++) {
					HitdownEnemy[i] = Game.spritesheetEnemy.getSprite(96 + (i * 16), 16, 16, 16);
				}for (int i = 0; i < 3; i++) {
					HitrightEnemy[i] = Game.spritesheetEnemy.getSprite(96 + (i * 16), 32, 16, 16);
				}for (int i = 0; i < 3; i++) {
					HitleftEnemy[i] = Game.spritesheetEnemy.getSprite(96 + (i * 16), 48, 16, 16);
				}
				
				for (int i = 0; i < 2; i++) {
					AtkupEnemy[i] = Game.spritesheetEnemy.getSprite(144 + (i * 16), 0, 16, 16);
				}for (int i = 0; i < 2; i++) {
					AtkdownEnemy[i] = Game.spritesheetEnemy.getSprite(144 + (i * 16), 16, 16, 16);
				}for (int i = 0; i < 2; i++) {
					AtkrightEnemy[i] = Game.spritesheetEnemy.getSprite(144 + (i * 16), 32, 16, 16);
				}for (int i = 0; i < 2; i++) {
					AtkleftEnemy[i] = Game.spritesheetEnemy.getSprite(144 + (i * 16), 48, 16, 16);
				}
				
				for (int i = 0; i < 4; i++) {
					KillupEnemy[i] = Game.spritesheetEnemy.getSprite(176 + (i * 16), 0, 16, 16);
				}for (int i = 0; i < 4; i++) {
					KilldownEnemy[i] = Game.spritesheetEnemy.getSprite(176 + (i * 16), 16, 16, 16);
				}for (int i = 0; i < 4; i++) {
					KillrightEnemy[i] = Game.spritesheetEnemy.getSprite(176 + (i * 16), 32, 16, 16);
				}for (int i = 0; i < 4; i++) {
					KillleftEnemy[i] = Game.spritesheetEnemy.getSprite(176 + (i * 16), 48, 16, 16);
				}
				for (int i = 0; i < 1; i++) {
					Kill2upEnemy[i] = Game.spritesheetEnemy.getSprite(240 + (i * 16), 0, 16, 16);
				}for (int i = 0; i < 1; i++) {
					Kill2downEnemy[i] = Game.spritesheetEnemy.getSprite(240 + (i * 16), 16, 16, 16);
				}for (int i = 0; i < 1; i++) {
					Kill2rightEnemy[i] = Game.spritesheetEnemy.getSprite(240 + (i * 16), 32, 16, 16);
				}for (int i = 0; i < 1; i++) {
					Kill2leftEnemy[i] = Game.spritesheetEnemy.getSprite(240 + (i * 16), 48, 16, 16);
				}
				for (int i = 0; i < 2; i++) {
					Hp2[i] = UI.spritesheetUi.getSprite(0 , 16+ (i * 16), 16, 16);
				}
				for (int i = 0; i < 2; i++) {
					Hp1[i] = UI.spritesheetUi.getSprite(16, 16+ (i * 16), 16, 16);
				}
	}

	public void tick() {
		
		
		if(Game.player.action == true) {
			//life = 0;
		}
		//APAGA O DROP
		if(Game.player.GiveDrop == true) {
			Drop = false;
		}
        
		if(Game.player.Squat == true || Game.player.SquatStop == true) {
			Vision = 45;
		}else {
			Vision = 80;
		}
		if(Drop == true) {
			/**if(Game.random.nextInt(100) < 5) {
				DropNum = 2;
			}else if(Game.random.nextInt(100) < 15) {
				DropNum = 1;
			}else {
				DropNum = 0;
			}**/
		}
		if(Drop == false) {
			if(Game.random.nextInt(100) < 5 && DropChance == true) {
				Drop = true;
				DropNum = 2;
				
			}else if(Game.random.nextInt(100) > 85 && DropChance == true) {
				Drop = true;
				DropNum = 1;
				
			}else {
				Drop = true;
				DropNum = 0;
			}
		}
		
		
		
		
        
		
		
		if(this.calculateDistance(this.getX(), this.getY(), Game.player.getX(), Game.player.getY()) < Vision){
			
			if(this.moved == true) {
				Game.player.Yesseen = true;
			}else {
				Game.player.Yesseen = false;
			}
			
			if (this.isColliddingWithPlayer() == false) {
				if(Game.random.nextInt(100)<50) {
					if ((int)x < Game.player.getX()&& World.isFree((int) (x+speed), this.getY()) && Destroy == false){
						//&& ! isCollidding((int) (x+speed), this.getY())) {
						
						
					   x+=speed;;
					   moved = true;
					   right = true;
					   dir = right_dir;
				    }
			        if ((int)x > Game.player.getX() && World.isFree((int) (x-speed), this.getY())&& Destroy == false){
			    		//&& ! isCollidding((int) (x-speed), this.getY())) {
			        	
					   x-=speed;;
					   moved = true;
					   left = true;
					   dir = left_dir;
				    }
				    if  ((int)y < Game.player.getY() +10&& World.isFree( this.getX(), (int) (y+speed))&& Destroy == false){
						//&& ! isCollidding( this.getX(), (int) (y+speed))) {
				    	
				    	
				    		y+=speed;;
				    		down = true;
							moved = true;
							dir = down_dir;

				    }
				    if ((int)y > Game.player.getY() + 10&& World.isFree( this.getX(), (int) (y-speed))&& Destroy == false){
						//&& ! isCollidding ( this.getX(),(int) (y-speed))) {
				    	
					   moved = true;
					   y-=speed;
					   up = true;
					   dir = up_dir;
				    }
					
					
					
				}

				
			} else {
				// Estamos colidindo
				if (Game.random.nextInt(100) < 5 && pause == false) {
					Atack = true;
					moved = false;
					if(completedAtk = true && Destroy == false) {
						//TIRA A VIDA DO PLAYER E AVISA QUE ELE  FOI ATACADO
						Game.player.life --;
						Game.player.isDamage = true;
						pause = true;
						
						//Game.player.life -= Game.random.nextInt(3);
						
					}
					
				}
			}
		}else {
			//Game.player.Yesseen = false;
			//Game.player.Notseen = true;
			right= false;
			up= false;
			left= false;
			down = false;
			moved = false;
			Atack = false;
			pause = false;
		}
	

		
		

		// Animation
         if(Drop) {
			
			
        	 Dropframes++;
			if (Dropframes == DropmaxFrames) {
				Dropframes = 0;
				Dropindex++;
				if (Dropindex > DropmaxIndex) {
					Dropindex = 0;
					
				}
			}
			
		}
		if(moved) {
			
			
			frames++;
			if (frames == maxFrames) {
				frames = 0;
				index++;
				if (index > maxIndex) {
					index = 0;
					
				}
			}
			
		}
		if (moved == false) {
			Game.player.Notseen = true;
			
			Stopframes++;
			if (Stopframes == StopmaxFrames) {
				
				Stopframes = 0;
				Stopindex++;
				if (Stopindex > StopmaxIndex) {
					
					
					Stopindex = 0;
				}
			}
		}if (isDamage == true) {
			Hitframes++;
			if(Game.player.dir == right_dir) {
				x+=2;
			}else if(Game.player.dir == left_dir) {
				x-=2;
				
			}else if(Game.player.dir == up_dir) {
				y-=2;
				
			}else if(Game.player.dir == down_dir) {
				y+=2;
				
			}
			if (Hitframes == HitmaxFrames) {
				Hitframes = 0;
				Hitindex++;
				
				
				if (Hitindex > HitmaxIndex) {
					Hitindex = 0;
				}
			}
		}if (Atack == true) {
			Atkframes++;
			if (Atkframes == AtkmaxFrames) {
				Atkframes = 0;
				Atkindex++;
				if (Atkindex > AtkmaxIndex) {
					Atkindex = 0;
					completedAtk = true;
				}
			}
		}else {
			completedAtk = false;
		}
		if (Kill == true) {
			Killframes++;
			if (Killframes == KillmaxFrames) {
				Killframes = 0;
				Killindex++;
				if (Killindex > KillmaxIndex - 1) {
					
					
				}
				if (Killindex > KillmaxIndex) {
					completedKill = true;
					
					Kill = false;
					Destroy = true;
					
				}
			}
		}
		if (Destroy == true) {
			Kill2frames++;
			if (Kill2frames == Kill2maxFrames) {
				Kill2frames = 0;
				Kill2index++;
				if (Kill2index > Kill2maxIndex) {
					completedDestroy = true;
					Destroy = false;
				}
				
				
			}
		}

		collidingBullet();
		collidingBullet2();
		
		if (life <= 0) {
			
			Kill = true;
			if(completedKill == true) {
				
				Destroy = true;
				if(completedDestroy == true) {
					 destroySelf();
					   return;
				}
				   
				
			}
			
		}
		
		
		if(isDamage) {
			this.damageCurrent++;
			if(this.damageCurrent == this.damageFrames) {
				this.damageCurrent = 0;
				this.isDamage = false;
			}
		}
		this.CheckCollisionEntityColision();
		this.checkCollisionDropEnemy();
		
	}
	//PEGAR DROP
	public void checkCollisionDropEnemy() {
		for (int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if (e instanceof Player) {
				if (Entity.isCollidding(this, e) && Game.player.life <= Game.player.maxLife) {
					if(Game.player.action == true) {
						if(Drop == true) {
							if(DropNum == 1) {
								
								Game.player.life+=1;
								Drop = false;
								DropChance = false;
								
								return;
							}else if(DropNum == 2) {
								if(life > Game.player.maxLife - 2) {
									Game.player.life+=1;
									Drop = false;
									DropChance = false;
									return;
								}
								Game.player.life+=2;
								Drop = false;
								DropChance = false;
								
								return;
								
							}
						}
					}
					
					
					
					return;
				}
			}
		}
	}

	public void destroySelf() {
		Game.enemies.remove(this);
		Game.entities.remove(this);
	}

	public void collidingBullet() {
		for (int i = 0; i < Game.bulletShoot.size(); i++) {
			Entity e = Game.bulletShoot.get(i);
			if (e instanceof BulletShoot) {
				if (Entity.isCollidding(this, e)) {
					
					isDamage = true;
					
					life--;
					Game.bulletShoot.remove(i);
					return;
				}
			}
		}
	}
	public void collidingBullet2() {
		for (int i = 0; i < Game.bulletShoot2.size(); i++) {
			Entity e = Game.bulletShoot2.get(i);
			if (e instanceof BulletShoot2) {
				if (Entity.isCollidding(this, e)) {
					
					isDamage = true;
					
					life-=3;
					
					return;
				}
			}
		}
	}
	
    
	
	

	public boolean isColliddingWithPlayer() {
		Rectangle enemyCurrent = new Rectangle(this.getX() + maskX, this.getY()+ maskY, maskW, maskH);
		Rectangle player = new Rectangle(Game.player.getX() + Game.player.maskx ,Game.player.getY() + Game.player.masky ,Game.player.mwidth, Game.player.mheight);
		

		return enemyCurrent.intersects(player);
	}public void CheckCollisionEntityColision() {
		for(int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			
			if(e instanceof EntityColision) {
				
				if(EntityColision.isCollidding(this, e)) {
					if(down) {
					    y -= Game.inimigo1.speed;
					    down = false;
					} if(up) {
						y += Game.inimigo1.speed;
						up = false;
					}if(right) {
						x -= Game.inimigo1.speed;
						right = false;
					} if(left) {
						x += Game.inimigo1.speed;
						left = false;
					}

				}

			}
            if(e instanceof EntityColision2) {
				
				if(EntityColision.isCollidding(this, e)) {
					if(down) {
					    y -= Game.inimigo1.speed;
					    down = false;
					} if(up) {
						y += Game.inimigo1.speed;
						up = false;
					}if(right) {
						x -= Game.inimigo1.speed;
						right = false;
					} if(left) {
						x += Game.inimigo1.speed;
						left = false;
					}

				}

			}
            if(e instanceof EntityColision3) {
				
				if(EntityColision.isCollidding(this, e)) {
					if(down) {
					    y -= Game.inimigo1.speed;
					    down = false;
					} if(up) {
						y += Game.inimigo1.speed;
						up = false;
					}if(right) {
						x -= Game.inimigo1.speed;
						right = false;
					} if(left) {
						x += Game.inimigo1.speed;
						left = false;
					}

				}

			}
		}
	}

	/**public boolean isCollidding(int xnext, int ynext) {
		Rectangle enemyCurrent = new Rectangle(xnext + maskX, ynext + maskY, maskW, maskH); // Classe que cria
																							// retangulos fictícios para
																							// testar colisões.
		for (int i = 0; i < Game.enemies.size(); i++) {
			Enemy e = Game.enemies.get(i);

			if (e == this) {
				continue;
			}
			Rectangle targetEnemy = new Rectangle(e.getX() + maskX, e.getY() + maskY, maskW, maskH);
			if (enemyCurrent.intersects(targetEnemy)) {
				return true;
			}

		}

		return false;
	}**/
    

	public void render(Graphics g) {
		
		
		if(Kill == false) {
			if (!isDamage) {
				//SPRITES DE MOVIMENTOS
				if(moved == true) {
					if (dir == up_dir) {
						
						   g.drawImage(upEnemy[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
						   
				    }else if (dir == down_dir) {
					
					   g.drawImage(downEnemy[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
					   
			        }else if(dir == left_dir) {
						//Desenha o sprite na posição atual
						g.drawImage(leftEnemy[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
						
					}else if (dir == right_dir) {
						
						g.drawImage(rightEnemy[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
						
				    }
				//SPRITE PARADO	
			    }else {
			    	if (dir == up_dir) {
			    		if(Atack == true) {
			    			g.drawImage(AtkupEnemy[Atkindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
			    		}else {
			    			g.drawImage(StopupEnemy[Stopindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
			    		}
			    		
			    	}else if (dir == down_dir) {
			    		if(Atack == true) {
			    			g.drawImage(AtkdownEnemy[Atkindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
			    		}else {
			    			g.drawImage(StopdownEnemy[Stopindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
			    		}
			    		
			    	}
			    	else if(dir == right_dir) {
			    		if(Atack == true) {
			    			g.drawImage(AtkrightEnemy[Atkindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
			    		}else {
			    			g.drawImage(StoprightEnemy[Stopindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
			    		}
			    		
			    	}
			    	else if (dir == left_dir) {
			    		if(Atack == true) {
			    			g.drawImage(AtkleftEnemy[Atkindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
			    		}else {
			    			g.drawImage(StopleftEnemy[Stopindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
			    		}
			    		
			    	}
					
				}

				

				
			} else {
				
				if (dir == up_dir) {
					g.drawImage(HitupEnemy[Hitindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				}else if (dir == down_dir) {
					g.drawImage(HitdownEnemy[Hitindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				}if (dir == right_dir) {
					g.drawImage(HitrightEnemy[Hitindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				}else if (dir == left_dir) {
					g.drawImage(HitleftEnemy[Hitindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				}
				
			}
		}else {
			
			if(Destroy == true) {
				
				
				if (dir == up_dir) {
					if(Drop == true) {
						if(DropNum == 1) {
							g.drawImage(Hp1[Dropindex], this.getX() - Camera.x, this.getY() - Camera.y-5, null);
						}else if(DropNum == 2) {
							g.drawImage(Hp2[Dropindex], this.getX() - Camera.x, this.getY() - Camera.y-5, null);
						}
						
					}
					g.drawImage(Kill2upEnemy[0], this.getX() - Camera.x, this.getY() - Camera.y, null);
				}if (dir == down_dir) {
					if(Drop == true) {
						if(DropNum == 1) {
							g.drawImage(Hp1[Dropindex], this.getX() - Camera.x, this.getY() - Camera.y-12, null);
						}else if(DropNum == 2) {
							g.drawImage(Hp2[Dropindex], this.getX() - Camera.x, this.getY() - Camera.y-12, null);
						}
						
					}
					g.drawImage(Kill2downEnemy[0], this.getX() - Camera.x, this.getY() - Camera.y, null);
				}if (dir == right_dir) {
					if(Drop == true) {
						if(DropNum == 1) {
							g.drawImage(Hp1[Dropindex], this.getX() - Camera.x, this.getY() - Camera.y-5, null);
						}else if(DropNum == 2) {
							g.drawImage(Hp2[Dropindex], this.getX() - Camera.x, this.getY() - Camera.y-5, null);
						}
						
					}
					g.drawImage(Kill2rightEnemy[0], this.getX() - Camera.x, this.getY() - Camera.y, null);
				}if (dir == left_dir) {
					if(Drop == true) {
						if(DropNum == 1) {
							g.drawImage(Hp1[Dropindex], this.getX() - Camera.x, this.getY() - Camera.y-5, null);
						}else if(DropNum == 2) {
							g.drawImage(Hp2[Dropindex], this.getX() - Camera.x, this.getY() - Camera.y-5, null);
						}
						
					}
					g.drawImage(Kill2leftEnemy[0], this.getX() - Camera.x, this.getY() - Camera.y, null);
				}
				
			}else {
				if (dir == up_dir) {
					g.drawImage(KillupEnemy[Killindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				}if (dir == down_dir) {
					g.drawImage(KilldownEnemy[Killindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				}if (dir == right_dir) {
					g.drawImage(KillrightEnemy[Killindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				}if (dir == left_dir) {
					g.drawImage(KillleftEnemy[Killindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				}
			}
			
			
			
			
		}
		
		g.setColor(Color.blue);
		//g.fillRect(this.getX() + maskX - Camera.x, this.getY()+ maskY - Camera.y, maskW, maskH);
        
       
	}
	
}
