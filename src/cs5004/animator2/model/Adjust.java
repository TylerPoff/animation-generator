package cs5004.animator2.model;

/**
 * Contains all methods that an adjustment (to a Shape) should contain.
 * An adjustment is defined as a type of change to a Shape.
 * @author Tyler Poff
 */
public interface Adjust {

  /**
   * Sets the start time of the adjustment.
   * @param newStart represents the time tick t that the adjustment starts at.
   */
  void setStart(int newStart);
  
  /**
   * Sets the end time of the adjustment.
   * @param newEnd represents the time tick t that the adjustment ends at.
   */
  void setEnd(int newEnd);

  /**
   * Gets the start time of the adjustment.
   * @return an integer representing the start time tick t.
   */
  int getStart();
  
  /**
   * Gets the end time of the adjustment.
   * @return an integer representing the end time tick t.
   */
  int getEnd();
  
  /**
   * Gets the shape the adjustment is associated with.
   * @return the Shape that the adjustment is associated with.
   */
  Shape getShape();
  
  /**
   * Displays a text describing the adjustment.
   * @return a String that describes the adjustment
   */
  String getTextDisplay();
}
