package org.usfirst.frc.team7224.robot.commands;
import org.usfirst.frc.team7224.robot.Robot;
import org.usfirst.frc.team7224.robot.RobotConstants;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomousCmdArmHeight extends Command {

	boolean State;
	double position = 0;

	public AutonomousCmdArmHeight(double height) {
		requires(Robot.arm);
	 position = height;
	}

	@Override
	protected void initialize() {
		RobotConstants.targetPositionRotations_a = position;
	    SmartDashboard.putNumber("Target Arm Position", RobotConstants.targetPositionRotations_a);
		Robot.arm.armControl();
		SmartDashboard.putNumber("Arm Should be down", RobotConstants.targetPositionRotations_a);
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
		end();
	}

}
