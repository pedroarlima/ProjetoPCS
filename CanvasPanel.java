package FomeSaudavel;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.lang.System.exit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CanvasPanel extends JPanel implements Runnable
{
    private Image background_jogo, background_menu;
    private Personagem personagem;
    private boolean iniciar = false;
    private boolean finalizar = false;
    
    public CanvasPanel() {
        setDoubleBuffered(true);
        setFocusable(true);
        load();
        new Thread(this).start();
    }
    
    
    @Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        draw(g);
    }
    
    @Override
    public void run()
    {
        double btime, dtime = 0;
        btime = System.currentTimeMillis();
        while(true) 
        {
            update(dtime/1000);
            repaint();                       
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            dtime = (System.currentTimeMillis() - btime); 
            btime = System.currentTimeMillis();
        }
    }
    
    private class KeyboardAdapter extends KeyAdapter {
      @Override
      public void keyReleased(KeyEvent e) {
        personagem.key_states[e.getKeyCode()] = false;
        
      }

      @Override
      public void keyPressed(KeyEvent e) {
        personagem.key_states[e.getKeyCode()] = true;
        
      }
    }

    private void load()
    {
       addKeyListener(new KeyboardAdapter());
       
       background_menu = new ImageIcon(this.getClass().getResource("Sprites/background_menu.jpg")).getImage();
       background_jogo = new ImageIcon(this.getClass().getResource("Sprites/background_jogo.png")).getImage();
       
       personagem = new Personagem();
        
        
        
    }
    
    private void update(double dt)
    {
        if (!iniciar){    
            
            if (personagem.key_states[KeyEvent.VK_N]) {
               iniciar = true; 
            }
            
            if (personagem.key_states[KeyEvent.VK_S]) {
                exit(0);
            }
        }
        
        if (iniciar){
            personagem.update(dt);
   
   
        }else
            finalizar = true;
            
               
        
        
       
        
    }
    
    private void draw(Graphics g) 
    {
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.drawImage(background_menu,0,0,this);
        g2d.drawString("Novo Jogo - N", 250, 350);
        g2d.drawString("Sair - S", 250, 450);
        
        if (iniciar){
            g2d.drawImage(background_jogo,0,0,this);
            personagem.draw(g2d);
        }
         
         
         
    }
}
