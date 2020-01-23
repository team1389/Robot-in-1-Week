package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.commands.ShooterHold;

public class OI {
    ShooterHold shooterHold = new ShooterHold(Robot.shooter);


    public XboxController driveController, manipController;

    public OI() {
        initControllers();
        Robot.shooter.setDefaultCommand(shooterHold);
    }

    /**
     * Initialize JoystickButtons and Controllers
     */
    private void initControllers() {
        driveController = new XboxController(0);
        manipController = new XboxController(1);

    }

    public double manipRightTrigger() {
        return manipController.getTriggerAxis(GenericHID.Hand.kRight);
    }

    public double mainpLeftTrigger() {
        return manipController.getTriggerAxis(GenericHID.Hand.kLeft);
    }


}