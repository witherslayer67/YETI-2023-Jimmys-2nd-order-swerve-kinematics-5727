package frc.robot.di;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.*;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.Constants;
import frc.robot.commands.drive.AutoBalancingCommand;
import frc.robot.commands.drive.FieldOrientedDrive;
import frc.robot.commands.drive.SwerveLockCommand;
import frc.robot.subsystems.drivetrain.DrivetrainSubsystem;
import javax.inject.Named;
import java.util.function.DoubleSupplier;

@Module
public class CommandsModule {
    @Provides
    @IntoMap
    @ClassKey(IntakeClampCommand.class)
    static CommandBase provideIntakeClampCommand(IntakeSubsystem intakeSubsystem){
        return new IntakeClampCommand(intakeSubsystem);
    }
    
    @Provides
    @IntoMap
    @ClassKey(IntakeUnclampCommand.class)
    static CommandBase provideIntakeUnClampCommand(IntakeSubsystem intakeSubsystem){
        return new IntakeUnclampCommand(intakeSubsystem);
    }
    
    @Provides
    @IntoMap
    @ClassKey(IntakeRollInCommand.class)
    static CommandBase provideIntakeRollInCommand(IntakeSubsystem intakeSubsystem){
        return new IntakeRollInCommand(intakeSubsystem);
    }
    
    @Provides
    @IntoMap
    @ClassKey(IntakeRollOutCommand.class)
    static CommandBase provideIntakeRollOutCommand(IntakeSubsystem intakeSubsystem){
        return new IntakeRollOutCommand(intakeSubsystem);
    }

    @Provides
    @IntoMap
    @ClassKey(IntakeShootCommand.class)
    static CommandBase provideIntakeShootCommand(IntakeSubsystem intakeSubsystem) {
        return new IntakeShootCommand(intakeSubsystem);
    }

    @Provides
    @IntoMap
    @ClassKey(FieldOrientedDrive.class)
    static CommandBase provideFieldOrientedDrive(
            DrivetrainSubsystem drivetrainSubsystem,
            @Named("translationXSupplier") DoubleSupplier translationXSupplier,
            @Named("translationYSupplier") DoubleSupplier translationYSupplier,
            @Named("thetaSupplier") DoubleSupplier rotationSupplier) {
        return new FieldOrientedDrive(drivetrainSubsystem, translationXSupplier, translationYSupplier, rotationSupplier);
    }

    @Provides
    @IntoMap
    @ClassKey(SwerveLockCommand.class)
    static CommandBase provideSwerveLockCommand(DrivetrainSubsystem drivetrainSubsystem) {
        return new SwerveLockCommand(drivetrainSubsystem);
    }
    @Provides
    @IntoMap
    @ClassKey(AutoBalancingCommand.class)
    static CommandBase providesAutoBalancingCommand(
            DrivetrainSubsystem drivetrainSubsystem) {
        PIDController pidController = new PIDController(Constants.AutoConstants.PITCH_P, Constants.AutoConstants.PITCH_I, Constants.AutoConstants.PITCH_D, Constants.AutoConstants.PITCH_F);
        pidController.setTolerance(1);
        pidController.setSetpoint(Constants.AutoConstants.PITCH_SET_POINT);
        return new AutoBalancingCommand(drivetrainSubsystem, pidController);
    }

}