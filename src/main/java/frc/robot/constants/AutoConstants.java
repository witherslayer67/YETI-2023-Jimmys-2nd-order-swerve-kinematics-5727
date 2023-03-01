package frc.robot.constants;

import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.auto.PIDConstants;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;

public final class AutoConstants {
    /**
     * Max velocity in meters per second
     */
    public static final double MAX_VELOCITY = DriveConstants.MAX_VELOCITY_METERS_PER_SECOND * 0.75;
    /**
     * Max acceleration in meters per second squared
     */
    public static final double MAX_ACCEL = DriveConstants.MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND * 0.75;
    public static final PathConstraints DEFAULT_CONSTRAINTS = new PathConstraints(MAX_VELOCITY, MAX_ACCEL);

    public static final double X_CONTROLLER_P = 6.0; //2.9, 2.15
    public static final double Y_CONTROLLER_P = 2.1; //2.9, 2.15
    public static final double X_CONTROLLER_D = 0.5;
    public static final double Y_CONTROLLER_D = 0;
    public static final double THETA_CONTROLLER_P = 3.7; //3

    public static final PIDConstants TRANSLATION_CONTROLLER = new PIDConstants(X_CONTROLLER_P, 0, X_CONTROLLER_D);
    public static final PIDConstants THETA_CONTROLLER = new PIDConstants(THETA_CONTROLLER_P, 0, 0);
    public static final TrapezoidProfile.Constraints THETA_CONTROLLER_CONTRAINTS = //
            new TrapezoidProfile.Constraints(
                    DriveConstants.MAX_VELOCITY_METERS_PER_SECOND,
                    DriveConstants.MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND);

    public static final double PITCH_SET_POINT = 0.0;
    public static final double PITCH_P = 0.03;
    public static final double PITCH_I = 0.0;
    public static final double PITCH_D = 0.005;
    public static final double PITCH_F = 0.0;
    public static final double PITCH_TOLERANCE = 1.0;

    public static final double ALIGN_OFFSET = 2.0; //placeholder
    public static final double CONE_OFFSET = 2.0; //placeholder
    public static final double CENTER_OFFSET = Units.inchesToMeters(DriveConstants.FRAME_PERIMETER / 2.0 + 4.0); // 0.4445

    public enum AutoModes {
        TESTING("testing", DEFAULT_CONSTRAINTS),
        MIDDLE_BALANCE("middleBalance", DEFAULT_CONSTRAINTS),
        MIDDLE_SHOOT_BALANCE("middleShootBalance", DEFAULT_CONSTRAINTS),
        MIDDLE_CONE_BALANCE("middleConeBalance", DEFAULT_CONSTRAINTS),
        TWO_PIECE_BALANCE("twoPieceBalance", new PathConstraints(0.75, 0.4), DEFAULT_CONSTRAINTS);

        public final String name;
        public final PathConstraints initConstraint;
        public final PathConstraints[] pathConstraints;
        AutoModes(String name, PathConstraints initConstraint, PathConstraints... pathConstraints) {
            this.name = name;
            this.initConstraint = initConstraint;
            this.pathConstraints = pathConstraints;
        }
    }

    public enum ALIGNMENT_POSITION {
        LEFT_DOUBLE_STATION(CENTER_OFFSET, 1.5, 0.0, 0.0),
        RIGHT_DOUBLE_STATION(CENTER_OFFSET, -1.5, 0.0, 0.0),
        LEFT(CENTER_OFFSET, -1.0, 180.0, 180.0),
        MIDDLE(CENTER_OFFSET, 0.0, 180.0, 0.0),
        RIGHT(CENTER_OFFSET, 1.0, 180.0, 180.);

        public final Pose2d offset;
        public final Rotation2d heading;
        ALIGNMENT_POSITION(double x, double y, double heading, double rotation) {
            this.offset = new Pose2d(x, y, Rotation2d.fromDegrees(rotation));
            this.heading = Rotation2d.fromDegrees(heading);
        }
    }
}
