package org.usfirst.frc.team4159.robot.subsystems;

import org.usfirst.frc.team4159.robot.RobotMap;
import org.usfirst.frc.team4159.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {
	
	private Victor leftVictor;
	private Victor rightVictor;
	private Encoder leftEncoder;
	private Encoder rightEncoder;
	private PIDController leftPID;
	private PIDController rightPID;
	
	private double rkP = 0;
	private double rkI = 0;
	private double rkD = 0;
	private double rkF = 0;
	private double lkP = 0;
	private double lkI = 0;
	private double lkD = 0;
	private double lkF = 0;
	
	public Drivetrain() {
		
		leftVictor = new Victor(RobotMap.leftDriveMotor);
		rightVictor = new Victor(RobotMap.rightDriveMotor);
		
		leftEncoder = new Encoder(RobotMap.leftDriveEncoderA, RobotMap.leftDriveEncoderB);
		rightEncoder = new Encoder(RobotMap.rightDriveEncoderA, RobotMap.rightDriveEncoderB);
		
		leftEncoder.setReverseDirection(false);
		rightEncoder.setReverseDirection(false);

		leftEncoder.setDistancePerPulse(RobotMap.distancePerPulse);
		rightEncoder.setDistancePerPulse(RobotMap.distancePerPulse);
		
		leftPID = new PIDController(rkP, rkI, rkD, rkF, leftEncoder, leftVictor);
		rightPID = new PIDController(lkP, lkI, lkD, lkF, rightEncoder, rightVictor);
	}
	
	public void enablePID() {
		leftPID.reset();
		rightPID.reset();
		leftPID.enable();
		rightPID.enable();
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	public void disablePID() {
		leftPID.disable();
		rightPID.disable();
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	public void setFromJoysticks(double leftValue, double rightValue) {
		leftVictor.set(leftValue * RobotMap.leftMultiplier);
		rightVictor.set(rightValue * RobotMap.rightMultiplier);
	}
	
	public void setRaw(double leftValue, double rightValue) {
		leftVictor.set(leftValue);
		rightVictor.set(rightValue);
	}
	
	
	public void stop() {
		leftVictor.set(0);
		rightVictor.set(0);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }
}
