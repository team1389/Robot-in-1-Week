package frc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.subsystems.Drivetrain;

public class DriveWithCurvature extends CommandBase {
    private Drivetrain drivetrain = null;

    public DriveWithCurvature() {
        drivetrain = Robot.drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        double throttle = Robot.oi.driveLeftY();
        double rotation = -(Robot.oi.driveRightY());
        boolean isQuickTurn = Robot.oi.driveLeftBumper();
        System.out.println("Jebediah is having fun driving around!");

        Robot.drivetrain.drive(throttle, rotation);

    }
}
