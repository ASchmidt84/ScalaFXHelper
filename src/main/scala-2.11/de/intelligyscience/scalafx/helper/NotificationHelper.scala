package de.intelligyscience.scalafx.helper

import java.util.function.Consumer

import org.controlsfx.control.NotificationPane

import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.Node

/**
  * Created by andre on 21.07.16.
  */
object NotificationHelper {

  private implicit def toJavaConsumer(function: javafx.event.ActionEvent => Unit): Consumer[javafx.event.ActionEvent] = new Consumer[javafx.event.ActionEvent]() {
    override def accept(arg: javafx.event.ActionEvent): Unit = function.apply(arg)
  }

  private implicit def toScalaConsumer(function: ActionEvent => Unit): Consumer[javafx.event.ActionEvent] = new Consumer[javafx.event.ActionEvent]() {
    override def accept(arg: javafx.event.ActionEvent): Unit = function.apply(arg)
  }

  def rawNotificationPane(content: Node) = {
    val note = new NotificationPane(content)
    note
  }

  def createJavaFXAction(name: String, action: (javafx.event.ActionEvent) => Unit) = {
    new org.controlsfx.control.action.Action(name,action)
  }

  def createScalaFXAction(name: String, action: (ActionEvent) => Unit) = {
    new org.controlsfx.control.action.Action(name,action)
  }

}
