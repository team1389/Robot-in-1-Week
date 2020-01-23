package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.commands.DriveWithCurvature;
import frc.commands.RunConveyor;
import frc.commands.RunIntake;
import frc.commands.ShooterHold;

public class OI {
    ShooterHold shooterHold = new ShooterHold(Robot.shooter);


    DriveWithCurvature driveWithCurvature = new DriveWithCurvature(Robot.drivetrain);
    RunIntake runIntake = new RunIntake(Robot.intake);
    RunConveyor runConveyor = new RunConveyor(Robot.conveyor);


    public XboxController driveController, manipController;

    public OI() {
        initControllers();

        Robot.shooter.setDefaultCommand(shooterHold);
        Robot.drivetrain.setDefaultCommand(driveWithCurvature);
        Robot.intake.setDefaultCommand(runIntake);
        Robot.conveyor.setDefaultCommand(runConveyor);
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

    public double manipRightTrigger() {
        return manipController.getTriggerAxis(GenericHID.Hand.kRight);
    }

    public double mainpLeftTrigger() {
        return manipController.getTriggerAxis(GenericHID.Hand.kLeft);
    }


    public boolean driveLeftBumper() {
        return driveController.getBumper(GenericHID.Hand.kLeft);
    }

    public boolean manipAButton() {return manipController.getAButtonPressed();}

    public boolean manipStartButton() {return manipController.getStartButtonPressed();}

    public boolean manipBackButton() {return manipController.getBackButtonPressed();}


    public double manipLeftTrigger() {return manipController.getTriggerAxis(GenericHID.Hand.kLeft);}
}