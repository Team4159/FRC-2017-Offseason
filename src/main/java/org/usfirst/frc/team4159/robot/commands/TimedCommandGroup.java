package org.usfirst.frc.team4159.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4159.robot.Robot;

public class TimedCommandGroup extends CommandGroup {

    public TimedCommandGroup(Mode m) {

        requires(Robot.drivetrain);

        switch (m) {
            case DO_NOTHING:
                break;
            case BASELINE:
                addSequential(new DriveStraight(5, 0.5, 0.51));
                break;
            case MIDDLE_GEAR:
                addSequential(new DriveStraight(13, 0.5, 0.51));
                break;
            default:
                break;

        }

    }

    public enum Mode {
        DO_NOTHING, BASELINE, MIDDLE_GEAR, LEFT_GEAR, RIGHT_GEAR
    }
}
