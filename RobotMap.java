package frc.team4749.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public interface RobotMap {

    //Driver Station
    int MAIN_CONTROLLER = 0;

    //Controller Buttons
    int CLIMB_BUTTON = 2;

    //CanTalonSRX
    int DT_FRONTLEFT = 1;
    int DT_FRONTRIGHT = 2;
    int DT_BACKLEFT = 3;
    int DT_BACKRIGHT = 4;

}
