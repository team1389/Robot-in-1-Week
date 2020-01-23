package frc.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Conveyor extends SubsystemBase {
    public TalonSRX conveyorMotor;

    public Conveyor() {
        conveyorMotor = new TalonSRX(RobotMap.CONVEYOR_MOTOR);

        conveyorMotor.setInverted(true);
    }
}