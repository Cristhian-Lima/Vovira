package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import java.awt.Point;
import java.util.ArrayList;

import eventos.KeyBoard;
import estado.*;

public class Vivora extends Objeto {

  private ArrayList<Point> cuerpo = new ArrayList<>(); 
  private int xa = Const.DIAMETRO;
  private int ya;

  private int direccion = KeyEvent.VK_RIGHT;

  // constructor
  public Vivora(Point position) {
    super(position);
    init();
  }

  public void init() {
    cuerpo.add(position);
    for (int i = 1; i <= 3; i++) {
      cuerpo.add(new Point(position.x - (i * Const.DIAMETRO), position.y));
    }
  }

  private void movimiento() {
    // para la cabeza

    if (KeyBoard.SALIR) {
      Estado.cambiarEstado(new EstadoMenu());
    }
    if (KeyBoard.UP) {
      if (direccion != KeyEvent.VK_DOWN) {
        ya = (Const.DIAMETRO * (-1));
        xa = 0;
        direccion = KeyEvent.VK_UP;
      }
      return;
    }
    if (KeyBoard.DOWN) {
      if (direccion != KeyEvent.VK_UP) {
        ya = Const.DIAMETRO;
        xa = 0;
        direccion = KeyEvent.VK_DOWN;
      }
      return;
    }
    if (KeyBoard.RIGHT) {
      if (direccion != KeyEvent.VK_LEFT) {
        xa = Const.DIAMETRO;
        ya = 0;
        direccion = KeyEvent.VK_RIGHT;
      }
      return;
    }
    if (KeyBoard.LEFHT) {
      if (direccion != KeyEvent.VK_RIGHT) {
        xa = (Const.DIAMETRO * (-1));
        ya = 0;
        direccion = KeyEvent.VK_LEFT;
      }
      return;
    }
  }

  @Override
  public void update() {

    movimiento();

    for (int i = cuerpo.size() - 1; i >= 0; i--) {
      if (i == 0) {

        position.x += xa;
        position.y += ya;

      } else {
        Point actual = cuerpo.get(i);
        Point next = cuerpo.get(i-1);

        actual.x = next.x;
        actual.y = next.y;
      }
    }
  } // mover

  public boolean isCanival() {
    boolean is = false;
    if (cuerpo.size() >= 5) {
      for (int i = 5; i < cuerpo.size(); i++) {
        if (position.equals(cuerpo.get(i))) {
          is = true;
          break;
        }
      }
    }
     return is;
  }

  @Override
  public void draw(Graphics g) {
      g.setColor(Const.VIVORA);
      for (Point p : cuerpo) {
        g.fillOval(p.x, p.y, Const.DIAMETRO, Const.DIAMETRO);
      }
  } // paint


  public void crecer() {
    Point p = cuerpo.get(cuerpo.size() - 1);
    Point np = new Point(p.x, p.y);
    cuerpo.add(np);
  }

  public Rectangle getBounds() {
    return new Rectangle(position.x, position.y, Const.DIAMETRO, Const.DIAMETRO);
  }

}
