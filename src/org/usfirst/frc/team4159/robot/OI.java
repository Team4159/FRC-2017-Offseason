package org.usfirst.frc.team4159.robot;

import org.usfirst.frc.team4159.robot.commands.Climb;
import org.usfirst.frc.team4159.robot.commands.EjectGear;
import org.usfirst.frc.team4159.robot.commands.IntakeGear;
import org.usfirst.frc.team4159.robot.commands.LiftGear;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	
	private static Joystick leftStick;
	private static Joystick rightStick;
	private Joystick secondaryStick;
	
	private Button gearIntakeButton;
	private Button gearOuttakeButton;
	private Button climbUpButton;
	private Button climbDownButton;

	public OI() {
		
		leftStick = new Joystick(0);
		rightStick = new Joystick(1);
		secondaryStick = new Joystick(2);
		
		gearIntakeButton = new JoystickButton(secondaryStick, 1); // change!
		gearOuttakeButton = new JoystickButton(secondaryStick, 2); // change!
		climbUpButton = new JoystickButton(secondaryStick, 3); // change!
		climbDownButton = new JoystickButton(secondaryStick, 4); // change!
		
		gearIntakeButton.whileHeld(new IntakeGear());
		gearIntakeButton.whenReleased(new LiftGear());
		
		gearOuttakeButton.whileHeld(new EjectGear());
		
		climbUpButton.whileHeld(new Climb("up"));
		climbDownButton.whileHeld(new Climb("down"));
				
	}
	
	public static double getLeftJoystick() {
		return leftStick.getY();
	}
	
	public static double getRightJoystick() {
		return rightStick.getY();
	}
		
}
