package plane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.Date;

import javax.sound.midi.VoiceStatus;



import util.GameUtil;
import util.MyFrame;

public class PlaneGameFrame extends MyFrame{
	plane p = new plane("plane.jpg",50,50);
	ArrayList bulletList = new ArrayList();	// 泛型暂时未学，暂不加
	
	
	Explode baozha;	
	
	Date startTime;
	Date endTime;
	
	public void paint(Graphics g ) {
		p.draw(g);
		
		for(int i=0;i<bulletList.size();i++) {
			bullet b = (bullet)bulletList.get(i);
			b.draw(g);
		
		//检测跟飞机的碰撞
		boolean peng =	b.getRect().intersects(p.getRect());
		if(peng ) {
			p.setLive(false);	//飞机死掉
			endTime = new Date();
			break;
			}
		}
	if(!p.isLive()) {
		
		int period = (int)(endTime.getTime()-startTime.getTime())/1000;
		printInfo(g, "生存时间:"+period+"秒", 20, 120, 260);
	
		switch(period/10) {
		case 0 :
		case 1 :	
			printInfo(g, "菜鸟", 50, 100, 200);
			break;
		case 2 :
			printInfo(g, "小鸟", 50, 100, 200);
			break;
		case 3 :
			printInfo(g, "大鸟", 50, 100, 200);
			break;
		case 4 :
			printInfo(g, "鸟王子", 50, 100, 200);
			break;
		default:
			printInfo(g, "鸟人", 50, 100, 200);
			break;
		}
	
	
	}

	
	
	//printInfo(g, "分数：100", 10, 50, 50);
	
	}
	
	
	/**
	 * 在窗口上打印信息
	 * @param g
	 * @param str
	 * @param size
	 */
	public void printInfo(Graphics g, String str, int size, int x, int y) {
		Font f = new Font("宋体",Font.BOLD,size);
		g.setFont(f);
		g.drawString(str, x,y);
	}
	
	
	public static void main(String[] agrs) {
		new PlaneGameFrame().launchFrame();
	}
	
	
	public void launchFrame() {
		super.launchFrame();
		//增加键盘的监听
		addKeyListener(new KeyMonitor());
		
		//生成一堆子弹
		for(int i=0;i<30;i++) {
			bullet b = new bullet();
			bulletList.add(b);
		}
		
	startTime = new Date();
	
	}
	
	//定义为内部类，可以方便的使用外部类的普通属性
	class KeyMonitor extends KeyAdapter{

		

		@Override
		public void keyPressed(KeyEvent e) {
		p.addDirection(e);
			}
		@Override
		public void keyReleased(KeyEvent e) {
		p.minusDirection(e);	
			
		}
		
	
	}
	
		
	
		
	}
	
	

