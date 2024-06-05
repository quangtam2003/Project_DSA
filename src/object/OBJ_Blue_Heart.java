/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import Entity.Entity;
import Main.GamePanel;

/**
 *
 * @author KhoiLe
 */
public class OBJ_Blue_Heart extends Entity{
    
    GamePanel gp;
    public static final String objName = "Blue Heart";
    
    public OBJ_Blue_Heart(GamePanel gp){
        super(gp);
        
        this.gp = gp;
        
        type = type_pickupOnly;
        name = objName;
        down1 = setup("/objects/blueheart",gp.tileSize,gp.tileSize);
        setDialogues();
    }
    
    public void setDialogues(){
        dialogues[0] = "You picked up a beautiful blue gem.\n"
                + "the legendary treasure!!";

    }
    
    
}
