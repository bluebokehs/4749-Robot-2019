package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.Controller;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.commands.drive.ManualDrive;

public class DriveTrain extends Subsystem implements RobotMap {

    private WPI_TalonSRX frontLeft, frontRight, backLeft, backRight;
    private MecanumDrive robotDrive;

    public DriveTrain(){
        frontLeft  = new WPI_TalonSRX(DT_FRONTLEFT);
        backLeft = new WPI_TalonSRX(DT_BACKLEFT);
        frontRight = new WPI_TalonSRX(DT_FRONTRIGHT);
        backRight = new WPI_TalonSRX(DT_BACKRIGHT);

        frontLeft.setInverted(true);
        backLeft.setInverted(true);
        frontRight.setInverted(true);
        backRight.setInverted(true);

        frontLeft.setNeutralMode(NeutralMode.Brake);
        frontRight.setNeutralMode(NeutralMode.Brake);
        backLeft.setNeutralMode(NeutralMode.Brake);
        backRight.setNeutralMode(NeutralMode.Brake);

        robotDrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
        setManual();
    }

    //Talon Mode change functions
    public void setAuto(){
        
        System.out.println("DriveTrain set to autonomous");
    }

    public void setManual(){
        System.out.println("DriveTrain set to manual" );
    }

    public void setSaftey(boolean state){
        robotDrive.setSafetyEnabled(state);
    }

    public void setBrake(){
        frontLeft.setNeutralMode(NeutralMode.Brake);
        frontRight.setNeutralMode(NeutralMode.Brake);
        backLeft.setNeutralMode(NeutralMode.Brake);
        backRight.setNeutralMode(NeutralMode.Brake);
    }

    public void setCoast(){
        frontLeft.setNeutralMode(NeutralMode.Coast);
        frontRight.setNeutralMode(NeutralMode.Coast);
        backLeft.setNeutralMode(NeutralMode.Coast);
        backRight.setNeutralMode(NeutralMode.Coast);
    }

    // Auto Functions
    public void autoForward(double time){
        robotDrive.driveCartesian(0.0, AUTO_SPEED,0.0);

        Timer.delay(time);
        this.stop();
    }
    public void autoBackward(double time){
        robotDrive.driveCartesian(0.0, AUTO_SPEED * -1, 0.0);
        Timer.delay(time);
        this.stop();
    }
    public void autoLeft(double time){
        robotDrive.driveCartesian(AUTO_SPEED * 2 * -1, 0.0,  0.0);
        Timer.delay(time);
        this.stop();
    }
    public void autoRight(double time){
        robotDrive.driveCartesian(AUTO_SPEED * 2, 0.0, 0.0);
        Timer.delay(time);
        this.stop();
    }
    public void autoRotateL(double time){
        robotDrive.driveCartesian(0.0, 0.0, AUTO_SPEED * -1);
        Timer.delay(time);
        this.stop();
    }
    public void autoRotateR(double time){
        robotDrive.driveCartesian(0.0, 0.0, AUTO_SPEED);
        Timer.delay(time);
        this.stop();
    }

    // Basic Teleop Functions
    public void manualDrive(Controller controller){
        robotDrive.driveCartesian((controller.getLX() * DRIVE_SPEED * -1), (controller.getLY() * DRIVE_SPEED),(controller.getRudder() * ROTATE_SPEED));
    }

    // Support functions
    public void stop() { // this stops the robot from moving
        robotDrive.driveCartesian(0.0, 0.0, 0.0, 0.0);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ManualDrive());
    }


}
