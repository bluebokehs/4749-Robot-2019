/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public interface RobotMap {
  //Driver Station
  int MAIN_CONTROLLER = 0;

  //Controller Buttons
  int ROTATE_BUTTON = 1;
  int CLIMB_UP = 2;

  //CanTalonSRX
  int DT_FRONTLEFT = 1;
  int DT_FRONTRIGHT = 2;
  int DT_BACKLEFT = 3;
  int DT_BACKRIGHT = 4;
  int HATCH_ROTATOR = 5;

  //Climber Constants
  double ROTATOR_SPEED = 0.3;
  double ROTATOR_AUTO_SPEED = 0.5;

  //Drive Train Constants
  double AUTO_SPEED = 0.3;
  double DRIVE_SPEED = 0.8;
  double ROTATE_SPEED = 0.6;
}
