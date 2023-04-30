
package game;

import java.awt.Graphics;
import java.util.Random;
import java.awt.Rectangle;

public class Comida extends Objeto {
  private Random random = new Random();

  public Comida () {
    position.x = rndX();
    position.y = rndY();
  }

  private int rndX() {
    int num = 0;
    do {
      num = (random.nextInt(Const.WIDHT - Const.DIAMETRO));
    } while (num % 15 != 0);
    return num;
  }
  private int rndY() {
    int num = 0;
    do {
      num = (int) Math.floor(random.nextDouble() * ((Const.HEIGHT / 20) - 525) + 525);
    } while (num % 15 != 0);
    return num;
  }

  public Rectangle getBounds() {
    return new Rectangle(position.x, position.y, Const.DIAMETRO, Const.DIAMETRO);
  }

  @Override
  public void update() {
    position.x = rndX();
    position.y = rndY();
  }
  @Override
  public void draw(Graphics g) {
    g.setColor(Const.COMIDA);
    g.fillOval(position.x, position.y, Const.DIAMETRO, Const.DIAMETRO);
  }
  
}
