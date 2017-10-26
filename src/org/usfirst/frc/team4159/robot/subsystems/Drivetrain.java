package org.usfirst.frc.team4159.robot.subsystems;

import org.usfirst.frc.team4159.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
	
	private static Victor leftVictor;
	private static Victor rightVictor;
	
	public Drivetrain() {
		leftVictor = new Victor(RobotMap.leftDriveMotor);
		rightVictor = new Victor(RobotMap.rightDriveMotor);
	}
	
	public static void set(double leftValue, double rightValue) {
		leftVictor.set(leftValue);
		rightVictor.set(rightValue);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

