package cs5004.animator2.view;

import cs5004.animator2.model.AModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * This class represents the SVG based view of the animation.
 * @author Tyler Poff
 */
public class SvgView implements View {
  protected AModel model;
  
  /**
   * Constructor for SVGView.
   * @param model The model the view will work off of
   */
  public SvgView(AModel model) {
    this.model = model;
  }
  
  @Override
  public void display() {
    try {
      File f = new File(model.getOutFile());
      FileOutputStream fos = new FileOutputStream(f);
      PrintWriter pw = new PrintWriter(fos);
      pw.write(model.getSvgOutput());
      pw.flush();
      fos.close();
      pw.close();  
    } catch (Exception e) {
      System.out.println(model.getSvgOutput());
    }
  }

}
