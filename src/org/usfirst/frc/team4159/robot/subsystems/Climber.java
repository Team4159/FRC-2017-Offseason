package org.usfirst.frc.team4159.robot.subsystems;

import org.usfirst.frc.team4159.robot.RobotMap;
import org.usfirst.frc.team4159.robot.commands.Climb;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	
	private Relay relay;
	
	public Climber() {
		relay = new Relay(RobotMap.climberRelay);
	}

	public void climbUp() {
		relay.set(Relay.Value.kForward);
	}
	
	public void climbDown() {
		relay.set(Relay.Value.kReverse);
	}
	
	public void stopClimb() {
		relay.set(Relay.Value.kOff);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new Climb());
    }
}
