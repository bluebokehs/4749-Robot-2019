package frc.team4749.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team4749.robot.subsystems.*;

public class Robot extends IterativeRobot {

    private static final String forward = "Forward";
    private static final String nothing = "Nothing";

    public static Elevator elevator = new Elevator();
    public static DriveTrain driveTrain = new DriveTrain();

    public static OI oi = new OI();

    private SendableChooser<String> autonomousChooser = new SendableChooser<>();
    
    @Override
    public void robotInit() { // runs once before robotPeriodic when the robot is turned on
        autonomousChooser.addDefault("Default Nothing Auto", nothing);
        autonomousChooser.addObject("Forward Auto", forward);
        SmartDashboard.putData("Auto modes", autonomousChooser);
    }

    @Override
    public void disabledInit() { // runs once before disabledPeriodic after the robot is disabled

    }

    @Override
    public void disabledPeriodic() { // runs is a loop while the robot is disabled
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() { // runs once before autonomousPeriodic after autonomous mode is started
        String autonomousSelected = autonomousChooser.getSelected();
        System.out.println("Auto selected: " + autonomousSelected);

        // MotorSafety improves safety when motors are updated in loops
        // but is disabled here because motor updates are not looped in
        // this autonomous mode.
        driveTrain.setSaftey(false);

        switch (autoSelected) {
            case nothing:
                break;
            case forward:
            default:
                driveTrain.autoForward(2.0);
                break;
        }
    }

    @Override
    public void autonomousPeriodic() { // runs is a loop while the robot is in autonomous mode
        Scheduler.getInstance().run();

    }

    @Override
    public void teleopInit() {
        // runs once before teleopPeriodic after teleop mode is started
        driveTrain.setManual();
    }

    @Override
    public void teleopPeriodic() { // runs is a loop while the robot is in teleop mode
        Scheduler.getInstance().run();
    }


    @Override
    public void testInit() { // runs once before testPeriodic after test mode is started

    }

    @Override
    public void testPeriodic() { // runs is a loop while the robot is in test mode

    }
}
