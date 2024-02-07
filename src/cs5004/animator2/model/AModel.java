package cs5004.animator2.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * This class represents the overall model for the animator.
 * The model contains a list of all shapes added and all adjustments made.
 * @author Tyler Poff
 */
public class AModel {
  private ArrayList<Shape> shapes;
  private ArrayList<Adjust> adjusts;
  private HashMap<Shape, ArrayList<Adjust>> map;
  private Canvas c;
  private int timeUnit = 50; 
  private String outFile;
  private int endT;

  /**
   * Constructor for AModel.
   */
  public AModel() {
    this.shapes = new ArrayList<>();
    this.adjusts = new ArrayList<>();
    this.map = new HashMap<>();
    endT = 0;
  }

  /**
   * Gets the end time of the animation.
   * @return The current end time associated with the animation.
   */
  public int getEndT() {
    return endT;
  }

  /**
   * Sets the end time of the animation.
   * @param endT the new end time of the animation.
   */
  public void setEndT(int endT) {
    this.endT = endT;
  }

  /**
   * Gets the file that certain views can be output to.
   * @return A file that will contain the animation output
   */
  public String getOutFile() {
    return outFile;
  }

  /**
   * Sets the file that certain views can be output to.
   * @param outFile The new out file.
   */
  public void setOutFile(String outFile) {
    this.outFile = outFile;
  }
  
  /**
   * Sets the list of shapes.
   * @param shapes an arraylist containing all the shapes involved in the animation
   */
  public void setShapes(ArrayList<Shape> shapes) {
    this.shapes = shapes;
  }

  /**
   * Sets the list of adjustments.
   * @param adjusts an arraylist containing all the adjustments involved in the animation
   */
  public void setAdjusts(ArrayList<Adjust> adjusts) {
    this.adjusts = adjusts;
  }
  
  /**
   * Gets the list of shapes.
   * @return an arraylist containing all the shapes involved in the animation
   */
  public ArrayList<Shape> getShapes() {
    return this.shapes;
  }
  
  /**
   * Finds the Shape in the list of Shapes by name.
   * @param name is the String name of the shape
   * @return The Shape that has the associated name
   */
  public Shape getShapeByName(String name) {
    for (Shape sp : shapes) {
      if (sp.getName().equals(name)) {
        return sp;
      }
    }
    return null;
  }
  
  /**
   * Gets the list of adjustments.
   * @return an arraylist containing all the adjustments involved in the animation
   */
  public ArrayList<Adjust> getAdjusts() {
    return this.adjusts;
  }
  
  /**
   * Sets the canvas that the animation will be displayed on.
   * @param x x-coordinate of top left of canvas
   * @param y y-coordinate of top left of canvas
   * @param l length of canvas
   * @param h height of canvas
   */
  public void setCanvas(int x, int y, int l, int h) {
    this.c = new Canvas(x,y,l,h);
  }
  
  /**
   * Gets the canvas that the animation will be displayed on.
   * @return The canvas that the animation will be displayed on.
   */
  public Canvas getCanvas() {
    return this.c;
  }
  
  /**
   * Sets the relative speed of the animation.
   * @param speed a factor that indicates the relative speed of the animation
   */
  public void setSpeed(int speed) {
    if (timeUnit / speed > 0) {
      timeUnit /= speed;
    }
  }
  
  /**
   * Gets the relative speed of the animation.
   * @return a factor that indicates the relative speed of the animation
   */
  public int getSpeed() {
    return timeUnit;
  }
  
  /**
   * Adds a shape to the list of the shapes.
   * @param s the shape to be added onto the list 
   * @throws IllegalArgumentException if the shape to be added already exists
   */
  public void addShape(Shape s) {
    shapes.add(s);
  }
  
  /**
   * Adds an adjustment to the list of adjustments.
   * @param a the adjustment to be added onto the list
   */
  public void addAdjust(Adjust a) {
    if (a != null) {
      adjusts.add(a);
      endT = Math.max(a.getEnd(), endT);
    }
  }
  
  /**
   * Sorts adjustments on the basis of their starting time.
   */
  public void sortAdjusts() {
    Collections.sort(adjusts, new Comparator<Adjust>() {
      @Override
      public int compare(Adjust o1, Adjust o2) {
        return o1.getStart() - o2.getStart();
      }
    });
  }
  
  /**
   * Gets a text based summary of a shape.
   * @return a String summarizing the shape involved in the animation
   */
  public String getShapesText() {
    String shapesString = "";
    if (!shapes.isEmpty()) {
      for (Shape s: shapes) {
        shapesString += s.toString() + "\n";
      }
    }
    return shapesString;
  }
  
  /**
   * Gets a text based summary of an adjustment.
   * @return a String summarizing the adjustment involved in the animation
   */
  public String getAdjustsText() {
    String adjustsString = "";
    if (!adjusts.isEmpty()) {
      for (Adjust a: adjusts) {
        adjustsString += a.getTextDisplay() + "\n";
      }
    }
    return adjustsString;
  }
  
  /**
   * Helper sort for organizing adjustments based on Shape.
   */
  private void bucketSortAdjusts() {
    if (shapes.isEmpty() || adjusts.isEmpty()) {
      return;
    }
    for (Adjust a: adjusts) {
      Shape s = a.getShape();
      if (map.containsKey(s)) {
        ArrayList<Adjust> list = map.get(s);
        list.add(a);
        map.put(s, list);
      } else {
        ArrayList<Adjust> list = new ArrayList<>();
        list.add(a);
        map.put(s, list);
      }
    }
  }
  
