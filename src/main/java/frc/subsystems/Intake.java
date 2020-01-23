package frc.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Intake extends SubsystemBase {
    private DoubleSolenoid leftExtender, rightExtender;
    private TalonSRX intakeMotor;

    public Intake() {
        intakeMotor = new TalonSRX(RobotMap.INTAKE_MOTOR);


    }
}
