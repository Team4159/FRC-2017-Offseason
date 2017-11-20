package org.usfirst.frc.team4159.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4159.robot.commands.TimedCommandGroup;
import org.usfirst.frc.team4159.robot.subsystems.Climber;
import org.usfirst.frc.team4159.robot.subsystems.Drivetrain;
import org.usfirst.frc.team4159.robot.subsystems.GearIO;
import org.usfirst.frc.team4159.robot.subsystems.GearLift;

import java.net.UnknownHostException;


public class Robot extends IterativeRobot {

    public static Drivetrain drivetrain;
    public static Climber climber;
    public static GearIO gearIO;
    public static GearLift gearLift;
    public static PowerDistributionPanel pdp;
    public static OI oi;
    public static RobotServer rs;

    private Command autonomousCommand;
    private SendableChooser<Command> chooser;

    @Override
    public void robotInit() {

        gearLift = new GearLift();
        drivetrain = new Drivetrain();
        climber = new Climber();
        gearIO = new GearIO();
        pdp = new PowerDistributionPanel();
        oi = new OI();

        try {
            rs = new RobotServer(5800);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        chooser = new SendableChooser<Command>();
        chooser.addObject("Default", new TimedCommandGroup(TimedCommandGroup.Mode.DO_NOTHING));
        chooser.addDefault("Baseline", new TimedCommandGroup(TimedCommandGroup.Mode.BASELINE));
        chooser.addObject("Middle Gear", new TimedCommandGroup(TimedCommandGroup.Mode.MIDDLE_GEAR));

//		chooser.addObject("Do Nothing", new AutoCommandGroup(AutoCommandGroup.Mode.DO_NOTHING));
//		chooser.addObject("Baseline", new AutoCommandGroup(AutoCommandGroup.Mode.BASELINE));
//		chooser.addObject("Middle Gear", new AutoCommandGroup(AutoCommandGroup.Mode.MIDDLE_GEAR));
//		chooser.addDefault("Left Gear", new AutoCommandGroup(AutoCommandGroup.Mode.LEFT_GEAR));
//		chooser.addObject("Right Gear", new AutoCommandGroup(AutoCommandGroup.Mode.RIGHT_GEAR));

        SmartDashboard.putData("Auto Mode", chooser);

        CameraServer.getInstance().startAutomaticCapture();

//			new Thread(() -> {
//				
//	            UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
//	            camera.setResolution(640, 480);
//	            
//	            CvSink cvSink = CameraServer.getInstance().getVideo();
//	            CvSource outputStream = CameraServer.getInstance().putVideo("gearcam", 640, 480); // check camera dimensions?
//	            
//	            Mat source = new Mat();
//	            Mat output = new Mat();
//	            
//	            while(!Thread.interrupted()) {
//	                cvSink.grabFrame(source);
//	                // Draw hud
//	                //Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
//	                Imgproc.rectangle(output, new Point(5,5), new Point(100,5), new Scalar(255,0,0)); // change x,y points and color
//	                outputStream.putFrame(output);
//	            }
//	        }).start();
//			

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
        autonomousCommand = (Command) chooser.getSelected();

        if (autonomousCommand != null) {
            autonomousCommand.start();
        }
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
