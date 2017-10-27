package org.usfirst.frc.team4159.robot.subsystems;

import org.usfirst.frc.team4159.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearIO extends Subsystem {
	
	private static Victor gearVictor;
	
	public GearIO() {
		gearVictor = new Victor(RobotMap.gearIOMotor);
	}

    public static void intake() {
    		gearVictor.set(1);
    }
    
    public static void outtake() {
    		gearVictor.set(-1);
    }
    
    public static void stop() {
    		gearVictor.set(0);
    }

    public void initDefaultCommand() {
        //setDefaultCommand(new MySpecialCommand());
    }
}
