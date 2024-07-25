import com.neuronrobotics.sdk.addons.kinematics.math.TransformNR

import eu.mihosoft.vrl.v3d.*
import javafx.scene.paint.Color

CSG starting = new Cube(20).toCSG().toZMin().setColor(Color.RED)
				.movez(30)

TransformNR height = new TransformNR(0,0,40)
TransformNR rightFront = new TransformNR(40,10,0)
TransformNR leftRear = new TransformNR(-10,80,0)


CSG resizeUp = starting.scaleToMeasurmentZ(height.getZ())
				.toZMin()
				.movez(starting.getMinZ())


double xdimen = rightFront.getX()-leftRear.getX()
double ydimen = rightFront.getY()-leftRear.getY()
resizeUp=resizeUp.scaleToMeasurmentX(xdimen)
				 .scaleToMeasurmentY(ydimen)
resizeUp=resizeUp
			.toXMin()
			.toYMin()
			.movex(leftRear.getX())
			.movey(rightFront.getY())

return [resizeUp]