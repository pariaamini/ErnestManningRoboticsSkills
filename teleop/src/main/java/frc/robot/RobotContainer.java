// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.DriverControls;
import frc.robot.commands.TurnStick;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Spinner;

/** Add your docs here. */
public class RobotContainer {
    private final CommandXboxController controller = new CommandXboxController(0);

    // subsystems
    private Drivetrain drive = new Drivetrain();
    private Spinner spinner = new Spinner();
    // commands
    private Command turnSlow = new TurnStick(spinner, 0.2);
    private Command turnFast = new TurnStick(spinner, 0.4);
    private Command turnBack = new TurnStick(spinner, -0.3);

    public RobotContainer() {
        configureButtons();
    }

    public void configureButtons() {
        drive.setDefaultCommand(
                new DriverControls(() -> (controller.getRightY()), () -> (controller.getRightX()),
                        () -> (controller.getLeftX()), drive));

        controller.a().whileTrue(turnSlow);
        controller.x().whileTrue(turnFast);
        controller.y().whileTrue(turnBack);
    }
}
