package org.usfirst.frc.team4159.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4159.robot.RobotMap;
import org.usfirst.frc.team4159.robot.commands.IOGear;

public class GearIO extends Subsystem {

	/* Gear Intake / Outtake */

    private VictorSP gearVictor;

    public GearIO() {
        gearVictor = new VictorSP(RobotMap.gearIOMotor);
    }

    public void intake() {
        gearVictor.set(1);
    }

    public void outtake() {
        gearVictor.set(-0.4);
    }

    public void stop() {
        gearVictor.set(0);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new IOGear());
    }
}
