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

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public HatchRotator()
    {
        hatchRotator = new WPI_TalonSRX(HATCH_ROTATOR);
        // TODO - make this motor controller brake instead of coast

        hatchRotator.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);

        this.close();
        hatchRotator.setSelectedSensorPosition(0,0,0);
        // hatchRotator.configForwardSoftLimitEnable(false, 0);
        // hatchRotator.configReverseSoftLimitEnable(false, 0);
        // hatchRotator.configForwardSoftLimitThreshold(19500, 0);
        // hatchRotator.configReverseSoftLimitThreshold(0, 0);
    }

    public void rotate(){
        hatchRotator.set(ROTATOR_SPEED);

        
    }

    public int getEncoderPosition(){
        return hatchRotator.getSelectedSensorPosition(0);
    }

    public void setMax(){
        hatchRotator.configForwardSoftLimitThreshold(this.getEncoderPosition(),0);
    }

    public void setMin(){
        hatchRotator.configReverseSoftLimitThreshold(this.getEncoderPosition(), 0);
    }

    public void reset(){
        hatchRotator.setSelectedSensorPosition(0,0,0);
    }

    public void open(){
        hatchRotator.configForwardSoftLimitEnable(false, 0);
        hatchRotator.configReverseSoftLimitEnable(false, 0);
    }

    public void close(){
        hatchRotator.configForwardSoftLimitEnable(true, 0);
        hatchRotator.configReverseSoftLimitEnable(true, 0);
    }

    public void resetPos() {
        System.out.println("hatchRotator Talon position reset");
    }

    public void climbUp(double time){
        hatchRotator.set(ROTATOR_AUTO_SPEED);
        Timer.delay(time);
        this.stop();
    }

    public void stop(){
        hatchRotator.set(0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());

    }

}
