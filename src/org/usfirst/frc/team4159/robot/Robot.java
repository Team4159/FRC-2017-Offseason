package org.usfirst.frc.team4159.robot;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

import org.usfirst.frc.team4159.robot.subsystems.Climber;
import org.usfirst.frc.team4159.robot.subsystems.Drivetrain;
import org.usfirst.frc.team4159.robot.subsystems.GearIO;
import org.usfirst.frc.team4159.robot.subsystems.GearLift;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

public class Robot extends IterativeRobot {

	public static OI oi;
	
	public static Drivetrain drivetrain;
	public static Climber climber;
	public static GearIO gearIO;
	public static GearLift gearLift;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		
		// Initialize subsystems
		drivetrain = new Drivetrain();
		climber = new Climber();
		gearIO = new GearIO();
		gearLift = new GearLift();
		
		oi = new OI();
		
		CameraServer.getInstance().startAutomaticCapture();
		
		/*
			
			new Thread(() -> {
				
	            UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
	            camera.setResolution(640, 480);
	            
	            CvSink cvSink = CameraServer.getInstance().getVideo();
	            CvSource outputStream = CameraServer.getInstance().putVideo("gearcam", 640, 480); // check camera dimensions?
	            
	            Mat source = new Mat();
	            Mat output = new Mat();
	            
	            while(!Thread.interrupted()) {
	                cvSink.grabFrame(source);
	                // Draw hud
	                //Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
	                Imgproc.rectangle(output, new Point(5,5), new Point(100,5), new Scalar(255,0,0)); // change x,y points and color
	                outputStream.putFrame(output);
	            }
	        }).start();
			
		*/
		
	}

	// Called every time robot enters Disabled mode. Use to clear and rest subsystem info.
	@Override
	public void disabledInit() {
		drivetrain.stop();
		climber.stopClimb();
		gearIO.stop();
		gearLift.stop();
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
		Scheduler.getInstance().run();
	}

	// Called periodically during test mode
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
