package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import model.Loader;
import view.ImageGame;
import view.StartGame;

public class ControllerStart {

	StartGame view;

	public ControllerStart() {
		super();
		this.view = new StartGame();
		action();

	}

	public void action() {
		for (ImageGame btn : view.getListBtn()) {
			setBtnAction(btn);

		}
	}

	public void setBtnAction(ImageGame btn) {
		switch (btn.getNumBut()) {
		case 1:

			btn.getBtn().addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {

					btn.setBounds(345, 365, 125, 67);
						btn.getBtn().setIcon(new ImageIcon(Loader.loadImage("play11.png")));

					}

					public void mouseExited(MouseEvent e){

						btn.setBounds(350, 370, 110, 58);
						btn.getBtn().setIcon(new ImageIcon(Loader.loadImage("play1.png")));

					}

				public void mouseClicked(MouseEvent e) {
					new ControllerGame().startGame();
					
					view.setVisible(false);

				}
				
			});

			break;
		case 2:
			btn.getBtn().addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {

				btn.setBounds(225, 415, 125, 67);
					btn.getBtn().setIcon(new ImageIcon(Loader.loadImage("guide1.png")));

				}

				public void mouseExited(MouseEvent e){

					btn.setBounds(230, 420, 110, 58);
					btn.getBtn().setIcon(new ImageIcon(Loader.loadImage("guide.png")));

				}

			});

			btn.getBtn().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (btn.getBtn() == e.getSource()) {

							JFrame f2 = new JFrame("Hướng dẫn chơi game");

							JLabel lb = new JLabel();
							lb.setIcon(new ImageIcon(Loader.loadImage("guide2.png")));
							f2.add(lb);
							f2.pack();
							f2.setVisible(true);
							f2.setLocationRelativeTo(null);
					}	
				}
			});

			break;
		case 3:
			btn.getBtn().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					JFrame f1 = new JFrame("About");
					f1.setLayout(null);

					JLabel label1 = new JLabel();

					label1.setText("<html>"
							+ "<span style='font-size:30.0pt;font:italic;color:blue'> HCM Nong Lam University </html>");
					label1.setForeground(Color.BLUE);
					label1.setBounds(50, 10, 300, 20);
					JLabel label2 = new JLabel();
					label2.setText("Student Perform: ");
					label2.setBounds(80, 50, 300, 20);
					label2.setForeground(Color.BLUE);
					JLabel label3 = new JLabel();
					label3.setText("Hoàng Minh Nam");
					label3.setForeground(Color.RED);
					label3.setBounds(80, 70, 300, 20);
					JLabel label4 = new JLabel();
					label4.setText("DH15DTC");
					label4.setForeground(Color.RED);
					label4.setBounds(100, 90, 300, 20);

					JLabel label6 = new JLabel();
					label6.setText("<html>"
							+ "<span style='font-size:10.0pt;font:italic;color:blue'> Email: minh_nam_fitnlu@yahoo.com </html>");
					label6.setForeground(Color.PINK);
					label6.setBounds(40, 110, 300, 20);
					JLabel label7 = new JLabel();
					label7.setText("Information Technology Faculty");
					label7.setBounds(50, 30, 300, 20);
					label7.setForeground(Color.MAGENTA);
					JLabel label8 = new JLabel();
					label8.setText(
							"<html>" + "<span style='font-size:14.0pt;font:bold;color:RED'> Game FlappyBird </html>");
					label8.setBounds(85, 170, 300, 20);
					JLabel label9 = new JLabel();
					label9.setText("Version 1.0");
					label9.setBounds(110, 188, 300, 20);
					JLabel label10 = new JLabel();
					label10.setText("Copyright @ 2007");
					label10.setBounds(95, 240, 300, 20);

					f1.add(label2);
					f1.add(label7);
					f1.add(label1);
					f1.add(label3);
					f1.add(label4);
					f1.add(label6);
					f1.add(label8);
					f1.add(label9);
					f1.add(label10);

					f1.pack();
					f1.setVisible(true);
					f1.setSize(300, 300);
					f1.setResizable(false);
					f1.setLocationRelativeTo(null);

				}
			});

			btn.getBtn().addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {

					btn.setBounds(465, 415, 125, 67);
					btn.getBtn().setIcon(new ImageIcon(Loader.loadImage("about1.png")));

				}

				public void mouseExited(MouseEvent e) {

					btn.setBounds(470, 420, 110, 58);
					btn.getBtn().setIcon(new ImageIcon(Loader.loadImage("about.png")));

				}

			});
			break;
		case 4:
			btn.getBtn().addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {

					btn.setBounds(345, 465, 125, 67);
					btn.getBtn().setIcon(new ImageIcon(Loader.loadImage("rank1.png")));

				}

				public void mouseExited(MouseEvent e) {

					btn.setBounds(350, 470, 110, 58);
					btn.getBtn().setIcon(new ImageIcon(Loader.loadImage("rank.png")));

				}

			});

			btn.getBtn().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame f3 = new JFrame();
					String data[][] = { { "", "" }, { "", "" }, { "", "" } };
					String column[] = { "Name", "Point" };

					JTable jt = new JTable(data, column);
					jt.setBounds(30, 40, 200, 300);

					JScrollPane sp = new JScrollPane(jt);
					f3.add(sp);
					f3.setTitle("Rank");
					f3.setVisible(true);
					f3.pack();
					f3.setLocationRelativeTo(null);

				}
			});

			break;

		case 5:

			btn.getBtn().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (btn.getBtn() == e.getSource()) {

						int kq = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát khỏi game không ?", "Confirm",
								JOptionPane.YES_NO_OPTION);
						if (kq == 0) {
							System.exit(0);
						}
					}

				}
			});
			break;
		}

	}

}
