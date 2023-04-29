// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriverControls extends CommandBase {
  private Supplier<Double> zTurn;
  private Supplier<Double> xMovement;
  private Supplier<Double> yMovement;
  private Drivetrain drive;

  /** Creates a new DriverControls. */
  public DriverControls(Supplier<Double> yMovement, Supplier<Double> xMovement, Supplier<Double> zTurn, Drivetrain drive) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
    this.drive = drive;
    this.yMovement = yMovement;
    this.xMovement = xMovement;
    this.zTurn = zTurn;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double y = yMovement.get();
    double x = xMovement.get();
    double z = zTurn.get();
    drive.drive(y, x, z);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
