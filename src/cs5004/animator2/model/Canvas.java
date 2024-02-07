package cs5004.animator2.model;

/**
 * Represents the dimensions of the animation window.
 * @author Tyler Poff
 *
 */
public class Canvas {
  private int x;
  private int y;
  private int l;
  private int h;
  
  /**
   * Constructor for Canvas.
   * @param x x-coordinate of the top left corner of window
   * @param y y-coordinate of the top left corner of window
   * @param l length of window
   * @param h height of window
   */
  public Canvas(int x, int y, int l, int h) {
    this.x = x;
    this.y = y;
    this.l = l;
    this.h = h;
  }
  
  /**
   * Gets x-coordinate of the top left corner of window.
   * @return a coordinate for the location of the window
   */
  public int getX() {
    return x;
  }
  
  /**
   * Gets y-coordinate of the top left corner of window.
   * @return a coordinate for the location of window
   */
  public int getY() {
    return y;
  }
 
  /**
   * Gets length of the window.
   * @return the length of the window
   */
  public int getL() {
    return l;
  }
  
  /**
   * Gets the height of the window.
   * @return the height of the window
   */
  public int getH() {
    return h;
  }

}
