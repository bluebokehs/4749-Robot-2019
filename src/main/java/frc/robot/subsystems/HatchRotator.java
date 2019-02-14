package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
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
    }

    public void rotate(double time){
        hatchRotator.set(ROTATOR_SPEED);
        Timer.delay(time);
        this.stop();
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
