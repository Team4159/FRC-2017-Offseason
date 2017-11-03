package org.usfirst.frc.team4159.robot.subsystems;

import org.usfirst.frc.team4159.robot.RobotMap;
import org.usfirst.frc.team4159.robot.commands.TeleopDrive;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {
	
	private static Victor leftVictor;
	private static Victor rightVictor;
	
	public Drivetrain() {
		leftVictor = new Victor(RobotMap.leftDriveMotor);
		rightVictor = new Victor(RobotMap.rightDriveMotor);
	}
	
	public void set(double leftValue, double rightValue) {
		leftVictor.set(leftValue);
		rightVictor.set(rightValue);
	}
	
	public void stop() {
		leftVictor.set(0);
		rightVictor.set(0);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new TeleopDrive());
    }
}
