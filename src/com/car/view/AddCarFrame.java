package com.car.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.car.dao.CarDao;
import com.car.model.Car;
import com.car.util.StringUtil;

public class AddCarFrame extends JInternalFrame {
	private JTextField carNameTextField;
	private JTextField carNumTextField;
	private JTextField carRentTextField;
	private JTextField carDepositTextField;
	private JTextPane carInfoTextPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCarFrame frame = new AddCarFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddCarFrame() {
		setTitle("\u6DFB\u52A0\u6C7D\u8F66");
		setBounds(100, 100, 453, 328);
		setClosable(true );
		setIconifiable(true);
		
		JLabel label = new JLabel("\u6C7D\u8F66\u540D\u5B57\uFF1A");
		label.setIcon(new ImageIcon(AddCarFrame.class.getResource("/images/\u8F66.png")));
		
		carNameTextField = new JTextField();
		carNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5E93\u5B58\u6570\u91CF\uFF1A");
		label_1.setIcon(new ImageIcon(AddCarFrame.class.getResource("/images/\u5E93\u5B58.png")));
		
		carNumTextField = new JTextField();
		carNumTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6C7D\u8F66\u79DF\u91D1\uFF1A");
		label_2.setIcon(new ImageIcon(AddCarFrame.class.getResource("/images/\u79DF\u91D1.png")));
		
		carRentTextField = new JTextField();
		carRentTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u79DF\u8F66\u62BC\u91D1\uFF1A");
		label_3.setIcon(new ImageIcon(AddCarFrame.class.getResource("/images/\u62BC\u91D1.png")));
		
		carDepositTextField = new JTextField();
		carDepositTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u6C7D\u8F66\u4ECB\u7ECD\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(AddCarFrame.class.getResource("/images/\u4ECB\u7ECD.png")));
		
		carInfoTextPane = new JTextPane();
		
		JButton submitButton = new JButton("\u786E\u5B9A");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCarAct(e);
			}
		});
		
		JButton cancelButton = new JButton("\u53D6\u6D88");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(88)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(carRentTextField))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(carNumTextField))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(carNameTextField, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_3)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(carInfoTextPane, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
								.addComponent(carDepositTextField)
								.addComponent(submitButton))))
					.addGap(97))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(254)
					.addComponent(cancelButton)
					.addContainerGap(126, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(carNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(carNumTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(carRentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(carDepositTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(carInfoTextPane, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cancelButton)
						.addComponent(submitButton))
					.addGap(25))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void addCarAct(ActionEvent e) {
		// TODO Auto-generated method stub
		String carName = carNameTextField.getText().toString();
		String carRent = carRentTextField.getText().toString();
		String carDeposit = carDepositTextField.getText().toString();
		String carInfo = carInfoTextPane.getText().toString();
		int Max_num = 0;
		try {
			Max_num = Integer.parseInt(carNumTextField.getText());
		} catch (Exception ex) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "库存量只能输入数字!");
			return;
		}
		if(StringUtil.isEmpty(carName)){
			JOptionPane.showMessageDialog(this, "请输入汽车名字!");
			return;
		}
		if(Max_num <= 0){
			JOptionPane.showMessageDialog(this, "库存数量只能输入大于0的数字!");
			return;
		}
		if(StringUtil.isEmpty(carRent)){
			JOptionPane.showMessageDialog(this, "请输入汽车租金!");
			return;
		}
		if(StringUtil.isEmpty(carDeposit)){
			JOptionPane.showMessageDialog(this, "请输入租车押金!");
			return;
		}
		if(StringUtil.isEmpty(carInfo)){
			JOptionPane.showMessageDialog(this, "请输入汽车介绍!");
			return;
		}
		Car car = new Car();
		car.setName(carName);
		car.setMax_num(Max_num);
		car.setRent(carRent);
		car.setDeposit(carDeposit);
		car.setInfo(carInfo);
		CarDao carDao = new CarDao();
		if(carDao.addCar(car)){
			JOptionPane.showMessageDialog(this, "添加成功!");
		}else{
			JOptionPane.showMessageDialog(this, "添加失败!");
		}
		resetValue(e);        
	}

	protected void resetValue(ActionEvent e) {
		// TODO Auto-generated method stub
		carNameTextField.setText("");
		carNumTextField.setText("");
		carRentTextField.setText("");
		carDepositTextField.setText("");
		carInfoTextPane.setText("");
	}
}
