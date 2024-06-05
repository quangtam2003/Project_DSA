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
public class OBJ_Shield_Wood extends Entity {
    public OBJ_Shield_Wood(GamePanel gp) {
        super(gp);
        type = type_shield;
        name = "Wood Shield";
        down1 = setup("/objects/shield_wood", gp.tileSize, gp.tileSize);
        defenceValue = 1;
        description = "" + name + "\n Made by wood.";
        price = 5;

    }
}
