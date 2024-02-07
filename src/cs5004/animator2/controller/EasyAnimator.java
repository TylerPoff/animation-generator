package cs5004.animator2.controller;

import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationReader;
import cs5004.animator2.model.AModel;
import cs5004.animator2.view.EditorView;
import cs5004.animator2.view.SvgView;
import cs5004.animator2.view.TextView;
import cs5004.animator2.view.View;
import cs5004.animator2.view.VisualView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.SwingUtilities;


/**
 * The controller for the animation.
 * @author Tyler Poff
 */
public class EasyAnimator {
  
  /**
  * This methods allows the animation to play.
  */
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    String str = "";
    try {
      str += br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    AModel model = new AModel();
    View view = new TextView(model);
    int speed = 1;
    String inFile = null;
    String outFile = null;
    
    String[] comps = str.split("-");
    for (String s: comps) {
      String[] pairs = s.split(" ");
      switch (pairs[0]) {
        case "in":
          inFile = pairs[1];
          break;
        case "view":
          switch (pairs[1]) {
            case "svg":
              view = new SvgView(model);
              break;
            case "visual":
              view = new VisualView(model);
              break;
            case "playback":
              view = new EditorView(model);
              break;
            default:
              break;
          }
          break;
        case "out":
          outFile = pairs[1];
          break;
        case "speed":
          try {
            speed = Integer.parseInt(pairs[1]);
          } catch (Exception e) {
            speed = 1;
          }
          break;
        default:
          break;
      }
    }
    model.setSpeed(speed);
    AnimationBuilder<AModel> builder = new Builder(model, view, inFile, speed, outFile);
    try {
      AnimationReader.parseFile(new FileReader(inFile), builder);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
     
    view.display();

    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new EasyAnimator();
      }
    });

  }
}
