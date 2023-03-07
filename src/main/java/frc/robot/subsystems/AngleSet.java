// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*
One Falcon 500 (Talon FX)
*    1) Angle
*        -Angle motor needs 3 preset positions:
*          -Starting Position
*          -Scoring Position
*          -Ground Pickup Position
*          -Test for player station pickup angle/position
*          -Will probably need a distance calculation based on number of rotations
* 
*        -Will need 2 commands - UP, and DOWN
*          -UP will go to the next highest location (Ground -> Scoring, Scoring->Starting)
*          -DOWN will go to next lowest location (Starting->Scoring, Scoring->Ground)
*          -Conditional to check current location to see if command will run
* 
*    VictorSRX controller
*    2) Extender
*        -Only operates if Angle motor is in Scoring Position
*        -Limit Switch controlled (Forward switch / Back switch)
*        -Command is one button toggle - if forward, go back, if back, go forward
*        
* 
*  Create "position" variable, and set it each time the Angle motor changes (1 is Start
*      2 is Score, and 3 is Pickup); Extend command will only function if variable is 2
*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.Constants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AngleSet extends SubsystemBase {
  /** Creates a new Elevator. */

TalonFX angleMotor = new TalonFX(Constants.angleMotorID);
VictorSPX extendMotor = new VictorSPX(Constants.extendMotorID);

//TODO: Calculate meters of rope per encoder tick//Adjust for quadrature vs TalonFX Sensor?
private final double kEncoderTick2Meter = 1.0/4096.0 * .1 * Math.PI;

public double getEncoderMeters() {
  return angleMotor.getSelectedSensorPosition() * kEncoderTick2Meter;
}

  public AngleSet() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Elevator encoder value", getEncoderMeters());
  }

  public void setMotor(double speed){
      angleMotor.set(TalonFXControlMode.PercentOutput, speed);
  }




}
