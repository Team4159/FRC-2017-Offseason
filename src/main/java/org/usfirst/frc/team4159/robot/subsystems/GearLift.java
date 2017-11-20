package org.usfirst.frc.team4159.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team4159.robot.RobotMap;
import org.usfirst.frc.team4159.robot.commands.LiftGear;

public class GearLift extends PIDSubsystem {

    private VictorSP liftVictor;
    private Encoder liftEncoder;

    private static double kP = 0.3; // must tune
    private static double kI = 0; // maybe tune
    private static double kD = 0; // most likely not

    public GearLift() {

        super("Gear Lift", kP, kI, kD);

        liftVictor = new VictorSP(RobotMap.gearLiftMotor);
        liftEncoder = new Encoder(RobotMap.liftEncoderA, RobotMap.liftEncoderB);

        setAbsoluteTolerance(0.05); // idk
        getPIDController().setContinuous(false);

        LiveWindow.addActuator("GearLift", "lift motor", liftVictor);
        LiveWindow.addSensor("GearLift", "encoder", liftEncoder);
        LiveWindow.addActuator("GearLift", "pid controller", getPIDController());

    }

    public void up() {
        setSetpoint(90); // tune. encoder count?
    }

    public void down() {
        setSetpoint(0); // tune. encoder count?
    }

    public void initDefaultCommand() {
        setDefaultCommand(new LiftGear());
    }

    public void setRaw(double speed) {
        liftVictor.set(speed);
    }

    public void stop() {
        liftVictor.stopMotor();
    }

    protected double returnPIDInput() {
        return liftEncoder.getRaw();
    }

    protected void usePIDOutput(double output) {
        liftVictor.set(output);
    }
}
