package Manager3D;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import Tools.Observer;
import Tools.Subject;


public class Camera implements Observer{
	private double xPos=4, yPos, xDir, yDir, xPlane, yPlane;
	private boolean left=false, right=false, forward=true, back;
	private  double MOVE_SPEED = 0;
	private  double ROTATION_SPEED = .02;
	private String name;
	private Subject topic;
	public Camera(double x, double y, double xd, double yd, double xp, double yp) {
		xPos = x;
		yPos = y;
		xDir = xd;
		yDir = yd;
		xPlane = xp;
		yPlane = yp;
	}
	public double getxPos() {
		return xPos;
	}
	public void setxPos(double xPos) {
		this.xPos = xPos;
	}
	public double getyPos() {
		return yPos;
	}
	public void setyPos(double yPos) {
		this.yPos = yPos;
	}
	public double getxDir() {
		return xDir;
	}
	public void setxDir(double xDir) {
		this.xDir = xDir;
	}
	public double getyDir() {
		return yDir;
	}
	public void setyDir(double yDir) {
		this.yDir = yDir;
	}
	public double getxPlane() {
		return xPlane;
	}
	public void setxPlane(double xPlane) {
		this.xPlane = xPlane;
	}
	public double getyPlane() {
		return yPlane;
	}
	public void setyPlane(double yPlane) {
		this.yPlane = yPlane;
	}
	public boolean isLeft() {
		return left;
	}
	public void setLeft(boolean left) {
		this.left = left;
	}
	public boolean isRight() {
		return right;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	public boolean isForward() {
		return forward;
	}
	public void setForward(boolean forward) {
		this.forward = forward;
	}
	public boolean isBack() {
		return back;
	}
	public void setBack(boolean back) {
		this.back = back;
	}
	public double getMOVE_SPEED() {
		return MOVE_SPEED;
	}
	public double getROTATION_SPEED() {
		return ROTATION_SPEED;
	}

	public void update(int[][] map) {
		if(forward) {
			if(map[(int)(xPos + xDir * MOVE_SPEED)][(int)yPos] == 0) {
				xPos+=xDir*MOVE_SPEED;
			}
			if(map[(int)xPos][(int)(yPos + yDir * MOVE_SPEED)] ==0)
				yPos+=yDir*MOVE_SPEED;
		}
		if(back) {
			if(map[(int)(xPos - xDir * MOVE_SPEED)][(int)yPos] == 0)
				xPos-=xDir*MOVE_SPEED;
			if(map[(int)xPos][(int)(yPos - yDir * MOVE_SPEED)]==0)
				yPos-=yDir*MOVE_SPEED;
		}
		if(right) {
			double oldxDir=xDir;
			xDir=xDir*Math.cos(-ROTATION_SPEED) - yDir*Math.sin(-ROTATION_SPEED);
			yDir=oldxDir*Math.sin(-ROTATION_SPEED) + yDir*Math.cos(-ROTATION_SPEED);
			double oldxPlane = xPlane;
			xPlane=xPlane*Math.cos(-ROTATION_SPEED) - yPlane*Math.sin(-ROTATION_SPEED);
			yPlane=oldxPlane*Math.sin(-ROTATION_SPEED) + yPlane*Math.cos(-ROTATION_SPEED);
		}
		if(left) {
			double oldxDir=xDir;
			xDir=xDir*Math.cos(ROTATION_SPEED) - yDir*Math.sin(ROTATION_SPEED);
			yDir=oldxDir*Math.sin(ROTATION_SPEED) + yDir*Math.cos(ROTATION_SPEED);
			double oldxPlane = xPlane;
			xPlane=xPlane*Math.cos(ROTATION_SPEED) - yPlane*Math.sin(ROTATION_SPEED);
			yPlane=oldxPlane*Math.sin(ROTATION_SPEED) + yPlane*Math.cos(ROTATION_SPEED);
		}

	}
	@Override
	public void update(Object info) {
		Car.CarSystem CarSystem  = (Car.CarSystem) info;
		ArrayList infoarray= CarSystem.returnActualValues();
		MOVE_SPEED=((int) infoarray.get(3)*0.009);
		left=(boolean) infoarray.get(5);
		right=(boolean) infoarray.get(6);

	}
	@Override
	public void setSubject(Subject sub) {
		this.topic=sub;
	}

}