/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  public static Climber climber = new Climber();
  public static DriveTrain driveTrain = new DriveTrain();

  public static OI m_oi;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  public void robotInit() { // runs once before robotPeriodic when the robot is turned on
    m_oi = new OI();
    //m_chooser.setDefaultOption("Default Auto", new Default Auto());
    // chooser.addOption("Other Auto", new AutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
  }

  @Override
  public void robotPeriodic() { // runs periodicly while the robot is turned on
  }

  @Override
  public void disabledInit() { // runs once before disabledPeriodic after the robot is disabled
  }

  @Override
  public void disabledPeriodic() { // runs periodicly while the robot is disabled
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() { // runs once before autonomousPeriodic after autonomous mode is started
    m_autonomousCommand = m_chooser.getSelected();

    // schedule the autonomous command
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  @Override
  public void autonomousPeriodic() { // runs periodicly while the robot is in autonomous mode
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() { // runs once before teleopPeriodic after the robot is in teleop mode
    
    // This makes sure that the autonomous stops running when teleop starts running.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() { // runs periodicly while the robot is in teleop mode
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() { // runs periodicly while the robot is in test mode
  }
}
