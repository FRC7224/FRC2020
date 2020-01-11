package org.usfirst.frc.team7224.robot.commands;

import org.usfirst.frc.team7224.robot.RobotConstants;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousGrpLeftAutoSelect extends CommandGroup{
	
	public AutonomousGrpLeftAutoSelect(){
		  // Drive to Scale or Switch  
         addSequential(new AutonomousCmdClaw(false)); // Close claw
  //       addSequential(new AutonomousCmdWait(0.5)); // wait 
	     addSequential(new AutonomousCmdTrajectoryFollowerTwoFixFile(1)); // 1 = Left
	     addSequential(new AutonomousCmdWait(0.1)); // wait 
	     addSequential(new AutonomousCmdClaw(true)); // Open claw
	     addSequential(new AutonomousCmdWait(0.1)); // wait
	     addSequential(new AutonomousCmdSimpleDrive(-0.3,1.5)); // Backup
	     addSequential(new AutonomousCmdWait(0.1)); // wait
	     addSequential(new AutonomousCmdArmHeight(RobotConstants.kArm_Zero_HT_a)); // Lower Arm
	     addSequential(new AutonomousCmdClaw(false)); // Close claw
	     addSequential(new AutonomousCmdArmReset(1.5)); // wait 
	     }
}