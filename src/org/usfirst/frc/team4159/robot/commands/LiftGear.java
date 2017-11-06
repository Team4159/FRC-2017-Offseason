package org.usfirst.frc.team4159.robot.commands;

import org.usfirst.frc.team4159.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class LiftGear extends Command {
	
	private double sp;
	
    public LiftGear(double sp) {
    		requires(Robot.gearLift);
    		this.sp = sp;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		// Enabled PID controller
    		Robot.gearLift.enable();
    		// Sets where PID controller should move the system to
    		Robot.gearLift.setSetpoint(sp); // 2 volts?
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.gearLift.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.gearLift.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
		Robot.gearLift.disable();
    }
}
