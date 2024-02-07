package cs5004.animator2.model;

import java.awt.Color;

/**
 * Implementation class for the interface Shape.
 * @author Tyler Poff
 */
public class ShapeImp implements Shape {
  protected String name;
  protected Point ref;
  protected Color c;
  protected double length;
  protected double height;
  protected int appearance;
  protected int disappearance;
  private boolean isInitialized;
  
  /**
   * Constructor for ShapeImp.
   * @param name a String representing the name of the Shape
   * @throws IllegalArgumentException
   *       If dimensions are non-positive
   *       If appearance is negative or dissappearance is non-positive
   *       If the disappearance time is before the appearance time
   */
  public ShapeImp(String name) {
    isInitialized = false;
    this.name = name;
  }

  public boolean isInitialized() {
    return isInitialized;
  }
  
  @Override
  public void setIsInitialized(boolean isInitialized) {
    this.isInitialized = isInitialized;
  }

  @Override
  public void setRef(Point newRef) {
    this.ref = newRef;
  }

  @Override
  public void setColor(Color newC) {
    this.c = newC;
  }

  @Override
  public void setLength(double newLength) {
    this.length = newLength;
  }

  @Override
  public void setHeight(double newHeight) {
    this.height = newHeight;
  }

  @Override
  public Point getRef() {
    return this.ref;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Color getColor() {
    return this.c;
  }
  
  @Override
  public double getLength() {
    return this.length;
  }

  @Override
  public double getHeight() {
    return this.height;
  }

  @Override
  public int getAppearance() {
    return this.appearance;
  }

  @Override
  public int getDisappearance() {
    return this.disappearance;
  }

  @Override
  public boolean getIsInitialized() {
    return false;
  }
}
