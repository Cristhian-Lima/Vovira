package estado;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import game.Vivora;
import game.Comida;
import game.Const;

public class EstadoGame extends Estado {

  static int NEW_HEIGHT = Const.HEIGHT - (Const.HEIGHT / 20) - 30;
  private int PUNTAJE = 0;

  private Vivora vivora;
  private Comida comida;

  public EstadoGame() {
    vivora = new Vivora(new Point(0, Const.HEIGHT/2));
    comida = new Comida();
  }

  public int getPuntaje() {
    return this.PUNTAJE;
  }

  public Rectangle getBounds() {
    return new Rectangle(0, Const.HEIGHT / 20, Const.WIDHT, NEW_HEIGHT);
  }

  @Override
  public void update() {

    // termina cuando choca con la pared
    vivora.update();
    if (!getBounds().contains(vivora.getPosition()) ||
        vivora.isCanival()) {
      Estado.cambiarEstado(new EstadoPerdido(PUNTAJE));
      return;
    }


    // cuando come
    if (vivora.getPosition().equals(comida.getPosition())) {
      comida.update();
      vivora.crecer();
      PUNTAJE++;
    }
  }

  public void drawScore(Graphics g) {

    g.setColor(Const.BG_SCORE);
    g.fillRect(0, 0, Const.WIDHT, Const.HEIGHT / 20);

    String mensaje = "Puntuación: " + PUNTAJE;
    g.setColor(Const.LETRAS);
    g.setFont(Const.FONT_SMALL);
    g.drawString(mensaje, 30, 20);
  }

  @Override
  public void draw(Graphics g) {

    g.setColor(Const.BG);
    g.fillRect(0, 0, Const.WIDHT, Const.HEIGHT);

    drawScore(g);
    vivora.draw(g);
    comida.draw(g);
  }
}
