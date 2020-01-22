package frc.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.subsystems.Conveyor;

public class RunConveyor extends CommandBase {
    private Conveyor conveyor = null;
    private boolean isConveying = false;

    public RunConveyor(Conveyor conveyor) {
        this.conveyor = conveyor;

        addRequirements(conveyor);
    }

    @Override
    public void execute() {
        //a button
        if(Robot.oi.manipAButton()) {
            if(isConveying) {
                isConveying = false;
            }
            else {
                isConveying = true;
            }
        }

        if(isConveying) {
            conveyor.conveyorMotor.set(ControlMode.PercentOutput, 0.5);
            System.out.println("Conveying");
        }
        else {
            conveyor.conveyorMotor.set(ControlMode.PercentOutput, 0);
        }

    }
}
