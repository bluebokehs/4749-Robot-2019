package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;


public class HatchRotator extends Subsystem implements RobotMap {

    private static HatchRotator instance;
    private WPI_TalonSRX hatchRotator;

    public boolean downState;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public HatchRotator()
    {
        hatchRotator = new WPI_TalonSRX(HATCH_ROTATOR);
        // TODO - make this motor controller brake instead of coast

        hatchRotator.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 
                                            kPIDLoopIdx,
				                            kTimeoutMs);
                                            
        hatchRotator.setSelectedSensorPosition(0,kPIDLoopIdx,kTimeoutMs);

		/* Ensure sensor is positive when output is positive */
		hatchRotator.setSensorPhase(kSensorPhase);

		/**
		 * Set based on what direction you want forward/positive to be.
		 * This does not affect sensor phase. 
		 */ 
		hatchRotator.setInverted(kMotorInvert);

		/* Config the peak and nominal outputs, 12V means full */
		hatchRotator.configNominalOutputForward(0, kTimeoutMs);
		hatchRotator.configNominalOutputReverse(0, kTimeoutMs);
		hatchRotator.configPeakOutputForward(1, kTimeoutMs);
		hatchRotator.configPeakOutputReverse(-1, kTimeoutMs);

		/**
		 * Config the allowable closed-loop error, Closed-Loop output will be
		 * neutral within this range. See Table in Section 17.2.1 for native
		 * units per rotation.
		 */
		hatchRotator.configAllowableClosedloopError(0, kPIDLoopIdx, kTimeoutMs);

		/* Config Position Closed Loop gains in slot0, tsypically kF stays zero. */
		hatchRotator.config_kF(kPIDLoopIdx, kGains.kF, kTimeoutMs);
		hatchRotator.config_kP(kPIDLoopIdx, kGains.kP, kTimeoutMs);
		hatchRotator.config_kI(kPIDLoopIdx, kGains.kI, kTimeoutMs);
		hatchRotator.config_kD(kPIDLoopIdx, kGains.kD, kTimeoutMs);

		/**
		 * Grab the 360 degree position of the MagEncoder's absolute
		 * position, and intitally set the relative sensor to match.
		 */
		int absolutePosition = hatchRotator.getSensorCollection().getPulseWidthPosition();

		/* Mask out overflows, keep bottom 12 bits */
		absolutePosition &= 0xFFF;
		if (kSensorPhase) { absolutePosition *= -1; }
		if (kMotorInvert) { absolutePosition *= -1; }
		

        // set position identifier to down
        downState = true;
    }

    public void rotate(){
        hatchRotator.set(ControlMode.Position, (this.getEncoderPosition()+ 21100));
        downState = !downState;
        
        SmartDashboard.putData("Downstate", downState);
    }

    public int getEncoderPosition(){
        return hatchRotator.getSelectedSensorPosition(0);
    }

    public void resetPos() {
        hatchRotator.setSelectedSensorPosition(0,0,kTimeoutMs);
        System.out.println("hatchRotator Talon position reset");
    }

    public void stop(){
        hatchRotator.set(0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());

    }

}
