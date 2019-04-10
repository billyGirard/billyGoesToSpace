package billy.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import billy.robot.OI;
import billy.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class Drive extends Command {

  public static OI m_oi;
  public static XboxController m_Xbox;

  public Drive() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    m_oi = new OI();
    m_Xbox = m_oi.mainXbox;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.drivetrain.arcadeDrive(m_Xbox.getX(), m_Xbox.getY());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
