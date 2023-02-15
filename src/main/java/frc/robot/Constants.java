// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;

import java.util.Map;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class DriveConstants {

        public static final int FRONT_LEFT_DRIVE = 2;
        public static final int FRONT_LEFT_AZIMUTH = 1;
        public static final int FRONT_LEFT_ENCODER = 1;
        public static final boolean FRONT_LEFT_DRIVE_REVERSED = true;
        public static final double FRONT_LEFT_ENCODER_OFFSET = -18.809;
        public static final boolean FRONT_LEFT_ENCODER_REVERSED = false;

        public static final int FRONT_RIGHT_DRIVE = 4;
        public static final int FRONT_RIGHT_AZIMUTH = 3;
        public static final int FRONT_RIGHT_ENCODER = 2;
        public static final boolean FRONT_RIGHT_DRIVE_REVERSED = false;
        public static final double FRONT_RIGHT_ENCODER_OFFSET = 153.545;
        public static final boolean FRONT_RIGHT_ENCODER_REVERSED = false;

        public static final int BACK_LEFT_DRIVE = 8;
        public static final int BACK_LEFT_AZIMUTH = 7;
        public static final int BACK_LEFT_ENCODER = 4;
        public static final boolean BACK_LEFT_DRIVE_REVERSED = true;
        public static final double BACK_LEFT_ENCODER_OFFSET = 21.973;
        public static final boolean BACK_LEFT_ENCODER_REVERSED = false;

        public static final int BACK_RIGHT_DRIVE = 6;
        public static final int BACK_RIGHT_AZIMUTH = 5;
        public static final int BACK_RIGHT_ENCODER = 3;
        public static final boolean BACK_RIGHT_DRIVE_REVERSED = false;
        public static final double BACK_RIGHT_ENCODER_OFFSET = -23.730;
        public static final boolean BACK_RIGHT_ENCODER_REVERSED = false;

        public static final int GYRO = 1; //placeholder value
        public static final double DRIVE_MOTOR_P = 1.0; //placeholder from borealis
        public static final double DRIVE_MOTOR_I = 0.0; //placeholder from borealis
        public static final double DRIVE_MOTOR_D = 0.0; //placeholder from borealis
        public static final double DRIVE_MOTOR_KS = 0.643; //placeholder from borealis
        public static final double DRIVE_MOTOR_KV = 2.178; //placeholder from borealis
        public static final double DRIVE_MOTOR_KA = 0.406; //placeholder from borealis

        public static final double AZIMUTH_MOTOR_P = 8.0; //placeholder from borealis 3
        public static final double AZIMUTH_MOTOR_I = 0.0; //placeholder from borealis
        public static final double AZIMUTH_MOTOR_D = 0.00; //placeholder from borealis 0.01
        public static final double AZIMUTH_MOTOR_KS = 0.75; //placeholder from borealis 0.75
        public static final double AZIMUTH_MOTOR_KV = 0.7; //placeholder from borealis 0.7
        public static final double AZIMUTH_MOTOR_KA = 0.0; //placeholder from borealis
        public static final double DEGREES_TO_FALCON = 20.64 * 2048 / 360.0;
        public static final double SWERVE_X_REDUCTION = 1.0 / 6.75;
        public static final double WHEEL_DIAMETER = Units.inchesToMeters(4); //0.1016
        public static final double MAX_VELOCITY_METERS_PER_SECOND = 6380.0 / 60.0 * SWERVE_X_REDUCTION * WHEEL_DIAMETER * Math.PI; //placeholder
        private static final double DRIVETRAIN_WHEELBASE_METERS = Units.inchesToMeters(21.75); //PLACEHOLDER
        private static final double DRIVETRAIN_TRACKWIDTH_METERS = Units.inchesToMeters(21.75); //PLACEHOLDER
        public static final double MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND = MAX_VELOCITY_METERS_PER_SECOND / Math.hypot(DriveConstants.DRIVETRAIN_TRACKWIDTH_METERS / 2, DriveConstants.DRIVETRAIN_WHEELBASE_METERS / 2); //PLACEHOLDER

        public static final SwerveDriveKinematics DRIVE_KINEMATICS =
                new SwerveDriveKinematics(
                        // Front left
                        new Translation2d(DriveConstants.DRIVETRAIN_WHEELBASE_METERS / 2.0,
                                DriveConstants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0),
                        // Front right
                        new Translation2d(DriveConstants.DRIVETRAIN_WHEELBASE_METERS / 2.0,
                                -DriveConstants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0),
                        // Back left
                        new Translation2d(-DriveConstants.DRIVETRAIN_WHEELBASE_METERS / 2.0,
                                DriveConstants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0),
                        // Back right
                        new Translation2d(-DriveConstants.DRIVETRAIN_WHEELBASE_METERS / 2.0,
                                -DriveConstants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0)
                );

    }

    public static final class AutoConstants {

        /**
         * Max velocity in meters per second
         */
        public static final double MAX_VELOCITY = DriveConstants.MAX_VELOCITY_METERS_PER_SECOND * 0.75;
        /**
         * Max acceleration in meters per second squared
         */
        public static final double MAX_ACCEL = DriveConstants.MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND * 0.75;

        public static final double X_CONTROLLER_P = 2.1; //2.9, 2.15
        public static final double Y_CONTROLLER_P = 2.1; //2.9, 2.15
        public static final double X_CONTROLLER_D = 0;
        public static final double Y_CONTROLLER_D = 0;
        public static final double THETA_CONTROLLER_P = 3; //3
        public static final TrapezoidProfile.Constraints THETA_CONTROLLER_CONTRAINTS = //
                new TrapezoidProfile.Constraints(
                        DriveConstants.MAX_VELOCITY_METERS_PER_SECOND,
                        DriveConstants.MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND);
    }


    public static final class OIConstants {
        /*
            Map of controllers using the port number as the key to the ControllerType
         */
        public static final Map<Integer, ControllerType> CONTROLLERS = Map.of(
                0, ControllerType.CUSTOM
        );
        public static final int CONTROLLER_COUNT = CONTROLLERS.size(); //placeholder value
        public static final double DEADBAND = 0.05;

        public enum ControllerType {
            CUSTOM, XBOX
        }
    }
}
