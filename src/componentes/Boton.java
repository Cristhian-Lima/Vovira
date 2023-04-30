package componentes;

import java.awt.Graphics;
import java.awt.FontMetrics;
import java.awt.Rectangle;

import game.Const;
import eventos.Mouse;

public class Boton {

  private int x, y;
  private String text;
  private Rectangle r;

  private static final int WIDHT = 70;
  private static final int HEIGHT = 30;

  private Accion accion;

  public Boton(int x, int y, String text, Accion a) {
    this.x = x;
    this.y = y;
    this.text = text;
    this.accion = a;

    this.r = new Rectangle(x, y, WIDHT, HEIGHT);
  }

  public void update() {
    if (r.contains(Mouse.X, Mouse.Y) && Mouse.CLICK) {
      accion.click();
    }
  }

  public void draw(Graphics g) {

    g.setColor(Const.BG_SCORE);
    g.fillRoundRect(x, y, WIDHT, HEIGHT, 15, 15);

    g.setFont(Const.FONT_SMALL);
    g.setColor(Const.LETRAS);
    FontMetrics fm = g.getFontMetrics();

    int centerX = x + (WIDHT / 2);
    int centerY = y + (HEIGHT / 2);

    g.drawString(text, centerX - fm.stringWidth(text)/2, centerY + fm.getDescent());
  }
}
