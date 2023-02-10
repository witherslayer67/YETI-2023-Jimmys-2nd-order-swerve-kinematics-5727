package frc.robot.di;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxLimitSwitch;
import dagger.Module;
import dagger.Provides;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.subsystems.CarriageSubsystem;
import frc.robot.subsystems.VisionSubsystem;

import javax.inject.Named;
import javax.inject.Singleton;

@Module
public class SubsystemsModule {
    @Provides
    @Singleton
    public CarriageSubsystem provideCarriageSubsystem(
            @Named("rollerMotor") CANSparkMax rollerMotor,
            @Named("flipMotor") CANSparkMax flipMotor,
            @Named("beamBreak") SparkMaxLimitSwitch beamBreak
    ) {
        return new CarriageSubsystem(rollerMotor, flipMotor, beamBreak);
    }

    @Provides
    @Singleton
    public VisionSubsystem providesVisionSubsystem(@Named("table") NetworkTableInstance table) {
        return new VisionSubsystem(NetworkTableInstance.getDefault());
    }
}