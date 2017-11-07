package org.usfirst.frc.team4159.robot;

public class RobotMap {
		
	// Joystick Ports
	public static final int leftJoy = 0;
	public static final int rightJoy = 1;
	public static final int secondaryJoy = 2;
	
	// PWM Ports
	public static final int leftDriveMotor = 0;
	public static final int rightDriveMotor = 1;
	public static final int gearIOMotor = 2;
	public static final int gearLiftMotor = 3;
	public static final int climberRelay = 4;
	
	// Analog Input Ports
	public static final int gearPot = 0;
	
	// Drivetrain Encoder Ports
	public static final int leftDriveEncoderA = 0;
	public static final int leftDriveEncoderB = 1;
	public static final int rightDriveEncoderA = 2;
	public static final int rightDriveEncoderB = 3;
	
	// Encoders
	public static final double pulsePerRotation = 360;
	public static final double wheelDiameter = 2; // inches
	public static final double wheelCircumference = wheelDiameter * Math.PI;
	public static final double distancePerPulse = wheelCircumference / pulsePerRotation;
	
	// Constants
	public static final double leftMultiplier = 1; // btw 0 to 1
	public static final double rightMultiplier = 1; // btw 0 to 1
	
	// Joystick Button Mappings
	public static final int gearIntakeButton = 3;
	public static final int gearOuttakeButton = 2;
	public static final int climbUpButton = 11;
	public static final int climbDownButton = 10;
	public static final int gearUpButton = 6;
	public static final int gearDownButton = 7;
	
}
