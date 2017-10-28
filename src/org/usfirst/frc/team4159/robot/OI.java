package org.usfirst.frc.team4159.robot;

import org.usfirst.frc.team4159.robot.commands.Climb;
import org.usfirst.frc.team4159.robot.commands.EjectGear;
import org.usfirst.frc.team4159.robot.commands.IntakeGear;
import org.usfirst.frc.team4159.robot.commands.LiftGear;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	
	private static Joystick leftStick;
	private static Joystick rightStick;
	private static Joystick secondaryStick;

	public OI() {
		
		leftStick = new Joystick(RobotMap.leftJoy);
		rightStick = new Joystick(RobotMap.rightJoy);
		secondaryStick = new Joystick(RobotMap.secondaryJoy);
				
		getButton(secondaryStick, RobotMap.gearIntakeButton).whileHeld(new IntakeGear());
		getButton(secondaryStick, RobotMap.gearIntakeButton).whenReleased(new LiftGear());
		
		getButton(secondaryStick, RobotMap.gearOuttakeButton).whileHeld(new EjectGear());
		
		getButton(secondaryStick, RobotMap.climbUpButton).whileHeld(new Climb("up"));
		getButton(secondaryStick, RobotMap.climbDownButton).whileHeld(new Climb("down"));
				
	}
	
	private JoystickButton getButton(Joystick s, int b) {
		return new JoystickButton(s, b);
	}
	
	public static double getLeftJoystick() {
		return leftStick.getY();
	}
	
	public static double getRightJoystick() {
		return rightStick.getY();
	}
	
}
