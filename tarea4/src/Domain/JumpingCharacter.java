package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class JumpingCharacter extends Character {

    public JumpingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 3; i++) {
        sprite.add(new Image(new FileInputStream("src/Assets/Jumping"+i+".png")));
        }
        
       
    }

    @Override
    public void run() {
        int controler = 370;
        ArrayList<Image> sprite = super.getSprite();
        super.setImage(sprite.get(0));
        while (true) {

            try {

                if (controler == 370) {
                    super.setImage(sprite.get(2));
                    Thread.sleep(400);
                    controler = 369;
                }

                if (controler == 369) {
                    super.setImage(sprite.get(0));
                    for (int i = 350; i >= 170; i = i - 5) {
                        Thread.sleep(28);
                        this.setY(i);
                        controler = i;
                    }
                    if (controler == 170) {
                        super.setImage(sprite.get(1));
                        for (int i = 170; i <= 370; i = i + 5) {
                            Thread.sleep(26);
                            this.setY(i);
                            controler = i;

                        }
                    }
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}
