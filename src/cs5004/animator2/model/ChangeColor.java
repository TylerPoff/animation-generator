package cs5004.animator2.model;

import java.awt.Color;

/**
 * This class represents an adjustment where the shape changes color from one to another.
 * @author Tyler Poff
 */
public class ChangeColor extends AdjustImp {
  private Color originColor;
  private Color newColor;
  
  /**
   * Constructor for ChangeColor.
   * @param s the Shape the color change is associated with
   * @param start the starting time tick of the color change
   * @param end the ending time tick of the color change
   * @param originColor the starting color of the shape
   * @param newColor the ending color of the shape
   */
  public ChangeColor(Shape s, int start, int end, Color originColor, Color newColor) {
    super(s, start, end);
    this.originColor = originColor;
    this.newColor = newColor;
  }
  
  /**
   * Gets the color that the Shape currently is.
   * @return the Color that the Shape is at the beginning of the color change
   */
  public Color getOriginColor() {
    return originColor;
  }

  /**
   * Gets the color that Shape will become.
   * @return the Color that the Shape will be at the end of the adjustment
   */
  public Color getNewColor() {
    return newColor;
  }
  
  @Override
  public String getTextDisplay() {
    return "Shape " + s.getName() + " changes color from (" + originColor.getRed() + "," 
        + originColor.getGreen() + "," + originColor.getBlue() + ") to (" 
        + newColor.getRed() + "," + newColor.getGreen() + "," + newColor.getBlue()
        + ") from t=" + start + " to t=" + end + "\n";
   
  }

}
