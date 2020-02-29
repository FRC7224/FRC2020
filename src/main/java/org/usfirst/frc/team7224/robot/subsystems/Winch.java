
   package org.usfirst.frc.team7224.robot.subsystems;
   import org.usfirst.frc.team7224.robot.RobotConstants;
   import org.usfirst.frc.team7224.robot.RobotMap;
   
   import com.ctre.phoenix.motorcontrol.ControlMode;
   import com.ctre.phoenix.motorcontrol.FeedbackDevice;
   //import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
   import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
   //import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
   
   import org.usfirst.frc.team7224.robot.commands.*;
   
  /**
*
*/
public class Winch extends Subsystem {


  private final WPI_VictorSPX winchmotor = RobotMap.winchVictorSPX13;
  private final WPI_VictorSPX hookmotor = RobotMap.hookVictorSPX12;


  public void initDefaultCommand() {
      setDefaultCommand(new WinchAction());
  }

  public void setupWinch() {
    winchmotor.set(ControlMode.PercentOutput,0);
  }

  /**
   * sets the winch motor speed  -1 to +1
   */
  public void setWinchSpeed(double wspeed) {
    winchmotor.set(wspeed);
    }

     /**
   * sets the hook motor speed  -1 to +1
   */
  public void setHookSpeed(double hspeed) {
    hookmotor.set(hspeed);
    }
}
  
