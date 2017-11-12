package org.usfirst.frc.team4159.robot.commands;

import org.usfirst.frc.team4159.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class DriveStraight extends TimedCommand {
	
	private double left;
	private double right;

    public DriveStraight(double timeout, double left, double right) {
        super(timeout);
        requires(Robot.drivetrain);
        this.left = left;
        this.right = right;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		System.out.println("Drive straight execute");
    		Robot.drivetrain.driveStraightRaw(left, right);
    }

    // Called once after timeout
    protected void end() {
    		Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
    
}
