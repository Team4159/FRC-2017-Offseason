package org.usfirst.frc.team4159.robot.subsystems;

import org.usfirst.frc.team4159.robot.RobotMap;
import org.usfirst.frc.team4159.robot.commands.LiftGear;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearLifter extends Subsystem {

	public static Victor liftVictor;
	
	public GearLifter() {
		liftVictor = new Victor(RobotMap.gearLiftMotor);
	}
	
	public void liftUp() {
		liftVictor.set(1);
	}
	
	public void liftDown() {
		liftVictor.set(-1);
	}
	
	public void stopLift() {
		liftVictor.set(0);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new LiftGear());
    }
}
