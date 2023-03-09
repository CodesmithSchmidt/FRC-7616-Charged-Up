package frc.robot.subsystems;

import java.util.function.BooleanSupplier;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.geometry.Translation2d;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
//import edu.wpi.first.wpilibj.SPI;
//import frc.robot.subsystems.Swerve;

public class NavXBalance extends SubsystemBase {
    // CHANGE THIS ACCORDING TO WHAT COMMUNICATION PROTOCOL IS BEING USED FOR THE NAVX
    // LOOKS LIKE IT'S ALREADY SPECIFIED SPI IN Swerve.java
    private AHRS ahrs;
    private Swerve swerve;
    private BooleanSupplier robotCentricSup;
    private double rotationVal;
    private Translation2d translation;
    
    public NavXBalance(AHRS ahrs_in, Swerve drive_in, BooleanSupplier supplier) {
        ahrs = ahrs_in;
        swerve = drive_in;
        robotCentricSup = supplier;
    }
    
    // THRESHOLD VALUE TO TWEAK
    // ENDS UP GETTING MULTIPLIED BY THE VELOCITY IN THE X DIRECTION
    private double threshold = 5;
    
    @Override
    public void periodic() {
        // NOT IMPLEMENTED
    }

    // RESET GYRO
    public void resetGyro() {
        ahrs.reset();
    }

    // RESET DISPLACEMENT
    public void zeroDisplacement() {
        ahrs.resetDisplacement();
    }

    // MEASURES HOW MUCH THE ROBOT IS MOVING
    // OFF THE PLATFORM. WON'T WORK IF THE ROBOT DOESN'T GO STRAIGHT
    // ON THE PLATFORM (X AXIS FORWARD). RETURNS A CORRECTION COEFFICIENT.
    public float checkPosition() {
        if (ahrs.isMoving()) {
            if (ahrs.getPitch() < 0) {
                return -1 * ahrs.getVelocityX();
            }
            else {
                return ahrs.getVelocityX();
            }
        }

        return 0;
    }

   // DRIVES THE MOTORS TO CORRECT
   // BASED OFF TeleopSwerve.java
   public void correct(float severity) {
    translation = new Translation2d(severity * threshold, 0);
    swerve.drive(translation.times(Constants.Swerve.maxSpeed), rotationVal * Constants.Swerve.maxAngularVelocity, !robotCentricSup.getAsBoolean(),true);
   }
}
