package org.usfirst.frc.team4159.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	
	private static Joystick leftStick;
	private static Joystick rightStick;
	private static Joystick secondaryStick;

	public OI() {
		
		leftStick = new Joystick(RobotMap.leftJoy);
		rightStick = new Joystick(RobotMap.rightJoy);
		secondaryStick = new Joystick(RobotMap.secondaryJoy);
		
	}
	
	public static boolean getRightButton(int b) {
		return rightStick.getRawButton(b);
	}
	
	public static boolean getLeftButton(int b) {
		return leftStick.getRawButton(b);
	}
	
	public static boolean getSecondaryButton(int b) {
		return secondaryStick.getRawButton(b);
	}
	
	public static double getLeftJoystick() {
		return leftStick.getY();
	}
	
	public static double getRightJoystick() {
		return rightStick.getY();
	}
	
}
