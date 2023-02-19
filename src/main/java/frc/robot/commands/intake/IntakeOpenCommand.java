package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.utils.CommandFactory;

import javax.inject.Inject;

public class IntakeOpenCommand extends CommandFactory {

    public static class IntakeUnclampImpl extends InstantCommand {
        private final IntakeSubsystem intakeSubsystem;

        public IntakeUnclampImpl(IntakeSubsystem intakeSubsystem) {
            super(() -> {
                intakeSubsystem.intakeOpen();
                intakeSubsystem.setBrakeMode();
            });
            this.intakeSubsystem = intakeSubsystem;
            addRequirements(intakeSubsystem);
        }
    }

    private IntakeSubsystem intakeSubsystem;

    @Inject
    public IntakeOpenCommand(IntakeSubsystem intakeSubsystem){
        this.intakeSubsystem = intakeSubsystem;
    }

    public CommandBase create() {
        return new IntakeUnclampImpl(intakeSubsystem);
    }
}
