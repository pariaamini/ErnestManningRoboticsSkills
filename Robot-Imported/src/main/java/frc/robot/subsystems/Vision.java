// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Vision extends SubsystemBase {
  NetworkTableInstance instance;
  private NetworkTable networkTable;

  /** Creates a new Vision. */
  public Vision() {  
  }

  public NetworkTable getEntries() {
    SmartDashboard.putBoolean("subsystemrunning", true);
    instance = NetworkTableInstance.getDefault();
    networkTable = instance.getTable("AprilTags");
    return networkTable;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
