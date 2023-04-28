// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.Arm.ArmHigh;
import frc.robot.commands.Arm.ArmLow;
import frc.robot.commands.Arm.ArmMid;
import frc.robot.commands.Autonomous.Paths.Cube2Auto;
import frc.robot.commands.Claw.ClawClosed;
import frc.robot.commands.Claw.ClawCube;
import frc.robot.commands.Claw.ClawOpen;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.OnBoardIO;
import frc.robot.subsystems.OnBoardIO.ChannelMode;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.VisionReader;
import frc.robot.subsystems.Vision;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final OnBoardIO m_onboardIO = new OnBoardIO(ChannelMode.INPUT, ChannelMode.INPUT);
  private final Arm m_arm = new Arm();
  private final Claw m_claw = new Claw();

  private final Vision m_vision = new Vision();
  // Assumes a gamepad plugged into channnel 0
  private final XboxController m_controller = new XboxController(0);
  // private final Joystick m_controller = new Joystick(0);

  // Create SmartDashboard chooser for autonomous routines
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  Button buttonX = new JoystickButton(m_controller, Constants.BUTTON_X);
  Button buttonA = new JoystickButton(m_controller, Constants.BUTTON_A);
  Button buttonB = new JoystickButton(m_controller, Constants.BUTTON_B);
  Button buttonY = new JoystickButton(m_controller, Constants.BUTTON_Y);
  Button dpadUp = new POVButton(m_controller, Constants.DPAD_UP);
  Button dpadDown = new POVButton(m_controller, Constants.DPAD_DOWN);
  Button dpadLeft = new POVButton(m_controller, Constants.DPAD_LEFT);
  Button dpadRight = new POVButton(m_controller, Constants.DPAD_RIGHT);

  private Command clawClosed = new ClawClosed(m_claw);
  private Command clawOpened = new ClawOpen(m_claw);
  private Command clawCube = new ClawCube(m_claw);
  private Command armHigh = new ArmHigh(m_arm);
  private Command armMid = new ArmMid(m_arm);
  private Command armLow = new ArmLow(m_arm);

  // NOTE: The I/O pin functionality of the 5 exposed I/O pins depends on the
  // hardware "overlay"
  // that is specified when launching the wpilib-ws server on the Romi raspberry
  // pi.
  // By default, the following are available (listed in order from inside of the
  // board to outside):
  // - DIO 8 (mapped to Arduino pin 11, closest to the inside of the board)
  // - Analog In 0 (mapped to Analog Channel 6 / Arduino Pin 4)
  // - Analog In 1 (mapped to Analog Channel 2 / Arduino Pin 20)
  // - PWM 2 (mapped to Arduino Pin 21)
  // - PWM 3 (mapped to Arduino Pin 22)
  //
  // Your subsystem configuration should take the overlays into account

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Default command is arcade drive. This will run unless another command
    // is scheduled over it.
    m_drivetrain.setDefaultCommand(getArcadeDriveCommand());
    m_vision.setDefaultCommand(getVisionReaderCommand());
    // Example of how to use the onboard IO
    Button onboardButtonA = new Button(m_onboardIO::getButtonAPressed);
    onboardButtonA
        .whenActive(new PrintCommand("Button A Pressed"))
        .whenInactive(new PrintCommand("Button A Released"));

    // claw buttons assigned to command
    buttonB.whenPressed(clawClosed);
    buttonX.whenPressed(clawOpened);
    buttonY.whenPressed(clawCube);

    // arm buttons assigned to command
    dpadDown.whenPressed(armLow);
    dpadUp.whenPressed(armHigh);
    dpadLeft.whenPressed(armMid);
    // dpadRight.whenPressed(new ArmDefault(m_arm));

    // Setup SmartDashboard options
    m_chooser.setDefaultOption("Cube2Auto", new Cube2Auto(m_claw, m_drivetrain, m_arm));
    SmartDashboard.putData(m_chooser);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

  /**
   * Use this to pass the teleop command to the main {@link Robot} class.
   *
   * @return the command to run in teleop
   */
  public Command getArcadeDriveCommand() {
    return new ArcadeDrive(m_drivetrain, () -> m_controller.getRawAxis(3)-m_controller.getRawAxis(2), () -> m_controller.getRawAxis(0), () -> m_controller.getRawAxis(4));
  }
  public Command getVisionReaderCommand() {
    return new VisionReader(m_vision);
  }
}
