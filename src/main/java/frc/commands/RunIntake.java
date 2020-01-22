package frc.commands;


import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.subsystems.Drivetrain;
import frc.subsystems.Intake;

public class RunIntake extends CommandBase {
    private Intake intake = null;
    private boolean isIntaking = true;

    public RunIntake(Intake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        if(Robot.oi.manipAButton()) {
            isIntaking = true;
        }
        if(Robot.oi.manipBButton()) {
            isIntaking = false;
        }

        if(isIntaking) {
            intake.intakeMotor.set(ControlMode.PercentOutput, 0.5);
        }
        else {
            intake.intakeMotor.set(ControlMode.PercentOutput, 0);
        }
    }
}
