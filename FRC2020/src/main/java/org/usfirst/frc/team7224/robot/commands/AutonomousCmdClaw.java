package org.usfirst.frc.team7224.robot.commands;
import org.usfirst.frc.team7224.robot.Robot;


import edu.wpi.first.wpilibj.command.Command;

public class AutonomousCmdClaw extends Command {

	boolean State;

	public AutonomousCmdClaw(boolean state) {
		requires(Robot.claw);
		State = state;
	}

	@Override
	protected void initialize() {
		if (State) {
		//	Robot.claw.openClaw(); 
		} else {
		//	Robot.claw.closeClaw();
		}
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
