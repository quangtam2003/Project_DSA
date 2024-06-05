/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import Entity.Entity;
import Main.GamePanel;
import java.awt.image.BufferedImage;

/**
 *
 * @author PC
 */
public class OBJ_Key extends Entity {
    GamePanel gp;
    public OBJ_Key(GamePanel gp) {
        super(gp);
        this.gp = gp;
        type = type_consumable;
        name = "Key";
        down1 = setup("/objects/key", gp.tileSize, gp.tileSize);
        description = "" + name + "\n Open a door.";
    }
    public boolean use(Entity entity){
        gp.gameState = gp.dialogueState;
        int objIndex = getDetected(entity,gp.obj,"Door");
        if(objIndex != 999){
            gp.ui.currentDialogue = "you use the key " + name + " and open the door ";
            gp.playSE(3);
            gp.obj[gp.currentMap][objIndex] = null;
            return true;
        }
        else{
            gp.ui.currentDialogue = "there is no door to open?h";      
             return false;

        }

    }
}
