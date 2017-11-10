package org.usfirst.frc.team4159.robot.commands;

import org.usfirst.frc.team4159.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class StraightDrive extends TimedCommand {

    public StraightDrive(double timeout) {
        super(timeout);
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		Robot.drivetrain.driveStraight();
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
