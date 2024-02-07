package cs5004.animator2.model;

/**
 * This class represents an adjustment where the shape moves from one point to another.
 * @author Tyler Poff
 */
public class Move extends AdjustImp {
  private Point originPoint;
  private Point newPoint;

  /**
   * Constructor for move.
   * @param s the Shape that the move is associated with
   * @param start the starting time tick of the move
   * @param end the ending time tick of the move
   * @param originPoint the starting point of the move
   * @param newPoint the ending point of the move
   */
  public Move(Shape s, int start, int end, Point originPoint, Point newPoint) {
    super(s, start, end);
    this.originPoint = originPoint;
    this.newPoint = newPoint;
  }
  
  /**
   * Gets the original reference point of the Shape.
   * @return The location of the Shape before the move
   */
  public Point getOriginPoint() {
    return originPoint;
  }

  /**
   * Gets the new reference point of the Shape.
   * @return The location of the Shape after the move
   */
  public Point getNewPoint() {
    return newPoint;
  }
  
  @Override
public String getTextDisplay() {
    return "Shape " + s.getName() + " moves from " + originPoint.toString() + " to "
        + newPoint.toString() + " from t=" + start + " to t=" + end + "\n";
  }

}
