package FomeSaudavel;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Pedro Arthur
 */
public  class Personagem {
    private int px, pontos = 0;
    private int py = 540;
    private Image imagem_personagem;
    public boolean[] key_states = new boolean[256];
    private int vidas = 3;
    
    public Personagem(){
        
        imagem_personagem = new ImageIcon(this.getClass().getResource("Sprites/sprite_pers_parado.jpg")).getImage();
    
    }
    
    public void somaPontos(int pts) {
        pontos+=pts;
    } 
    
    public int getPontos(){
        return pontos;
    }
    
    public int getVidas() {
        return vidas;
    }
    
    public void perdeVida(){
        vidas--;
    }
    
    
    
    public void update(double dt){
    
    if ((key_states[KeyEvent.VK_RIGHT])&&(px < 818)){            
            px +=  dt;
    }
    
    if ((key_states[KeyEvent.VK_LEFT])&&(px > 0)){
            px -=  dt;
        }
    
    if ((key_states[KeyEvent.VK_UP])&&(py < 647)){            
            py -= dt;
    }
    
    if ((key_states[KeyEvent.VK_DOWN])&&(py > 0)){
            py += dt;
        }
    
    
    
    
    
    }
    
    public void draw(Graphics2D g2d) {
        g2d.drawImage(imagem_personagem, (int)px, (int)py, null);        
    }
    
}
