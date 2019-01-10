package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


public class Climber extends Subsystem implements RobotMap {

    private static Climber instance;
    private WPI_TalonSRX climber;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Climber()
    {
        climber = new WPI_TalonSRX(CLIMBER);
        // TODO - make this motor controller brake instead of coast
    }

    public void climb(){
        climber.set(CLIMBER_SPEED);
    }

    public void climbUp(double time){
        climber.set(CLIMBER_AUTO_SPEED);
        Timer.delay(time);
        this.stop();
    }

    public void stop(){
        climber.set(0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

}
