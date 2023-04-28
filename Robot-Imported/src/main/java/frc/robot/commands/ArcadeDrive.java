// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.Supplier;

public class ArcadeDrive extends CommandBase {
  private final Drivetrain m_drivetrain;
  private final Supplier<Double> m_xaxisSpeedSupplier;
  private final Supplier<Double> m_zaxisRotateSupplier;
  private final Supplier<Double> m_LowSensitivityControl;

  /**
   * Creates a new ArcadeDrive. This command will drive your robot according to
   * the speed supplier
   * lambdas. This command does not terminate.
   *
   * @param drivetrain          The drivetrain subsystem on which this command
   *                            will run
   * @param xaxisSpeedSupplier  Lambda supplier of forward/backward speed
   * @param zaxisRotateSupplier Lambda supplier of rotational speed
   */
  public ArcadeDrive(
      Drivetrain drivetrain,
      Supplier<Double> xaxisSpeedSupplier,
      Supplier<Double> zaxisRotateSupplier,
      Supplier<Double> LowSensitivityControl) {
    m_drivetrain = drivetrain;
    m_xaxisSpeedSupplier = xaxisSpeedSupplier;
    m_zaxisRotateSupplier = zaxisRotateSupplier;
    m_LowSensitivityControl = LowSensitivityControl;

    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.arcadeDrive(m_xaxisSpeedSupplier.get(), m_zaxisRotateSupplier.get());
    double rounding = m_LowSensitivityControl.get();
    if (rounding<0.1 && rounding>-0.1){
      rounding = 0;
    }
    SmartDashboard.putNumber("speed", m_xaxisSpeedSupplier.get());
    SmartDashboard.putNumber("turnVal", m_zaxisRotateSupplier.get());
    if (!(rounding == 0)) {
      m_drivetrain.curvatureDrive(m_xaxisSpeedSupplier.get() * 0.4, m_LowSensitivityControl.get() * 0.2, true);
    } else {
      m_drivetrain.curvatureDrive(m_xaxisSpeedSupplier.get() * 0.5, m_zaxisRotateSupplier.get() * 0.3, true);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}