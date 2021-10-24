package com.MayronStudios.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.MayronStudios.entities.NPC;
import com.MayronStudios.entities.BulletShoot;
import com.MayronStudios.entities.BulletShoot2;
import com.MayronStudios.entities.Enemy;
import com.MayronStudios.entities.Enemy2;
import com.MayronStudios.entities.Enemy3;
import com.MayronStudios.entities.Entity;
import com.MayronStudios.entities.Player;
import com.MayronStudios.graficos.Spritesheet;
import com.MayronStudios.graficos.UI;
import com.MayronStudios.world.World;
import com.MayronStudios.world.World2;

public class Game extends Canvas implements Runnable, KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;
	// Variables
	// Janela e Run Game
	public static JFrame frame;
	private boolean isRunning = true;
	private Thread thread;
	public static final int WIDTH = 240, HEIGHT = 160, SCALE = 6;

	// Imagens e Gráficos
	private int CUR_LEVEL = 3, MAX_LEVEL = 5;
	private BufferedImage image;
	public static BufferedImage sprite1;
	public static int [] pixels1;
	
	public static int x1 = 30, y1= 90;
	public static int x2= 100, y2=100;
	
	public static BufferedImage sprite2;
	public static BufferedImage questlocal;
	public static BufferedImage HubWorld;
	private BufferedImage QuestBallon[];
	
	public static int [] pixels2;
	private Graphics g;
	// Entities
	
	//lists
	public static List<Entity> entities;
	public static List<Enemy> enemies;
	public static List<Enemy2> enemies2;
	public static List<Enemy3> SWAT;
	

	public static List<BulletShoot> bulletShoot;
	public static List<BulletShoot2> bulletShoot2;
	//FONTES//MESSAGES
	public InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("Pixelfont.ttf");
	public Font newfont;
	
	public static int currentMessage = 0;
	public static int maxMessage = 100;
	public static boolean showingMessage = false;
	public static boolean CloseMessage = false;
	public static int DialogNun = 0;
	
	//spritesheets
	public static Spritesheet spritesheet;
	public static Spritesheet spritesheetTelhado;
	public static Spritesheet spritesheetNPC;
	public static Spritesheet spritesheetMapa;
	public static Spritesheet spritesheetMapaLayer1;
	public static Spritesheet spritesheetPlayer;
	public static Spritesheet spritesheetEnemy;
	public static Spritesheet spritesheetMoved;
	public static Spritesheet spritesheetEfeitoInimigo;
	
	//IMAGENS
	public static World world;
	public static World2 world2;
	public static Player player;
	//INIMIGOS
	public static Enemy inimigo1;
	public static Enemy2 inimigo2;
	public static Enemy3 SWAT1;
	
	
	public static Random random;
	public UI ui;
	public SwtchEvents SEvents;
	
	
	// Game State
	public static String gameState = "MENU";
	private boolean showMessageGameOver = true;
	private int framesGameOver = 0;
	private boolean restartGame = false;
	// Menu
	public Menu menu;
	//QUEST
		public static boolean Quest = false;
		public boolean Bookfixed = false;
		public boolean ClosedBook = false;
		public boolean ClosedBookfixed = false;
		
		private int frames = 0, index= 0;

	/***/

	// Construtor
	public Game() {
		
		random = new Random();

		// Para que os eventos de teclado e mouse funcionem
		addKeyListener(this);
		addMouseListener(this);

		this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		initFrame();
		// Inicializando Objetos
		ui = new UI();
		//SEvents = new SwtchEvents();
		
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		entities = new ArrayList<Entity>();
		enemies = new ArrayList<Enemy>();
		enemies2 = new ArrayList<Enemy2>();
		SWAT = new ArrayList<Enemy3>();
		
		bulletShoot = new ArrayList<BulletShoot>();
		bulletShoot2 = new ArrayList<BulletShoot2>();
		
		
		

		spritesheet = new Spritesheet("/spritesheet.png");
		spritesheetTelhado = new Spritesheet("/spritesheetTelhados.png");
		spritesheetNPC = new Spritesheet("/spritesheetNpcs.png");
		spritesheetMapa = new Spritesheet("/MapaCasa.png");
		spritesheetMapaLayer1 = new Spritesheet("/MapaLayer1.png");
		spritesheetPlayer = new Spritesheet("/spriteSheetPlayer.png");
		spritesheetMoved = new Spritesheet("/spritesheetMovedSprites.png");
		spritesheetEnemy = new Spritesheet("/Enemy1.png");
		spritesheetEfeitoInimigo = new Spritesheet("/EfeitoInimigos.png");
		questlocal = UI.spritesheetUi.getSprite(672, 0, 128, 128);
		HubWorld = UI.spritesheetUi.getSprite(560, 0, 97, 112);
		player = new Player(0, 0, 32, 32, spritesheetPlayer.getSprite(32, 0, 32, 32));
		//adicionar inimigos
		inimigo1 = new Enemy(0, 0, 32, 32, spritesheetPlayer.getSprite(32, 0, 32, 32));
		inimigo2 = new Enemy2(0, 0, 32, 32, spritesheetPlayer.getSprite(32, 0, 32, 32));
		SWAT1 = new Enemy3(0, 0, 32, 32, spritesheetPlayer.getSprite(32, 0, 32, 32));
		
		//ANIMAÇÃO DO LIVRO DE QUEST
        QuestBallon = new BufferedImage[5];
		
		QuestBallon[0] = UI.spritesheetUi.getSprite(96, 32, 48, 80);
		QuestBallon[1] = UI.spritesheetUi.getSprite(144, 32, 64, 80);
		QuestBallon[2] = UI.spritesheetUi.getSprite(208, 32, 64, 80);
		QuestBallon[3] = UI.spritesheetUi.getSprite(272, 32, 80, 80);
		QuestBallon[4] = UI.spritesheetUi.getSprite(352, 32, 96, 80);
		
		
		entities.add(player);
		
		
		menu = new Menu();
		//TESTANDO PIXEL PERFECT
		try {
			sprite1 = ImageIO.read(getClass().getResource("/sprite1.png"));
			sprite2 = ImageIO.read(getClass().getResource("/sprite2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pixels1 = new int[sprite1.getWidth()*sprite1.getHeight()];
		sprite1.getRGB(0, 0, sprite1.getWidth(), sprite1.getHeight(), pixels1, 0, sprite1.getWidth());
		
		pixels2 = new int[sprite2.getWidth()*sprite2.getHeight()];
		sprite2.getRGB(0, 0, sprite2.getWidth(), sprite2.getHeight(), pixels2, 0, sprite2.getWidth());
		world = new World("/level3.png");
		world2 = new World2("/level2.png");
		
		//fonte
		try {
			newfont = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont((5f*SCALE));
		} catch (FontFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	// Criação da Janela
	public void initFrame() {
		frame = new JFrame("New Window");
		frame.add(this);
		frame.setResizable(false);// Usuário não irá ajustar janela
		frame.pack();
		frame.setLocationRelativeTo(null);// Janela inicializa no centro
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Fechar o programa por completo
		frame.setVisible(true);// Dizer que estará visível
	}

	// Threads
	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}

	public synchronized void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Método Principal
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}

	// Ticks do Jogo
	public void tick() {
		
		
		//System.out.println(currentMessage);
		//System.out.println(maxMessage);
		//ADICIONAR TICKS DE OUTROS LUGARES
		//SEvents.tick();
		x1++;
        if(this.isCollidingPerfect(x1, x2, y1, y2, pixels1, pixels2, sprite1, sprite2)) {
			
		}
		
		if (gameState == "NORMAL") {
			for (int i = 0; i < entities.size(); i++) {
				Entity e = entities.get(i);
				e.tick();
			}

			for (int i = 0; i < bulletShoot.size(); i++) {
				bulletShoot.get(i).tick();
			}
			for (int i = 0; i < bulletShoot2.size(); i++) {
				bulletShoot2.get(i).tick();
			}

			if (enemies.size() <= 0) {
				// System.out.println("Next Level");
				CUR_LEVEL++;
				if (CUR_LEVEL > MAX_LEVEL) {
					CUR_LEVEL = 1;
				}
				String newWorld = "level" + CUR_LEVEL + ".png";
				World.restartGame(newWorld);
				World2.restartGame(newWorld);
			}
		} else if (gameState == "GAME_OVER") {
			framesGameOver++;
			if (framesGameOver == 35) {
				framesGameOver = 0;
				if (showMessageGameOver) {
					showMessageGameOver = false;
				} else {
					showMessageGameOver = true;
				}
			}

			if (restartGame) {
				restartGame = false;
				gameState = "NORMAL";
				CUR_LEVEL = 1;
				String newWorld = "level" + CUR_LEVEL + ".png";
				World.restartGame(newWorld);
				World2.restartGame(newWorld);
			}
		} else if (gameState == "MENU") {
			this.menu.tick();
		}
	}

	// O que será mostrado em tela
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();// Sequência de buffer para otimizar a renderização, lidando com
														// performace gráfica
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		g = image.getGraphics();// Renderizar imagens na tela
		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);

		/* Render do jogo */
		world.render(g);
		world2.render(g);
		Collections.sort(entities, Entity.nodeSorter);
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.render(g);
		}
		for (int i = 0; i < bulletShoot.size(); i++) {
			bulletShoot.get(i).render(g);
		}
		
		
		ui.render(g);
		//SEvents.render(g);
		
		/***/
		if(Quest == true) {
			
			
			
			if(index == 4) {
				
			}else {
				frames ++;
				
			}
			
			if(frames >= 5) {
				
				frames = 0;
				index++;

				
				if (index >= 4) {
					Bookfixed = true;
					
					
								  
				}
				
			}
			if(Bookfixed == false){
				g.drawImage(QuestBallon[index],17+index*2,4, null);

			}else {
				g.drawImage(QuestBallon[4],21,4, null);
				
			}
			
						
					
				
				
			}else {
				Bookfixed = false;
				
				
			}
			if(ClosedBook == true) {
				if(index >= 0) {
					frames ++;
				}else {
					
					
				}
				if(Quest == true) {
					index = 0;
					ClosedBook = false;
					ClosedBookfixed = true;
				}
				
				if(frames >= 6) {
					
					frames = 0;
					index--;
					
					
					if (index == 0) {
						if(Quest == true) {
							index = 0;
							ClosedBook = false;
							ClosedBookfixed = true;
						}
						index = 0;
						ClosedBook = false;
						ClosedBookfixed = true;
									  
					}
					
				}
				if(ClosedBookfixed == false){
					g.drawImage(QuestBallon[index],21,4, null);
					
				}
			}else {
				
			}
		
		
		g.dispose();// Limpar dados de imagem não usados
		g = bs.getDrawGraphics();
		
		g.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		g.setFont(new Font("arial", Font.BOLD, 17));
		g.setColor(Color.white);
		//g.drawString("Munição: " + player.ammo, 60, 40);
		if(Game.player.receivedQuest == true) {
			if(Quest == false && index == 0) {
				g.drawImage(questlocal, 12,20, null);
			}
		}
		
		
		//g.drawImage(HubWorld, 1320,20, null);
		
		
		// Game Over Configs
		if (gameState == "GAME_OVER") {
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(new Color(0, 0, 0, 100));
			g2.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
			g.setFont(new Font("arial", Font.BOLD, 36));
			g.setColor(Color.white);
			g.drawString("Game Over", (WIDTH * SCALE) / 2 - 100, (HEIGHT * SCALE) / 2 - 40);
			if (showMessageGameOver) {
				g.setFont(new Font("arial", Font.BOLD, 20));
				g.drawString("> Press Enter to Restart the Game <", (WIDTH * SCALE) / 2 - 170, (HEIGHT * SCALE) / 2);
			}

		} else if (gameState == "MENU") {
			menu.render(g);
		}
		//NPCS MESSAGES
		if(NPC.ShowMessageNpc == true) {
			showingMessage = true;
			//ShowBallonMessage = true;
			//MAXIMO DE MESSAGENS QUE PODEM TER
			if(DialogNun == 0) {
				maxMessage = 8;
				
			}else {
				maxMessage = 1;
				
				
			}
			
			//FONTE
			g.setFont(newfont);		
			g.setColor(Color.WHITE);
			if(DialogNun == 0) {
				//MENSSAGEM
				NPC.drawString(g,NPC.FrasesNpc[currentMessage],/**LarguraX**/WIDTH/4 * SCALE + SCALE*34,/**alturaY**/ HEIGHT+SCALE*16 );
				if(currentMessage == 8) {
					
					
					DialogNun = 1;
					currentMessage = 0;
					NPC.ShowMessageNpc = false; 
					
					
				}
				
			}
			if(DialogNun == 1) {
				
				
				NPC.drawString(g,NPC.FrasesNpc[8],/**LarguraX**/WIDTH/4 * SCALE + SCALE*34,/**alturaY**/ HEIGHT+SCALE*16 );
				
                if(currentMessage == 1) {
					
					
                	
					
					
					
					
				}	
					
					
					
				
				
			}
			
			
					
		}

		

		bs.show();
	}
	public boolean isCollidingPerfect(int x1, int x2, int y1, int y2, int[] pixels1, int[] pixels2, BufferedImage sprite1, BufferedImage sprite2 ) {
		for(int xx1 = 0; xx1 < sprite1.getWidth(); xx1 ++) {
			for(int yy1 = 0; yy1 < sprite1.getHeight(); yy1 ++) {
				for(int xx2 = 0; xx2 < sprite2.getWidth(); xx2 ++) {
					for(int yy2 = 0; yy2 < sprite2.getHeight(); yy2 ++) {
						int pixelAtual1 = pixels1[xx1+yy1*sprite1.getWidth()];
						int pixelAtual2 = pixels2[xx1+yy2*sprite2.getWidth()];
						if(pixelAtual1 == 0x00FFFFFF || pixelAtual2 == 0x00FFFFFF) {
							continue;
						}
						if(xx1+x1 == xx2+x2 && yy1+y1 == yy2+y2) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	// Controle de FPS
	public void run() {
		// Variables
		long lastTime = System.nanoTime();// Usa o tempo atual do computador em nano segundos, bem mais preciso
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;// Calculo exato de Ticks
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		requestFocus();
		// Ruuner Game
		while (isRunning == true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				frames++;
				delta--;
			}

			if (System.currentTimeMillis() - timer >= 1000) {
				System.out.println("FPS: " + frames);
				frames = 0;
				timer += 1000;
			}
		}

		stop(); // Garante que todas as Threads relacionadas ao computador foram terminadas,
				// para garantir performance.

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		// Esquerda e Direita
		if(Game.player.InEvent == false) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
				if(Game.player.SquatStop == true) {
					Game.player.Squat = true;
				}
				player.right = true;

			} if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
	            if(Game.player.SquatStop == true) {
					Game.player.Squat = true;
				}
				player.left = true;
			}

			// Cima e Baixo
			if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
				if(Game.player.SquatStop == true) {
					Game.player.Squat = true;
				}else {
					Game.player.Squat = false;
				}
				player.up = true;
				
				if (gameState == "MENU") {
					this.menu.up = true;
				}

			}  if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
				if(Game.player.SquatStop == true) {
					Game.player.Squat = true;
				}else {
					Game.player.Squat = false;
				}
				player.down = true;
				if (gameState == "MENU") {
					this.menu.down = true;
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
				if(player.Squat == false) {
					if(player.up == true || player.right == true || player.left == true || player.down == true) {
						if(Game.player.mana >= 0.2) {
							player.run = true;
						}
						
					}
				}
				
				
				
			}
			if (e.getKeyCode() == KeyEvent.VK_E) {
				
				
				if(maxMessage == currentMessage) {
					NPC.ShowMessageNpc = false;
				}else {
					player.action = true;
				}
				
				
	            
				if(showingMessage == true) {
					
					if(!(maxMessage == currentMessage)) {
						//MUDA AS MESSAGENS
						currentMessage++;	
						showingMessage = false;
						
				
					}else {
						//CONDIÇÃO PRA DETERMIDADA ORDEM DE DIALOGO
						
						currentMessage = 0;
						Game.showingMessage = false;
						Game.CloseMessage = true;
					}
				}
				
						
						
					
					
					
					
				
			}
			if (e.getKeyCode() == KeyEvent.VK_C) {
				if(player.SquatStop == true) {
					
					player.SquatStop = false;
				}else {
					player.SquatStop = true;
				}
				
				
				
			}

			if (e.getKeyCode() == KeyEvent.VK_X) {
				player.shoot = true;
			}if (e.getKeyCode() == KeyEvent.VK_K) {
				if(Game.player.run == true) {
					if(Game.player.mana >= 1) {
						Game.player.atack2 = true;
						Game.player.mana -=1;
					}
					
					
					
					
					
					
					
				}else {
					if(Game.player.mana >= 0.5) {
						Game.player.atack1 = true;
						Game.player.mana -=0.5;
					}
					
					
				}
				
			}if (e.getKeyCode() == KeyEvent.VK_Q && Game.player.receivedQuest == true)  {
				
				if(Quest == true) {
					Quest = false;
					ClosedBook = true;
					ClosedBookfixed = false;
				}else {
					Quest = true;
					
				}
				
				
				
			}

			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				gameState = "MENU";
				menu.pause = true;
			}
		}
		

	}

	public void keyReleased(KeyEvent e) {
		if(Game.player.InEvent == false) {
			// Esquerda e Direita
			if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
				if(Game.player.Squat == true) {
					Game.player.Squat = false;
				}
				player.right = false;

			} else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
				if(Game.player.Squat == true) {
					Game.player.Squat = false;
				}
				player.left = false;
			}

			// Cima e Baixo
			if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
				if(Game.player.Squat == true) {
					Game.player.Squat = false;
				}
				player.up = false;

			} else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
				if(Game.player.Squat == true) {
					Game.player.Squat = false;
				}
				player.down = false;
			}

			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				this.restartGame = true;
				if (gameState == "MENU") {
					this.menu.enter = true;
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_E) {
				Game.player.action = false;

				
			}
			if (e.getKeyCode() == KeyEvent.VK_C) {
				

				
			}
			if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
				Game.player.run = false;

				
			}
			

		}
		}
		

	public void mouseClicked(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		player.mouseShoot = true;
		player.mx = (e.getX() / 3);
		player.my = (e.getY() / 3);
	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

}
