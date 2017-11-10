package org.usfirst.frc.team4159.robot.subsystems;

import org.usfirst.frc.team4159.robot.RobotMap;
import org.usfirst.frc.team4159.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Drivetrain extends Subsystem {
	
	private RobotDrive dt;
	private VictorSP leftVictor, rightVictor;
	private ADXRS450_Gyro gyro;
	private double kP = 0.1; // tune!
	
	public Drivetrain() {
		
		leftVictor = new VictorSP(RobotMap.leftDriveMotor);
		rightVictor = new VictorSP(RobotMap.rightDriveMotor);
		dt = new RobotDrive(leftVictor, rightVictor);
		gyro = new ADXRS450_Gyro();
		
		gyro.reset();
		
		LiveWindow.addActuator("Drivetrain", "left motor", leftVictor);
		LiveWindow.addActuator("Drivetrain", "Right motor", rightVictor);
		LiveWindow.addSensor("Drivetrain", "Gyro", gyro);

	}
	
	public void driveStraight() {
		double angle = gyro.getAngle();
		dt.arcadeDrive(-1, angle * kP); // maybe negative angle
	}

	public void setFromJoysticks(double leftValue, double rightValue) {
		dt.tankDrive(leftValue * RobotMap.leftMultiplier, rightValue * RobotMap.rightMultiplier);
//		leftVictor.set(leftValue * RobotMap.leftMultiplier);
//		rightVictor.set(rightValue * RobotMap.rightMultiplier);
	}
	
	public void setRaw(double leftValue, double rightValue) {
		dt.tankDrive(leftValue, rightValue);
//		leftVictor.set(leftValue);
//		rightVictor.set(rightValue);
	}
		
	
	public void stop() {
		dt.tankDrive(0, 0);
//		leftVictor.set(0);
//		rightVictor.set(0);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }
    
}
