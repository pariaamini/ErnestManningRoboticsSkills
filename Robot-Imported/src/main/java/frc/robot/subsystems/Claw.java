// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Claw extends SubsystemBase {
  private PWM clawServo = new PWM(Constants.CLAW_PWM_PORT); // sets to pwn2 which corresponds to pin 2

  /** Creates a new Claw. */
  public Claw() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setClaw(double pos) {
    clawServo.setPosition(pos);
    
    SmartDashboard.putNumber("claw pos", pos);
  }
}
