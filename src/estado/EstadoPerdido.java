package estado;

import java.awt.Graphics;
import java.awt.FontMetrics;
import java.util.ArrayList;

import game.Const;
import componentes.Boton;
import componentes.Accion;


public class EstadoPerdido extends Estado {

  private int puntos;


  private ArrayList<Boton> botones;

  public EstadoPerdido (int p) {
    this.puntos = p;
    this.botones = new ArrayList<>();
    botones.add(
      new Boton(255, 416, "Play", new Accion() {
        @Override
        public void click() {
          Estado.cambiarEstado(new EstadoGame());
        }
      })
    );

    botones.add(
      new Boton(255, 474, "Salir", new Accion() {
        @Override
        public void click() {
          System.exit(0);
        }
      })
    );

  }
  @Override
  public void update() {
    for (Boton b : botones) {
      b.update();
    }
  }

  @Override
  public void draw(Graphics g) {

    g.setColor(Const.BG);
    g.fillRect(0, 0, Const.WIDHT, Const.HEIGHT);

    g.setFont(Const.FONT_BIG);
    g.setColor(Const.BG_SCORE);

    FontMetrics fm = g.getFontMetrics();

    String mensaje = "GAME OVER";
    int x = (Const.WIDHT / 2) - fm.stringWidth(mensaje) / 2;
    int y = (Const.HEIGHT / 2);
    g.drawString(mensaje, x, y);

    String score = "Puntaje: " + puntos;
    y += fm.getHeight();
    g.drawString(score, x, y);

    for (Boton b : botones) {
      b.draw(g);
    }
  }
}
