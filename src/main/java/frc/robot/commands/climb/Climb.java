package frc.robot.commands.climb;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class Climb extends Command {

    public Climb(){
        requires(Robot.climber);
    }

    protected void initialize(){
        Robot.climber.climb();
    }

    protected void end(){
        Robot.climber.stop();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }


}
