package frc.robot.commands.climb;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;
import frc.robot.RobotMap;

public class Slow extends Command implements RobotMap {

    public static boolean toSlow = false;

  

    protected void initialize(){
        System.out.println("START SLOW");
        toSlow = true;
    }

    protected void end(){
        System.out.println("STOP SLOW");
        toSlow = false;
    }

    @Override
    protected boolean isFinished() {
        return false;
    }


}
