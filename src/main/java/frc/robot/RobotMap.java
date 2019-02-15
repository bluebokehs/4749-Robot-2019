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
  double ROTATOR_SPEED = 1;
  double ROTATOR_AUTO_SPEED = 0.5;

  //Drive Train Constants
  double AUTO_SPEED = 0.3;
  double DRIVE_SPEED = 0.8;
  double ROTATE_SPEED = 0.6;

  //Position stuff
  /**
	 * Which PID slot to pull gains from. Starting 2018, you can choose from
	 * 0,1,2 or 3. Only the first two (0,1) are visible in web-based
	 * configuration.
	 */
	public static final int kSlotIdx = 0;

	/**
	 * Talon SRX/ Victor SPX will supported multiple (cascaded) PID loops. For
	 * now we just want the primary one.
	 */
	public static final int kPIDLoopIdx = 0;

	/**
	 * Set to zero to skip waiting for confirmation, set to nonzero to wait and
	 * report to DS if action fails.
	 */
	public static final int kTimeoutMs = 30;
	
	/* Choose so that Talon does not report sensor out of phase */
	public static boolean kSensorPhase = true;

	/**
	 * Choose based on what direction you want to be positive,
	 * this does not affect motor invert. 
	 */
	public static boolean kMotorInvert = false;

	/**
	 * Gains used in Positon Closed Loop, to be adjusted accordingly
     * Gains(kp, ki, kd, kf, izone, peak output);
     */
  static final Gains kGains = new Gains(0.15, 0.0, 1.0, 0.0, 0, 1.0);
}
