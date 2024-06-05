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
public class OBJ_Boots extends Entity {

    public OBJ_Boots(GamePanel gp){
        super(gp);
        
        name = "Boots";
        down1 = setup("/objects/boots",gp.tileSize,gp.tileSize);
        price = 100;

    }
    
}
