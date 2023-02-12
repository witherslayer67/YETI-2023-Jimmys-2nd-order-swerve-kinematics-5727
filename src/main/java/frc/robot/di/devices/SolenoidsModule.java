package frc.robot.di.devices;

import dagger.Module;
import dagger.Provides;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.Constants;

import javax.inject.Named;
import javax.inject.Singleton;
@Module
public class SolenoidsModule {
    @Provides
    @Singleton
    @Named("elevator piston")
    public DoubleSolenoid providesDoubleSolenoid() {

        return new DoubleSolenoid(
                PneumaticsModuleType.CTREPCM,
                Constants.ElevatorConstants.ELEVATOR_PISTON[0],
                Constants.ElevatorConstants.ELEVATOR_PISTON[1]);
    }
}