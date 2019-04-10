package billy.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import billy.robot.RobotMap;
import billy.robot.commands.Drive;


public class Drivetrain extends Subsystem {
  private static CANSparkMax left_back;
  private static CANSparkMax left_center;
  private static CANSparkMax left_front;
  private static SpeedControllerGroup left;

  private static CANSparkMax right_back;
  private static CANSparkMax right_center;
  private static CANSparkMax right_front;
  private static SpeedControllerGroup right;
  
  private static DifferentialDrive m_drive;

  public void init() {
    // Left Motors
    left_back = new CANSparkMax(RobotMap.CANDevice.LEFT_BACK.id, MotorType.kBrushless);
    left_center = new CANSparkMax(RobotMap.CANDevice.LEFT_CENTER.id, MotorType.kBrushless);
    left_front = new CANSparkMax(RobotMap.CANDevice.LEFT_FRONT.id, MotorType.kBrushless);
    left = new SpeedControllerGroup(left_back, left_center, left_front);

    // Right Motors
    right_back = new CANSparkMax(RobotMap.CANDevice.RIGHT_BACK.id, MotorType.kBrushless);
    right_center = new CANSparkMax(RobotMap.CANDevice.RIGHT_CENTER.id, MotorType.kBrushless);
    right_front = new CANSparkMax(RobotMap.CANDevice.RIGHT_FRONT.id, MotorType.kBrushless);
    right = new SpeedControllerGroup(right_back, right_center, right_front);
    
    m_drive = new DifferentialDrive(left, right);
  }

  public void arcadeDrive(double speed, double rot) {
    m_drive.arcadeDrive(speed, rot);
  }
  @Override
  public void initDefaultCommand() {
    // Drive
    setDefaultCommand(new Drive());
  }
}
