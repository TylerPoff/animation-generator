package viewTests;

import static org.junit.Assert.assertEquals;

import cs5004.animator2.model.AModel;
import cs5004.animator2.model.Adjust;
import cs5004.animator2.model.ChangeColor;
import cs5004.animator2.model.Move;
import cs5004.animator2.model.Oval;
import cs5004.animator2.model.Point;
import cs5004.animator2.model.Rectangle;
import org.junit.Before;
import org.junit.Test;

import java.awt.Color;

/**
 * Junit tests for textView
 * @author Tyler Poff
 */
public class TextViewTest {
  private Rectangle r1;
  private Oval o1;
  boolean passed;
  private AModel m;
  
  /**
   * Set up for Junit tests.
   */
  @Before
  public void setUp() {
    r1 = new Rectangle("r1");
    Point p1 = new Point(0,0);
    Point p2 = new Point(300, 300);
    r1.setRef(p1);
    r1.setHeight(10);
    r1.setLength(30);
    r1.setColor(Color.red);
    o1 = new Oval("o1");
    o1.setRef(p2);
    o1.setHeight(40);
    o1.setLength(15);
    o1.setColor(Color.green);
    
    m = new AModel();
    Adjust a1 = new Move(r1, 0, 100, r1.getRef(), new Point(400, 500));
    Adjust a2 = new ChangeColor(o1, 0, 200, o1.getColor(), Color.blue);
    m.addShape(r1);
    m.addShape(o1);
    m.addAdjust(a1);
    m.addAdjust(a2);
  }
  
  /**
   * Testing getTextView().
   */
  @Test
  public void testGetTextView() {
    assertEquals(m.getShapesText()+m.getAdjustsText(), "Name: r1\n"
    		+ "Type: Rectangle\n"
    		+ "Min corner: (0.0,0.0), Width: 30.0, Height: 10.0, Color: (255,0,0)\n"
    		+ "\n"
    		+ "Name: o1\n"
    		+ "Type: Oval\n"
    		+ "Min corner: (300.0,300.0), Horizontal Radius: 7.5, Vertical Radius: 20.0, Color: (0,255,0)\n"
    		+ "\n"
    		+ "Shape r1 moves from (0.0,0.0) to (400.0,500.0) from t=0 to t=100\n"
    		+ "\n"
    		+ "Shape o1 changes color from (0,255,0) to (0,0,255) from t=0 to t=200\n"
    		+ "\n");
  }
  
}
