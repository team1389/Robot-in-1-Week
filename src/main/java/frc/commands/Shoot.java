package frc.commands;


import com.revrobotics.CANPIDController;
import com.revrobotics.ControlType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Robot;

import static frc.robot.Robot.*;

public class Shoot extends SequentialCommandGroup {

    public Shoot() {
        addRequirements(shooter);
        addCommands(new ShootOnce());
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stopMotors();
        System.out.println("stopping motors");
    }

    public static class SpinUpShooters extends CommandBase {
        private CANPIDController pid;
        private double shooterRPM;
        private double shooterTargetRPM;
        private double tolerance, threshold;
        private double previousRPM;
        private boolean wasInRange;


        public SpinUpShooters() {
            addRequirements(Robot.shooter);
            pid = Robot.shooter.getShooterLeftPIDController();

            System.out.println("Made Object");
        }

        @Override
        public void initialize() {
            shooterTargetRPM = 5200;
            pid.setReference(shooterTargetRPM, ControlType.kVelocity);
        }

        @Override
        public boolean isFinished() {
            return false;
        }

        @Override
        public void execute() {
            shooterRPM = Robot.shooter.getShooterLeftRPM();
            pid.setReference(shooterTargetRPM, ControlType.kVelocity);

            //System.out.println("Shooter RPM " + shooterRPM);
            //System.out.println(shooter.shooterTop.get());

            previousRPM = shooterRPM;
        }

        @Override
        public void end(boolean interrupted) {
            //pid.setReference(0, ControlType.kVelocity);
            shooter.stopMotors();
        }


        //@Override
        /*public boolean isFinished() {
            return tolerance <= Math.abs(shooterTargetRPM - threshold);
        }*/

    }

    private class ShootOnce extends SequentialCommandGroup {
        public ShootOnce() {
            addRequirements(shooter, Robot.indexer);
            addCommands(new SpinUpShooters(), new InstantCommand(() -> indexer.runIndexer(1)), new WaitCommand(0.25),
                    new InstantCommand(() -> conveyor.startConveying()), new WaitCommand(0.5));
        }

        @Override
        public void end(boolean interrupted) {
            shooter.stopMotors();
            System.out.println("stopping motors");
        }
    }


}
