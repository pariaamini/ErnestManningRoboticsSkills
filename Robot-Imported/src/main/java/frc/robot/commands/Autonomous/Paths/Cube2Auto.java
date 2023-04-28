// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous.Paths;

import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.Autonomous.Functions.ArmSet;
import frc.robot.commands.Autonomous.Functions.ClawSet;
import frc.robot.commands.Autonomous.Functions.DriveDistance;
import frc.robot.commands.Autonomous.Functions.TurnDegrees;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Cube2Auto extends SequentialCommandGroup {
  /** Creates a new Cube2Auto. */
  public Cube2Auto(Claw claw, Drivetrain drivetrain, Arm arm) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
        // new ClawSet(Constants.CLAW_OPEN_POSITION,claw),
        new DriveDistance(0.5, 8, drivetrain),
        new ArmSet(Constants.ARM_MID_POSITION, arm),
        new ClawSet(Constants.CLAW_OPEN_POSITION, claw),
        new DriveDistance(-0.5, 8.5, drivetrain),
        new TurnDegrees(-0.5, 90, drivetrain),
        new ArmSet(Constants.ARM_LOW_POSITION, arm),
        new ClawSet(Constants.CLAW_CUBE_POSITION, claw),
        new ArmSet(Constants.ARM_MID_POSITION, arm) // pos depends on what tier we want to take

    );
  }
}
