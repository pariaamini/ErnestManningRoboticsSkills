// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Spinner extends SubsystemBase {
  /** Creates a new Spinner. */
  private Talon motor1 = new Talon(Constants.spinnerMotor1);
  private Talon motor2 = new Talon(Constants.spinnerMotor2);

  public Spinner() {
    
  }
  public void setMotorSpeed(double speed){
    motor1.set(speed);
    motor2.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
