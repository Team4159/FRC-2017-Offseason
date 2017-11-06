package org.usfirst.frc.team4159.robot.subsystems;

import org.usfirst.frc.team4159.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class GearLift extends PIDSubsystem {
	
	private static double kP = 0;
	private static double kI = 0;
	private static double kD = 0;
	
	private Victor liftVictor;
	private AnalogInput pot;

    public GearLift() {
    	
    		super("GearLift", kP, kI, kD);
    		
    		liftVictor = new Victor(RobotMap.gearLiftMotor);
    		pot = new AnalogInput(RobotMap.gearPot);
    		
    		setAbsoluteTolerance(0.05); // idk
    		getPIDController().setContinuous(false);

    }

    protected double returnPIDInput() {
    		// Returns sensor input value for the PID loop
        return pot.getAverageVoltage();
    }

    protected void usePIDOutput(double output) {
        // Use output to control the system
        liftVictor.set(output);
    }
    
    public void setRaw(double val) {
    		liftVictor.set(val);
    }
    
    public void stop() {
    		liftVictor.set(0);
    }
    
    public void initDefaultCommand() {
        //setDefaultCommand(new MySpecialCommand());
    }

}
