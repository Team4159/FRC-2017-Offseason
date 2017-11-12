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

	//PID control variables
	private static final double kP = 0.1, kI = 0, bkP = 0.01; //TODO tune!
	private double sumError;
	
	public Drivetrain() {
		leftVictor = new VictorSP(RobotMap.leftDriveMotor);
		rightVictor = new VictorSP(RobotMap.rightDriveMotor);
		dt = new RobotDrive(leftVictor, rightVictor);
		dt.setSafetyEnabled(false);
		gyro = new ADXRS450_Gyro();

		gyro.reset();
		
		LiveWindow.addActuator("Drivetrain", "left motor", leftVictor);
		LiveWindow.addActuator("Drivetrain", "Right motor", rightVictor);
		LiveWindow.addSensor("Drivetrain", "Gyro", gyro);
	}

	/**
	 * PI control:
	 * Get the current angle, calculator and integrate error, and set the desired rotation
	 */
	
	public void drivePIDa(double targetAngle) {
		double angle = gyro.getAngle();
		dt.drive(-0.5, -angle*bkP + targetAngle);
	}
	
	
	public void drivePIDb(double targetRPM) {
		double error = targetRPM - gyro.getRate();
		sumError += error;
		double rotation = kP * (error + (kI * sumError));

		if(rotation > 1 || rotation < -1) //un-integrate to avoid integrator windup. Values already limited
			sumError -= error;

		dt.arcadeDrive(-0.5, rotation);
	}
	
	public void driveStraightRaw(double right, double left) {
		System.out.println("drive straight raw");
		dt.tankDrive(-right, -left);
	}

	public void setFromJoysticks(double leftValue, double rightValue) {
		
		dt.tankDrive(leftValue * RobotMap.leftMultiplier, rightValue * RobotMap.rightMultiplier);
		
	}
	
	public void setRaw(double leftValue, double rightValue) {
		
		dt.tankDrive(leftValue, rightValue);

	}
		
	
	public void stop() {
		
		dt.tankDrive(0, 0);
		
	}
	
	public void resetGyro() {
		gyro.reset();
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }
    
}
