package org.usfirst.frc.team7224.robot.commands;

import org.usfirst.frc.team7224.robot.RobotConstants;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomousGrpRightAutoSelect extends CommandGroup{
	
	public AutonomousGrpRightAutoSelect(){
		  // Drive to Scale or Switch
         addSequential(new AutonomousCmdClaw(false)); // Close claw
     //    addSequential(new AutonomousCmdWait(0.5)); // wait 
         addSequential(new AutonomousCmdTrajectoryFollowerTwoFixFile(3)); // 3 = Right
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

