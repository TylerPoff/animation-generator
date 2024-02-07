import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cs5004.animator2.model.AModel;
import cs5004.animator2.model.Adjust;
import cs5004.animator2.model.ChangeColor;
import cs5004.animator2.model.ChangeScale;
import cs5004.animator2.model.Move;
import cs5004.animator2.model.Oval;
import cs5004.animator2.model.Point;
import cs5004.animator2.model.Rectangle;
import cs5004.animator2.model.Shape;

/**
 * Junit tests for AModel.
 * @author Tyler Poff
 */
public class AModelTest {
  private Rectangle r1;
  private Oval o1;
  private Move m1;
  private ChangeColor cc1;
  private ChangeScale cs1;
  private AModel model;
  private ArrayList<Shape> shapeTest;
  private ArrayList<Adjust> adjustTest;
	
  /**
   * Set up for Junit tests.
   */
  @Before
  public void setUp() {
    r1 = new Rectangle("r1");
    o1 = new Oval("o1");
    m1 = new Move(r1, 0, 30, r1.getRef(), new Point(50,50));
    cc1 = new ChangeColor(o1, 5, 50, o1.getColor(), new Color(200,200,200));
    cs1 = new ChangeScale(o1, 50, 100, o1.getLength(), o1.getHeight(), 50, 30);
    model = new AModel();
    model.addShape(r1);
    model.addShape(o1);
    model.addAdjust(m1);
    model.addAdjust(cc1);
    model.addAdjust(cs1);
    shapeTest = new ArrayList<>();
    adjustTest = new ArrayList<>();
    shapeTest.add(r1);
    shapeTest.add(o1);
    adjustTest.add(m1);
    adjustTest.add(cc1);
    adjustTest.add(cs1);
  }
  
  /**
   * Testing getShapes().
   */
  @Test
  public void testGetShapes() {
    assertEquals(shapeTest, model.getShapes());
  }
  
  /**
   * Testing getAdjusts().
   */
  @Test
  public void testGetAdjusts() {
    assertEquals(adjustTest, model.getAdjusts());
  }
  
  /**
   * Testing addShape().
   */
  @Test
  public void testAddShape() {
    AModel modelTest1 = new AModel();
    modelTest1.addShape(r1);
    modelTest1.addShape(o1);
    modelTest1.addAdjust(m1);
    modelTest1.addAdjust(cc1);
    modelTest1.addAdjust(cs1);
    Rectangle rTest1 = new Rectangle("r1");
    modelTest1.addShape(rTest1);
    String shapesText = r1.toString() +"\n" + o1.toString() + "\n" + 
          rTest1.toString() + "\n";
    assertEquals(shapesText, modelTest1.getShapesText());
    
	  
  }
  
  /**
   * Testing addAdjust().
   */
  @Test
  public void testAddAdjust() {
	  
  }
  
  /**
   * Testing getShapesText().
   */
  @Test
  public void testGetShapesText() {
    String shapesText = r1.toString() +"\n"+  o1.toString() + "\n";
    assertEquals(shapesText, model.getShapesText());
  }
  
  /**
   * Testing getAdjustsText().
   */
  @Test
  public void testGetAdjustsText() {
    String adjustsText = m1.getTextDisplay() + "\n" + cc1.getTextDisplay() + "\n"
        + cs1.getTextDisplay() + "\n";
    assertEquals(adjustsText, model.getAdjustsText());
  }
  
  /**
   * Testing getShapesSVG().
   */
  @Test
  public void testGetShapesSVG() {
	  
  }
  
  
	
}
