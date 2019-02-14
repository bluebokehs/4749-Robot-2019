package frc.robot.commands.climb;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class Climb extends Command {

    public Climb(){
        requires(Robot.hatchRotator);
    }

    protected void initialize(){
        Robot.hatchRotator.rotate(.02205);
    }

    protected void end(){
        Robot.hatchRotator.stop();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }


}
