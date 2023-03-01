// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Manipulator extends SubsystemBase {
  /** Creates a new Manipulator. 
 *
 *      One Falcon 500 (Talon FX)
 *    1) Angle
 *        -Angle motor needs 3 preset positions:
 *          -Starting Position
 *          -Scoring Position
 *          -Ground Pickup Position
 *          -Test for player station pickup angle/position
 *      
 * Probably a VictorSRX controller
 *    2) Extender
 *        -Only operates if Angle motor is in Scoring Position
 *        -Limit Switch controlled? (Forward/Back)
 *        
 * 
 *  Create "position" variable, and set it each time the Angle motor changes (1 is Start
 *      2 is Score, and 3 is Pickup); Extend command will only function if variable is 2
 * 
 * 
 *      One other motor (Victor):
 *    1) Claw to intake/output
 *        -Test output speed for launch possibility
 * 
 * 
 */



  public Manipulator() {

  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
