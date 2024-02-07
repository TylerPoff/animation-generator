import static org.junit.Assert.assertEquals;

import cs5004.animator2.model.Oval;
import cs5004.animator2.model.Point;
import cs5004.animator2.model.Rectangle;
import org.junit.Before;
import org.junit.Test;

import java.awt.Color;

/**
 * Junit tests for Shape.
 * @author Tyler Poff
 */
public class ShapeTest {
  private Rectangle r1;
  private Oval o1;
  boolean passed;
  
  /**
   * Set up for Junit tests.
   */
  @Before
  public void setUp() {
    r1 = new Rectangle("r1");
    o1 = new Oval("o1");
  }
  
  /**
   * Testing getName().
   */
  @Test
  public void testGetName() {
    assertEquals("r1", r1.getName());
    assertEquals("o1", o1.getName());
  }
  
  /**
   * Testing setRef().
   */
  @Test
  public void testSetRef() {
    Rectangle rSet1 = new Rectangle("r1");
    rSet1.setRef(new Point(11, 10));
    assertEquals(new Point(11,10).toString(), rSet1.getRef().toString());
  }
  
  /**
   * Testing setColor().
   */
  @Test
  public void testSetColor() {
    Rectangle rSet2 = new Rectangle("r1");
    rSet2.setColor(new Color(100,101,102));
    assertEquals(new Color(100,101,102), rSet2.getColor());
  }
  
  /**
   * Testing setLength().
   */
  @Test
  public void testSetLength() {
    Rectangle rSet3 = new Rectangle("r1");
    rSet3.setLength(7);
    assertEquals(7, rSet3.getLength(), 0.01); 
  }
  
  /**
   * Testing setHeight().
   */
  @Test
  public void testSetHeight() {
    Rectangle rSet4 = new Rectangle("r1");
    rSet4.setHeight(7);
    assertEquals(7, rSet4.getHeight(), 0.01);
  }
}
