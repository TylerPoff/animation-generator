package cs5004.animator2.model;

/**
 * Abstract implementation for an adjustment.
 * @author Tyler Poff
 */
public abstract class AdjustImp implements Adjust {
  protected Shape s;
  protected int start;
  protected int end;
  
  /**
   * Constructor for AdjustImp
   * All adjustments will know the Shape associated with it, when it starts, and when it ends.
   * @param s the Shape that the adjustment is associated with
   * @param start the starting time tick the adjustment begins at
   * @param end the ending time tick the adjustment ends at
   */
  public AdjustImp(Shape s, int start, int end) {
    this.s = s;
    this.start = start;
    this.end = end;
  }

  @Override
  public void setStart(int newStart) {
    this.start = newStart;
  }

  @Override
  public void setEnd(int newEnd) {
    this.end = newEnd;
  }

  @Override
  public int getStart() {
    return this.start;
  }

  @Override
  public int getEnd() {
    return this.end;
  }
  
  @Override
  public Shape getShape() {
    return this.s;
  }

}
