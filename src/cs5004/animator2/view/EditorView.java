package cs5004.animator2.view;

import cs5004.animator2.model.AModel;
import cs5004.animator2.model.Canvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


/**
 * This class represents the Editor view for the animation.
 * @author Tyler Poff
 */
public class EditorView extends JFrame implements View {
  private static final long serialVersionUID = 1L;
  private APanel panel;
  private AModel model;
  private boolean isPause;
  JButton start;
  JButton pause ;
  JButton resume;
  JButton restart;
  JButton loop;
  JButton inc;
  JButton dec;
  private int speed = 1;
 
  /**
   * Constructor for EditorView.
   * @param model the model that the view is based on
   */
  public EditorView(AModel model) {
    this.model = model;
    isPause = true;
  }

  @Override
  public void display() {
    Canvas c = model.getCanvas();
    this.panel = new APanel(model, c.getX(), c.getY(), c.getL(), c.getH());
    start = new JButton("Start");
    ActionListener st = new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (isPause) {
          panel.setTick(speed);
        }
        isPause = false;
      }
    };
    start.addActionListener(st);
    panel.add(start);
    pause = new JButton("Pause");
    pause.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (!isPause) {
          panel.setTick(0);
        }
        isPause = true;
      }
    });
    panel.add(pause);
    resume = new JButton("Resume");
    resume.addActionListener(st);
    panel.add(resume);
    restart = new JButton("Restart");
    restart.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        panel.setThisTime(0);
        speed = 1;
        panel.setSpeed(speed);
        isPause = false;
      }
    });
    panel.add(restart);
    loop = new JButton("Loop");
    loop.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        panel.setLoop(!panel.isLoop());
      }
    });
    panel.add(loop);
    inc = new JButton("+");
    inc.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        speed++;
        panel.setTick(speed);
      }
    });
    panel.add(inc);
    dec = new JButton("-");
    dec.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (speed > 0) {
          speed--;
        }
        panel.setTick(speed);
      }
    });
    panel.add(dec);
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