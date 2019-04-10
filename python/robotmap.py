# Imports
import wpilib
import rev

# Define constants
brushless = rev.MotorType.kBrushless

class RobotMap():
    motors = {
        "leftFront": rev.CANSparkMax(1, brushless),
        "leftCenter": rev.CANSparkMax(2, brushless),
        "leftBack": rev.CANSparkMax(3, brushless),
        "rightFront": rev.CANSparkMax(4, brushless),
        "rightCenter": rev.CANSparkMax(5, brushless),
        "rightBack": rev.CANSparkMax(6, brushless)
    }

    leftDrive = wpilib.SpeedControllerGroup(motors["leftFront"], motors["leftCenter"], motors["leftBack"])
    rightDrive = wpilib.SpeedControllerGroup(motors["rightFront"], motors["rightCenter"], motors["rightBack"])
