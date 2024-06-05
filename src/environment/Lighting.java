package environment;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.image.BufferedImage;

import Main.GamePanel;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Lighting {
    GamePanel gp;
    BufferedImage darknessFilter;
    int dayCounter;
    float filterAlpha = 0f;
    final int day = 0;
    final int dusk = 1;
    final int night = 2;
    final int dawn = 3;
    int dayState = day;

    public Lighting(GamePanel gp, int circleSize) {
        
        darknessFilter = new BufferedImage(gp.screenWidth, gp.screenHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D)darknessFilter.getGraphics();
        Area screenArea = new Area(new Rectangle2D.Double(0,0,gp.screenWidth,gp.screenHeight));
        
        int centerX = gp.player.screenX + (gp.tileSize)/2;
        int centerY = gp.player.screenY + (gp.tileSize)/2;
      
        double x = centerX - (circleSize/2);
        double y = centerY - (circleSize/2);
        
        Shape circleShape = new Ellipse2D.Double(x,y,circleSize,circleSize);
        
        Area lightArea = new Area(circleShape);
        
        screenArea.subtract(lightArea);
        
        Color color[] = new Color[5];
        
        color[0] = new Color(0,0,0,0f);
        color[1] = new Color(0,0,0,0.25f);
        color[2] = new Color(0,0,0,0.5f);
        color[3] = new Color(0,0,0,0.75f);
        color[4] = new Color(0,0,0,0.98f);
        

        
        g2.setColor(new Color(0,0,0,0.95f));
        g2.fill(screenArea);
        g2.dispose();
        
        this.gp = gp;
        setLightSource();

    }

    public void setLightSource() {
        // create a buffered image
        darknessFilter = new BufferedImage(gp.screenWidth, gp.screenHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) darknessFilter.getGraphics();
        // Area screenArea = new Area(new Rectangle2D.Double(0, 0, gp.screenWidth,
        // gp.screenHeight));
        if (gp.player.currentLight == null) {
            g2.setColor(new Color(0, 0, 0, 0.89f));
        } else {
            int centerX = gp.player.screenX + (gp.tileSize) / 2;
            int centerY = gp.player.screenY + (gp.tileSize) / 2;

            // create gradiation
            Color color[] = new Color[5];
            float fraction[] = new float[5];
            color[0] = new Color(0, 0, 0, 0f);
            color[1] = new Color(0, 0, 0, 0.25f);
            color[2] = new Color(0, 0, 0, 0.5f);
            color[3] = new Color(0, 0, 0, 0.75f);
            color[4] = new Color(0, 0, 0, 0.98f);

            fraction[0] = 0f;
            fraction[1] = 0.25f;
            fraction[2] = 0.5f;
            fraction[3] = 0.75f;
            fraction[4] = 1f;

            // create a graditon paint setting for the lighting cicle
            RadialGradientPaint gPaint = new RadialGradientPaint(centerX, centerY, gp.player.currentLight.lightRadius,
                    fraction, color);
            // set the gradient data on g2
            g2.setPaint(gPaint);
            // draw the light circle

        }
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        g2.dispose();

    }

    public void resetDay(){
        dayState = day;
        filterAlpha = 0f;
    }
    
    public void update() {
        if (gp.player.lightUpdated == true) {
            setLightSource();
            gp.player.lightUpdated = false;
        }
        // check state of the day
        if (dayState == day) {

            dayCounter++;
            if (dayCounter > 900) {
                dayState = dusk;
                dayCounter = 0;

            }
        }
        if (dayState == dusk) {
            filterAlpha += 0.001f;
            if (filterAlpha > 1f) {
                filterAlpha = 1f;
                dayState = night;
            }

        }
        if (dayState == night) {
            dayCounter++;
            if (dayCounter > 900) {
                dayState = dawn;
                dayCounter = 0;
            }
        }
        if (dayState == dawn) {
            filterAlpha -= 0.001f;
            if(filterAlpha < 0f){
                filterAlpha = 0;
                dayState = day;
            }
        }
    }

    public void draw(Graphics2D g2) {
        
        if (gp.currentArea == gp.outside){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, filterAlpha));
        }
        
        if (gp.currentArea == gp.outside || gp.currentArea == gp.dungeon1){
            g2.drawImage(darknessFilter, 0, 0, null);
        }
        if (gp.currentArea == gp.outside || gp.currentArea == gp.dungeon2){
            g2.drawImage(darknessFilter, 0, 0, null);
        }
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

    }
}
