package frc.commands;


import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.subsystems.Shooter;

import javax.naming.ldap.Control;
import edu.wpi.first.wpilibj.Timer;
import java.util.TimerTask;

public class ShooterHold extends CommandBase {
    private Shooter shooter = null;
    public boolean shootBool = false;
    public Timer timer = new Timer();

    public ShooterHold(Shooter shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
    }

    @Override
    public void execute() {
        if(Robot.oi.manipRightTrigger() > 0 && !shootBool) {
            timer.reset();
            shootBool = true;

            shooter.frontShooterRight.set(ControlMode.PercentOutput, 1);
            shooter.frontShooterLeft.set(ControlMode.PercentOutput, 1);
        }

        if(Robot.oi.manipRightTrigger() > 0 && shootBool && timer.get() >= 2) {
            shooter.backShooterRight.set(ControlMode.PercentOutput, 0.5);
            shooter.backShooterLeft.set(ControlMode.PercentOutput, 0.5);
        }

        if(Robot.oi.manipRightTrigger() > 0 && shootBool && timer.get() >= 3) {
            shooter.backShooterRight.set(ControlMode.PercentOutput, 0);
            shooter.backShooterLeft.set(ControlMode.PercentOutput, 0);
            shooter.frontShooterRight.set(ControlMode.PercentOutput, 0);
            shooter.frontShooterLeft.set(ControlMode.PercentOutput, 0);
        }

        if(Robot.oi.manipRightTrigger() == 0) {
            timer.reset();
            shooter.backShooterRight.set(ControlMode.PercentOutput, 0);
            shooter.backShooterLeft.set(ControlMode.PercentOutput, 0);
            shooter.frontShooterRight.set(ControlMode.PercentOutput, 0);
            shooter.frontShooterLeft.set(ControlMode.PercentOutput, 0);
            shootBool = false;
            System.out.print("pew pew pew pew pew pew pew pew pew pew pew pew pew pew pew pew pew");
        }
        System.out.println(timer.get());
    }
}