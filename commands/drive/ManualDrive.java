package frc.team4749.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team4749.robot.Robot;

public class ManualDrive extends Command {

    public ManualDrive(){
        requires(Robot.driveTrain);
    }

    protected void initialize() {
        Robot.driveTrain.setManual();
    }

    protected void execute() {
        Robot.driveTrain.manualDrive(Robot.oi.getController());
    }

    protected void end() {
        Robot.driveTrain.stop();
    }

    protected void interrupted() {
        end();
    }

    protected boolean isFinished() {
        return false;
    }

}
