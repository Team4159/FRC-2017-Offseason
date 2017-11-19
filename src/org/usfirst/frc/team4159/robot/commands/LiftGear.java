package org.usfirst.frc.team4159.robot.commands;

import org.usfirst.frc.team4159.robot.OI;
import org.usfirst.frc.team4159.robot.Robot;
import org.usfirst.frc.team4159.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class LiftGear extends Command {
		
    public LiftGear() {
    		requires(Robot.gearLift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		Robot.gearLift.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    		Robot.gearLift.setRaw(OI.getSecondaryJoystick() * 0.4);
    		
    		if( OI.getNesButton(RobotMap.nesGearUp) )
    			Robot.gearLift.setRaw(0.3);
    		else if ( OI.getNesButton(RobotMap.nesGearDown) )
    			Robot.gearLift.setRaw(-0.3);
		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    		return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.gearLift.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
}
