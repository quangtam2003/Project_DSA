package object;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_Axe extends Entity {
    public OBJ_Axe(GamePanel gp) {
        super(gp);
        type = type_axe;
        name = "Axe";
        down1 = setup("/objects/axe", gp.tileSize, gp.tileSize);
        attackValue = 2;
        attackArea.width = 20;
        attackArea.height = 20;
        description = "" + name + "\n Heavy Axe.";
        price = 10;
    }

}
