package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

public class StandingCharacter extends Character {

    public StandingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 4; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Standing" + i + ".png")));
        }
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        int controler = 0;
        int time = 0;
        ArrayList<Image> sprite = super.getSprite();
        super.setImage(sprite.get(0));

        while (true) {

            try {
                if (time == 800) {

                    if(controler==0){
                    for (int i = 0; i <= 3; i++) {
                        Thread.sleep(100);
                        super.setImage(sprite.get(i));
                    }
                    controler=3;
                    }
                    if(controler==3){
                    for (int i = 3; i >= 0; i--) {
                        Thread.sleep(100);
                        super.setImage(sprite.get(i));
                    }
                    controler=0;
                    }
                    time = 0;
                }
                time++;
                Thread.sleep(4);

            } catch (InterruptedException ex) {
            }
        }
    }
}
