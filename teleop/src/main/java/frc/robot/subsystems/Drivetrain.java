// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  private MecanumDrive mecanum;
  // change motor channels!!!
  Talon frontLeft = new Talon(Constants.frontLeft);
  Talon rearLeft = new Talon(Constants.backLeft);
  Talon frontRight = new Talon(Constants.frontRight);
  Talon rearRight = new Talon(Constants.backLeft);

  public Drivetrain() {
    frontRight.setInverted(true);
    rearRight.setInverted(true);
    mecanum = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
  }

  public void drive(double y, double x, double z) {
    mecanum.driveCartesian(y, x, z);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
