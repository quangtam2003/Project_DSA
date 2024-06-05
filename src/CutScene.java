

import Main.GamePanel;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import object.OBJ_Blue_Heart;

/**
 *
 * @author KhoiLe
 */
public class CutScene {
    
    GamePanel gp;
    Graphics2D g2;
    public int sceneNum;
    public int scenePhase;
    int counter = 0;
    float alpha = 0f;
    int y;
    
    //scene num
    public final int NA = 0;
    public final int ending = 1;
    
    public CutScene(GamePanel gp){
        this.gp = gp;
    }
    
    public void draw(Graphics2D g2){
        this.g2 = g2;
        
        switch(sceneNum){
            case ending: scene_ending(); 
            break;
        }
        
    }
    
    private void showCongratulatoryMessage() {
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(gp, "Congratulations! You won!");
        });
    }
    
    public void scene_ending(){
        if(scenePhase == 0){
            gp.stopMusic();
            gp.ui.npc = new OBJ_Blue_Heart(gp);
            scenePhase++;
        }
        if (scenePhase == 1){
            //display dialogues
            gp.ui.drawDialogueScreen();
        }
        if (scenePhase == 2){
            //play fanfare
            gp.playSE(4);
            scenePhase++;
        }
        if (scenePhase == 3){
            //wait until SE end
            if (counterReached(300) == true){
                scenePhase++;
            }
        }
        if (scenePhase == 4){
            //darker scene
            alpha += 0.005f;
            if (alpha > 1f ){
                alpha = 1f;
            }
            drawBlackBackground(alpha);
            if (alpha == 1f){
                alpha = 0;
                scenePhase++;
                showCongratulatoryMessage();  // Show congratulatory message
            }
        }
    }
    
    public boolean counterReached(int target){
        boolean counterReached = false;
        counter++;
        if (counter>target){
            counterReached = true;
            counter = 0;
        }
        return counterReached;
    }
    
    public void drawBlackBackground(float alpha){
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2.setColor(Color.black);
        g2.fillRect(0,0,gp.screenWidth, gp.screenHeight);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }
}
