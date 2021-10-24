package com.MayronStudios.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.MayronStudios.entities.NPC;
import com.MayronStudios.entities.Bullet;
import com.MayronStudios.entities.Enemy;
import com.MayronStudios.entities.Enemy2;
import com.MayronStudios.entities.Enemy3;
import com.MayronStudios.entities.Entity;
import com.MayronStudios.entities.Lifepack;
import com.MayronStudios.entities.Player;
import com.MayronStudios.entities.Weapon;
import com.MayronStudios.graficos.Spritesheet;
import com.MayronStudios.main.Game;
import com.MayronStudios.main.SwtchEvents;

public class World {
	
	public static Tile[] tiles;
	public static int WIDTH, HEIGHT;
	public static final int TILE_SIZE = 16;

	public World(String path) {
		try {
			BufferedImage map = ImageIO.read(getClass().getResource(path));
			//Calcular os pixels do mapa
			int[] pixels = new int[map.getWidth() * map.getHeight()];
			WIDTH = map.getWidth();
			HEIGHT = map.getHeight();
			tiles = new Tile[map.getWidth() * map.getHeight()];
			
			map.getRGB(0, 0, map.getWidth(), map.getHeight(), pixels, 0, map.getWidth());
			
			for(int xx = 0; xx<map.getWidth(); xx++) {
				for(int yy = 0; yy<map.getHeight(); yy++) {
					
					int pixelAtual = pixels[xx +(yy * map.getWidth())];
					tiles[xx+(yy * WIDTH)] = new FloorTile(xx*16, yy*16, Tile.TILE_FLOOR);
					
					if(pixelAtual == 0xFFffffff) {
						//Floor
						EntityColision col = new EntityColision(xx*16-5, yy*16, 16, 16, Tile.TILE_FLOOR);
						col.setMask(0,0,16,16);
						Game.entities.add(col );
					}else if(pixelAtual == 0xFF693e3e){
						//Bullet
						Entity MAPA = new Entity(xx*16, yy*16, 16, 16, Entity.MAPA_EN);
						EntityColision QUARTOWALL = new EntityColision(172, 222, 16, 16, Entity.QUARTOWALL_EN);
						EntityColision QUARTOWALL1 = new EntityColision(180, 150, 16, 16, Entity.QUARTOWALL1_EN);
						EntityColision QUARTOWALL2 = new EntityColision(180, 51, 16, 16, Entity.QUARTOWALL2_EN);
						EntityColision QUARTOWALL3 = new EntityColision(269, 255, 16, 16, Entity.QUARTOWALL3_EN);
						QUARTOWALL1.setDepth(0, 0, 144, 20);
						QUARTOWALL.setDepth(0, 0, 104, 22);
						QUARTOWALL.setMask3(8, -38, 6, 1);
						
						QUARTOWALL.setMask5(131, -38, 20, 1);
						QUARTOWALL.setMask(27, -38, 90, 1);
						QUARTOWALL.setAct(125, -5, 27, 4, 4);
						QUARTOWALL.setMask3(123, -5, 3, 35);
						QUARTOWALL.setMask4(125, -1, 27, 1);
						QUARTOWALL2.setMask(27, -38, 90, 1);
						QUARTOWALL1.setMask(144, -60, 1, 200);
						QUARTOWALL1.setMask2(115, 101, 28, 1);
						
						QUARTOWALL.setMask2(27, 0, 69, 1);
						Game.entities.add(MAPA);
						Game.entities.add(QUARTOWALL);
						Game.entities.add(QUARTOWALL1);
						Game.entities.add(QUARTOWALL2);
						Game.entities.add(QUARTOWALL3);
						
					}
					else if(pixelAtual == 0xFFFFFFFF) {
						//Wall
						tiles[xx+(yy * WIDTH)] = new WallTile(xx*16, yy*16, Tile.TILE_WALL);
					} else if(pixelAtual == 0xFF0026FF) {
						//Player
						Game.player.setX(xx*16);
						Game.player.setY(yy*16);
					}
					
					//Objs Game
                    else if(pixelAtual == 0xFF3b3b3b) {
						
						EntityColision2 poste = new EntityColision2(xx*16-5, yy*16, 16, 16, Entity.POSTE_EN);
						poste.setMask(6,10,3,4);
						poste.setDepth(6, 0, 3, 1);
						Game.entities.add(poste );
						
					}else if(pixelAtual == 0xFF293635) {
						
						EntityColision2 poste1 = new EntityColision2(xx*16, yy*16, 16, 16, Entity.POSTE1_EN);
						poste1.setMask(7,40,3,4);
						poste1.setDepth(4, 10, 16, 33);
						Game.entities.add(poste1);
						
					}else if(pixelAtual == 0xFF666666) {
						
						EntityColision2 poste = new EntityColision2(xx*16-5, yy*16, 16, 16, Entity.CERCA_EN);
						poste.setMask(0,29,160,4);
						poste.setDepth(0, 10, 160, 12);
						Game.entities.add(poste );
						
					}else if(pixelAtual == 0xFF666667) {
						
						EntityColision2 poste = new EntityColision2(xx*16-5, yy*16, 16, 16, Entity.CERCA1_EN);
						poste.setMask(16,29,10,4);
						poste.setDepth(0, 10, 32, 16);
						Game.entities.add(poste );
						
					}else if(pixelAtual == 0xFF66665a) {
						
						EntityColision poste = new EntityColision(xx*16-5, yy*16-14, 16, 16, Entity.CERCA2_EN);
						poste.setMask(1,28,2,84);
						poste.setDepth(0, 6, 3, 90);
						Game.entities.add(poste);
						
					}else if(pixelAtual == 0xFF001252) {
						
						EntityColision CASA = new EntityColision(xx*16, yy*16, 16, 16, Entity.HOUSE_EN);
						EntityColision2 CASApt2 = new EntityColision2(xx*16, yy*16 + 16*7-1, 16, 16, Entity.HOUSEPT2_EN);
						
						CASA.setMask(7,28,116,74);
						CASA.setMask2(7,119,42,8);
						CASA.setMask3(81,119,42,8);
						CASA.setMask4(121,100,2,16);
						CASA.setMask5(7,100,2,16);
						
						CASA.setDepth(4, 13, 121, 68);
						
						CASApt2.setDepth(9, 0,38, 1);
						CASApt2.setDepth2(83, 0,38, 1);
						CASApt2.setMask(0,0,0,0);
						Game.entities.add(CASA);
						Game.entities.add(CASApt2);
						
						
					}
					//QUART0
                    else if(pixelAtual == 0xFF8f3c00) {
						
						
						
					}
                     else if(pixelAtual == 0xFF9c0085) {
                    	EntityColision cama2 = new EntityColision(xx*16+2, yy*16-240, 16, 16, Entity.CAMA2_EN);
                        EntityColision GUARDAROUPA = new EntityColision(xx*16+55, yy*16-246, 16, 16, Entity.GUARDA_ROUPA_EN);
                    	EntityColision PRIVADA = new EntityColision(xx*16+134, yy*16-190, 16, 16, Entity.PRIVADA_EN);
						EntityColision cama = new EntityColision(xx*16, yy*16, 16, 16, Entity.CAMA_EN);
						EntityColision CADEIRA = new EntityColision(xx*16+60, yy*16-10, 16, 16, Entity.CADEIRA_EN);
						EntityColision Mesinha = new EntityColision(xx*16+70, yy*16, 16, 16, Entity.MESINHA_EN);
						EntityColision plantinha = new EntityColision(xx*16+60, yy*16-130, 16, 16, Entity.PLANTA1_EN);
						EntityColision plantinha3 = new EntityColision(xx*16+30, yy*16-130, 16, 16, Entity.PLANTA_EN);
						EntityColision plantinha2 = new EntityColision(xx*16+90, yy*16-130, 16, 16, Entity.PLANTA_EN);
						plantinha.setMask(3,9,10,5);
						plantinha.setMask(26,-94,8,100);
						plantinha2.setMask(3,9,10,5);
						plantinha3.setMask(3,9,10,5);
						Mesinha.setMask(3,3,10,10);
						PRIVADA.setMask(3,11,8,3);
						PRIVADA.setDepth(3,0,12,1);
						Mesinha.setDepth(3, 0, 10, 1);
						CADEIRA.setMask(5,7,7,5);
						CADEIRA.setDepth(4, -5, 8, 1);
						cama.setMask(5,12,22,12);
						cama2.setMask(4,13,25,24);
						cama.setDepth(6, 7, 20, 1);
						GUARDAROUPA.setMask(4,22,24,10);
						Game.entities.add(cama);
						Game.entities.add(GUARDAROUPA);
						Game.entities.add(cama2);
						Game.entities.add(CADEIRA);
						Game.entities.add(PRIVADA);
						Game.entities.add(Mesinha);
						Game.entities.add(plantinha);
						Game.entities.add(plantinha2);
						Game.entities.add(plantinha3);
						
					}else if(pixelAtual == 0xFF9c0084) {
						
						SwtchEvents penteadeira = new SwtchEvents(xx*16+5, yy*16+8, 16, 16, Entity.PENTEADEIRA_EN);
						penteadeira.setMask(5,28,23,4);
						penteadeira.setMask2(32,-06,9,102);
						penteadeira.setMask5(-48,95,80,1);
						penteadeira.setMask4(-50,-47,1,143);
						penteadeira.setMask3(-29,26,61,1);
						penteadeira.setAct(5, 32, 23, 5, 2);
						
						
						
						
						Game.entities.add(penteadeira);
						
					}else if(pixelAtual == 0xFF9c0086) {
						SwtchEvents porta = new SwtchEvents(xx*16-8, yy*16+15, 16, 16, Entity.PORTA_EN);
						SwtchEvents porta2 = new SwtchEvents(xx*16-8, yy*16-60, 16, 16, Entity.PORTA_EN);
						porta2.setAct(7, 20, 1, 5, 3);
						porta2.setStopAct(2, -22, 12, 1);
						porta.setAct(7, 20, 1, 5, 1);
						porta.setStopAct(2, -22, 12, 1);
						
						
						Game.entities.add(porta);
						Game.entities.add(porta2);
						
						EntityColision penteadeira = new EntityColision(xx*16+7, yy*16+8, 16, 16, Entity.ESTANTE_EN);
						penteadeira.setMask(5,28,19,4);
						penteadeira.setMask2(-19,26,4,1);
						penteadeira.setMask3(0,-8,1,30);
						Game.entities.add(penteadeira);
						
					}
					
					
					else if(pixelAtual == 0xFF313354) {
						
						EntityColision3 store = new EntityColision3(xx*16, yy*16, 16, 16, Entity.STORE1_EN);
						store.setMask(9,25,69,46);
						store.setDepth(7, 18, 75, 30);
						Game.entities.add(store);
						
					}
					else if(pixelAtual == 0xFF0d6e00) {
						
						EntityColision tree = new EntityColision(xx*16+8, yy*16, 16, 16, Entity.TREE_EN);
						tree.setMask(26,50,12,9);
						tree.setDepth(3, 2, 58, 36);
						Game.entities.add(tree);
						
					}else if(pixelAtual == 0xFF338000) {
						
						EntityColision3 tree = new EntityColision3(xx*16, yy*16, 16, 16, Entity.TREE1_EN);
						tree.setMask(26,50,6,7);
						tree.setDepth(3, 7, 48, 34);
						Game.entities.add(tree);
						
					}else if(pixelAtual == 0xFF7a4b37) {
						
						EntityColision3 tree2 = new EntityColision3(xx*16, yy*16, 16, 16, Entity.TREE2_EN);
						tree2.setMask(6,25,4,4);
						tree2.setDepth(2, 6, 10, 12);
						Game.entities.add(tree2);
						
					}
					
					else if(pixelAtual == 0xFFb0815d) {
						
						EntityColision3 car = new EntityColision3(xx*16-3, yy*16+4, 16, 16, Entity.CAR0_EN);
						car.setMask(8,11,62,16);
						car.setDepth(7, 0, 69, 16);
						Game.entities.add(car);
						
						
					}
					else if(pixelAtual == 0xFFFF6A00){
						//Weapon
						Game.entities.add(new Weapon(xx*16, yy*16, 16, 16, Entity.WEAPON_EN));
					} else if(pixelAtual == 0xFFFF7F7F){
						//Life Pack
						Lifepack lifePack = new Lifepack(xx*16, yy*16, 16, 16, Entity.LIFEPACK_EN);
						//lifePack.setMask(8, 8, 8, 8);
						Game.entities.add(lifePack);
						
					} else if(pixelAtual == 0xFFFFD800){
						//Bullet
						Game.entities.add(new Bullet(xx*16, yy*16, 16, 16, Entity.BULLET_EN));
					}else if(pixelAtual == 0xFFFF0000){
						//Enemy
						
						Enemy enemyObj = new Enemy(xx*16, yy*16, 16, 16, Entity.ENEMY_EN);
						Game.entities.add(enemyObj);
						Game.enemies.add(enemyObj);
						
						 
					}else if(pixelAtual == 0xFFFF0001){
						//Enemy3b0001
						
						Enemy2 enemyObj = new Enemy2(xx*16, yy*16, 16, 16, Entity.ENEMY_EN);
						Game.entities.add(enemyObj);
						Game.enemies2.add(enemyObj);
						
						 
					}
					else if(pixelAtual == 0xFF3b0001){
						//EnemySWAT
						
						Enemy3 SWAT = new Enemy3(xx*16, yy*16, 16, 16, Entity.ENEMY_EN);
						Game.entities.add(SWAT);
						Game.SWAT.add(SWAT);
						
						
						 
					}
					else if(pixelAtual == 0xFF730063) {
						
						NPC npc = new NPC(xx*16, yy*16, 16, 8, NPC.NPC_NPC);
						npc.setMask(11,22,11,6);
						
						
						npc.setDepth(10, 4, 12, 6);
						Game.entities.add(npc);
						
						
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean isFree(int xnext, int ynext) {
		int x1 = xnext / TILE_SIZE;
		int y1 = ynext / TILE_SIZE;
		
		int x2 = (xnext+TILE_SIZE-1) / TILE_SIZE;
		int y2 = ynext / TILE_SIZE;
		
		int x3 = xnext / TILE_SIZE;
		int y3 = (ynext+TILE_SIZE-1) / TILE_SIZE;
		
		int x4 = (xnext+TILE_SIZE-1) / TILE_SIZE;
		int y4 = (ynext+TILE_SIZE-1) / TILE_SIZE;
		
		return !(tiles[x1 + (y1*World.WIDTH)] instanceof WallTile || 
				tiles[x2 + (y2*World.WIDTH)] instanceof WallTile || 
				tiles[x3 + (y3*World.WIDTH)] instanceof WallTile || 
				tiles[x4 + (y4*World.WIDTH)] instanceof WallTile);
	}
	
	public static void restartGame(String level) {
		Game.entities.clear();
		Game.enemies.clear();
		Game.entities = new ArrayList<Entity>();
		Game.enemies = new ArrayList<Enemy>();
		Game.spritesheet = new Spritesheet("/spritesheet.png");
		Game.player = new Player(0, 0, 32, 32, Game.spritesheet.getSprite(32, 0, 32, 32));
		Game.entities.add(Game.player);
		Game.world = new World("/"+level);
		return;
	}
	
	public void render(Graphics g) {
		
		int xstart = Camera.x >> 4;
		int ystart = Camera.y >> 4;
		
		int xfinal = xstart + (Game.WIDTH >> 4);
		int yfinal = ystart + (Game.HEIGHT >> 4);
		
		for(int xx = xstart; xx <= xfinal; xx++) {
			for(int yy = ystart; yy <= yfinal; yy++) {
				if(xx < 0 || yy < 0 || xx >= WIDTH || yy >= HEIGHT) {
					continue;
				}
				Tile tile = tiles[xx + (yy*WIDTH)];
				tile.render(g);
			}
		}
	}
}
