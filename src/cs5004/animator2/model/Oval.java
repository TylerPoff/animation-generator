package cs5004.animator2.model;

/**
 * This class represents an oval shape.
 * @author Tyler Poff
 */
public class Oval extends ShapeImp {

  /**
  * Constructor for ShapeImp.
  * @param name a String representing the name of the Shape
  * @throws IllegalArgumentException
  *       If dimensions are non-positive
  *       If appearance is negative or dissappearance is non-positive
  *       If the disappearance time is before the appearance time
  */
  public Oval(String name) {
    super(name);
  }
  
  /**
   * Provides a text based summary of the Shape.
   */
  public String toString() {
    return "Name: " + this.name + "\n" + "Type: " + "Oval" + "\n" 
        + "Min corner: " + this.ref.toString() + ", Horizontal Radius: " 
        + String.format("%.1f", length / 2) + ", Vertical Radius: "
        + String.format("%.1f", height / 2) + ", "
        + "Color: (" + c.getRed() + "," + c.getGreen() + "," + c.getBlue()
        + ")\n" ;
  }

}
