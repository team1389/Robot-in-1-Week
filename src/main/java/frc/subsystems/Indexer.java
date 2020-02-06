package frc.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Indexer extends SubsystemBase {   //The motor to stop the balls is a BAG Motor

    private TalonSRX indexerLeft;
    private TalonSRX indexerRight;

    public Indexer() {
        indexerLeft = new TalonSRX(RobotMap.INDEXER_LEFT);
        indexerRight = new TalonSRX(RobotMap.INDEXER_RIGHT);
    }

    public void runIndexer(double percent) {
        indexerLeft.set(ControlMode.PercentOutput, percent);
        indexerRight.set(ControlMode.PercentOutput, percent);
    }

    public void stopIndexer() {
        indexerLeft.set(ControlMode.PercentOutput, 0);
        indexerRight.set(ControlMode.PercentOutput, 0);
    }
}
