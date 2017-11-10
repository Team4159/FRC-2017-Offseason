package org.usfirst.frc.team4159.robot.commands;

import org.usfirst.frc.team4159.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class AutoCommand extends TimedCommand {
	
	private Mode mode;
	
    public AutoCommand(Mode m) {
    		super(10); // Auton is actually 15 seconds.
    		
    		requires(Robot.gearLift);
    		requires(Robot.gearIO);
    		
    		mode = m;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    		switch (mode) {
    			case DO_NOTHING:
    				break;
    			case STRAIGHT:
    				new StraightDrive(1); // seconds to drive straight. TUNE!
    				break;
    			case MIDDLE_GEAR:
    				Robot.gearLift.up();
    				new StraightDrive(2); // seconds to drive straight. TUNE!
    				Robot.gearIO.outtake();
    				break;
    			default:
    				break;
    		}
    		
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Called once after timeout
    protected void end() {
    		Robot.drivetrain.stop();
    		Robot.gearIO.stop();
    		Robot.gearLift.down();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
    
    public enum Mode {
    		DO_NOTHING, STRAIGHT, MIDDLE_GEAR
    }
}
