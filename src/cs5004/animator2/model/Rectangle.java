package cs5004.animator2.model;

/**
 * This class represents a rectangle shape.
 * @author Tyler Poff
 */
public class Rectangle extends ShapeImp {

  /**
  * Constructor for ShapeImp.
  * @param name a String representing the name of the Shape
  * @throws IllegalArgumentException
  *       If dimensions are non-positive
  *       If appearance is negative or dissappearance is non-positive
  *       If the disappearance time is before the appearance time
  */
  public Rectangle(String name) {
    super(name);
  }
  
  /**
   * Provides a text based summary of the Shape.
   */
  public String toString() {
    return "Name: " + this.name + "\n" + "Type: " + "Rectangle" + "\n" 
        + "Min corner: " + this.ref.toString() + ", Width: " 
        + String.format("%.1f", length) + ", Height: "
        + String.format("%.1f",height) + ", Color: (" + c.getRed() + "," 
        + c.getGreen() + "," + c.getBlue() 
        + ")\n" ;
  }

}
