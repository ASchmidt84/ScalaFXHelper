# ScalaFXHelper
Gives small access to special graphical things like Dialogs
More in the next few days

#Update 20.07.2016 - 1.9
To modify the displayed text visual, I added dialogs with `Text`. You can now completly edit the displayed text by using `scalafx.scene.text.Text`.

    def textFlowInfoDialog(dialogTitle: String,
                           headerSeq: Seq[Text],
                           textSeq: Seq[Text])(implicit dialogIcon: Image = ScalaFxHelper.getImageOfResource("fallback_logo.png")) = {
        textFlowDialog(dialogTitle,headerSeq,textSeq,AlertType.Information,dialogIcon)
    }
You can now add a lot of different or same `Text` elements in a TextFlow Dialog. This is for the header text and for the content text. As you wish you can highlight your given text.

    labelStackTraceText: Seq[Text] = Seq( new Text("Error Stacktrace:"){
                                            this.fill = Color.Red
                                            this.font = Font("",FontWeight.Bold,16)
                                            effect = new DropShadow(){
                                                offsetY = 4.0
                                                color = Color.color(0.4,0.4,0.4)
                                            }
                                        } )
                                        
So you can add more styled information for your users.

*****

