package org.usfirst.frc.team4159.robot;

public class RobotMap {
		
	// Joysticks
	public static final int leftJoy = 0;
	public static final int rightJoy = 1;
	public static final int secondaryJoy = 2;
	
	// Drivetrain PWM Ports
	public static final int leftDriveMotor = 0;
	public static final int rightDriveMotor = 1;
	public static final int gearIOMotor = 2;
	public static final int gearLiftMotor = 3;
	public static final int climberMotor = 4;
	
	// Analog input ports
	public static final int gearPot = 0;
	
	// Drivetrain Encoder Ports
	public static final int leftDriveEncoderA = 0;
	public static final int leftDriveEncoderB = 1;
	public static final int rightDriveEncoderA = 2;
	public static final int rightDriveEncoderB = 3;
	
	// Constants
	public static final double pulsePerRotation = 360;
	public static final double wheelDiameter = 2; // inches
	public static final double wheelCircumference = wheelDiameter * Math.PI;
	public static final double distancePerPulse = wheelCircumference / pulsePerRotation;
	public static final double leftMultiplier = 1; // btw 0 to 1
	public static final double rightMultiplier = 1; // btw 0 to 1
	
	// Joystick button mappings
	public static final int gearIntakeButton = 1;
	public static final int gearOuttakeButton = 2;
	public static final int climbUpButton = 3;
	public static final int climbDownButton = 4;
	public static final int gearUpButton = 5;
	public static final int gearDownButton = 6;
	
}
