package de.intelligyscience.scalafx.helper

import ui.RingProgressIndicator

import scalafx.scene.layout.AnchorPane
import scalafx.stage.{Modality, Screen, Stage, StageStyle}
import scalafx.Includes._
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.paint.Color

/**
  * Created by andre on 08.09.16.
  */
class RingProgressIndicatorScreen {

  val anchorPane = new AnchorPane()
  val progressIndicator = new RingProgressIndicator


  val stage = new Stage(){
    initStyle(StageStyle.Transparent)
    scene = new Scene(anchorPane){
      fill = Color.Transparent
    }
    initModality(Modality.ApplicationModal)
  }

  def indeterminate_=(x: Boolean) = progressIndicator.setProgress( if(x) -1 else 0 )
  def indeterminate = if(progressIndicator.getProgress < 0) true else false
  def progress_=(x: Int) = progressIndicator.setProgress(x)
  def progress = progressIndicator.getProgress


  def show(): Unit = {
    val screen = Screen.primary
    val bounds = screen.getVisualBounds
    AnchorPane.setAnchors(progressIndicator,0.0,0.0,0.0,0.0)
    anchorPane.children += progressIndicator
    anchorPane.opacity = 0.75
    anchorPane.padding = Insets( (bounds.getHeight-250)/2.0, (bounds.getWidth-250)/2.0, (bounds.getHeight-250)/2.0, (bounds.getWidth-250)/2.0 )
    stage.setX(bounds.getMinX)
    stage.setY(bounds.getMinY)
    stage.setWidth(bounds.getWidth)
    stage.setHeight(bounds.getHeight)
    stage.show()
  }

  def close(): Unit = {
    stage.close()
  }

}
