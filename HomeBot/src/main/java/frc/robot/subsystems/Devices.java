
package frc.robot.subsystems;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.devices.*;

// This class contains singleton (static) instances of id mapped subsystem components.
// If a device is not connected at initialization, it should be set to null.
// IMPORTANT: Only ONE subsystem should control any given device.
// Device instances are package-private (neither private nor public) so they can only be used by subsystems.
public class Devices {

    //////////////////////
    // Device Instances //
    //////////////////////

    // TalonSRX
    static DevTalonSRX talonSrxDiffWheelFrontLeft = new DevTalonSRX("talonFxDiffWheelFrontLeft", 6);
    static DevTalonSRX talonSrxDiffWheelFrontRight = new DevTalonSRX("talonFxDiffWheelFrontRight", 2);
    static DevTalonSRX talonSrxDiffWheelRearLeft = new DevTalonSRX("talonFxDiffWheelRearLeft", 7);
    static DevTalonSRX talonSrxDiffWheelRearRight = new DevTalonSRX("talonFxDiffWheelRearRight", 9);

    static DevTalonSRX talonSrxShooterBottomWheel = new DevTalonSRX("talonSrxShooterBottomWheel", 4);
    static DevTalonSRX talonSrxShooterTopWheel = new DevTalonSRX("talonSrxShooterTopWheel", 10);
    

    /////////////////////
    // Drive Instances //
    /////////////////////

    public static DevDifferentialDrive diffDriveTalon = new DevDifferentialDrive("diffDriveTalon",
                                                                                talonSrxDiffWheelFrontLeft,
                                                                                talonSrxDiffWheelFrontRight);

}
