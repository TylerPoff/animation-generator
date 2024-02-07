package cs5004.animator2.model;


/**
 * This class represents a point on a 2D animation frame.
 * @author Tyler Poff
 */
public class Point {
  private double x;
  private double y;
  
  /**
   * Constructor for Point.
   * @param x represents where the point is on the horizontal plane
   * @param y represents where the point is on the vertical plane
   */
  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }
  
  /**
   * Returns the horizontal location of the Point.
   * @return a double representing the horizontal location of the Point
   */
  public double getX() {
    return this.x;
  }
  
  /**
   * Returns the vertical location of the Point.
   * @return a double representing the vertical location of the Point
   */
  public double getY() {
    return this.y;
  }
  
  /**
   * Sets the horizontal location of the Point.
   * @param x sets a double to the horizontal location of the Point
   */
  public void setX(double x) {
    this.x = x;
  }
  
  /**
   * Sets the vertical location of the Point.
   * @param y sets a double to the vertical location of the Point
   */
  public void setY(double y) {
    this.y = y;
  }
  
  /**
   * Displays a String representing the coordinates of the Point.
   */
  public String toString() {
    String res = String.format("(%.1f", this.x) + "," + String.format("%.1f)", this.y);
    return res;
  }
}