package org.usfirst.frc.team4159.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

import org.usfirst.frc.team4159.robot.subsystems.Climber;
import org.usfirst.frc.team4159.robot.subsystems.Drivetrain;
import org.usfirst.frc.team4159.robot.subsystems.GearIO;
import org.usfirst.frc.team4159.robot.subsystems.GearLifter;
import org.usfirst.frc.team4159.robot.commands.TeleopDrive;

public class Robot extends IterativeRobot {

	public static OI oi;
	
	public static Drivetrain drivetrain;
	public static Climber climber;
	public static GearIO gearIO;
	public static GearLifter gearLifter;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		oi = new OI();
		drivetrain = new Drivetrain();
		climber = new Climber();
		gearIO = new GearIO();
		gearLifter = new GearLifter();
	}

	// Called everytime robot enters Disabled mode. Use to clear and rest subsystem info.
	@Override
	public void disabledInit() {
		drivetrain.stop();
		climber.stopClimb();
		gearIO.stop();
		gearLifter.stopLift();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	// Called periodically during autonomous
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// Makes sure auton stops when teleop starts
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	// Called periodically during operator control
	@Override
	public void teleopPeriodic() {
		new TeleopDrive();
		Scheduler.getInstance().run();
	}

	// Called periodically during test mode
	@Override
	public void testPeriodic() {
		new TeleopDrive();
		LiveWindow.run();
	}
}
