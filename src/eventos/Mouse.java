package eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {

  public static int X = 0;
  public static int Y = 0;
  public static boolean CLICK = false;

  @Override
  public void mousePressed(MouseEvent e) {
    if (e.getButton() == MouseEvent.BUTTON1) {
      X = e.getX();
      Y = e.getY();
      CLICK = true;
    }
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    if (e.getButton() == MouseEvent.BUTTON1) {
      X = e.getX();
      Y = e.getY();
      CLICK = false;
    }
  }
}
