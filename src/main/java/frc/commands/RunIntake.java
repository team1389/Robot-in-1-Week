package frc.commands;


import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.subsystems.Drivetrain;
import frc.subsystems.Intake;

public class RunIntake extends CommandBase {
    private Intake intake = null;
    private boolean isIntaking = false;

    public RunIntake() {
        intake = Robot.intake;
        addRequirements(intake);

    }

    @Override
    public void execute() {
        System.out.println("Intake command works");
        intake.startIntaking();
    }

    @Override
    public void end(boolean interrupted) {
        intake.stopIntaking();
    }
}
