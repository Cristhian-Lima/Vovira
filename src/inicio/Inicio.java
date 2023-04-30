package inicio;

// paquetes de java...
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;

// paquetes locales...
import game.Const;
import estado.*;
import eventos.*;

public class Inicio extends JFrame implements Runnable {

  private boolean running = false;
  private Thread thread;
  private Canvas canvas;
  private BufferStrategy bs;
  private Graphics g;

  private final int FPS = 13;
  private double TARGETTIME = 1000000000/FPS;
  private double delta = 0;

  private KeyBoard keyBoard;
  private Mouse mouse;

  public Inicio() {

    setTitle(Const.TITLE);
    setSize(Const.WIDHT, Const.HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setVisible(true);

    canvas = new Canvas();

    canvas.setPreferredSize(new Dimension(Const.WIDHT, Const.HEIGHT));
    canvas.setMaximumSize(new Dimension(Const.WIDHT, Const.HEIGHT));
    canvas.setMinimumSize(new Dimension(Const.WIDHT, Const.HEIGHT));
    canvas.setFocusable(true);

    keyBoard = new KeyBoard();
    canvas.addKeyListener(keyBoard);
    mouse = new Mouse();
    canvas.addMouseListener(mouse);

    add(canvas);

  }

  /*-----------------MAIN-----------------*/
  public static void main(String[] args) {
    new Inicio().start();
  }
  /*-----------------MAIN-----------------*/

  private void init() {
    Estado.cambiarEstado(new EstadoMenu());
  }

  private void update() {
    keyBoard.update();
    Estado.getEstadoActual().update();
  }

  private void draw() {
    bs = canvas.getBufferStrategy();
    
    if (bs == null) {
      canvas.createBufferStrategy(2);
      return;
    }

    g = bs.getDrawGraphics();
    /*---------------Espacio para dibujar------------------------*/
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

    g.clearRect(0, 0, Const.WIDHT, Const.HEIGHT);

    Estado.getEstadoActual().draw(g);

    /*---------------Espacio para dibujar------------------------*/
    g.dispose();
    bs.show();

  }

  @Override
  public void run() {

    long now = 0;
    long lastTime = System.nanoTime();

    init();

    while(running) {
      now = System.nanoTime();
      delta += (now - lastTime) / TARGETTIME;
      lastTime = now;

      if (delta >= 1) {
        update();
        draw();

        delta--;
      }
    }

    stop();
  }

  public void start() {
    thread = new Thread(this);
    thread.start();
    running = true;

  }
  public void stop() {
    try {
      thread.join();
      running = false;
    } catch(Exception e){
      e.printStackTrace();
    }

  }
  /*-----------------MAIN-----------------*/
}
