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
 * Junit tests for SVGView
 * @author Tyler Poff
 */
public class SvgViewTest {
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
   * Testing getSVGOutput().
   */
  @Test
  public void testGetSvgView() {
    assertEquals(m.getSvgOutput(), "<svg width=\"1700\" height=\"1500\" version=\"1.1\"\r\n"
    		+ "     xmlns=\"http://www.w3.org/2000/svg\"> \r\n"
    		+ "     <rect id=\"r1\" x=\"0.00\" y=\"0.00\" width=\"30.00\" height=\"10.00\" \r\n"
    		+ "          fill=\"rgb(255,0,0)\" visibility=\"visible\"> \r\n"
    		+ "          <animate \r\n"
    		+ "                attributType=\"xml\" \r\n"
    		+ "                begin=\"0ms\" \r\n"
    		+ "                dur=\"5000ms\" \r\n"
    		+ "                attributeName=\"x\" \r\n"
    		+ "                from=\"0.00\" \r\n"
    		+ "                to=\"400.00\" \r\n"
    		+ "                fill=\"freeze\" /> \r\n"
    		+ "          <animate \r\n"
    		+ "                attributType=\"xml\" \r\n"
    		+ "                begin=\"0ms\" \r\n"
    		+ "                dur=\"5000ms\" \r\n"
    		+ "                attributeName=\"y\" \r\n"
    		+ "                from=\"0.00\" \r\n"
    		+ "                to=\"500.00\" \r\n"
    		+ "                fill=\"freeze\" /> \r\n"
    		+ "     </rect>\r\n"
    		+ " \r\n"
    		+ "     <ellipse id=\"o1\" cx=\"307.50\" cy=\"320.00\" rx=\"7.50\" ry=\"20.00\" \r\n"
    		+ "          fill=\"rgb(0,255,0)\" visibility=\"visible\"> \r\n"
    		+ "          <animate  \r\n"
    		+ "                attributType=\"xml\"   \r\n"
    		+ "                attributeName=\"fill\"   \r\n"
    		+ "                begin=\"0ms\"   \r\n"
    		+ "                dur=\"10000ms\"   \r\n"
    		+ "                from=\"rgb(0,255,0)\" \r\n"
    		+ "                to=\"rgb(0,0,255)\"  \r\n"
    		+ "                fill=\"freeze\" /> \r\n"
    		+ "     </ellipse>\r\n"
    		+ " \r\n"
    		+ "</svg>");
  }
  
}