package frc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class TestCommand extends CommandBase {
    public TestCommand() {
        System.out.println("Made Test Command");
    }

    @Override
    public void execute() {
        System.out.println("Hola the button works");
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("IT'S ALL ENDING!!");
    }
}