

package cs5004.animator2.controller;

import cs5004.animator.util.AnimationBuilder;
import cs5004.animator2.model.AModel;
import cs5004.animator2.model.ChangeColor;
import cs5004.animator2.model.ChangeScale;
import cs5004.animator2.model.Move;
import cs5004.animator2.model.Oval;
import cs5004.animator2.model.Point;
import cs5004.animator2.model.Rectangle;
import cs5004.animator2.model.Shape;
import cs5004.animator2.view.View;

import java.awt.Color;

/**
 * Builds the animation based off a general text-based set of instructions.
 * @author Tyler Poff
 *
 */
public class Builder implements AnimationBuilder<AModel> {
  private AModel model;


  /**
   * Constructor for Builder.
   * @param model The model to be built.
   * @param view The view used to display the animation.
   * @param inFile The file to be read from.
   * @param speed The relative speed of the animation.
   * @param outFile The file to output the display to (Only applicable to some views).
   */
  public Builder(AModel model, View view, String inFile, int speed, String outFile) {
    this.model = model;
    model.setOutFile(outFile);
  }

  /**
   * Returns the model that is being built/has been built.
   */
  @Override
  public AModel build() {
    return this.model;
  }

  @Override
  public AnimationBuilder<AModel> setBounds(int x, int y, int width, int height) {
    model.setCanvas(x, y, width, height);
    return this;
  }

  @Override
  public AnimationBuilder<AModel> declareShape(String name, String type) {
    Shape s = type.equals("rectangle") ? new Rectangle(name) : new Oval(name);
    model.addShape(s);
    return this;
  }

  @Override
  public AnimationBuilder<AModel> addMotion(String name, int t1, int x1, int y1, int w1, int h1, int r1, 
      int g1, int b1,int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
    Shape s = model.getShapeByName(name);
    if (x1 != x2 || y1 != y2) {
      model.addAdjust(new Move(s, t1, t2, new Point(x1,y1), new Point(x2, y2)));
    }
    if (w1 != w2 || h1 != h2) {
      model.addAdjust(new ChangeScale(s, t1, t2, w1, h1, w2, h2));
    }
    if (r1 != r2 || g1 != g2 || b1 != b2) {
      model.addAdjust(new ChangeColor(s, t1, t2, new Color(r1, g1, b1), new Color(r2,g2,b2)));
    }
    if (t1 == t2) {
      if (!s.getIsInitialized()) {
        s.setRef(new Point(x1,y1));
        s.setLength(w1);
        s.setHeight(h1);
        s.setColor(new Color(r1,g1,b1));
        s.setIsInitialized(true);
      }
    }
    return this;
  }
}
