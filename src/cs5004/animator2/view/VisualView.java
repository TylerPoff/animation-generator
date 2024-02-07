package cs5004.animator2.view;

import cs5004.animator2.model.AModel;
import cs5004.animator2.model.Canvas;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * This class represents the visual view for the animation.
 * @author Tyler Poff
 */
public class VisualView extends JFrame implements View {
  private static final long serialVersionUID = 1L;
  private APanel panel;
  private AModel model;
  
  /**
   * Constructor for VisualView.
   * @param model the model that the view is based on
   */
  public VisualView(AModel model) {
    this.model = model;
  }

  @Override
  public void display() {
    Canvas c = model.getCanvas();
    this.panel = new APanel(model, c.getX(), c.getY(), c.getL(), c.getH());
    this.setTitle("Animation - Visual View");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().setBackground(Color.WHITE);
    this.setPreferredSize(new Dimension(c.getL(), c.getH()));
    this.setLocation(c.getX(), c.getY());
    this.setVisible(true);
    this.add(panel);
    this.pack();
  }
}
