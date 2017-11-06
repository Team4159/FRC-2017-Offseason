package org.usfirst.frc.team4159.robot;

import org.usfirst.frc.team4159.robot.commands.LiftGear;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	
	private static Joystick leftStick;
	private static Joystick rightStick;
	private static Joystick secondaryStick;
	private JoystickButton a;
	private JoystickButton b;

	public OI() {
		
		leftStick = new Joystick(RobotMap.leftJoy);
		rightStick = new Joystick(RobotMap.rightJoy);
		secondaryStick = new Joystick(RobotMap.secondaryJoy);
		
		a = new JoystickButton(secondaryStick, RobotMap.gearUpButton);
		b = new JoystickButton(secondaryStick, RobotMap.gearDownButton);
		a.whenReleased(new LiftGear(2.5)); // up
		b.whenReleased(new LiftGear(0)); // down
		
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
