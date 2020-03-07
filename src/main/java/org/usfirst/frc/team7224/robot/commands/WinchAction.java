

package org.usfirst.frc.team7224.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team7224.robot.Robot;
import org.usfirst.frc.team7224.robot.RobotConstants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class WinchAction extends Command {



    public WinchAction() {
        requires(Robot.winch);

  }

   // Called just before this Command runs the first time
   @Override
   protected void initialize() {
         
        Robot.winch.winchSetup();
    }

   // Called repeatedly when this Command is scheduled to run
   @Override
   protected void execute() {
           

 // Manual adjustment
 if (Robot.oi.joystick1.getRawButton(RobotConstants.kpreButton)) {
 RobotConstants.targetPositionRotations_w =  RobotConstants.targetPositionRotations_w +
 RobotConstants.kwinchManualSensitivity_w; 
 Robot.winch.winchControl1();
 Robot.winch.winchControl2();
 SmartDashboard.putNumber("Target Winch Position", RobotConstants.targetPositionRotations_w);
 }

              // Move hook 
                    
  double hookspeed = Robot.chassis.deadZone(Robot.oi.joystick1.getZ());
    Robot.winch.setHookSpeed(hookspeed);  
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




