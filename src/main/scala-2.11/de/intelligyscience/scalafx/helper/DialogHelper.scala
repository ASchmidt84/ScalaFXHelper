package de.intelligyscience.scalafx.helper

import org.controlsfx.dialog.CommandLinksDialog
import org.controlsfx.dialog.CommandLinksDialog.CommandLinksButtonType

import scalafx.scene.Node
import scalafx.scene.control.ButtonBar.ButtonData
import scalafx.scene.control._
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.layout.{Priority, GridPane}
import java.io.{PrintWriter, StringWriter}

/**
  * Created by andre on 22.01.16.
  */
object DialogHelper {

  def dialog(text: String,
             header: String,
             title: String,
             alertType: AlertType,
             titleIcon: Image) = {
    val alert = new Alert(alertType)
    alert.title = title
    if(header.nonEmpty) alert.headerText = header
    alert.contentText = text
    alert.getDialogPane.getScene.getWindow.asInstanceOf[javafx.stage.Stage].getIcons.add( titleIcon )
    alert
  }

  def infoDialog(text: String,
                 header: String = "",
                 title: String = "Information")(implicit titleIcon: Image = ScalaFxHelper.getArrayOfResource("fallback_logo.png")) = {
    dialog(text,header,title,AlertType.Information,titleIcon)
  }

  def errorDialog(text: String,
                  header: String = "",
                  title: String = "Fehler")(implicit titleIcon: Image = ScalaFxHelper.getArrayOfResource("fallback_logo.png")) = {
    dialog(text,header,title,AlertType.Error,titleIcon)
  }

  def exceptionDialog(exception: Throwable,
                      text: String,
                      header: String = "",
                      title: String = "Ausnahmefehler")(implicit titleIcon: Image = ScalaFxHelper.getArrayOfResource("fallback_logo.png")) = {

    val alert = dialog(text,header,title,AlertType.Error,titleIcon)
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
    expContent.maxWidth = Double.MaxValue
    alert.dialogPane().setExpandableContent(textArea)
    alert.dialogPane().setExpanded(true)
    alert
  }

  def inputDialog(input: String,
                  title: String,
                  content: String,
                  header: String = "")(implicit titleIcon: Image = ScalaFxHelper.getArrayOfResource("fallback_logo.png")) = {
    val dialog = new TextInputDialog(input)
    dialog.title = title
    dialog.getDialogPane.getScene.getWindow.asInstanceOf[javafx.stage.Stage].getIcons.add( titleIcon )
    if(header.nonEmpty) dialog.headerText = header
    dialog.contentText = content
    dialog
  }

  def complexDialog[A](title:String,
                       header:String,
                       icon: ImageView)(implicit titleIcon: Image = ScalaFxHelper.getArrayOfResource("fallback_logo.png")) = {
    val dialog = new Dialog[A]()
    dialog.title = title
    dialog.headerText = header
    dialog.graphic = icon
    dialog.width = 800
    dialog.height = 600
    dialog.getDialogPane.getScene.getWindow.asInstanceOf[javafx.stage.Stage].getIcons.add( titleIcon )
    dialog
  }

  /**
    * Generates a dialog with a ComboBox the user can choose
    *
    * @param title
    * @param header
    * @param contentText
    * @param elems The elements who the user can choose
    * @tparam A Type of the Elements
    * @return
    */
  def choiceDialog[A](title: String,
                      header: String,
                      contentText: String,
                      elems: Seq[A])(implicit titleIcon: Image = ScalaFxHelper.getArrayOfResource("fallback_logo.png")) = {
    val dialog = new ChoiceDialog[A]()
    dialog.items ++= elems
    dialog.title = title
    dialog.headerText = header
    dialog.contentText = contentText
    dialog.getDialogPane.getScene.getWindow.asInstanceOf[javafx.stage.Stage].getIcons.add( titleIcon )
    dialog
  }

  lazy val dialogButton = (buttonData: ButtonData) => (text: String) => new ButtonType(text,buttonData)
  lazy val standardDialogButton = dialogButton(ButtonData.Other)(_)
  lazy val okDialogButton = dialogButton(ButtonData.OKDone)(_)
  lazy val abortDialogButton = dialogButton(ButtonData.CancelClose)(_)

  def safeButton(msgKey: String = "Speichern")= new ButtonType(msgKey,ButtonData.OKDone)

  def notImplementedDialog(content: String,
                           title: String = "Noch nicht implementiert",
                           header: String = "Noch nicht implementiert")(implicit titleIcon: Image = ScalaFxHelper.getArrayOfResource("fallback_logo.png")) = {
    dialog(
      content,
      header,
      title,
      AlertType.Warning,
      titleIcon
    )
  }

  def confirmationDialog(title: String, headerText: String, contentText: String)(implicit titleIcon: Image = ScalaFxHelper.getArrayOfResource("fallback_logo.png")) = {
    dialog(contentText,headerText, title, AlertType.Confirmation,titleIcon)
  }

  def customConfirmationDialog(title:String,
                               headerText: String,
                               contentText: String,
                               buttonSeq: Seq[ButtonType])(implicit titleIcon: Image = ScalaFxHelper.getArrayOfResource("fallback_logo.png")) = {
    val dialog = confirmationDialog(title,headerText,contentText)(titleIcon)
    dialog.buttonTypes.clear()
    dialog.buttonTypes ++= buttonSeq.map(_.delegate)
    dialog
  }

  def creteCommandLink(headline: String,
                       longText: String,
                       default: Boolean = false) = new CommandLinksButtonType(headline,longText,false)

  def commandLinkDialog(title: String,
                        commandLinks: Seq[CommandLinksButtonType],
                        graphic: Node)(titleIcon: String) = {
    val dialog = new CommandLinksDialog(commandLinks:_*)
    dialog.setTitle(title)
    if(titleIcon.nonEmpty) dialog.getDialogPane.getScene.getWindow.asInstanceOf[javafx.stage.Stage].getIcons.add( ScalaFxHelper.getArrayOfResource(titleIcon) )
    dialog.setGraphic( graphic )
    dialog
  }


}
