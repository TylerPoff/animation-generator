import static org.junit.Assert.assertEquals;

import cs5004.animator2.model.Point;
import org.junit.Before;
import org.junit.Test;


/**
 * Junit tests for Point.
 * @author Tyler Poff
 */
public class PointTest {
  private Point p1;

  /**
   * Set up for Junit tests.
   */
  @Before
  public void setUp() {
    p1 = new Point(2, 3);
  }
  
  /**
   * Testing getX().
   */
  @Test
  public void testGetX() {
    assertEquals(2, p1.getX(), 0.01);
  }
  
  /**
   * Testing getY().
   */
  @Test
  public void testGetY() {
    assertEquals(3, p1.getY(), 0.01);
  }
  
  /**
   * Testing setX().
   */
  @Test
  public void testSetX() {
    p1.setX(4);
    assertEquals(4, p1.getX(), 0.01);
  }
  
  /**
   * Testing setY().
   */
  @Test
  public void testSetY() {
    p1.setY(7);
    assertEquals(7, p1.getY(), 0.01);
  }
  
  /**
   * Testing toString().
   */
  @Test 
  public void testToString() {
    String pointString = "(2.0,3.0)";
    assertEquals(pointString, p1.toString());
  }
}
