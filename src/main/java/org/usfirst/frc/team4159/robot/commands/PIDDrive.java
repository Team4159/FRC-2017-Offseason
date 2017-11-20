package org.usfirst.frc.team4159.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc.team4159.robot.Robot;

public class PIDDrive extends TimedCommand {

    private double angle;

    public PIDDrive(double timeout, double angle) {
        super(timeout);
        requires(Robot.drivetrain);
        this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.drivetrain.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("PID EXECUTING");
        Robot.drivetrain.drivePIDa(angle);
    }

    // Called once after timeout
    protected void end() {
        Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
