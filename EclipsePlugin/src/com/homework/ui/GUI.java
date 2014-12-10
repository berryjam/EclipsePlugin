package com.homework.ui;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.homework.algorithm.FunctionHandler;
import javax.swing.JTree;
import javax.swing.JList;

public class GUI {

	private FunctionHandler fh = new FunctionHandler();

	public static String functionInfoPath = "/Users/berryjam/Tsinghua/软件体系结构/大作业相关/doxygen+ubigraph+GUI/函数信息.txt";

	private JFrame frame;

	private JTextArea referencedbyTextArea;

	private JTextArea referenceTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		try {
			fh.loadInfo(functionInfoPath);
			this.setReferencedbyTextArea();
			this.setReferenceTextArea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 713, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel referencedbyLabel = new JLabel("被调用次数最多的前10个函数");
		referencedbyLabel.setBounds(42, 6, 179, 16);
		frame.getContentPane().add(referencedbyLabel);

		JLabel referenceLabel = new JLabel("函数内调用其他函数数目最多的前10个函数");
		referenceLabel.setBounds(429, 6, 250, 16);
		frame.getContentPane().add(referenceLabel);

		referencedbyTextArea = new JTextArea();
		referencedbyTextArea.setBounds(23, 30, 267, 345);
		frame.getContentPane().add(referencedbyTextArea);

		referenceTextArea = new JTextArea();
		referenceTextArea.setBounds(426, 30, 267, 345);
		frame.getContentPane().add(referenceTextArea);
		
		JTree tree = new JTree();
		tree.setBounds(295, 65, 79, 76);
		frame.getContentPane().add(tree);
		
		JList list = new JList();
		
		list.setBounds(351, 226, 1, 1);
		frame.getContentPane().add(list);
	}

	public void setReferenceTextArea() {
		String result = fh.getReferenceCountInfo();
		referenceTextArea.setText(result);
	}

	public void setReferencedbyTextArea() {
		String result = fh.getReferencedbyCountInfo();
		referencedbyTextArea.setText(result);
	}
}
