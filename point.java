package com.example.cat;

import android.R.integer;

/**
 * @author Cloud E-mail:
 * @version 创建时间：2016-3-13 下午5:37:45
 * 类说明
 */
public class point {
    int x,y;
    int pointStatus;
    public static final int POINTCHECKED=1;
    public static final int POINTUNCHECKED=0;
    public static final int CATSTAND=2;
	public point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getPointStatus() {
		return pointStatus;
	}
	public void setPointStatus(int pointStatus) {
		this.pointStatus = pointStatus;
	}
    
}
