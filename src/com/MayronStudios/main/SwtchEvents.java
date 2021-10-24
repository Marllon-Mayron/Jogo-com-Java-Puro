package com.MayronStudios.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.MayronStudios.entities.Entity;
import com.MayronStudios.world.Camera;

public class SwtchEvents extends Entity{
	
	
	//S1 = ABRIR PORTA
	//S3 = ABRIR PORTA
	//S2 = ABRIR GAVETA
	public static int Swtch = 0;
	public static boolean SwtchAnimation = false;
	public static  boolean SwtchTelhado = false;
	public static boolean SwtchTelhado0 = false;
	public static boolean SwtchTelhado1 = false;
	
	//ANIMATION SPRITES
    private int S1frames = 0, S1maxFrames = 4, S1index = 0, S1maxIndex = 5;
    private int S2frames = 0, S2maxFrames = 4, S2index = 0, S2maxIndex = 5;
 	
	private BufferedImage[] PORTA;
	private BufferedImage[] TELHADO;
  
	
	
	
	
		
		
		
	public SwtchEvents(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		// TODO Auto-generated constructor stub
		this.setMask(2, 16,12,4);
		depth = 4;
		PORTA = new BufferedImage[6];
		TELHADO = new BufferedImage[1];
			
		for (int i = 0; i < 6; i++) {
			PORTA[i] = Game.spritesheetMoved.getSprite(0 + (i * 16), 48, 16, 32);
		}
		TELHADO[0] = Game.spritesheetTelhado.getSprite(0, 0, 97, 106);
		
		
			
	}
	
	
	
	public void tick() {
		
		
		System.out.println(SwtchTelhado);
		
		if (SwtchEvents.SwtchAnimation == true && SwtchEvents.Swtch == 1) {
			
			S1frames++;
			if (S1frames == S1maxFrames) {
				S1frames = 0;
				S1index++;
				if (S1index > S1maxIndex) {
					S1index = S1maxIndex;
					Swtch = 0;
					
					this.setMask(2, -58,12,4);
					
					
					if(Game.player.InEvent == true) {
						SwtchAnimation = false;
						//ANDAR PRA CIMA
						Game.player.up = true;
						Game.player.moved = true;
					}
					
					
					
				}
			}
		}
		if (SwtchEvents.SwtchAnimation == true && SwtchEvents.Swtch == 2) {
			Game.player.receivedQuest = true;
			SwtchEvents.SwtchAnimation = false;
			Game.player.InEvent = false;
			
		}
        if (SwtchEvents.SwtchAnimation == true && SwtchEvents.Swtch == 3) {
			
			S2frames++;
			if (S2frames == S2maxFrames) {
				S2frames = 0;
				S2index++;
				if (S2index > S2maxIndex) {
					S2index = S2maxIndex;
					Swtch = 0;
					
					this.setMask(2, 16,12,0);
					
					
					
					
					if(Game.player.InEvent == true) {
						
						SwtchAnimation = false;
						//SwtchTelhado0 = true;
						//ANDAR PRA CIMA
						Game.player.up = true;
						Game.player.moved = true;
					}
					
					
					
				}
			}
		}
		
	
		
		if(Swtch == 1) {
			if(Game.player.action == false ) {
				
				
			}
			
		}
		if(Swtch == 2) {
			if(Game.player.action == false) {
				
				
			}
		}
	}
	
		
	public void render(Graphics g){
		//MOSTRAR DESESNHOS
		g.drawImage(sprite, this.getX() - Camera.x, this.getY() - Camera.y, null);
		//CORES
		g.setColor(Color.blue);
		//g.fillRect(getX() + maskx3 - Camera.x, getY()+ masky3 - Camera.y, mwidth3, mheight3);
		g.setColor(Color.yellow);
		//g.fillRect(getX() + Actmaskx - Camera.x, getY()+ Actmasky - Camera.y, Actwidth, Actheight);
		//g.fillRect(getX() + StopActmaskx - Camera.x, getY()+ StopActmasky - Camera.y, StopActwidth, StopActheight);
		
		//PORTA DESENHO
		g.drawImage(PORTA[S1index], 184 - Camera.x,  240 - Camera.y, null);
		g.drawImage(PORTA[S2index], 184 - Camera.x,  165 - Camera.y, null);
		//TELHADOS
		if(SwtchTelhado0 == false) {
			g.drawImage(TELHADO[0], 172 - Camera.x,  45 - Camera.y, null);
		}
		
		
		
	}
	

}
