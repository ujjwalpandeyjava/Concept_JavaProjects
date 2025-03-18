package pandey.ujjwal.javaConcepts.guiEg.multiThreading.multithreadingThreadClass;

import java.awt.Color;
import java.util.Random;
import javax.swing.*;

public class Race extends Thread {
	public Race() {
		buildGUI();
	}

	public Race(String s) {
		super(s);
	}

	public void run() {
		runObstacleA();
		/*
		 * if(Thread.currentThread().getName().equals("ObstacleA")) { runObstacleA(); }
		 * if(Thread.currentThread().getName().equals("ObstacleB")) { runObstacleB(); }
		 * if(Thread.currentThread().getName().equals("ObstacleC")) { runObstacleC(); }
		 */
	}

	public void runObstacleA() {
		Random ran1 = new Random();
		int r1 = ran1.nextInt(200);
		int r11 = ran1.nextInt(200);
		for (int i = 0; i < 20; i++) {
			l1.setBounds((r11 + i), r1, 20, 20);
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		runObstacleC();
	}

	public void runObstacleB() {
		Random ran2 = new Random();
		int r2 = ran2.nextInt(200);
		int r22 = ran2.nextInt(200);
		for (int i = 0; i < 20; i++) {
			l2.setBounds((r22 + i), r2, 20, 20);
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		runObstacleA();
	}

	public void runObstacleC() {
		Random ran3 = new Random();
		int r3 = ran3.nextInt(200);
		int r33 = ran3.nextInt(200);
		for (int i = 0; i < 20; i++) {
			l3.setBounds((r33 + i), r3, 20, 20);
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		runObstacleB();
	}

	JFrame fr;
	JLabel l;
	JPanel l1, l2, l3;

	public void buildGUI() {
		fr = new JFrame("By Thread class...");
		fr.setVisible(true);
		fr.setSize(300, 300);
		fr.setLayout(null);

		l = new JLabel("");
		l.setBounds(10, 10, 400, 20);
		l1 = new JPanel();
		l1.setSize(20, 20);
		l1.setBackground(Color.red);
		l1.setBounds(10, 40, 20, 20);
		l2 = new JPanel();
		l2.setSize(20, 20);
		l2.setBackground(Color.blue);
		l2.setBounds(10, 80, 20, 20);
		l3 = new JPanel();
		l3.setSize(20, 20);
		l3.setBackground(Color.black);
		l3.setBounds(10, 100, 20, 20);

		fr.add(l);
		fr.add(l1);
		fr.add(l2);
		fr.add(l3);
	}

	public static void main(String args[]) {
		Race obj1 = new Race();
//		Race obj2=new Race();
//		Race obj3=new Race();
//		Thread Obstacle1 = new Thread(obj);
//		Thread Obstacle2 = new Thread(obj);
//		Thread Obstacle3 = new Thread(obj);
//			Obstacle1.setName("ObstacleA");
//			Obstacle2.setName("ObstacleB");
//			Obstacle3.setName("ObstacleC");
		obj1.start();
//		obj2.start();
//		obj3.start();
	}
}