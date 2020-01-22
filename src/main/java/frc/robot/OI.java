package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.commands.DriveWithCurvature;
import frc.commands.RunIntake;

public class OI {
    DriveWithCurvature driveWithCurvature = new DriveWithCurvature(Robot.drivetrain);
    RunIntake runIntake = new RunIntake(Robot.intake);
    public XboxController driveController, manipController;

    public OI() {
        initControllers();

        Robot.drivetrain.setDefaultCommand(driveWithCurvature);
        Robot.intake.setDefaultCommand(runIntake);
    }

    /**
     * Initialize JoystickButtons and Controllers
     */
    private void initControllers() {
        driveController = new XboxController(0);
        manipController = new XboxController(1);
    }

    public double driveLeftY() {
        return -driveController.getY(GenericHID.Hand.kLeft);
    }

    public double driveRightX() {
        return driveController.getX(GenericHID.Hand.kRight);
    }

    public boolean driveLeftBumper() {
        return driveController.getBumper(GenericHID.Hand.kLeft);
    }

    public boolean manipAButton() {return manipController.getAButton();}

    public boolean manipBButton() {return manipController.getBButton();}
}