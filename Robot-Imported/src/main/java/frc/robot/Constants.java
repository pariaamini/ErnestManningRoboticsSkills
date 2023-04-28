// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    // Controller Buttons
    public static final int CONTROLLER = 0;

    public static final int BUTTON_A = 1;
    public static final int BUTTON_B = 2;
    public static final int BUTTON_X = 3;
    public static final int BUTTON_Y = 4;
    public static final int LEFT_BUMPER = 5;
    public static final int RIGHT_BUMPER = 6;
    public static final int BACK_BUTTON = 7;
    public static final int START_BUTTON = 8;
    public static final int LEFT_STICK_BUTTON = 9;
    public static final int RIGHT_STICK_BUTTON = 10;

    public static final int DPAD_UP = 0;
    public static final int DPAD_UPRIGHT = 45;
    public static final int DPAD_RIGHT = 90;
    public static final int DPAD_DOWN = 180;
    public static final int DPAD_LEFT = 270;
    public static final int DPAD_UPLEFT = 315;

    public static final int LEFT_STICK_X = 0;
    public static final int LEFT_STICK_Y = 1;
    public static final int RIGHT_STICK_Y = 5;
    public static final int RIGHT_STICK_X = 4;

    public static final int LEFT_TRIGGER = 2;
    public static final int RIGHT_TRIGGER = 3;

    // Arm Values
    // arm values have been tuned, maybe some finetuning left to do
    public static int ARM_PWM_PORT = 3;
    public static double ARM_LOW_POSITION = 0.52; // 0.452
    public static double ARM_MID_POSITION = 0.68; // 0.57
    public static double ARM_HIGH_POSITION = 0.80; // 0.68
    public static double ARM_TEST = 0.2; // testing servos

    // Claw Values
    // all calw values to be tested
    public static int CLAW_PWM_PORT = 2;
    public static double CLAW_OPEN_POSITION = 0.52;
    public static double CLAW_CLOSED_POSITION = 0.9;
    public static double CLAW_CUBE_POSITION = 0.5; // used when closed on a cube
}
