package game;

import java.awt.Point;
import java.awt.Graphics;

public abstract class Objeto {

  protected Point position;

  public Objeto() {
    position = new Point();
  }
  public Objeto(Point pos) {
    this.position = pos;
  }

  public void setPosition(Point pos) {
    this.position = pos;
  }
  public Point getPosition() {
    return this.position;
  }

  // metodos abstractos...
  public abstract void update();
  public abstract void draw(Graphics g);

}
