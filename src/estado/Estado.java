package estado;

import java.awt.Graphics;

public abstract class Estado {

  private static Estado estado_actual = null;

  public static Estado getEstadoActual() {
    return estado_actual;
  }
  public static void cambiarEstado(Estado e) {
    estado_actual = e;
  }

  public abstract void update();
  public abstract void draw(Graphics g);
}
