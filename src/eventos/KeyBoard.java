package eventos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class KeyBoard extends KeyAdapter {

  private boolean[] keys = new boolean[256];

  public static boolean RIGHT;
  public static boolean LEFHT;
  public static boolean UP;
  public static boolean DOWN;
  public static boolean SALIR;
  public static boolean PLAY;

  public KeyBoard() {
    RIGHT = false;
    LEFHT = false;
    UP = false;
    DOWN = false;
    SALIR = false;
    PLAY = false;
  }

  public void update() {
    RIGHT = keys[KeyEvent.VK_RIGHT];
    LEFHT = keys[KeyEvent.VK_LEFT];
    UP = keys[KeyEvent.VK_UP];
    DOWN = keys[KeyEvent.VK_DOWN];
    SALIR = keys[KeyEvent.VK_ESCAPE];
    PLAY = keys[KeyEvent.VK_SPACE];
  }

  @Override
  public void keyPressed(KeyEvent e) {
    keys[e.getKeyCode()] = true;

  }

  @Override
  public void keyReleased(KeyEvent e) {
    keys[e.getKeyCode()] = false;
  }
}

