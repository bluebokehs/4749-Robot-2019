package frc.robot.commands.climb;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class HatchRotator extends Command {

    public HatchRotator(){
        requires(Robot.hatchRotator);
    }

    protected void initialize(){
        Robot.hatchRotator.rotate();
    }

    protected void end(){
        Robot.hatchRotator.stop();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }


}
