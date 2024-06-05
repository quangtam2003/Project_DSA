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
public class OBJ_Door extends Entity {
GamePanel gp;

    public OBJ_Door(GamePanel gp){
        super(gp);
        this.gp = gp;
        type = type_obstacle;
        name = "Door";
        down1 = setup("/objects/door",gp.tileSize,gp.tileSize);
        collision = true;
        
        solidArea.x = 0;
        solidArea.y = 16;
        solidArea.width = 48;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
    public void interact(){
        gp.gameState =gp.dialogueState;
        gp.ui.currentDialogue = "you need a key to open this";
    }
}
