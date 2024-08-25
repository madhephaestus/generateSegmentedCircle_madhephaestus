import eu.mihosoft.vrl.v3d.CSG
import eu.mihosoft.vrl.v3d.Cube
import javafx.scene.paint.Color

import eu.mihosoft.vrl.v3d.parametrics.*;
CSG getObject(){

	StringParameter word = new StringParameter(	"CaDoodle_TextGeneration_Value",
										"TEXT",[])
	StringParameter font = new StringParameter(	"CaDoodle_TextGeneration_Font",
		"Arial",["Arial","System",
"Serif",
"SansSerif",
"Monospaced"])
	CSG text = CSG.text( word.getStrValue(),  10,  20, font.getStrValue())
	
	text=   text.toZMin()
				.rotz(-90)
				.moveToCenterX()
				.moveToCenterY()
				.setColor(Color.RED)
	return text
		.setParameter(word)
		.setParameter(font)
		.setRegenerate({getObject()})
}
return getObject()
