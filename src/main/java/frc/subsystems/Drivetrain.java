package frc.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;




public class Drivetrain extends SubsystemBase {
    private DifferentialDrive differentialDrive;
    private SpeedControllerGroup right, left;
    public CANSparkMax rightA, rightB, leftA, leftB;
    private AHRS ahrs;


    public Drivetrain() {
        rightA = new CANSparkMax(RobotMap.RIGHT_DRIVE_A, CANSparkMaxLowLevel.MotorType.kBrushless);
        rightB = new CANSparkMax(RobotMap.RIGHT_DRIVE_B, CANSparkMaxLowLevel.MotorType.kBrushless);
        right = new SpeedControllerGroup(rightA, rightB);

        leftA = new CANSparkMax(RobotMap.LEFT_DRIVE_A, CANSparkMaxLowLevel.MotorType.kBrushless);
        leftB = new CANSparkMax(RobotMap.LEFT_DRIVE_B, CANSparkMaxLowLevel.MotorType.kBrushless);
        left = new SpeedControllerGroup(leftA, leftB);

        ahrs = new AHRS(SerialPort.Port.kMXP);

        differentialDrive = new DifferentialDrive(left, right);
    }

    //Used in the vision
    public void set(double leftPower, double rightPower) {
        leftA.set(leftPower);
        leftB.set(leftPower);

        rightA.set(-rightPower);
        rightB .set(-rightPower);
    }

    public void drive(double leftY, double rightY) {
        differentialDrive.tankDrive(leftY, rightY);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run; use it for debugging and stuff

    }
}
