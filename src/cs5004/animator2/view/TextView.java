package cs5004.animator2.view;

import cs5004.animator2.model.AModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * This class represents the text based view of the animation.
 * @author Tyler Poff
 */
public class TextView implements View {
  protected AModel model;
  
  /**
   * Constructor for TextView.
   * @param model is the model that the view is based on.
   */
  public TextView(AModel model) {
    this.model = model;
  }

  @Override
  public void display() {
    try {
      File f = new File(model.getOutFile());
      FileOutputStream fos = new FileOutputStream(f);
      PrintWriter pw = new PrintWriter(fos);
      pw.write(model.getShapesText() + model.getAdjustsText());
      pw.flush();
      fos.close();
      pw.close();  
    } catch (Exception e) {
      System.out.println(model.getShapesText());
      System.out.println(model.getAdjustsText());
    }
  }
}
