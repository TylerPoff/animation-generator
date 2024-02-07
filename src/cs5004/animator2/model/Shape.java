package cs5004.animator2.model;

import java.awt.Color;

/**
 * This interface describes methods that all Shapes should contain.
 * @author Tyler Poff
 */
public interface Shape {
  
  /**
  * Sets the reference point for a Shape.
  * @param ref a Point that serves as the basis for the location of the Shape on a grid
  */
  void setRef(Point ref);
  
  /**
   * Sets the color for a Shape.
   * @param c a Color that represents the color of the Shape
   */
  void setColor(Color c);
  
  /**
   * Sets the length (horizontal distance) of the Shape.
   * @param x a double representing the length of the Shape on the x-axis
   */
  void setLength(double x);
  
  /**
   * Sets the height (vertical distance) of the Shape.
   * @param x a double representing the height of the Shape on the y-axis
   */
  void setHeight(double x);
  
  /**
   * Gets the reference point of the Shape.
   * @return a Point representing the reference point of the Shape
   */
  Point getRef();
  
  /**
   * Gets the name of the Shape.
   * @return a String representing the name of the Shape
   */
  String getName();
  
  /**
   * Gets the color of the Shape.
   * @return a Color represnting the color of the Shape
   */
  Color getColor();
  
  /**
   * Gets the length of the Shape.
   * @return a double representing the horizontal length of the Shape
   */
  double getLength();
  
  /**
   * Gets the height of the Shape.
   * @return a double representing the vertical height of the Shape
   */
  double getHeight();
  
  /**
   * Gets the appearance time of the Shape.
   * @return an int representing the appearance time tick that the Shape appears at
   */
  int getAppearance();
  
  /**
   * Gets the disappearance time of the Shape.
   * @return an int representing the disappearance time tick that Shape disappears at
   */
  int getDisappearance();
  
  /**
   * Finds whether the Shape is initialized or not.
   * @return a boolean determining whether a Shape has been initialized or not
   */
  boolean getIsInitialized();
  
  /**
   * Sets the initialization status of a Shape.
   * @param b the status the initialization should be set to.
   */
  void setIsInitialized(boolean b);

}
