package com.MayronStudios.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.MayronStudios.world.EntityColision;
import com.MayronStudios.world.EntityColision2;
import com.MayronStudios.world.EntityColision3;
import com.MayronStudios.main.Game;
import com.MayronStudios.main.SwtchEvents;
import com.MayronStudios.world.*;

public class Player extends Entity {
	// Movements
	public boolean StopedPlayer = false;
	public boolean right, up, left, down;
	public int right_dir = 0, left_dir = 1, down_dir = 2, up_dir = 3;
	public int dir = right_dir;
	public boolean action;
	public boolean running = false;
	public boolean run = false;
	public boolean Squat = false;
	public boolean SquatStop = false;
	public boolean GiveDrop = false;
	public boolean InEvent = false;
	//PERMIÇÕES
	public boolean receivedQuest = false;
	//Variaveis
	
	
	
	public boolean seen = false;
	public boolean Notseen = false;
	public boolean Yesseen = false;
	public static int PlayerVision = 40;
	public static boolean Showseen = false;
	public double speed = 1;
	public static boolean diagonal = true;
	public static int NunAtk = 0;

	// Animations
	private int frames = 0, maxFrames = 8, index = 0, maxIndex = 3;
	private int Stopframes = 0, StopmaxFrames = 8, Stopindex = 0, StopmaxIndex = 2;
	private int StopSquatframes = 0, StopSquatmaxFrames = 8, StopSquatindex = 0, StopSquatmaxIndex = 2;
	private int atkframes = 0, atkmaxFrames = 4, atkindex = 0, atkmaxIndex = 4;
	private int runframes = 0, runmaxFrames = 6, runindex = 0, runmaxIndex = 3;
	private int squatframes = 0, squatmaxFrames = 6, squatindex = 0, squatmaxIndex = 3;
	public boolean moved = false;
	//Imagens
	private BufferedImage[] rightPlayer;
	private BufferedImage[] leftPlayer;
	private BufferedImage[] downPlayer;
	private BufferedImage[] upPlayer;
	
	private BufferedImage[] RunrightPlayer;
	private BufferedImage[] RunleftPlayer;
	private BufferedImage[] RundownPlayer;
	private BufferedImage[] RunupPlayer;
	
	private BufferedImage[] SquatrightPlayer;
	private BufferedImage[] SquatleftPlayer;
	private BufferedImage[] SquatdownPlayer;
	private BufferedImage[] SquatupPlayer;
	
	
	
	private BufferedImage[] PunchrightPlayer;
	private BufferedImage[] PunchleftPlayer;
	private BufferedImage[] PunchdownPlayer;
	private BufferedImage[] PunchupPlayer;
	
	private BufferedImage[] Punch2rightPlayer;
	private BufferedImage[] Punch2leftPlayer;
	private BufferedImage[] Punch2downPlayer;
	private BufferedImage[] Punch2upPlayer;
	
	private BufferedImage[] StoprightPlayer;
	private BufferedImage[] StopleftPlayer;
	private BufferedImage[] StopupPlayer;
	private BufferedImage[] StopdownPlayer;
	
	private BufferedImage[] StopSquatrightPlayer;
	private BufferedImage[] StopSquatleftPlayer;
	private BufferedImage[] StopSquatupPlayer;
	private BufferedImage[] StopSquatdownPlayer;
	
	
	private BufferedImage playerDamage;
	// Gun and Damage
	private boolean hasGun = false;
	public int ammo = 0;
	public boolean isDamage = false;
	private int damageFrames = 0;
	public boolean shoot = false;
	public boolean mouseShoot = false;
	// Life
	public double life = 3, maxLife = 6;
	public double mana = 3, maxMana = 3;
	public int mx, my;
	//camadas
	public static boolean Camada1 = false;
	public static boolean Camada2 = false;
	public static boolean Camada3 = false;
	public static boolean Camada4 = false;
	//ataques
	public  boolean atack1 = false;
	public  boolean atack2 = false;
	public  boolean atacando = false;
	public  boolean EndPunch = false;
	

