package org.usfirst.frc.team4159.robot;

public class RobotMap {
	
	public static int leftDriveMotor;
	public static int rightDriveMotor;
	public static int gearIOMotor;
	public static int gearLiftMotor;
	public static int climberMotor;
	
	public RobotMap() {
		
		// PWM Ports
		leftDriveMotor = 0;
		rightDriveMotor = 1;
		gearIOMotor = 2;
		gearLiftMotor = 3;
		climberMotor = 4;
		
	}
	
}

// For example to map the left and right motors, you could define the
// following variables to use with your drivetrain subsystem.
// public static int leftMotor = 1;
// public static int rightMotor = 2;

// If you are using multiple modules, make sure to define both the port
// number and the module. For example you with a rangefinder:
// public static int rangefinderPort = 1;
// public static int rangefinderModule = 1;
