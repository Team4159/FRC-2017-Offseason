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
	private static final double kP = 0.1, kI = 0.1, TARGET_RPM = 0; //TODO tune!
	private double sumError;
	
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

	/**
	 * PI control:
	 * Get the current angle, calculator and integrate error, and set the desired rotation
	 */
	public void driveStraight() {
		double error = TARGET_RPM - gyro.getRate();
		sumError += error;
		double rotation = kP * (error + (kI * sumError));

		if(rotation > 1 || rotation < -1) //un-integrate to avoid integrator windup. Values already limited
			sumError -= error;

		dt.arcadeDrive(-1, rotation);
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