	public Player(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		this.maskx = 12;
		this.masky = 20;
		this.mwidth = 9;
		this.mheight = 5;
		
		this.depthX = 12;
		this.depthY = 8;
		this.mwidthDepth = 9;
		this.mheightDepth = 16;
		
		// Animações quantidade
		upPlayer = new BufferedImage[4];
		downPlayer = new BufferedImage[4];
		rightPlayer = new BufferedImage[4];
		leftPlayer = new BufferedImage[4];
		
		RunupPlayer = new BufferedImage[4];
		RundownPlayer = new BufferedImage[4];
		RunrightPlayer = new BufferedImage[4];
		RunleftPlayer = new BufferedImage[4];
		
		SquatupPlayer = new BufferedImage[4];
		SquatdownPlayer = new BufferedImage[4];
		SquatrightPlayer = new BufferedImage[4];
		SquatleftPlayer = new BufferedImage[4];
		
		PunchupPlayer = new BufferedImage[5];
		PunchdownPlayer = new BufferedImage[5];
		PunchrightPlayer = new BufferedImage[5];
		PunchleftPlayer = new BufferedImage[5];
		
		Punch2upPlayer = new BufferedImage[5];
		Punch2downPlayer = new BufferedImage[5];
		Punch2rightPlayer = new BufferedImage[5];
		Punch2leftPlayer = new BufferedImage[5];
		
		StopupPlayer = new BufferedImage[3];
		StopdownPlayer = new BufferedImage[3];
		StoprightPlayer = new BufferedImage[3];
		StopleftPlayer = new BufferedImage[3];
		
		StopSquatupPlayer = new BufferedImage[3];
		StopSquatdownPlayer = new BufferedImage[3];
		StopSquatrightPlayer = new BufferedImage[3];
		StopSquatleftPlayer = new BufferedImage[3];
		
		
		
		
		
		playerDamage = Game.spritesheetPlayer.getSprite(32, 64, 32, 32);
		for (int i = 0; i < 4; i++) {
			upPlayer[i] = Game.spritesheetPlayer.getSprite(96 + (i * 32), 0, 32, 32);
		}for (int i = 0; i < 4; i++) {
			downPlayer[i] = Game.spritesheetPlayer.getSprite(96 + (i * 32), 32, 32, 32);
		}for (int i = 0; i < 4; i++) {
			rightPlayer[i] = Game.spritesheetPlayer.getSprite(96 + (i * 32), 64, 32, 32);
		}for (int i = 0; i < 4; i++) {
			leftPlayer[i] = Game.spritesheetPlayer.getSprite(96 + (i * 32), 96, 32, 32);
		}
		for (int i = 0; i < 4; i++) {
			RunupPlayer[i] = Game.spritesheetPlayer.getSprite(384 + (i * 32), 0, 32, 32);
		}for (int i = 0; i < 4; i++) {
			RundownPlayer[i] = Game.spritesheetPlayer.getSprite(384 + (i * 32), 32, 32, 32);
		}for (int i = 0; i < 4; i++) {
			RunrightPlayer[i] = Game.spritesheetPlayer.getSprite(384 + (i * 32), 64, 32, 32);
		}for (int i = 0; i < 4; i++) {
			RunleftPlayer[i] = Game.spritesheetPlayer.getSprite(384 + (i * 32), 96, 32, 32);
		}
		for (int i = 0; i < 4; i++) {
			SquatupPlayer[i] = Game.spritesheetPlayer.getSprite(672 + (i * 32), 0, 32, 32);
		}for (int i = 0; i < 4; i++) {
			SquatdownPlayer[i] = Game.spritesheetPlayer.getSprite(672 + (i * 32), 32, 32, 32);
		}for (int i = 0; i < 4; i++) {
			SquatrightPlayer[i] = Game.spritesheetPlayer.getSprite(672 + (i * 32), 64, 32, 32);
		}for (int i = 0; i < 4; i++) {
			SquatleftPlayer[i] = Game.spritesheetPlayer.getSprite(672 + (i * 32), 96, 32, 32);
		}
		
		for (int i = 0; i < 3; i++) {
			StopupPlayer[i] = Game.spritesheetPlayer.getSprite(0 + (i * 32), 0, 32, 32);
		}for (int i = 0; i < 3; i++) {
			StopdownPlayer[i] = Game.spritesheetPlayer.getSprite(0 + (i * 32), 32, 32, 32);
		}for (int i = 0; i < 3; i++) {
			StoprightPlayer[i] = Game.spritesheetPlayer.getSprite(0 + (i * 32), 64, 32, 32);
		}for (int i = 0; i < 3; i++) {
			StopleftPlayer[i] = Game.spritesheetPlayer.getSprite(0 + (i * 32), 96, 32, 32);
		}
		
		for (int i = 0; i < 3; i++) {
			StopSquatupPlayer[i] = Game.spritesheetPlayer.getSprite(800 + (i * 32), 0, 32, 32);
		}for (int i = 0; i < 3; i++) {
			StopSquatdownPlayer[i] = Game.spritesheetPlayer.getSprite(800 + (i * 32), 32, 32, 32);
		}for (int i = 0; i < 3; i++) {
			StopSquatrightPlayer[i] = Game.spritesheetPlayer.getSprite(800 + (i * 32), 64, 32, 32);
		}for (int i = 0; i < 3; i++) {
			StopSquatleftPlayer[i] = Game.spritesheetPlayer.getSprite(800 + (i * 32), 96, 32, 32);
		}
		
		for (int i = 0; i < 5; i++) {
			PunchupPlayer[i] = Game.spritesheetPlayer.getSprite(224 + (i * 32), 0, 32, 32);
		}for (int i = 0; i < 5; i++) {
			PunchdownPlayer[i] = Game.spritesheetPlayer.getSprite(224 + (i * 32), 32, 32, 32);
		}for (int i = 0; i < 5; i++) {
			PunchrightPlayer[i] = Game.spritesheetPlayer.getSprite(224 + (i * 32), 64, 32, 32);
		}for (int i = 0; i < 5; i++) {
			PunchleftPlayer[i] = Game.spritesheetPlayer.getSprite(224 + (i * 32), 96, 32, 32);
		}
		
		for (int i = 0; i < 5; i++) {
			Punch2upPlayer[i] = Game.spritesheetPlayer.getSprite(512 + (i * 32), 0, 32, 32);
		}for (int i = 0; i < 5; i++) {
			Punch2downPlayer[i] = Game.spritesheetPlayer.getSprite(512 + (i * 32), 32, 32, 32);
		}for (int i = 0; i < 5; i++) {
			Punch2rightPlayer[i] = Game.spritesheetPlayer.getSprite(512 + (i * 32), 64, 32, 32);
		}for (int i = 0; i < 5; i++) {
			Punch2leftPlayer[i] = Game.spritesheetPlayer.getSprite(512 + (i * 32), 96, 32, 32);
		}
		
		

	}
	

