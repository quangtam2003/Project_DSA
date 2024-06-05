/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import Entity.Entity;
import Main.GamePanel;

/**
 *
 * @author Acer
 */
public class OBJ_Potion_Red extends Entity {

    GamePanel gp;

    public OBJ_Potion_Red(GamePanel gp) {
        super(gp);
        this.gp = gp;
        type = type_consumable;
        name = "Red potion";
        value = 5;
        down1 = setup("/objects/potion_red", gp.tileSize, gp.tileSize);
        defenceValue = 2;
        description = "" + name + "\n Heal your HP by " + value;
        price = 5;


    }

    public boolean use(Entity entity) {
        gp.gameState = gp.dialogueState;
        gp.ui.currentDialogue = "You drink the " + name + "\n" +
                "You feel refreshed";

        entity.life += value;
        gp.playSE(2);
        return true;

    }
}
