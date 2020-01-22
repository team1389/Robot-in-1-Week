package frc.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Intake extends SubsystemBase {
    public TalonSRX intakeMotor;

    public Intake() {
        intakeMotor = new TalonSRX(RobotMap.INTAKE_MOTOR);
    }
}
