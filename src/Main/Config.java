package Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Config {
    GamePanel gp;

    public Config(GamePanel gp) {
        this.gp = gp;
    }

    public void saveConfig(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("config.txt"));
            if(gp.FullscreanOn == true){
                bw.write("On");
            }
            if(gp.FullscreanOn == false){
                bw.write("Off");
            }
            bw.newLine();
            //music volume
            bw.write(String.valueOf(gp.music.volumeScale));
            bw.newLine();
            bw.write(String.valueOf(gp.se.volumeScale));
            bw.newLine();
            bw.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void loadConfig() {
        try {BufferedReader br = new BufferedReader(new FileReader("config.txt")); 
        String s = br.readLine();
        //full screen
        if(s.equals("On")){
            gp.FullscreanOn = true;

        }
        if(s.equals("Off")){
            gp.FullscreanOn = false;

        }
        //music volume
        s = br.readLine();
        gp.music.volumeScale = Integer.parseInt(s);

        //SE volume
        s = br.readLine();
        gp.se.volumeScale = Integer.parseInt(s);

        br.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
