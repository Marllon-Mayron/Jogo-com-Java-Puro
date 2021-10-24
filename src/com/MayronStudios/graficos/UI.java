package com.MayronStudios.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.MayronStudios.entities.NPC;
import com.MayronStudios.entities.Player;
//import com.arcastudio.entities.Player;
import com.MayronStudios.main.Game;
import com.MayronStudios.world.Camera;

public class UI {
	public static BufferedImage heart;
	public static BufferedImage heart2;
	public static BufferedImage heart3;
	public static BufferedImage heartlocal;
	public static BufferedImage questlocal;
	public static BufferedImage mana1;
	public static BufferedImage mana2;
	public static BufferedImage mana3;
	
	public static BufferedImage seen;
	public static BufferedImage Notseen;
	
	
	public static BufferedImage BallonMessage;
	public static BufferedImage TimeMessage;
	public static BufferedImage HubMold;
	public static BufferedImage HubWorld;
	
	public static BufferedImage PlayerHubLeft;
	public static BufferedImage PlayerHubLeft1;
	
	public static BufferedImage PlayerHubRight;
	public static BufferedImage PlayerHubRight1;
	
	
	
	public static BufferedImage Npc1HubLeft;
	public static BufferedImage Npc1HubLeft1;
	public static BufferedImage Npc1HubLeft2;
	
	public static BufferedImage Npc1HubRight;
	public static BufferedImage Npc1HubRight1;
	public static BufferedImage Npc1HubRight2;
	
	public static Spritesheet spritesheetUi;
	public static Spritesheet spritesheetHubs;
	
	
	
