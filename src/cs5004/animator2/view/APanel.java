package cs5004.animator2.view;

import cs5004.animator2.model.AModel;
import cs5004.animator2.model.Adjust;
import cs5004.animator2.model.ChangeColor;
import cs5004.animator2.model.ChangeScale;
import cs5004.animator2.model.Move;
import cs5004.animator2.model.Oval;
import cs5004.animator2.model.Rectangle;
import cs5004.animator2.model.Shape;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Panel class for the visual view.
 * @author Tyler Poff
 */
public class APanel extends JPanel {
  private static final long serialVersionUID = 1L;
  private Timer timer;
  private int thisTime;
  private AModel model;
  private int delay;
  private boolean isLoop = true;
  private int tick;

  /**
   * Constructor for APanel.
   * @param model The model for the animation
   * @param x x-coordinate for the panel
   * @param y y-coordinate for the panel
   * @param d1 length dimension of the frame
   * @param d2 height dimension of the frame
   */
  public APanel(AModel model, int x, int y, int d1, int d2) {
    super();
    this.model = model;
    delay = model.getSpeed();
    this.setLocation(x, y);
    this.setPreferredSize(new Dimension(d1,d2));
    this.setVisible(true);
    this.thisTime = 0;
    this.tick = 1; 
    timer = new Timer(delay, new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        repaint();
        update();
        thisTime += tick;
        if (isLoop) {
          thisTime %= model.getEndT();
        }
      }
    });
    timer.start();
  }
  
  /**
   * Gets current total ticks of the animation.
   * @return the current tick
   */
  public int getThisTime() {
    return thisTime;
  }

  /**
   * Sets the current total ticks of the animation.
   * @param thisTime the current tick
   */
  public void setThisTime(int thisTime) {
    this.thisTime = thisTime;
  }

  /**
   * Sets the relative speed of the animation.
   * @param speed the relative speed of the animation
   * @throws IllegalArgumentException if speed is non-positive
   */
  public void setSpeed(int speed) throws IllegalArgumentException {
    if (speed <= 0) {
      throw new IllegalArgumentException("Speed cannot be non-positive");
    }
    this.delay /= speed;
  }
  
  /**
   * Draws the components from the list of shapes in the model.
   */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D)g;
    for (Shape s: this.model.getShapes()) {
      int refX = (int)s.getRef().getX();
      int refY = (int)s.getRef().getY();
      int length = (int)s.getLength();
      int height = (int)s.getHeight();
      Color c = s.getColor();
      if (s instanceof Rectangle) {
        g2d.setColor(c);
        g2d.fillRect(refX, refY, length, height);
      }
      if (s instanceof Oval) {
        g2d.setColor(c);
        g2d.fillOval(refX, refY, length, height);
      }
    }
  }
  
  /**
   * Gets whether the animation is looping or not based on a boolean.
   * @return a boolean indicating whether the animation is looping or not
   */
  public boolean isLoop() {
    return isLoop;
  }

  /**
   * Sets whether the animation is looping or not.
   * @param isLoop a boolean indicating whether the animaiton is looping or not
   */
  public void setLoop(boolean isLoop) {
    this.isLoop = isLoop;
  }
  
  /**
   * Gets the ticks of the animation.
   * @return an integer that represents the ticks of the animation. This controls the relative speed
   */
  public int getTick() {
    return tick;
  }

  /**
   * Sets the ticks of the animation.
   * @param tick an integer that represents the ticks of the animation. 
   *     This controls the relative speed
   */
  public void setTick(int tick) {
    this.tick = tick;
  }
  
  /**
   * This method updates the shapes on the panel.
   */
  public void update() {
    for (Adjust a: model.getAdjusts()) {
      if (a.getStart() <= thisTime && a.getEnd() >= thisTime) {
        Shape s = a.getShape();
        int startT = a.getStart();
        int endT = a.getEnd();
        double totalT = endT - startT;
        double frac1 = (thisTime - startT) / (double)totalT;
        double frac2 = (endT - thisTime) / (double)totalT;
        if (a instanceof Move) {
          Move m = (Move)a;
          double x1 = m.getOriginPoint().getX();
          double x2 = m.getNewPoint().getX();
          double y1 = m.getOriginPoint().getY();
          double y2 = m.getNewPoint().getY();
          double x = (x1 * frac2) + (x2 * frac1); 
          double y = (y1 * frac2) + (y2 * frac1);
          s.getRef().setX(x);
          s.getRef().setY(y);
        } else if (a instanceof ChangeColor) {
          ChangeColor cc = (ChangeColor)a;
          Color c1 = cc.getOriginColor();
          Color c2 = cc.getNewColor();
          int r = (int) (c1.getRed() * frac2 + c2.getRed() * frac1);
          int g = (int) (c1.getGreen() * frac2 + c2.getGreen() * frac1);
          int b = (int) (c1.getBlue() * frac2 + c2.getBlue() * frac1);
          s.setColor(new Color(r,g,b));
        } else {
          ChangeScale cs = (ChangeScale) a;
          double l1 = cs.getOriginLength();
          double l2 = cs.getNewLength();
          double h1 = cs.getOriginHeight();
          double h2 = cs.getNewHeight();
          double l = l1 * frac2 + l2 * frac1;
          double h = h1 * frac2 + h2 * frac1;
          s.setLength(l);
          s.setHeight(h);
        }
      }
    }
  }
  
  

}

