package frc.robot.commands;

import java.util.List;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Swerve;

public class GotoPlatform extends CommandBase {
   // LIST OF WAYPOINTS TO GET TO THE PLATFORM
   public List<Translation2d> waypoint;
   public Trajectory finalTrajectory;
   public Swerve swerve;
   public TrajectoryConfig config;

   public GotoPlatform(Swerve swerve_in) {
    // POPULATE TRAJECTORY WAYPOINTS HERE. LOOK AT THE FIELD MAP...
    swerve = swerve_in;

     // ALL UNITS FOR TRAJECTORIES ARE IN METRES
     finalTrajectory = TrajectoryGenerator.generateTrajectory(
        // START POSITION (0, 0) FACING +X
        new Pose2d(0, 0, new Rotation2d(0)),
        // LIST OF INTERIOR WAYPOINTS
        waypoint,
        // POSITION OF THE PLATFORM
        new Pose2d(null, null),
        // CONFIGURATION FOR THE SWERVE DRIVE
        config);
   } 

   public void initialize() {
    // CAN PROBABLY ASSIGN HERE TOO
   }

   public void execute() {
    // FIGURE OUT HOW TO PASS THE TRAJECTORY TO THE SWERVE

   }

   public void end() {
    // NOT IMPLEMENTED
   }
}
