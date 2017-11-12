package org.usfirst.frc.team4159.robot;

public class RobotMap {
		
	// Joystick Ports
	public static final int leftJoy = 0;
	public static final int rightJoy = 1;
	public static final int secondaryJoy = 2;
	
	// PWM Ports
	public static final int leftDriveMotor = 0;
	public static final int rightDriveMotor = 1;
	public static final int gearLiftMotor = 2;
	public static final int gearIOMotor = 3;
	public static final int climberMotor = 4;
	
	// Digital Input Ports
	public static final int liftEncoderA = 0;
	public static final int liftEncoderB = 1;
	
	// Encoders
	public static final double pulsePerRotation = 360;
	public static final double wheelDiameter = 2; // inches
	public static final double wheelCircumference = wheelDiameter * Math.PI;
	public static final double distancePerPulse = wheelCircumference / pulsePerRotation;
	
	// Constants
	public static final double leftMultiplier = 0.99; // btw 0 to 1
	public static final double rightMultiplier = 1; // btw 0 to 1
	
	// Joystick Button Mappings
	public static final int gearIntakeButton = 6;
	public static final int gearOuttakeButton = 7;
	public static final int climbUpButton = 11;
	public static final int climbDownButton = 10;
	
}
