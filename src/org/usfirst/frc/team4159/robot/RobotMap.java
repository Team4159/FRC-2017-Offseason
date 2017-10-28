package org.usfirst.frc.team4159.robot;

public class RobotMap {
	
	public static int leftJoy;
	public static int rightJoy;
	public static int secondaryJoy;
	
	public static int leftDriveMotor;
	public static int rightDriveMotor;
	public static int gearIOMotor;
	public static int gearLiftMotor;
	public static int climberMotor;
	
	public static int gearIntakeButton;
	public static int gearOuttakeButton;
	public static int climbUpButton;
	public static int climbDownButton;
	
	public RobotMap() {
		
		// CHANGE ALL OF THIS ONCE ELECTRONICS BOARD IS FINALIZED!!!!!
		// Joysticks
		leftJoy = 0;
		rightJoy = 1;
		secondaryJoy = 2;
		
		// Buttons
		gearIntakeButton = 1;
		gearOuttakeButton = 2;
		climbUpButton = 3;
		climbDownButton = 4;
		
		// PWM Ports
		leftDriveMotor = 0;
		rightDriveMotor = 1;
		gearIOMotor = 2;
		gearLiftMotor = 3;
		climberMotor = 4;
		
	}
	
}

// If you are using multiple modules, make sure to define both the port
// number and the module. For example you with a rangefinder:
// public static int rangefinderPort = 1;
// public static int rangefinderModule = 1;
