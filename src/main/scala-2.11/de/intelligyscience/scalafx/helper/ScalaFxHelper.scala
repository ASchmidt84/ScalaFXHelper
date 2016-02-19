package de.intelligyscience.scalafx.helper

import java.io.ByteArrayInputStream

import scalafx.geometry.Insets
import scalafx.scene.control.{TextField, Label}
import scalafx.scene.image.{ImageView, Image}

/**
  * Created by andre on 17.02.16.
  */
object ScalaFxHelper {

  /**
    * Looks in resoruce folder of src/main/resource with the subfolder img
    * It is necessary to create this folder. You can add more subfolder in img to sort your images
    */
  lazy val getResourceOf = (name: String) => getClass.getResourceAsStream(s"/img/$name")
  lazy val getResourceOfWithPath = (path: String) => (name: String) => getClass.getResourceAsStream(s"$path$name")

  lazy val getArrayOfResource = (name: String) => image( scala.io.Source.fromInputStream( getResourceOf(name) )("latin1" ).map(_.toByte).toArray )

  lazy val image = (data: Array[Byte]) => new Image( new ByteArrayInputStream(data) )

  lazy val iconNode = (width:Int) => (height: Int) => (name:String) => {
    val tmp = new ImageView( getResourceOf(name).toString )
    tmp.fitWidth = width
    tmp.fitHeight = height
    tmp
  }

  lazy val iconByteNode = (width:Int) => (height: Int) => (data: Array[Byte]) => {
    val tmp = new ImageView( image(data) )
    tmp.preserveRatio = true
    tmp.fitWidth = width
    tmp.fitHeight = height
    tmp
  }

  lazy val iconNodeQubic      = (size: Int) => iconNode(size)(size)(_)
  lazy val iconByteNodeQubic  = (size: Int) => iconByteNode(size)(size)(_)

  lazy val iconNode8    = iconNodeQubic(8)(_)
  lazy val iconNode16   = iconNodeQubic(16)(_)
  lazy val iconNode24   = iconNodeQubic(24)(_)
  lazy val iconNode32   = iconNodeQubic(32)(_)
  lazy val iconNode40   = iconNodeQubic(40)(_)
  lazy val iconNode48   = iconNodeQubic(48)(_)
  lazy val iconNode56   = iconNodeQubic(56)(_)
  lazy val iconNode64   = iconNodeQubic(64)(_)
  lazy val iconNode72   = iconNodeQubic(72)(_)
  lazy val iconNode80   = iconNodeQubic(80)(_)
  lazy val iconNode128  = iconNodeQubic(128)(_)
  lazy val iconNode256  = iconNodeQubic(256)(_)
  lazy val iconNode512  = iconNodeQubic(512)(_)

  lazy val iconByteNode8    = iconByteNodeQubic(8)(_)
  lazy val iconByteNode16   = iconByteNodeQubic(16)(_)
  lazy val iconByteNode24   = iconByteNodeQubic(24)(_)
  lazy val iconByteNode32   = iconByteNodeQubic(32)(_)
  lazy val iconByteNode40   = iconByteNodeQubic(40)(_)
  lazy val iconByteNode48   = iconByteNodeQubic(48)(_)
  lazy val iconByteNode56   = iconByteNodeQubic(56)(_)
  lazy val iconByteNode64   = iconByteNodeQubic(64)(_)
  lazy val iconByteNode72   = iconByteNodeQubic(72)(_)
  lazy val iconByteNode80   = iconByteNodeQubic(80)(_)
  lazy val iconByteNode128  = iconByteNodeQubic(128)(_)
  lazy val iconByteNode256  = iconByteNodeQubic(256)(_)
  lazy val iconByteNode512  = iconByteNodeQubic(512)(_)

  lazy val label = (marginTop: Int) => (marginLeft: Int) => (marginRight: Int) => (marginBottom: Int) => (title: String) => {
    val lbl = new Label(title)
    lbl.margin = Insets(marginTop,marginLeft,marginRight,marginBottom)
    lbl
  }

  lazy val textField = (marginTop: Int) => (marginLeft: Int) => (marginRight: Int) => (marginBottom: Int) => (text: String) => {
    val field = new TextField()
    field.text = text
    field.margin = Insets(marginTop,marginLeft,marginRight,marginBottom)
    field
  }

  lazy val labelSymmetric = (insets: Int) => label(insets)(insets)(insets)(insets)(_)
  lazy val textFieldSymmetric = (insets: Int) => textField(insets)(insets)(insets)(insets)(_)
  lazy val label10 = labelSymmetric(10)(_)
  lazy val label20 = labelSymmetric(20)(_)
  lazy val textField10 = textFieldSymmetric(10)(_)
  lazy val textField20 = textFieldSymmetric(20)(_)

}
