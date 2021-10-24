package com.MayronStudios.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.MayronStudios.entities.NPC;
import com.MayronStudios.entities.Bullet;
import com.MayronStudios.entities.Enemy;
import com.MayronStudios.entities.Entity;
import com.MayronStudios.entities.Lifepack;
import com.MayronStudios.entities.Player;
import com.MayronStudios.entities.Weapon;
import com.MayronStudios.graficos.Spritesheet;
import com.MayronStudios.main.Game;

public class World2 {
	
	public static Tile[] tiles;
	public static int WIDTH, HEIGHT;
	public static final int TILE_SIZE = 16;

	public World2(String path) {
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
						Game.entities.add(MAPA);
						
					}else if(pixelAtual == 0xFF693e2e){
						//Bullet
						EntityColision2 MAPAL1 = new EntityColision2(xx*16-16, yy*16, 16, 16, Entity.MAPALAYER1_EN);
						Game.entities.add(MAPAL1);
						
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
                    else if(pixelAtual == 0xFF319c00) {
						
						EntityColision3 Grass = new EntityColision3(xx*16, yy*16-4, 16, 16, Entity.GRASS_EN);
						Grass.setMask(0,0,0,0);
						Grass.setDepth(7, 6, 20, 6);
						Game.entities.add(Grass);
						
					}
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
						
						EntityColision poste = new EntityColision(xx*16-5, yy*16, 16, 16, Entity.CERCA_EN);
						poste.setMask(0,29,160,4);
						poste.setDepth(0, 6, 160, 16);
						Game.entities.add(poste );
						
					}else if(pixelAtual == 0xFF666667) {
						
						EntityColision poste = new EntityColision(xx*16-5, yy*16, 16, 16, Entity.CERCA1_EN);
						poste.setMask(16,29,10,4);
						poste.setDepth(0, 6, 32, 16);
						Game.entities.add(poste );
						
					}else if(pixelAtual == 0xFF66665a) {
						
						EntityColision poste = new EntityColision(xx*16-5, yy*16-14, 16, 16, Entity.CERCA2_EN);
						poste.setMask(1,28,2,84);
						poste.setDepth(16, 6, 5, 112);
						Game.entities.add(poste );
						
					}else if(pixelAtual == 0xFF313354) {
						
						EntityColision2 store = new EntityColision2(xx*16, yy*16, 16, 16, Entity.STORE1_EN);
						store.setMask(9,25,69,46);
						store.setDepth(7, 5, 75, 43);
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
						
						EntityColision2 tree2 = new EntityColision2(xx*16, yy*16, 16, 16, Entity.TREE2_EN);
						tree2.setMask(6,25,4,4);
						tree2.setDepth(2, 6, 10, 12);
						Game.entities.add(tree2);
						
					}else if(pixelAtual == 0xFF338001) {
						
						EntityColision4 tree4 = new EntityColision4(xx*16, yy*16, 16, 16, Entity.TREE1_EN);
						tree4.setMask(26,50,6,7);
						tree4.setDepth(3, 7, 48, 34);
						Game.entities.add(tree4);
						
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
						
						 
					} else if(pixelAtual == 0xFF730063) {
						
						NPC npc = new NPC(xx*16, yy*16, 16, 8, NPC.NPC_NPC);
						npc.setMask(4,10,8,6);
						
						
						npc.setDepth(0, 0, 12, 2);
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
		
		return !(tiles[x1 + (y1*World2.WIDTH)] instanceof WallTile || 
				tiles[x2 + (y2*World2.WIDTH)] instanceof WallTile || 
				tiles[x3 + (y3*World2.WIDTH)] instanceof WallTile || 
				tiles[x4 + (y4*World2.WIDTH)] instanceof WallTile);
	}
	
	public static void restartGame(String level) {
		Game.entities.clear();
		Game.enemies.clear();
		Game.entities = new ArrayList<Entity>();
		Game.enemies = new ArrayList<Enemy>();
		Game.spritesheet = new Spritesheet("/spritesheet.png");
		Game.player = new Player(0, 0, 32, 32, Game.spritesheet.getSprite(32, 0, 32, 32));
		Game.entities.add(Game.player);
		Game.world2 = new World2("/"+level);
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
