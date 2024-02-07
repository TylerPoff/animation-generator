Introduction

This animation project's goal is to create simple 2-Dimensional animations from simple shapes. The program will receive a set of text-based instructions
and produce an animation, specifically of the style that the user chooses.

Model

The model package contains the logical basis for how the animation operates. The model is made up of the Shape interface and its derivatives,
the Adjust interface and its derivatives, the Canvas, and the AModel (for Animation Model).

  Shape
  
  The Shape series are classes that represent a simple Shape of the animation.
  Shapes can obtain information about their dimensions, location, and color. 
  Since the Shape has all this information about itself, it can produce a text based interpretation also.	

  Adjust
  
  The Adjust series are classes that represent the manipulations of Shapes and when along the timeline that they happen.
  This includes changing location, changing dimensions, and changing color.
  Similarly to Shape, it can produce a text based interpretation of itself also.

  Canvas
  
  The Canvas represents the animation window in the visual views.
  It can set where and how big the animation window will be.

  AModel
  
  The AModel contains the logical basis for making the animations work, given Shapes and their Adjusts.
  The AModel contains a list of Shapes and Adjusts involved in the animation. From this, the total Text based and SVG view can be outputted from combining
      the information obtained from every Shape and every Adjust.
  Additionally, the AModel contains the logic for setting the relative speed of the animation and setting up the Canvas.
 
View

The view package contains pathways to obtain the View style that the user indicates, using logic from the model

  TextView
  
  The Text based view provides a written intepretation of the animation.
  It first provides information about every Shape involved, and then lists every Adjustment the Shapes will undergo.

  Visual View
  
  The Visual based view provides a visual interpretation of the animation upon activation.
  The user can actively see the animation and its manipulations in real time from opening.

  SVG View
  
  The SVG based view provides text that can be interpreted by an SVG file to display the animation in real-time.

  Editor View
  
  The Editor is the same as the Visual view, but with buttons added to the animation window for added functionality.
  This includes starting the animation, pausing and resuming the animation, looping the animation, and setting the relative speed of the animation.

Controller

The controller package allows the logic in the model to communicate with the logic in the view.

  Builder
  
  This class builds the canvas bounds, Shapes, and Motions (Adjusts) and returns a realized AModel that can be interpreted.

  EasyAnimator
  
  This class is the main method for the Animation project. It is a controller that mediates the model and the views.
  It will take instructions from the command line and choose which methods to be executed and which view to be displayed.
