// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Elevator extends SubsystemBase {
  /** Creates a new Elevator. */
  VictorSPX elevatorMotor = new VictorSPX(Constants.extendMotorID);

  public Elevator() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setMotor(boolean scoring, double speed){
    if(scoring){
      //TODO: tune speed/direction on testing
      elevatorMotor.set(VictorSPXControlMode.PercentOutput, speed);
    } 
  }


}
