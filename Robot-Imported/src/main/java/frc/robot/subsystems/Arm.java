// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm extends SubsystemBase {
  private static PWM armServo = new PWM(Constants.ARM_PWM_PORT); // sets the pwm servo at channel 3 which is corresponding with port 22

  /** Creates a new Arm. */
  public Arm() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setArm(double pos) {
    armServo.setPosition(pos);
    
    SmartDashboard.putNumber("arm pos", pos);

  }
}
