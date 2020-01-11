
package org.usfirst.frc.team7224.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team7224.robot.Robot;
import org.usfirst.frc.team7224.robot.RobotConstants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;




/**
 *
 */
public class ArmClosedLoop extends Command {


    public ArmClosedLoop() {
    	 requires(Robot.arm);

   }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
  		  	 Robot.arm.armSetup();
     }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
     	    // Manual adjustment
    	    double height = Robot.chassis.deadZone(Robot.oi.joystick1.getRawAxis(4)); // height
     	    RobotConstants.targetPositionRotations_a =  RobotConstants.targetPositionRotations_a +
     	    		(height * RobotConstants.kArmManualSensitivity_a); 
             
      if (Robot.oi.joystick1.getRawButton(RobotConstants.kpreButton)) {
                        /// Preset
        RobotConstants.targetPositionRotations_a = RobotConstants.kArmpreHt_a;
                          // Redefine top
                    }
     	    
     	   if (Robot.oi.joystick1.getRawButton(RobotConstants.kArmOverideButton)) {
     		   /// This is bad only use in an emergancy 
     		     SmartDashboard.putNumber("Override", RobotConstants.targetPositionRotations_a);
     		    if (RobotConstants.targetPositionRotations_a <= RobotConstants.kArmMinHt_a) 
     		    	 RobotConstants.kArmMinHt_a =RobotConstants.targetPositionRotations_a;  // Redefine bottom
          	    if (RobotConstants.targetPositionRotations_a >= RobotConstants.kArmMaxHt_a )
          	    	RobotConstants.kArmMaxHt_a = RobotConstants.targetPositionRotations_a;  // Redefine top
     	   }  else {
     		   // Button not pressed - Normal mode     	
     	    if (RobotConstants.targetPositionRotations_a <= RobotConstants.kArmMinHt_a) 
     	       RobotConstants.targetPositionRotations_a = RobotConstants.kArmMinHt_a;  // Limit to zero height
     	    if (RobotConstants.targetPositionRotations_a >= RobotConstants.kArmMaxHt_a )
     	       RobotConstants.targetPositionRotations_a = RobotConstants.kArmMaxHt_a;  // Limit to max height
     	   }
     	   
     	   
     	   
     	   /*
     	    // Preset Heights
     	    if (Robot.oi.joystick1.getRawButtonPressed(RobotConstants.karm_FieldHTbutton )) {
     		  RobotConstants.targetPositionRotations_a = RobotConstants.kArm_FieldHT_a;
     	    }else if (Robot.oi.joystick1.getRawButtonPressed(RobotConstants.karm_SwitchHTbutton)) {
     		  RobotConstants.targetPositionRotations_a = RobotConstants.kArm_SwitchHT_a;
     	    }else if (Robot.oi.joystick1.getRawButtonPressed(RobotConstants.karm_ScaleHTbutton)) {
     		  RobotConstants.targetPositionRotations_a = RobotConstants.kArm_ScaleHT_a;
     	    }
     	    */
     	    
    // 	   if (Robot.oi.joystick1.getRawButton(RobotConstants.kArmOverideButton) && 
    // 			  Robot.oi.joystick1.getRawButton(RobotConstants.kzeroResetbutton)) {
     //		   // This is bad... something went wrong ...  emergency reset
     //		  SmartDashboard.putNumber("RESSEEEEEEEE", RobotConstants.targetPositionRotations);
     //		  Robot.arm.armPosReset();
    // 	   }
     	    
     	  
     	    Robot.arm.armControl();
           SmartDashboard.putNumber("Height", height);
           SmartDashboard.putNumber("Target Arm Position", RobotConstants.targetPositionRotations_a);

            
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
