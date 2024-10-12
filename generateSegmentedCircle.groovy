import eu.mihosoft.vrl.v3d.CSG
import eu.mihosoft.vrl.v3d.Cube
import eu.mihosoft.vrl.v3d.Cylinder
import javafx.scene.paint.Color

// code here

double rad=150.0/2.0

double stroke = 13.720
int numSeg = 16
double seperate = 360.0/numSeg

CSG hole = new Cylinder(rad-stroke,rad-stroke, 1,numSeg).toCSG();
CSG outer = new Cylinder(rad,rad, 1,numSeg).toCSG().difference(hole)
			//
CSG cutter = new Cube(1,rad*2,2).toCSG();
for( double i=0;i<360;i+=(seperate)) {
	outer=outer.difference(cutter.rotz(i))
}
outer=outer.rotz(seperate/2)
outer.setColor(Color.web("#ff8000"))
outer.addExportFormat("svg");

return outer
