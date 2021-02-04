package frc.robot.sensors;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.consoles.Logger;
import frc.robot.brains.ShooterBrain;
public class LimeLight {
    public static enum ledMode{
      PIPELINE,
      OFF,
      BLINK,
      ON;
    }

    private static final double CAMERA_HEIGHT = 10.5; // height of lens (in)
    private  static final double TARGET_HEIGHT = 89.75; //height to the center of target(in)
    private static final double CAMERA_ANGLE= 0;// angle of the camera(deg)
    
    private static NetworkTable m_limelight= NetworkTableInstance.getDefault().getTable("limelight");
    private static NetworkTableEntry m_tx = m_limelight.getEntry("tx");
    private static NetworkTableEntry m_ty = m_limelight.getEntry("ty");
    private static NetworkTableEntry m_tv = m_limelight.getEntry("tv");
    private static NetworkTableEntry m_ta = m_limelight.getEntry("ta");
    private static NetworkTableEntry m_ledMode = m_limelight.getEntry("ledMode");

    private static double getXOffset(){
        return m_tx.getDouble(0.00);
    }
    private static double getYOffset(){
        return m_ty.getDouble(0.00);
    }
    private static double getArea(){
        return m_ta.getDouble(0.00);
    }
    private static boolean isTarget(){
        return m_tv.getDouble(0.0)==1;
    }
    public static void setLedMode(int mode){
        m_ledMode.forceSetNumber(mode);
    }
     // Uses the limelight to find the distance in feet
     public static void calculateDistanceToTarget() {
        double yOffset = getYOffset();
        double angleInRadians = ((yOffset + CAMERA_ANGLE)/180.) * Math.PI;

        double distance = (TARGET_HEIGHT - CAMERA_HEIGHT) / Math.tan(angleInRadians);
        distance /= 12.0; // converts inches to feet
        ShooterBrain.setShootDistance(distance);
    }
} 