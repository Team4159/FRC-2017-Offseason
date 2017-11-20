package org.usfirst.frc.team4159.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4159.robot.Robot;

public class TurnLeft extends Command {

    public TurnLeft() {
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.drivetrain.turnLeftRaw();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
