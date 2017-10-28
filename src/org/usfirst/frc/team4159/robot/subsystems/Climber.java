package org.usfirst.frc.team4159.robot.subsystems;

import org.usfirst.frc.team4159.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	
	private static Victor climbVictor;
	
	public Climber() {
		climbVictor = new Victor(RobotMap.climberMotor);
	}

	public void climbUp() {
		climbVictor.set(1);
	}
	
	public void climbDown() {
		climbVictor.set(-1);
	}
	
	public void stopClimb() {
		climbVictor.set(0);
	}

    public void initDefaultCommand() {
        //setDefaultCommand(new MySpecialCommand());
    }
}
