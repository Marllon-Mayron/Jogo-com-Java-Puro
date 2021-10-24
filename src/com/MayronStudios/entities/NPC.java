package com.MayronStudios.entities;


import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.io.InputStream;

import com.MayronStudios.graficos.UI;
import com.MayronStudios.main.Game;
import com.MayronStudios.world.Camera;

public class NPC extends Entity{
	private int frames = 0, MaxFrames = 30, index= 0,  MaxIndex = 1;
	public int LGNPC;
	public static int ShowMessageX;
	public static int ShowMessageY;
	public static int ShowNumber = 0;
	public int FrasesCurrent = 2;
	public static int right_dir = 0, left_dir = 1;
	public static int dir = right_dir;
	
	public static String[] FrasesNpc = new String[10];
	
	private boolean start = true;
	public static boolean ShowMessageNpc = false;

	public static BufferedImage NPC_NPC = Game.spritesheetNPC.getSprite(0,0,16,16);
	
	
	private BufferedImage[] stopRightNpc;
	private BufferedImage[] stopLeftNpc;

	private BufferedImage[] SayRightNpc;
	private BufferedImage[] SayLeftNpc;
	
	
	
	

	public NPC(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		// TODO Auto-generated constructor stub
		//FRASES
		
		
		
		
		depth = 10;
		
		FrasesNpc[0] = "Sapão: Ora Ora, uma humana!!";
		FrasesNpc[1] = "Sapão: E ainda é das pequenas, perfeito.\nPreciso de um favor seu.";
		FrasesNpc[2] = "Sapão: Só preciso que você entre por esse \nburaco na porta e pegue a minha pulseira \nque caiu la dentro.";
		FrasesNpc[3] = "Você: O que eu vou reeber em troca?";
		FrasesNpc[4] = "Sapão: Você é espertinha demais para \nseu tamanho em.";
		FrasesNpc[5] = "Você: Eu aceito doces ou brinquedos.";
		FrasesNpc[6] = "Sapão: Tudo bem, pega minha pulseira de \nouro,e eu te darei um bombom.";
		FrasesNpc[7] = "Você: Fechado!!!";
		FrasesNpc[8] = "Sapão: Saudades da minha pulseira...";
		
		
		
		
		
		
		//ANIMAÇÕES
		stopLeftNpc = new BufferedImage[3];
		stopRightNpc = new BufferedImage[3];
		
		SayLeftNpc = new BufferedImage[2];
		SayRightNpc = new BufferedImage[2];
		

		
		
		for(int i =0; i < 3; i++) {
			stopLeftNpc[i] = Game.spritesheetNPC.getSprite(0 + (i*32), 0 , 32, 32);
			}
		for(int i =0; i < 3; i++) {
			stopRightNpc[i] = Game.spritesheetNPC.getSprite(0 + (i*32), 32 , 32, 32);
			
			}
		for(int i =0; i < 2; i++) {
			SayLeftNpc[i] = Game.spritesheetNPC.getSprite(96 + (i*32), 0 , 32, 32);
			}

		for(int i =0; i < 2; i++) {
			SayRightNpc[i] = Game.spritesheetNPC.getSprite(96 + (i*32), 32 , 32, 32);
			
			}
		
	}
	public static void drawString (Graphics g, String text, int x, int y) {
        for (String line: text.split ("\n")) {
        	  g.drawString (line, x, y += g.getFontMetrics (). getHeight ());
        	
        }
          
    }public static void drawtabString (Graphics g, String text, int x, int y) {
        for (String line: text.split ("\t"))
            g.drawString (line, x += g.getFontMetrics (). getHeight (), y);
    }
	public void tick() {
		
		int Xplayer = Game.player.getX();
		int Yplayer = Game.player.getY();
		int Xnpc = (int)x;
		int Ynpc = (int)y;
		ShowMessageX = (int)x;
		ShowMessageY = (int)y;
		if(Math.abs(Xplayer-Xnpc) < 32 && Math.abs(Yplayer-Ynpc) < 32) {
			if(Xplayer > Xnpc) {
				dir = right_dir;
			}else {
				dir = left_dir;
				
			}
			
			if(Game.player.action == true) {
				if(Game.CloseMessage == true && Game.currentMessage == 0) {
					Game.CloseMessage = false;
				}else {
					ShowMessageNpc = true;
				}
				
				
				
			}
			
			
			
			
		}else {
			if(ShowMessageNpc == true) {
				ShowMessageNpc = false;
				
			}
			
			
		}
		
		depth = 2;
		
		
		if (start) {
			frames ++;
			if(frames == MaxFrames) {
				frames = 0;
				index++;
				if (start == false) {
					index = 0;
				}
				   if (index > MaxIndex) {
					   index = 0;
					   
				   }
			}
			
		}
		
		
			
		
	}
	public void render(Graphics g) {
		
		if(NPC.ShowMessageNpc == true) {
			
			
			
			
			//g.drawString(NPC.FrasesNpc1[0], getX() - Camera.x, getY() - Camera.y);
		}
		if(start == true) {
			if(dir == right_dir) {
				if(ShowMessageNpc == true){
					g.drawImage(SayRightNpc[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				}else {
					g.drawImage(stopRightNpc[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
					
				} 
			}else{
				if(ShowMessageNpc == true){
					g.drawImage(SayLeftNpc[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				}else {
					g.drawImage(stopLeftNpc[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
					
				}
				
			}
			
			
		}
		
		
		
		
		
			
		g.setColor(Color.yellow);
		//g.fillRect(this.getX() + maskx - Camera.x, this.getY()+ masky - Camera.y, mwidth, mheight);
		g.fillRect(this.getX() + depthX - Camera.x, this.getY()+ depthY - Camera.y, mwidthDepth, mheightDepth);
		
	}
	

}
