package cs5004.animator2.model;

/**
 * This class represents an adjustment where the shape changes dimensions.
 * @author Tyler Poff
 */
public class ChangeScale extends AdjustImp {
  private double originLength;
  private double originHeight;
  private double newLength;
  private double newHeight;

  /**
   * Constructor for ChaneScale.
   * @param s the shape the scale change is associated with
   * @param start the starting time tick of the scale change
   * @param end the ending time tick of the scale change
   * @param originLength the stating length of the shape
   * @param originHeight the starting height of the shape
   * @param newLength the ending length of the shape
   * @param newHeight the ending height of the shape
   */
  public ChangeScale(Shape s, int start, int end, double originLength, double originHeight, 
      double newLength, double newHeight) {
    super(s, start, end);
    this.originLength = originLength;
    this.originHeight = originHeight;
    this.newLength = newLength;
    this.newHeight = newHeight;
  }
  
  /**
   * Gets the original length of the Shape.
   * @return The length that the Shape is at the beginning of the scale change
   */
  public double getOriginLength() {
    return originLength;
  }

  /**
   * Gets the original height of the Shape.
   * @return the height that the Shape is at the beginning of the scale change
   */
  public double getOriginHeight() {
    return originHeight;
  }

  /**
   * Gets the new length of the Shape.
   * @return the length that the Shape will be at the end of the scale change
   */
  public double getNewLength() {
    return newLength;
  }

  /**
   * Gets the new height of the Shape.
   * @return the height that the Shape will be at the end of the scale change
   */
  public double getNewHeight() {
    return newHeight;
  }

  @Override
  public String getTextDisplay() {
    return "Shape " + s.getName() + " scales from " + "length: " + originLength + ", height: "
        + originHeight + " to length: " + newLength + ", height: " + newHeight + " from t="
        + start + " to t=" + end + "\n";
  }

}