	public void tick() {
		
		//System.out.println(receivedQuest);
		
		
		
		
		if(!(mana >= maxMana)) {
			if(run == false && atack1 == false && atack2 == false) {
				mana+=0.005;
			}
			
		}
		if(mana < 0) {
			mana = 0;
		}
		if(mana < 0.1) {
			run = false;
		}
		//LIBERAR VISÃO
		if(Squat == true || SquatStop == true) {
			
			Showseen = true;
		}else {
			Showseen = false;
		}
		if(Yesseen == true && Notseen == true) {
			seen = true;
			
		}else if(Yesseen == true && Notseen == false) {
			seen = true;
			
		}else if(Yesseen == false && Notseen == true) {
			seen = false;
			
		}
		
		
		
		
		
		//System.out.println(mana);
		EndPunch = false;
		
		if(depth == 15) {
			Camada1 = false;
			Camada2 = false;
			Camada3 = false;
		}
		
		
		depth = 15;
		if(atack1 == true || atack2 == true) {
			atacando = true;
				
		}
		
        
		
		// Movements
		if(InEvent == false) {
			moved = false;
		}
	
		if(run == false) {
			running = false;
			if(Squat == true) {
				//FAZER A TROCA DO AGACHAR PRO ANDAR
				if(SquatStop == false) {
                    if (right && World.isFree((int) (x+speed), this.getY())) {
                    	Squat = false;
						moved = true;
						dir = right_dir;
						x += speed;
					}else if (left && World.isFree((int) (x-speed), this.getY())) {
						Squat = false;
						moved = true;
						dir = left_dir;
						x -= speed;
					}
					else if (up && World.isFree(this.getX(), (int) (y-speed))) {
						moved = true;
						dir = up_dir;
						y -= speed;	
					}else if (down && World.isFree(this.getX(), (int) (y+speed))) {
						moved = true;
						dir = down_dir;
						y += speed;
					}
				}
				//AGACHAR
				if (right && World.isFree((int) (x+speed), this.getY())) {
					
					
					
					dir = right_dir;
					x += speed/2;
					
					
				} else if (left && World.isFree((int) (x-speed), this.getY())) {
					
					
					dir = left_dir;
					x -= speed/2;
					
					
				}

				else if (up && World.isFree(this.getX(), (int) (y-speed))) {
					
					
					dir = up_dir;
					y -= speed/2;
					
					
				} else if (down && World.isFree(this.getX(), (int) (y+speed))) {
					
					
					dir = down_dir;
					y += speed/2;
					
					
				}
			}else {
				//FAZER A TROCA DO ANDAR PRO AGACHAR  
				if(SquatStop == true) {
					if (right && World.isFree((int) (x+speed), this.getY())) {
						Squat = true;
						dir = right_dir;
						x += speed/2;
					} else if (left && World.isFree((int) (x-speed), this.getY())) {
						dir = left_dir;
						x -= speed/2;
						Squat = true;
					}

					if (up && World.isFree(this.getX(), (int) (y-speed))) {
						dir = up_dir;
						y -= speed/2;
						Squat = true;
					} else if (down && World.isFree(this.getX(), (int) (y+speed))) {
						Squat = true;
						dir = down_dir;
						y += speed/2;
					}
				}else {
					//ANDAR
					if (right && World.isFree((int) (x+speed), this.getY())) {
						
						moved = true;
						
						dir = right_dir;
						x += speed;
						
						
					} else if (left && World.isFree((int) (x-speed), this.getY())) {
						
						moved = true;
						dir = left_dir;
						x -= speed;
						
						
					}

					if (up && World.isFree(this.getX(), (int) (y-speed))) {
		               
						moved = true;
						dir = up_dir;
						y -= speed;
						
						
					} else if (down && World.isFree(this.getX(), (int) (y+speed))) {
						
						moved = true;
						dir = down_dir;
						y += speed;
						
						
					}
				}
				
			}
			
		}else {
			
			mana -=0.003;
			if (right && World.isFree((int) (x+speed), this.getY())) {
				if(atack2 == true) {
					
				}else {
					
					running = true;
					dir = right_dir;
					x += speed*1.5;
				}
				
				
			} else if (left && World.isFree((int) (x-speed), this.getY())) {
				if(atack2 == true) {
					
				}else {
					
					running = true;
					dir = left_dir;
					x -= speed*1.5;
				}
				
			}

			if (up && World.isFree(this.getX(), (int) (y-speed))) {
				
				running = true;
				dir = up_dir;
				y -= speed*1.5;
			} else if (down && World.isFree(this.getX(), (int) (y+speed))) {
				
				running = true;
				dir = down_dir;
				y += speed*1.5;
			}
		}
		
			
			
		
		
		// Controller Animations
		//CORRER
		if(running == true && up == true || down == true || left == true || right == true) {
			runframes++;
			if (runframes == runmaxFrames) {
				runframes = 0;
				runindex++;
				if (runindex > runmaxIndex) {
					runindex = 0;
					moved = true;
				}
			}
		}else {
			run = false;
		}
		//MOVER E PARADO
		if (moved) {
			frames++;
			if (frames == maxFrames) {
				frames = 0;
				index++;
				if (index > maxIndex) {
					index = 0;
				}
			}
		}if (moved == false) {
			Stopframes++;
			if (Stopframes == StopmaxFrames) {
				Stopframes = 0;
				Stopindex++;
				if (Stopindex > StopmaxIndex) {
					Stopindex = 0;
				}
			}
		}
		//AGACHAR
		if (Squat) {
			squatframes++;
			if (squatframes == squatmaxFrames) {
				squatframes = 0;
				squatindex++;
				if (squatindex > squatmaxIndex) {
					squatindex = 0;
				}
			}
		}else if(SquatStop == true) {
			StopSquatframes++;
			if (StopSquatframes == StopSquatmaxFrames) {
				StopSquatframes = 0;
				StopSquatindex++;
				if (StopSquatindex > StopSquatmaxIndex) {
					StopSquatindex = 0;
				}
			}
		}
		//ATAQUES
		if (atacando == true) {
			atkframes++;
			
			if (atkframes == atkmaxFrames) {
				atkframes = 0;
				atkindex++;
				
				if(atkindex == 4) {
					if(atack2 == true) {
						run = false;
						
					}
					EndPunch = true;
				}
				if (atkindex > atkmaxIndex) {
					atkindex = 0;
					atack1 = false;
					atack2 = false;
					
					
					atacando = false;
					
				}
			}
		}else {
			
		}
		//INICIALIZAR METODOS

		this.checkCollisionAmmo();
		this.checkCollisionWeapon();
		this.checkCollisionLifePack();
		 
		this.CheckCollisionSwtchEvents();
		this.CheckCollisionEntityColision();
		this.CheckCollisionEntityColision2();
		this.CheckCollisionEntityColision3();
		this.CheckCollisionEntityColision4();
		this.CheckCollisionEntityEnemy();
		this.CheckCollisionSWAT();
		this.CheckCollisionNPC();
		//this.CheckCollisionEntityRange();
		
		//this.checkCollisionDropEnemy();

		// Recebendo Animação de Dano
		if (isDamage) {
			this.damageFrames++;
			if (this.damageFrames == 8) {
				this.damageFrames = 0;
				this.isDamage = false;
			}
		}
		/***/

		// Criar bala e atirar com o teclado
	
		if (atack1 == true) {
			atack1 = false;
			NunAtk = 1;
			//GERAR ATAQUE
			//P = POSICION, D = DIRECION	
			int dx2 = 0;
			int px2 = 0;
			int py2 = 12;
			int dy2 = 0;
			//DEBUGS

			if (dir == right_dir) {
				px2 = 10;
				dx2 = 1;
			} else if (dir == left_dir)  {
				px2 = 18;
				dx2 = -1;
			}else if (dir == down_dir)  {
				py2 = 16;
				px2 = 12;
				dx2 = 0;
				dy2 = 1;
			}
			else if (dir == up_dir)  {
				py2 = 20;
				px2 = 12;
				dx2 = 0;
				dy2 = -1;
				
				
			}
			if(dir == left_dir || dir == right_dir)  {
				BulletShoot soco = new BulletShoot(this.getX() + px2, this.getY() + py2, 3, 10, null, dx2, dy2);
				Game.bulletShoot.add(soco);
			}else {
				
				BulletShoot soco = new BulletShoot(this.getX() + px2, this.getY() + py2, 10, 3, null, dx2, dy2);
				Game.bulletShoot.add(soco);
			}
		
			
			
			
			
			
		}
		if (atack2 == true) {
			atack2 = false;
			NunAtk = 2;
			//GERAR ATAQUE
			//P = POSICION, D = DIRECION	
			int dx2 = 0;
			int px2 = 0;
			int py2 = 12;
			int dy2 = 0;
			//DEBUGS

			if (dir == right_dir) {
				px2 = 10;
				dx2 = 1;
			} else if (dir == left_dir)  {
				px2 = 18;
				dx2 = -1;
			}else if (dir == down_dir)  {
				py2 = 16;
				px2 = 12;
				dx2 = 0;
				dy2 = 1;
			}
			else if (dir == up_dir)  {
				py2 = 20;
				px2 = 12;
				dx2 = 0;
				dy2 = -1;
				
				
			}
			if(dir == left_dir || dir == right_dir)  {
				BulletShoot2 soco2 = new BulletShoot2(this.getX() + px2, this.getY() + py2, 6, 10, null, dx2, dy2);
				Game.bulletShoot2.add(soco2);
			}else {
				
				BulletShoot2 soco2 = new BulletShoot2(this.getX() + px2, this.getY() + py2, 10, 6, null, dx2, dy2);
				Game.bulletShoot2.add(soco2);
			}
		
			
			
			
			
			
		}
		/***/

		// Criar bala e atirar com o mouse
		if (mouseShoot) {
			mouseShoot = false;

			if (hasGun && ammo > 0) {
				ammo--;

				int px = 0;
				int py = 8;
				double angle = 0;
				if (dir == right_dir) {
					px = 18;
					angle = Math.atan2(my - (this.getY() + py - Camera.y), mx - (this.getX() + px - Camera.x));
				} else {
					px = -8;
					angle = Math.atan2(my - (this.getY() + py - Camera.y), mx - (this.getX() + px - Camera.x));
				}
				double dx = Math.cos(angle);
				double dy = Math.sin(angle);

				BulletShoot bulletShoot = new BulletShoot(this.getX() + px, this.getY() + py, 3, 3, null, dx, dy);
				Game.bulletShoot.add(bulletShoot);
			}
		}
		/***/

		// Resetar Game
		if (life <= 0) {
			life = 0;
			Game.gameState = "GAME_OVER";
		}

		// Config Camera
		Camera.x = Camera.clamp(this.getX() - (Game.WIDTH / 2), 11, World.WIDTH * 16 - Game.WIDTH);
		Camera.y = Camera.clamp(this.getY() - (Game.HEIGHT / 2), 16, World.HEIGHT * 16 - Game.HEIGHT);
		
	}

