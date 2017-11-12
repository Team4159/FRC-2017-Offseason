package org.usfirst.frc.team4159.robot.subsystems;

import org.usfirst.frc.team4159.robot.RobotMap;
import org.usfirst.frc.team4159.robot.commands.Climb;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	
	private VictorSP climbVictor;
	
	public Climber() {
		climbVictor = new VictorSP(RobotMap.climberMotor);
	}

	public void climbUp() {
		climbVictor.set(-1);
	}
	
	public void stopClimb() {
		climbVictor.set(0);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new Climb());
    }
}
