package object;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_Lantern extends Entity {

    public OBJ_Lantern(GamePanel gp) {
        super(gp);
        type = type_light;
        name = "Lantern";
        down1 = setup("/objects/lantern",gp.tileSize,gp.tileSize);
        description = "[lantern]\n illuminate you surrounding";
         price = 20;
         lightRadius = 250;
         
    }
    
}
