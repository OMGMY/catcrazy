package com.example.cat;

import android.R.integer;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

/**
 * @author Cloud E-mail:
 * @version 创建时间：2016-3-13 下午5:07:49
 * 类说明
 */
public class backImage extends SurfaceView implements OnTouchListener {
	private point matrix[][];
	private static final int ROWNUMBER=10;
	private static final int COLNUMBER=10;
    public  static  final int OBSERVE=10;
    public static int length=30;

	public backImage(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
		matrix=new point[ROWNUMBER][COLNUMBER];
		for(int i=0;i<ROWNUMBER;i++){
			for(int j=0;j<COLNUMBER;j++)
			{
				matrix[i][j]=new point(j, i);
			}
		}
		init();
		setOnTouchListener(this);
		getHolder().addCallback(callback);
		
	}
	private void init() {
		for(int i=0;i<ROWNUMBER;i++){
			for(int j=0;j<COLNUMBER;j++)
			{
				matrix[i][j].setPointStatus(point.POINTUNCHECKED);
			}
		}
		matrix[4][5].setPointStatus(point.CATSTAND);
		System.out.println(matrix[4][5].getPointStatus()+"System.out.println(matrix[y][x].getPointStatus());");
		for (int i = 0; i < OBSERVE;) {
			int x=(int) (((Math.random()*1000)%COLNUMBER));
			int y=(int) ((((Math.random()*1000)*1000)%ROWNUMBER));	
			if(matrix[y][x].getPointStatus()==point.POINTUNCHECKED)
			{
				matrix[y][x].setPointStatus(point.POINTCHECKED);
				i++;
				
			}
		}
		
		
	}
	public void  drawImage() {
		Canvas c=getHolder().lockCanvas();
		c.drawColor(Color.LTGRAY);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
		Paint paint=new Paint();
		paint.setFlags(Paint.ANTI_ALIAS_FLAG);
		for(int i=0;i<ROWNUMBER;i++){
			int distance=0;
			if(i%2!=0)
			{
				distance=length/4*3;
			}
			for(int j=0;j<COLNUMBER;j++)
			{
				point mPoint=matrix[i][j];
				switch (mPoint.pointStatus) {
				case point.POINTCHECKED:
					paint.setColor(0xFFFFAA00);
					break;
				case point.POINTUNCHECKED:
					paint.setColor(0xFFEEEEEE);
					break;
				case point.CATSTAND:
				paint.setColor(0xFFFF0000);
					break;
				default:
					break;
				}
				c.drawOval(new RectF(mPoint.getX()*length+distance, mPoint.getY()*length, (mPoint.getX()+1)*length+distance, (mPoint.getY()+1)*length), paint);
			}
		}
		getHolder().unlockCanvasAndPost(c);
	}
	Callback callback=new Callback() {
		
		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			drawImage();
		}
		
		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {
			// TODO Auto-generated method stub
			length=width/(COLNUMBER+1);
			drawImage();
		}
	};

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		if(event.getAction()==MotionEvent.ACTION_UP)
		{
			Toast.makeText(getContext(), event.getX()+":"+event.getY(), Toast.LENGTH_SHORT).show();
			int x,y;
			
			y=(int) (event.getY()/length);
			if(y%2==0)//说明奇数行
			{
				x=(int) (event.getX()/length);
			}else {
				
					x=(int)( (event.getX()-(length/4*3))/length);	
			}
			if(x+1>COLNUMBER||y+1>ROWNUMBER)
			{
				System.out.println(length+"");
				System.out.println(event.getX()+"");
				System.out.println("x  y"+x+y);
				init();
			}
			else if(matrix[y][x].getPointStatus()==point.POINTUNCHECKED)
			{
				matrix[y][x].setPointStatus(point.POINTCHECKED);	
			}
			drawImage();
		}
		return true;
	}
}
