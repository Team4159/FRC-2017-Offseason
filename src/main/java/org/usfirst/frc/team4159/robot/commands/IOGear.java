package org.usfirst.frc.team4159.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4159.robot.OI;
import org.usfirst.frc.team4159.robot.Robot;
import org.usfirst.frc.team4159.robot.RobotMap;

public class IOGear extends Command {

	/* Intake / Outtake gear */

    public IOGear() {
        requires(Robot.gearIO);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

        if (OI.getSecondaryButton(RobotMap.gearIntakeButton) || OI.getNesButton(RobotMap.nesGearIntake))
            Robot.gearIO.intake();

        else if (OI.getSecondaryButton(RobotMap.gearOuttakeButton))
            Robot.gearIO.outtake();

        else
            Robot.gearIO.stop();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.gearIO.stop();
    }
}
