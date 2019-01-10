package frc.team4749.robot;

import edu.wpi.cscore.AxisCamera;
import edu.wpi.cscore.CvSink;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team4749.robot.commands.drive.FastDrive;
import frc.team4749.robot.commands.elevator.*;
import frc.team4749.robot.commands.drive.Brake;
import frc.team4749.robot.commands.climb.Climb;

public class OI implements RobotMap {

    public static OI instance;
    private Controller mainController;
    private JoystickButton climb;

    private Thread m_visionThread;

    public static OI getInstance()
    {
        if (instance == null){
            instance =  new OI();
        }
        return instance;
    }

    OI(){
        mainController = new Controller(MAIN_CONTROLLER);

        createButtons();
        dashboardInit();
    }

    private void dashboardInit(){
        m_visionThread = new Thread(() -> {
            // Get the Axis camera from CameraServer
            AxisCamera camera = CameraServer.getInstance().addAxisCamera("axis-camera.local");

            // Get a CvSink. This will capture Mats from the camera
            CvSink cvSink = CameraServer.getInstance().getVideo();
        });
        m_visionThread.setDaemon(true);
        m_visionThread.start();
    }

    private void createButtons(){
        //Create Buttons for main controller
        climb = new JoystickButton(mainController,CLIMB_BUTTON);

        assignButtons();
    }

    private void assignButtons(){
        //Assign commands to main controller buttons
        climb.whileHeld(new Climb());

    }
    public Controller getController(){
        return mainController;
    }
}
