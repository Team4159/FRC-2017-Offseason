package org.usfirst.frc.team4159.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {

    private static Joystick leftStick;
    private static Joystick rightStick;
    private static Joystick secondaryStick;
    private static Joystick nes;
//	private static Joystick xbox;

    public OI() {

        leftStick = new Joystick(RobotMap.leftJoy);
        rightStick = new Joystick(RobotMap.rightJoy);
        secondaryStick = new Joystick(RobotMap.secondaryJoy);
        nes = new Joystick(RobotMap.nes);
//		xbox = new Joystick(RobotMap.xbox);

    }

    public static Joystick getLeftJoystick() {
        return leftStick;
    }

    public static Joystick getRightJoystick() {
        return rightStick;
    }

    public static boolean getRightButton(int b) {
        return rightStick.getRawButton(b);
    }

    public static boolean getLeftButton(int b) {
        return leftStick.getRawButton(b);
    }

    public static boolean getSecondaryButton(int b) {
        return secondaryStick.getRawButton(b);
    }

    public static boolean getNesButton(int b) {
        return nes.getRawButton(b);
    }

    public static double getNesAxis(int a) {
        return -nes.getRawAxis(a);
    }

    public static double getLeftAxis() {
        return leftStick.getY();
    }

    public static double getRightAxis() {
        return rightStick.getY();
    }

    public static double getSecondaryJoystick() {
        return secondaryStick.getY();
    }

}