  /**
   * Returns a String in the format suitable for SVG output.
   * @return a String in the SVG format
   */
  public String getSvgOutput() {
    bucketSortAdjusts();
    String svgString = "<svg width=\"1700\" height=\"1500\" version=\"1.1\"\r\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\"> \r\n";
    if (!shapes.isEmpty()) {
      for (Shape s: shapes) {
        boolean isRec = s instanceof Rectangle;
        
        String sStr = isRec ? String.format("     <%s id=\"%s\" x=\"%.2f\" y=\"%.2f\" "
            + "width=\"%.2f\" height=\"%.2f\" \r\n"
            + "          fill=\"rgb(%d,%d,%d)\" visibility=\"visible\"> \r\n", "rect", 
            s.getName(),s.getRef().getX(), s.getRef().getY(), 
            s.getLength(), s.getHeight(), s.getColor().getRed(), 
            s.getColor().getGreen(), s.getColor().getBlue())
            : String.format("     <%s id=\"%s\" cx=\"%.2f\" cy=\"%.2f\" "
            + "rx=\"%.2f\" ry=\"%.2f\" \r\n"
            + "          fill=\"rgb(%d,%d,%d)\" visibility=\"visible\"> \r\n ",  
            "ellipse", s.getName(),
            s.getRef().getX() + (s.getLength() / 2), s.getRef().getY() + (s.getHeight() / 2), 
            s.getLength() / 2, s.getHeight() /  2, s.getColor().getRed(), 
            s.getColor().getGreen(), s.getColor().getBlue());
        svgString += sStr;
        if (map.containsKey(s)) {
          ArrayList<Adjust> adjs = map.get(s);
          for (Adjust a: adjs) {
            String aStr = "";
            if (a instanceof Move) {
              Move m = (Move) a;
              aStr += String.format("          <animate \r\n"
              + "                attributType=\"xml\" \r\n"
              + "                begin=\"%dms\" \r\n"
              + "                dur=\"%dms\" \r\n"
              + "                attributeName=\"%s\" \r\n"
              + "                from=\"%.2f\" \r\n"
              + "                to=\"%.2f\" \r\n"
              + "                fill=\"freeze\" /> \r\n", m.getStart() * timeUnit, 
              timeUnit * (m.getEnd() - m.getStart()),
              isRec ? "x" : "cx", isRec ? m.getOriginPoint().getX() : m.getOriginPoint().getX() 
              + (s.getHeight() / 2), 
              isRec ? m.getNewPoint().getX() : m.getNewPoint().getX() + (s.getHeight() / 2));
              aStr += String.format("          <animate \r\n"
              + "                attributType=\"xml\" \r\n"
              + "                begin=\"%dms\" \r\n"
              + "                dur=\"%dms\" \r\n"
              + "                attributeName=\"%s\" \r\n"
              + "                from=\"%.2f\" \r\n"
              + "                to=\"%.2f\" \r\n"
              + "                fill=\"freeze\" /> \r\n", m.getStart() * timeUnit, 
              timeUnit * (m.getEnd() - m.getStart()), 
              isRec ? "y" : "cy", isRec ? m.getOriginPoint().getY() 
              : m.getOriginPoint().getY() + (m.getShape().getHeight() / 2), 
              isRec ? m.getNewPoint().getY() 
              : m.getNewPoint().getY() + (m.getShape().getHeight() / 2));
            } else if (a instanceof ChangeColor) {
              ChangeColor cc = (ChangeColor) a;
              Color c1 = cc.getOriginColor();
              Color c2 = cc.getNewColor();
              aStr += String.format("         <animate  \r\n"
              + "                attributType=\"xml\"   \r\n"
              + "                attributeName=\"fill\"   \r\n"
              + "                begin=\"%dms\"   \r\n"
              + "                dur=\"%dms\"   \r\n"
              + "                from=\"rgb(%d,%d,%d)\" \r\n"
              + "                to=\"rgb(%d,%d,%d)\"  \r\n"
              + "                fill=\"freeze\" /> \r\n", cc.getStart() * timeUnit, 
              timeUnit * (cc.getEnd() - cc.getStart()), c1.getRed(), c1.getGreen(), c1.getBlue(),
              c2.getRed(), c2.getGreen(), c2.getBlue());
            } else {
              ChangeScale cs = (ChangeScale) a;
              aStr += String.format("          <animate \r\n"
              + "                attributType=\"xml\" \r\n"
              + "                begin=\"%dms\" \r\n"
              + "                dur=\"%dms\" \r\n"
              + "                attributeName=\"width\" \r\n"
              + "                from=\"%.2f\" \r\n"
              + "                to=\"%.2f\" \r\n"
              + "                fill=\"freeze\" /> \r\n", cs.getStart() * timeUnit, 
              timeUnit * (cs.getEnd() - cs.getStart()), cs.getOriginLength(), cs.getNewLength());
              aStr += String.format("          <animate \r\n"
              + "                attributType=\"xml\" \r\n"
              + "                begin=\"%dms\" \r\n"
              + "                dur=\"%dms\" \r\n"
              + "                attributeName=\"height\" \r\n"
              + "                from=\"%.2f\" \r\n"
              + "                to=\"%.2f\" \r\n"
              + "                fill=\"freeze\" /> \r\n", cs.getStart() * timeUnit, 
              timeUnit * (cs.getEnd() - cs.getStart()), cs.getOriginHeight(), cs.getNewHeight());
            }
            svgString += aStr;
          }
        }
        svgString += "     " + ((s instanceof Rectangle) ? "</rect>" : "</ellipse>" ) + "\r\n \r\n";
      }
    }
    svgString += "</svg>";
    return svgString;
  }
  
}
