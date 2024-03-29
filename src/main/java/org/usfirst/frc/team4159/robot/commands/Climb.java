package org.usfirst.frc.team4159.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4159.robot.OI;
import org.usfirst.frc.team4159.robot.Robot;
import org.usfirst.frc.team4159.robot.RobotMap;

public class Climb extends Command {

    public Climb() {
        requires(Robot.climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

        if (OI.getSecondaryButton(RobotMap.climbUpButton) || OI.getNesButton(RobotMap.nesClimb))
            Robot.climber.climbUp();
        else
            Robot.climber.stopClimb();

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.climber.stopClimb();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
