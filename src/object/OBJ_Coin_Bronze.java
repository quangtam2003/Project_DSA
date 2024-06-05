package object;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_Coin_Bronze extends Entity {
    GamePanel gp;

    public OBJ_Coin_Bronze(GamePanel gp) {
        super(gp);
        this.gp = gp;
        type = type_pickupOnly;
        name = "Coin";
        down1 = setup("/objects/coin_bronze", gp.tileSize, gp.tileSize);
        value = 1;

    }

    public boolean use(Entity entity) {
        // gp.ui.addMessage("Coin +" + value);
        gp.player.coin += value;
        gp.playSE(1);
        return true;
    }
}
