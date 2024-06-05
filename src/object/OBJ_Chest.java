/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import Entity.Entity;
import Main.GamePanel;


/**
 *
 * @author PC
 */
public class OBJ_Chest extends Entity {
    GamePanel gp;

    public OBJ_Chest(GamePanel gp){
        super(gp);
        this.gp = gp;

        type = type_obstacle;

        name = "Chest";
        image = setup("/objects/chest", gp.tileSize, gp.tileSize);
        image2 = setup("/objects/chest_opened", gp.tileSize, gp.tileSize);

        down1 = image;
        collision = true;
        solidArea.x =4;
        solidArea.y = 16;
        solidArea.width = 40;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
    }
    
    public void setLoot(Entity loot){
        this.loot = loot;
    }
    
    public void interact(){
        gp.gameState = gp.dialogueState;
        if(opened == false){
            gp.playSE(3);
            StringBuilder sb = new StringBuilder();
            sb.append("you open the chest and find a "+ loot.name );
            if(gp.player.inventory.size() == gp.player.maxInventorySize){
                sb.append("\n...But you cannot carry any more");

            }
            else{
                sb.append("\n you obtain the " + loot.name);
                gp.player.inventory.add(loot);
                down1 = image2;
                opened = true;
            }
            gp.ui.currentDialogue = sb.toString();
        }
        else{
            gp.ui.currentDialogue = " It's emty";
        }
    }
    
}
