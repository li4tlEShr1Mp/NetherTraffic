package base;

import java.awt.Color;

import base.unit.Direction;
import base.unit.Point;

//地标
public class Warp {

	private Direction Trunk;	//主干方向
	private Direction Branch;	//支路方向
	private final String NAME;		//地标名字
	private final Point POSITION;		//地标坐标
	private final Color BRUNCH_COLOR;		//支路颜色

	public Warp(String name, Point position, Color brunchColor) {
		NAME =name;
		POSITION =position;
		BRUNCH_COLOR =brunchColor;
	}
	public Warp(String name, Point position) {
		NAME =name;
		POSITION =position;
		BRUNCH_COLOR =Color.GRAY;
	}
	
	public Direction getTrunk() {
		return Trunk;
	}
	public Direction getBranch() {
		return Branch;
	}
	public String getNAME() {
		return NAME;
	}
	public Point getPos() {
		return POSITION;
	}
	public Color getBrunchColor() {
		return BRUNCH_COLOR;
	}
	public Color getTrunkColor() {
		return MapColor.dtC(Trunk);
	}
	public void setTrunkDirection(Direction direction){
		this.Trunk=direction;
	}
	public void setBranchDirection(Direction direction){
		this.Branch=direction;
	}
}
