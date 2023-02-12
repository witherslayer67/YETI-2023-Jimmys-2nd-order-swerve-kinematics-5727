package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.ElevatorSubsystem;

import javax.inject.Inject;


public class SetElevatorDeployLevelCommand extends CommandBase {

    private final ElevatorSubsystem elevatorSubsystem;

    int elevatorLevel;

    @Inject
    public SetElevatorDeployLevelCommand(ElevatorSubsystem elevatorSubsystem, int elevatorLevel) {
        this.elevatorSubsystem = elevatorSubsystem;
        this.elevatorLevel = elevatorLevel;
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() { elevatorSubsystem.setLevel(elevatorLevel); }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return true;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
