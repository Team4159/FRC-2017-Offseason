package org.usfirst.frc.team4159.robot.commands;

import org.usfirst.frc.team4159.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCommandGroup extends CommandGroup {

    public AutoCommandGroup(Mode m) {
    		requires(Robot.drivetrain);
    		
    		System.out.println("Command group started");
    		
    		switch(m) {
    		case DO_NOTHING:
    			break;
    		case BASELINE:
    			addSequential(new PIDDrive(5,0));
    			break;
    		case MIDDLE_GEAR:
    			System.out.println("PID middle gear started");
    			addSequential(new PIDDrive(10,0));
    			break;
    		case LEFT_GEAR:
    			//addSequential(new PIDStraight(1,0));
    			//addSequential(new PIDTurn());
    			//addSequential(new PIDTurn(1,0));
    			break;
    		case RIGHT_GEAR:
//    			addSequential(new PIDStraight());
//    			addSequential(new PIDTurn());
//    			addSequential(new PIDStraight());
    			break;
    		}
    }
    
    public enum Mode {
		DO_NOTHING, BASELINE, MIDDLE_GEAR, LEFT_GEAR, RIGHT_GEAR
    }
}