	public UI(){
		spritesheetUi = new Spritesheet("/spritesheetUi.png");
		spritesheetHubs = new Spritesheet("/spritesheetNpcHub.png");
		seen = spritesheetUi.getSprite(48, 32, 16, 16);
		Notseen = spritesheetUi.getSprite(64, 32, 16, 16);
		heart = spritesheetUi.getSprite(0, 0, 16, 16);
		heart2 = spritesheetUi.getSprite(16, 0, 16, 16);
		heart3 = spritesheetUi.getSprite(32, 0, 16, 16);
		
		mana1 = spritesheetUi.getSprite(32, 16, 16, 16);
		mana2 = spritesheetUi.getSprite(48, 16, 16, 16);
		mana3 = spritesheetUi.getSprite(64, 16, 16, 16);
		
		heartlocal = spritesheetUi.getSprite(48, 0, 48, 16);
		questlocal = spritesheetUi.getSprite(48, 32, 32, 32);
		
		BallonMessage = spritesheetHubs.getSprite(0, 32, 144, 48);
		TimeMessage = spritesheetHubs.getSprite(16, 80, 112, 16);
		HubMold = spritesheetHubs.getSprite(144, 32, 38, 38);
		HubWorld = spritesheetUi.getSprite(160, 0, 32, 32);
		
		PlayerHubRight = spritesheetHubs.getSprite(192, 0, 32, 32);
		PlayerHubRight1 = spritesheetHubs.getSprite(224, 0, 32, 32);
		
		PlayerHubLeft = spritesheetHubs.getSprite(320, 0, 32, 32);
		PlayerHubLeft1 = spritesheetHubs.getSprite(352, 0, 32, 32);
		
		Npc1HubLeft = spritesheetHubs.getSprite(192, 32, 32, 48);
		Npc1HubLeft1 = spritesheetHubs.getSprite(192+32, 32, 32, 48);
		Npc1HubLeft2= spritesheetHubs.getSprite(192+64, 32, 32, 48);
		
		Npc1HubRight = spritesheetHubs.getSprite(288, 32, 32, 48);
		Npc1HubRight1 = spritesheetHubs.getSprite(288+32, 32, 32, 48);
		Npc1HubRight2 = spritesheetHubs.getSprite(288+64, 32, 32, 48);
		
	}
	public void render(Graphics g) {
		if(Player.Showseen == true) {
			if(Game.player.seen == true) {
				
				g.drawImage(seen, Game.player.getX() - Camera.x + 8, Game.player.getY() - Camera.y -8, null);
			}else {
				
				g.drawImage(Notseen, Game.player.getX() - Camera.x + 8, Game.player.getY() - Camera.y -8, null);
			}
			
		}
		//coração
		g.drawImage(PlayerHubRight, 3,125, null);
		g.drawImage(heartlocal, 40,135, null);
		
		//g.drawImage(questlocal, 3,10, null);
		g.drawImage(heart3, 40,135, null);
		g.drawImage(heart3, 50,135, null);
		g.drawImage(heart3, 60,135, null);
		
		g.drawImage(mana1, 40,146, null);
		g.drawImage(mana1, 50,146, null);
		g.drawImage(mana1, 60,146, null);
		
		
		if(Game.player.maxLife > 6 && Game.player.maxLife < 8) {
			g.drawImage(heart3, 40,135, null);
		}if(Game.player.maxLife > 6 && Game.player.maxLife < 10) {
			g.drawImage(heart3, 50,135, null);
		}

		if(Game.player.life == 1) {
			g.drawImage(heart2, 40,135, null);
			
			
		}if(Game.player.life >= 2) {
			g.drawImage(heart, 40,135, null);
			
			
		}if(Game.player.life == 3) {
			g.drawImage(heart2, 50,135, null);
			
		}if(Game.player.life >= 4) {
			g.drawImage(heart, 50,135, null);
			
			
			
		}if(Game.player.life == 5) {
			g.drawImage(heart2, 60,135, null);
			
		}if(Game.player.life >= 6) {
			g.drawImage(heart, 60,135, null);
		}if(Game.player.life == 7 && Game.player.maxLife == 8) {
			g.drawImage(heart2, 40,135, null);
			
		}if(Game.player.life >= 8 && Game.player.maxLife == 8) {
			g.drawImage(heart, 40,135, null);
		}if(Game.player.life == 9 && Game.player.maxLife == 10) {
			g.drawImage(heart2, 50,135, null);
			
		}if(Game.player.life >= 10 && Game.player.maxLife == 10) {
			g.drawImage(heart, 50,135, null);
		}
		
		if(Game.player.mana >= 0.5 ) {
			g.drawImage(mana2, 40,146, null);
			
			
		}if(Game.player.mana >= 1 ) {
			g.drawImage(mana3, 40,146, null);
			
			
		}if(Game.player.mana >= 1.5) {
			g.drawImage(mana2, 50,146, null);
			
		}if(Game.player.mana >= 2 ) {
			g.drawImage(mana3, 50,146, null);
			
		}if(Game.player.mana >= 2.5 ) {
			g.drawImage(mana2, 60,146, null);
			
		}if(Game.player.mana >= 2.99 ) {
			g.drawImage(mana3, 60,146, null);
			
		}
		
		//NPC
		
		if(NPC.ShowMessageNpc == true) {
			g.drawImage(UI.BallonMessage, 50,35, null);
			g.drawImage(UI.HubMold, 55,40, null);
			if(NPC.dir == NPC.left_dir) {
				if(Game.DialogNun == 0) {
					 if (Game.currentMessage == 3){
						
						g.drawImage(UI.PlayerHubRight, 58,43, null);
					}else if (Game.currentMessage == 5){
						
						g.drawImage(UI.PlayerHubRight, 58,43, null);
					}else if (Game.currentMessage == 7){
						
						g.drawImage(UI.PlayerHubRight1, 58,43, null);
					}
					
					else {
						
						g.drawImage(UI.Npc1HubLeft, 58,33, null);
					}
				}else if(Game.DialogNun == 1) {
					if(Game.currentMessage >= 0) {
						g.drawImage(UI.Npc1HubLeft1, 58,33, null);
					}
				}
				
				
			}else {
				if(Game.DialogNun == 0) {
					
					 if (Game.currentMessage == 3){
						
						g.drawImage(UI.PlayerHubLeft, 58,43, null);
					}else if (Game.currentMessage == 5){
						
						g.drawImage(UI.PlayerHubLeft, 58,43, null);
					}else if (Game.currentMessage == 7){
						
						g.drawImage(UI.PlayerHubLeft1, 58,43, null);
					}
					else {
						g.drawImage(UI.Npc1HubRight, 58,33, null);
					}
					
				}else if(Game.DialogNun == 1) {
					g.drawImage(UI.Npc1HubRight1, 58,33, null);
				}
				
				
			}
			
		}
		
		
		//g.drawImage(questlocal, 3,10, null);
		
		
		
		
	}
	public void tick() {
		
	}
	
}
