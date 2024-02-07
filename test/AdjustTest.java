import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import cs5004.animator2.model.ChangeColor;
import cs5004.animator2.model.ChangeScale;
import cs5004.animator2.model.Move;
import cs5004.animator2.model.Oval;
import cs5004.animator2.model.Point;
import cs5004.animator2.model.Rectangle;

/**
 * Junit tests for Adjust.
 * @author Tyler Poff
 */
public class AdjustTest {
  private Move m1;
  private ChangeColor cc1;
  private ChangeScale cs1;
  private Rectangle r1;
  private Oval o1;

  /**
   * Set up for Junit tests.
   */
  @Before
  public void setUp() {
    r1 = new Rectangle("r1");
    o1 = new Oval("o1");
    m1 = new Move(r1, 0, 30, new Point(7,8), new Point(50,50));
    cc1 = new ChangeColor(o1, 5, 50, Color.BLACK, new Color(200,200,200));
    cs1 = new ChangeScale(o1, 50, 100, 40, 35, 50, 30);
  }
  
  /**
   * Testing getStart().
   */
  @Test
  public void testGetStart() {
    assertEquals(0, m1.getStart());
    assertEquals(5, cc1.getStart());
    assertEquals(50, cs1.getStart());
  }
  
  /**
   * Testing getEnd().
   */
  @Test
  public void testGetEnd() {
    assertEquals(30, m1.getEnd());
    assertEquals(50, cc1.getEnd());
    assertEquals(100, cs1.getEnd());
  }
  
  /**
   * Testing getTextDisplay().
   */
  @Test
  public void testGetTextDisplay() {
    String mText = "Shape r1 moves from (7.0,8.0) to (50.0,50.0) from t=0 to t=30\n";
    assertEquals(mText, m1.getTextDisplay());
    String ccText = "Shape o1 changes color from (0,0,0) to (200,200,200) from t=5 to t=50\n";
    assertEquals(ccText, cc1.getTextDisplay());
    String csText = "Shape o1 scales from length: 40.0, height: 35.0 "
    		+ "to length: 50.0, height: 30.0 from t=50 to t=100\n";
    assertEquals(csText, cs1.getTextDisplay());
  }
  
  /*
   * Testing setStart().
   */
  @Test
  public void testSetStart() {
    Move m1set = new Move(r1, 0, 30, r1.getRef(), new Point(50,50));
    ChangeColor cc1set = new ChangeColor(o1, 5, 50, o1.getColor(), new Color(0,0,0));
    ChangeScale cs1set = new ChangeScale(o1, 50, 100, o1.getLength(), o1.getHeight(), 50, 30);
    m1set.setStart(10);
    cc1set.setStart(15);
    cs1set.setStart(99);
    assertEquals(10, m1set.getStart());
    assertEquals(15, cc1set.getStart());
    assertEquals(99, cs1set.getStart());
	  
  }
  
  /**
   * Testing setEnd().
   */
  @Test
  public void testSetEnd() {
    Move m2set = new Move(r1, 0, 30, r1.getRef(), new Point(50,50));
    ChangeColor cc2set = new ChangeColor(o1, 5, 50, o1.getColor(), new Color(0,0,0));
    ChangeScale cs2set = new ChangeScale(o1, 50, 100, o1.getLength(), o1.getHeight(), 50, 30);
    m2set.setEnd(200);
    cc2set.setEnd(201);
    cs2set.setEnd(202);
    assertEquals(200, m2set.getEnd());
    assertEquals(201, cc2set.getEnd());
    assertEquals(202, cs2set.getEnd());
	  
  }
  
  /**
   * Testing getOriginPoint().
   */
  @Test
  public void testGetOriginPoint() {
    assertEquals(new Point(7,8).toString(), m1.getOriginPoint().toString());
  }
  
  /**
   * Testing getNewPoint().
   */
  @Test
  public void testGetNewPoint() {
    assertEquals(new Point(50,50).toString(), m1.getNewPoint().toString());
  }
  
  /**
   * Testing getOriginColor().
   */
  @Test
  public void testGetOriginColor() {
    assertEquals(Color.BLACK, cc1.getOriginColor());  
  }
  
  /**
   * Testing getNewColor().
   */
  @Test
  public void testGetNewColor() {
    assertEquals(new Color(200,200,200), cc1.getNewColor());
  }
  
  /**
   * Testing getOriginLength().
   */
  @Test
  public void testGetOriginLength() {
    assertEquals(40, cs1.getOriginLength(), 0.01);
  }
  
  /**
   * Testing getOriginHeight().
   */
  @Test
  public void testGetOriginHeight() {
    assertEquals(35, cs1.getOriginHeight(), 0.01);
  }
  
  /**
   * Testing getNewLength().
   */
  @Test
  public void testGetNewLength() {
    assertEquals(50, cs1.getNewLength(), 0.01);
  }
  
  /**
   * Testing getNewHeight().
   */
  @Test
  public void testGetNewHeight() {
    assertEquals(30, cs1.getNewHeight(), 0.01);
  }

}
