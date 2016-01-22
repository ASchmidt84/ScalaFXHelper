package de.intelligyscience.scalafx.helper

import scalafx.scene.control.ButtonBar.ButtonData
import scalafx.scene.control._
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.image.ImageView
import scalafx.scene.layout.{Priority, GridPane}
import java.io.{PrintWriter, StringWriter}

/**
  * Created by andre on 22.01.16.
  */
object DialogHelper {

  def dialog(text: String, header: String, title: String, alertType: AlertType) = {
    val alert = new Alert(alertType)
    alert.title = title
    if(header.nonEmpty) alert.headerText = header
    alert.contentText = text
    alert
  }

  def infoDialog(text: String, header: String = "", title: String = "Information") = {
    dialog(text,header,title,AlertType.Information)
  }

  def errorDialog(text: String, header: String = "", title: String = "Fehler") = {
    dialog(text,header,title,AlertType.Error)
  }

  def exceptionDialog(exception: Throwable, text: String, header: String = "", title: String = "Ausnahmefehler") = {
    val alert = dialog(text,header,title,AlertType.Error)
    val label = new Label("Error stacktrace:")

    val sw = new StringWriter()
    val pw = new PrintWriter(sw)
    exception.printStackTrace(pw)

    val textArea = new TextArea(sw.toString)
    textArea.editable = false
    textArea.wrapText = true
    textArea.maxWidth = Double.MaxValue
    textArea.maxHeight = Double.MaxValue
    GridPane.setVgrow(textArea,Priority.Always)
    GridPane.setHgrow(textArea,Priority.Always)
    val expContent = new GridPane()
    expContent.add(label,0,0)
    expContent.add(textArea,0,1)
    alert.dialogPane().setExpandableContent(textArea)
    alert
  }

  def inputDialog(input: String,title: String, content: String, header: String = "") = {
    val dialog = new TextInputDialog(input)
    dialog.title = title
    if(header.nonEmpty) dialog.headerText = header
    dialog.contentText = content
    dialog
  }

  def complexDialog[A](title:String, header:String, icon: ImageView) = {
    val dialog = new Dialog[A]()
    dialog.title = title
    dialog.headerText = header
    dialog.graphic = icon
    dialog.width = 800
    dialog.height = 600
    dialog
  }

  def choiceDialog[A](title: String, header: String, contentText: String, elems: Seq[A]) = {
    val dialog = new ChoiceDialog[A]()
    dialog.items ++= elems
    dialog.title = title
    dialog.headerText = header
    dialog.contentText = contentText
    dialog
  }

  def safeButton(msgKey: String = "Speichern")= new ButtonType(msgKey,ButtonData.OKDone)

  def notImplementedDialog(content: String, title: String = "Noch nicht implementiert", header: String = "Noch nicht implementiert") = {
    dialog(
      content,
      header,
      title,
      AlertType.Warning
    )
  }


}