	// Coletar Arma
	public void checkCollisionWeapon() {
		for (int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if (e instanceof Weapon) {
				if (Entity.isCollidding(this, e)) {
					hasGun = true;
					Game.entities.remove(i);
					// return;
				}
			}
		}
	}

	// Coletar balas
	public void checkCollisionAmmo() {
		for (int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if (e instanceof Bullet) {
				if (Entity.isCollidding(this, e)) {
					ammo += 50;
					// System.out.println(ammo);
					if (ammo >= 100) {
						ammo = 100;
					}
					Game.entities.remove(i);
					return;
				}
			}
		}
	}

	// Coletar vida
	public void checkCollisionLifePack() {
		for (int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if (e instanceof Lifepack) {
				if (Entity.isCollidding(this, e) && life < 100) {
					life += 8;
					if (life >= 100) {
						life = 100;
					}
					Game.entities.remove(i);
					return;
				}
			}
		}
	}
   
	public void CheckCollisionSwtchEvents() {
		for(int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			
			if(e instanceof SwtchEvents) {
				//STOP ACTION
				if(EntityColision.isCollidding00(this, e)) {
					if(InEvent == true) {
						InEvent = false;
						SwtchEvents.Swtch = 0;
						Game.player.action = false;
						Game.player.moved = false;
						Game.player.up = false;
						Game.player.down = false;
						Game.player.left = false;
						Game.player.right = false;
					}
					
					
					
				}
				//ACTIONS
				if(SwtchEvents.isCollidding0(this, e)) {
					
						
					
						if(SwtchEvents.SwtchTelhado0 == false) {
							SwtchEvents.SwtchTelhado0 = true;
						}else if(SwtchEvents.SwtchTelhado0 == true){
							SwtchEvents.SwtchTelhado0 = false;
								
								
						}
					
					
						
					if(action == true) {
						SwtchEvents.Swtch = e.ActNum;
						
						SwtchEvents.SwtchAnimation = true;
						if(SwtchEvents.Swtch == 1 || SwtchEvents.Swtch == 3) {
							Game.player.InEvent = true;
						}
						
						
						
					}
					
				}
                if(SwtchEvents.isCollidding(this, e)) {
					
					
					isColliddingWithObjects();

				}if(SwtchEvents.isCollidding2(this, e)) {
					
					
					isColliddingWithObjects();

				}if(SwtchEvents.isCollidding3(this, e)) {
					
					
					isColliddingWithObjects();

				}if(SwtchEvents.isCollidding4(this, e)) {
					
					
					isColliddingWithObjects();

				}if(SwtchEvents.isCollidding5(this, e)) {
					
					
					isColliddingWithObjects();

				}if(SwtchEvents.isCollidding6(this, e)) {
					
					
					isColliddingWithObjects();

				}
				if(SwtchEvents.Depth(this, e)) {
					Camada1 = true;
					
					if(Camada1 == true) {
						depth = 1;
					}
	
				}if(SwtchEvents.Depth2(this, e)) {
					Camada1 = true;
					
					if(Camada1 == true) {
						
						depth = 1;
					}

	
				}
				if(SwtchEvents.Depth3(this, e)) {
					Camada1 = true;
					
					if(Camada1 == true) {
						depth = 1;
					}
	
				}
				if(!(SwtchEvents.Depth(this, e))) {
					
				}
			}
		}
	}
	
				
	public void CheckCollisionEntityColision() {
		for(int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			
			if(e instanceof EntityColision) {
				if(EntityColision.isCollidding00(this, e)) {
					System.out.println("aaaaaaaaaaaaa");
					InEvent = false;
					SwtchEvents.Swtch = 0;
					
				}
				if(EntityColision.isCollidding0(this, e)) {
					if(action == true) {
						SwtchEvents.Swtch = e.ActNum;
						//action = false;
						
					}
					
				}
				
				if(EntityColision.isCollidding(this, e)) {
					
					
					isColliddingWithObjects();

				}if(EntityColision.isCollidding2(this, e)) {
					
					
					isColliddingWithObjects();

				}if(EntityColision.isCollidding3(this, e)) {
					
					
					isColliddingWithObjects();

				}if(EntityColision.isCollidding4(this, e)) {
					
					
					isColliddingWithObjects();

				}if(EntityColision.isCollidding5(this, e)) {
					
					
					isColliddingWithObjects();

				}if(EntityColision.isCollidding6(this, e)) {
					
					
					isColliddingWithObjects();

				}
				if(EntityColision.Depth(this, e)) {
					Camada1 = true;
					
					if(Camada1 == true) {
						depth = 1;
					}
	
				}if(EntityColision.Depth2(this, e)) {
					Camada1 = true;
					
					if(Camada1 == true) {
						
						depth = 1;
					}

	
				}
				if(EntityColision.Depth3(this, e)) {
					Camada1 = true;
					
					if(Camada1 == true) {
						depth = 1;
					}
	
				}
				if(!(EntityColision.Depth(this, e))) {
					
				}
					
				
				
			}
		}
	}public void CheckCollisionEntityColision2() {
		for(int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			
			if(e instanceof EntityColision2) {
				
                if(EntityColision2.isCollidding(this, e)) {
					
					
					isColliddingWithObjects();

				}if(EntityColision2.isCollidding2(this, e)) {
					
					
					isColliddingWithObjects();

				}if(EntityColision2.isCollidding3(this, e)) {
					
					
					isColliddingWithObjects();

				}if(EntityColision2.isCollidding4(this, e)) {
					
					
					isColliddingWithObjects();

				}if(EntityColision2.isCollidding5(this, e)) {
					
					
					isColliddingWithObjects();

				}if(EntityColision2.isCollidding6(this, e)) {
					
					
					isColliddingWithObjects();

				}
			if(EntityColision2.Depth2(this, e)) {
				Camada2 = true;
				if(Camada1 == true) {
					//depth = 1;
					
				}if(Camada2 == true){
					depth = 2;
					
					
				}

	
				}
				if(EntityColision2.Depth3(this, e)) {
					Camada2 = true;
					if(Camada1 == true) {
						//depth = 1;
						
					}if(Camada2 == true){
						depth = 2;
						
					}
	
				}
				if(EntityColision2.Depth(this, e)) {
					
					Camada2 = true;
					if(Camada1 == true) {
						//depth = 1;
						
					}if(Camada2 == true){
						depth = 2;
						
					}
					
					
	
				}
				
			}
			
		}
	}public void CheckCollisionEntityRange() {
		for(int i = 0; i < Game.entities.size(); i++) {
            Entity e = Game.entities.get(i);
			
			if(e instanceof Enemy3) {
				
				if(Enemy3.Range(e, this)) {
					
					
					

				}
				
					
				
				
			}
		}
			
		
	}
	public void CheckCollisionEntityColision3() {
		for(int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			
			if(e instanceof EntityColision3) {
				
				if(EntityColision3.isCollidding(this, e)) {
					
					
					isColliddingWithObjects();

				}
				if(EntityColision3.Depth(this, e)) {
					
					Camada3 = true;
					if(Camada1 == true) {
						//depth = 1;
						
					}if(Camada2 == true){
						//depth = 2;
						
					}if(Camada3 == true){
						depth = 4;
						
					}
					 
					 
					
					
	
				}
				
			}
			
		}
	}public void CheckCollisionEntityColision4() {
		for(int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			
			if(e instanceof EntityColision4) {
				
				if(EntityColision4.isCollidding(this, e)) {
					
					
					isColliddingWithObjects();

				}
				if(EntityColision4.Depth(this, e)) {
					
					Camada4 = true;
					if(Camada1 == true) {
						//depth = 1;
						
					}if(Camada2 == true){
						//depth = 2;
						
					}if(Camada4 == true){
						depth = 5;
						
					}
					 
					 
					
					
	
				}
				
			}
			
		}
	}public void CheckCollisionEntityEnemy() {
		for (int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if (e instanceof Enemy) {
				if (Entity.isCollidding(this, e)){
					
					
					 
						
					
					
				}else {
					
				}
				
				
			}
		}
	}public void CheckCollisionSWAT() {
		for(int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			
			if(e instanceof Enemy3) {
				
				if(Enemy3.isCollidding(this, e)) {
					
					
					isColliddingWithObjects();

				}
				if(Enemy3.Depth(this, e)) {
					Camada1 = true;
					
					if(Camada1 == true) {
						depth = 1;
					}
					
				
					
	
				}
				if(!(Enemy3.Depth(this, e))) {
					
				}
					
				
				
			}
		}
	}public void CheckCollisionNPC() {
		for(int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			
			if(e instanceof NPC) {
				
				if(NPC.isCollidding(this, e)) {
					
					
					isColliddingWithObjects();

				}
				if(NPC.Depth(this, e)) {
					Camada1 = true;
					
					if(Camada1 == true) {
						depth = 1;
					}
					
				
					
	
				}
				if(!(NPC.Depth(this, e))) {
					
				}
					
				
				
			}
		}
	}

