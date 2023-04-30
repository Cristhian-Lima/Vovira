package estado;

import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.FontMetrics;

import componentes.Boton;
import componentes.Accion;
import game.Const;

public class EstadoMenu extends Estado {

  private ArrayList<Boton> botones;

  public EstadoMenu() {
    this.botones = new ArrayList<>();

    int y = Const.HEIGHT / 2;
    botones.add(
        new Boton(255, y, "Jugar", new Accion() {
          @Override
          public void click() {
            Estado.cambiarEstado(new EstadoGame());
          }
        })
    );

    botones.add(
        new Boton(255, y + 58, "Salir", new Accion() {
          @Override
          public void click() {
            System.exit(0);
          }
        })
    );
  }

  @Override
  public void update() {
    for (Boton b : botones) 
      b.update();
  }

  @Override
  public void draw(Graphics g) {

    g.setColor(Const.BG);
    g.fillRect(0, 0, Const.WIDHT, Const.HEIGHT);

    g.setColor(Const.BG_SCORE);
    g.setFont(Const.FONT_BIG);
    FontMetrics fm = g.getFontMetrics();
    g.drawString(Const.TITLE, (Const.WIDHT / 2) - fm.stringWidth(Const.TITLE)/2, (Const.HEIGHT / 2) - fm.getHeight());

    for (Boton b : botones) 
      b.draw(g);
  }
}
