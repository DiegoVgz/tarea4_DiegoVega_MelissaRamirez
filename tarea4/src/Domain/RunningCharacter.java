package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class RunningCharacter extends Character {

    public RunningCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i <8; i++) {
        sprite.add(new Image(new FileInputStream("src/Assets/Running"+i+".png")));
        }
       
        super.setSprite(sprite);
    }

    @Override
    public void run() {

        ArrayList<Image> sprite = super.getSprite();
        super.setImage(sprite.get(0));
        while (true) {
            try {
                int setImage = 0;
                int temp = 0;
                for (int i = 0; i <= 900; i = i + 5) {
                    super.setImage(sprite.get(setImage));
                    super.setX(i);

                    Thread.sleep(20);
                    if (i == temp + 20) {
                        setImage++;
                        temp = i;

                    }

                    if (setImage == 7) {
                        setImage = 0;
                    }
                }

            } catch (InterruptedException ex) {
            }
        }
    }
}
