package org.usfirst.frc.team4159.robot;

public class RobotMap {

    // Joystick Ports
    public static final int leftJoy = 0;
    public static final int rightJoy = 1;
    public static final int secondaryJoy = 2;
    public static final int xbox = 4;
    public static final int nes = 5;

    // PWM Ports
    public static final int leftDriveMotor = 0;
    public static final int rightDriveMotor = 1;
    public static final int gearLiftMotor = 2;
    public static final int gearIOMotor = 3;
    public static final int climberMotor = 4;

    // Encoder (digital) Ports
    public static final int liftEncoderA = 0;
    public static final int liftEncoderB = 1;

    // Encoder Constants
    public static final double pulsePerRotation = 360;
    public static final double wheelDiameter = 2; // inches
    public static final double wheelCircumference = wheelDiameter * Math.PI;
    public static final double distancePerPulse = wheelCircumference / pulsePerRotation;

    // Multiplier Constants
    public static final double leftMultiplier = 0.99;
    public static final double rightMultiplier = 1;

    // Joystick Button Mappings
    public static final int gearIntakeButton = 6;
    public static final int gearOuttakeButton = 7;
    public static final int climbUpButton = 11;

    // NES Button and Axis Mappings
    public static final int nesAcceleration = 1;
    public static final int nesTurnLeft = 4;
    public static final int nesTurnRight = 0;
    public static final int nesGearIntake = 11;
    public static final int nesGearUp = 6;
    public static final int nesGearDown = 7;
    public static final int nesClimb = 10;

}