	public void render(Graphics g) {
		
		// Ativar o player no JFrame, flip
		if (!isDamage) {
			//SPRITES DE MOVIMENTOS
			if(run == true) {
				if (dir == up_dir) {
                    if(atacando == true) {
			    		
		        		g.drawImage(Punch2upPlayer[atkindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
		        	}else {
		        		g.drawImage(RunupPlayer[runindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
		        	}
					
				}else if (dir == down_dir) {
                    if(atacando == true) {
			    		
		        		g.drawImage(Punch2downPlayer[atkindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
		        	}else {
		        		g.drawImage(RundownPlayer[runindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
		        	}
					
				}else if (dir == left_dir) {
					if(atacando == true) {
			    		
		        		g.drawImage(Punch2leftPlayer[atkindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
		        	}else {
		        		g.drawImage(RunleftPlayer[runindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
		        	}
					
				}else if (dir == right_dir) {
                    if(atacando == true) {
			    		
		        		g.drawImage(Punch2rightPlayer[atkindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
		        	}else {
		        		g.drawImage(RunrightPlayer[runindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
		        	}
					
					
				}
			}else {
				if(Squat == true) {
					if (dir == up_dir) {
						g.drawImage(SquatupPlayer[squatindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
					}
					if (dir == down_dir) {
						g.drawImage(SquatdownPlayer[squatindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
					}
					if (dir == left_dir) {
						g.drawImage(SquatleftPlayer[squatindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
					}
					if (dir == right_dir) {
						g.drawImage(SquatrightPlayer[squatindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
					}
				}else {
					if(moved == true) {
						
						if (dir == up_dir) {
		                    if(atacando == true) {
					    		
				        		g.drawImage(PunchupPlayer[atkindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				        	}else {
				        		g.drawImage(upPlayer[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
								   if (hasGun) {
									// Renderizar Arma na Direita
									g.drawImage(Entity.GUN_RIGHT, this.getX() + 7 - Camera.x, this.getY() - Camera.y, null);
								   }
				        	}
		   
					    }else if (dir == down_dir) {
					    	if(atacando == true) {
					    		
				        		g.drawImage(PunchdownPlayer[atkindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				        	}else {
				        		g.drawImage(downPlayer[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
								if (hasGun) {
									// Renderizar Arma na Direita
									g.drawImage(Entity.GUN_RIGHT, this.getX() + 7 - Camera.x, this.getY() - Camera.y, null);
							    }
				            }
						
						   
				        }else if(dir == left_dir) {
							//Desenha o sprite na posição atual
				        	if(atacando == true) {
				        		g.drawImage(PunchleftPlayer[atkindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				        	}else {
				        		g.drawImage(leftPlayer[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
								if (hasGun) {
									// Renderizar Arma na Esquerda
									g.drawImage(Entity.GUN_LEFT, this.getX() - 7 - Camera.x, this.getY() - Camera.y, null);
								
								}
				        		
				        	}
							
								
						}else if (dir == right_dir) {
							
							if(atacando == true) {
				        		g.drawImage(PunchrightPlayer[atkindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				        	}else {
				        		g.drawImage(rightPlayer[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
								if (hasGun) {
									// Renderizar Arma na Esquerda
									g.drawImage(Entity.GUN_LEFT, this.getX() - 7 - Camera.x, this.getY() - Camera.y, null);
								
								}
				        		
				        	}
					    }
					//SPRITE PARADO	
				    }else if(SquatStop == true) {
				    	if (dir == up_dir) {
				    		if(atacando == true) {
				        		g.drawImage(PunchupPlayer[atkindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				        	}else {
				        		g.drawImage(StopSquatupPlayer[Stopindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				        	}
				    		
				    	}if (dir == down_dir) {
				    		if(atacando == true) {
				        		g.drawImage(PunchdownPlayer[atkindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				        	}else {
				        		g.drawImage(StopSquatdownPlayer[Stopindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				        	}
				    		
				    	}if (dir == left_dir) {
				    		if(atacando == true) {
				        		g.drawImage(PunchleftPlayer[atkindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				        	}else {
				        		g.drawImage(StopSquatleftPlayer[Stopindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				        	}
				    		
				    	}if (dir == right_dir) {
				    		if(atacando == true) {
				        		g.drawImage(PunchrightPlayer[atkindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				        	}else {
				        		g.drawImage(StopSquatrightPlayer[Stopindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				        	}
				    		
				    	}
				    
				    }else if(moved == false){
				    	if (dir == up_dir) {
				    		if(atacando == true) {
				    			g.drawImage(PunchupPlayer[atkindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				    		}else {
				    			g.drawImage(StopupPlayer[Stopindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				    		}
				    		
				    	}else if (dir == down_dir) {
				    		if(atacando == true) {
				    			g.drawImage(PunchdownPlayer[atkindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				    		}else {
				    			g.drawImage(StopdownPlayer[Stopindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				    		}
				    		
				    	}
				    	else if(dir == right_dir) {
				    		if(atacando == true) {
				        		g.drawImage(PunchrightPlayer[atkindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				        	}else {
				        		g.drawImage(StoprightPlayer[Stopindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				        	}
				    		
				    	}
				    	else if (dir == left_dir) {
				    		if(atacando == true) {
				        		g.drawImage(PunchleftPlayer[atkindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				        	}else {
				        		g.drawImage(StopleftPlayer[Stopindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
				        		
				        	}
				    		
				    	}
						
					}
				}
				
			}
			

			

			
		} else {
			g.drawImage(playerDamage, this.getX() - Camera.x, this.getY() - Camera.y, null);
			if (hasGun) {
				if (dir == left_dir) {
					g.drawImage(Entity.GUN_DAMAGE_LEFT, this.getX() - 7 - Camera.x, this.getY() - Camera.y, null);
				} else {
					g.drawImage(Entity.GUN_DAMAGE_RIGHT, this.getX() + 7 - Camera.x, this.getY() - Camera.y, null);
				}
			}
		}
		g.setColor(Color.green);
		
		//sg.fillRect(this.getX() + maskx - Camera.x, this.getY()+ masky - Camera.y, mwidth, mheight);
		//g.fillRect(this.getX() + depthX - Camera.x, this.getY()+ depthY - Camera.y, mwidthDepth, mheightDepth);
	}

}
