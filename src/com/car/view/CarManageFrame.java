package com.car.view;

import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.car.dao.CarDao;
import com.car.model.Car;
import com.car.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CarManageFrame extends JInternalFrame {
	private JTextField searchCarNameTextField;
	private JTable carListTable;
	private JTextField editCarNameTextField;
	private JTextField editCarNumTextField;
	private JTextField editCarRentTextField;
	private JTextField editCarDepositTextField;
	private JTextPane editCarInfoTextPane;
	private JButton deleteCarButton;
	private JButton editCarButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarManageFrame frame = new CarManageFrame();
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
	public CarManageFrame() {
		setTitle("\u6C7D\u8F66\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 604, 487);
		setClosable(true);
		setIconifiable(true);
		
		JLabel label = new JLabel("\u6C7D\u8F66\u540D\u5B57\uFF1A");
		label.setIcon(new ImageIcon(CarManageFrame.class.getResource("/images/\u8F66.png")));
		
		searchCarNameTextField = new JTextField();
		searchCarNameTextField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchCar(e);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u6C7D\u8F66\u4FE1\u606F\u7F16\u8F91", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(82)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(searchCarNameTextField, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
					.addComponent(searchButton)
					.addGap(92))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 548, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 548, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(searchCarNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel("\u6C7D\u8F66\u540D\u5B57 \uFF1A");
		label_1.setIcon(new ImageIcon(CarManageFrame.class.getResource("/images/\u8F66.png")));
		
		editCarNameTextField = new JTextField();
		editCarNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5E93\u5B58\u6570\u91CF;");
		label_2.setIcon(new ImageIcon(CarManageFrame.class.getResource("/images/\u5E93\u5B58.png")));
		
		editCarNumTextField = new JTextField();
		editCarNumTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u6C7D\u8F66\u79DF\u91D1\uFF1A");
		label_3.setIcon(new ImageIcon(CarManageFrame.class.getResource("/images/\u79DF\u91D1.png")));
		
		editCarRentTextField = new JTextField();
		editCarRentTextField.setColumns(10);
		
		JLabel label_4 = new JLabel("\u79DF\u8F66\u62BC\u91D1\uFF1A");
		label_4.setIcon(new ImageIcon(CarManageFrame.class.getResource("/images/\u62BC\u91D1.png")));
		
		editCarDepositTextField = new JTextField();
		editCarDepositTextField.setColumns(10);
		
		JLabel label_5 = new JLabel("\u6C7D\u8F66\u4ECB\u7ECD\uFF1A");
		label_5.setIcon(new ImageIcon(CarManageFrame.class.getResource("/images/\u4ECB\u7ECD.png")));
		
		editCarInfoTextPane = new JTextPane();
		
		editCarButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		editCarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editCarSubmit(e);
			}
		});
		
		deleteCarButton = new JButton("\u5220\u9664\u6C7D\u8F66");
		deleteCarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteCar(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editCarNameTextField, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(editCarRentTextField, 134, 134, 134)))
							.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(editCarNumTextField, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editCarDepositTextField)))
							.addGap(25))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_5)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(editCarInfoTextPane, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
							.addGap(86)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(editCarButton)
								.addComponent(deleteCarButton))
							.addGap(56))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(editCarNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(editCarNumTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(editCarRentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(editCarDepositTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label_5)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(editCarButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(deleteCarButton))
						.addComponent(editCarInfoTextPane))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		carListTable = new JTable();
		carListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectedCar(me);
			}
		});
		carListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6C7D\u8F66\u7F16\u53F7", "\u6C7D\u8F66\u540D\u5B57", "\u5E93\u5B58\u6570\u91CF", "\u6C7D\u8F66\u79DF\u91D1", "\u79DF\u8F66\u62BC\u91D1", "\u5DF2\u79DF\u8F66\u91CF", "\u6C7D\u8F66\u4ECB\u7ECD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		carListTable.getColumnModel().getColumn(0).setPreferredWidth(58);
		carListTable.getColumnModel().getColumn(1).setPreferredWidth(78);
		carListTable.getColumnModel().getColumn(2).setPreferredWidth(58);
		carListTable.getColumnModel().getColumn(3).setPreferredWidth(60);
		carListTable.getColumnModel().getColumn(4).setPreferredWidth(59);
		carListTable.getColumnModel().getColumn(5).setPreferredWidth(58);
		carListTable.getColumnModel().getColumn(6).setPreferredWidth(120);
		scrollPane.setViewportView(carListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new Car());
		setAuthority();

	}
	protected void editCarSubmit(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = carListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要更新的数据！");
			return;
		}
		String carName = editCarNameTextField.getText().toString();
		if(StringUtil.isEmpty(carName)){
			JOptionPane.showMessageDialog(this, "请输入汽车名字！");
			return;
		}
		int carMax_num = 0;
		try {
			carMax_num = Integer.parseInt(editCarNumTextField.getText().toString());
		} catch (Exception ex) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "库存数量请输入大于0的整！");
			return;
		}
		if(carMax_num <= 0){
			JOptionPane.showMessageDialog(this, "库存数量请输入大于0的整！");
			return;
		}
		String carRent = editCarRentTextField.getText().toString();
		String carDeposit = editCarDepositTextField.getText().toString();
		String carInfo = editCarInfoTextPane.getText().toString();
		if(StringUtil.isEmpty(carRent)){
			JOptionPane.showMessageDialog(this, "请输入汽车租金！");
			return;
		}
		if(StringUtil.isEmpty(carDeposit)){
			JOptionPane.showMessageDialog(this, "请输入租车押金！");
			return;
		}
		if(StringUtil.isEmpty(carInfo)){
			JOptionPane.showMessageDialog(this, "请输入汽车介绍！");
			return;
		}
		
		Car car = new Car();
		car.setName(carName);
		car.setMax_num(carMax_num);
		car.setRent(carRent);
		car.setDeposit(carDeposit);
		car.setInfo(carInfo);
		car.setId(Integer.parseInt(carListTable.getValueAt(row, 0).toString()));
		CarDao carDao = new CarDao();
		if(carDao.update(car)){
			JOptionPane.showMessageDialog(this, "更新成功！");
		}else{
			JOptionPane.showMessageDialog(this, "更新失败！");
		}
		carDao.closeDao();
		setTable(new Car());
	}

	protected void selectedCar(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) carListTable.getModel();
		editCarNameTextField.setText(dft.getValueAt(carListTable.getSelectedRow(), 1).toString());
		editCarNumTextField.setText(dft.getValueAt(carListTable.getSelectedRow(), 2).toString());
		editCarRentTextField.setText(dft.getValueAt(carListTable.getSelectedRow(), 3).toString());
		editCarDepositTextField.setText(dft.getValueAt(carListTable.getSelectedRow(), 4).toString());
		editCarInfoTextPane.setText(dft.getValueAt(carListTable.getSelectedRow(), 6).toString());
	}

	protected void searchCar(ActionEvent e) {
		// TODO Auto-generated method stub
		Car car = new Car();
		car.setName(searchCarNameTextField.getText().toString());
		setTable(car);
	}

	protected void deleteCar(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = carListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要删除的数据！");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "您确定删除么？") != JOptionPane.OK_OPTION){
			return;
		}
		CarDao carDao = new CarDao();
		if(carDao.delete(Integer.parseInt(carListTable.getValueAt(row, 0).toString()))){
			JOptionPane.showMessageDialog(this, "删除成功！");
		}else{
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		carDao.closeDao();
		setTable(new Car());
	}

	private void setTable(Car car){
		DefaultTableModel dft = (DefaultTableModel) carListTable.getModel();
		dft.setRowCount(0);
		CarDao carDao = new CarDao();
		List<Car> carList = carDao.getCarList(car);
		for (Car c : carList) {
			Vector v = new Vector();
			v.add(c.getId());
			v.add(c.getName());
			v.add(c.getMax_num());
			v.add(c.getRent());
			v.add(c.getDeposit());
			v.add(c.getSelected_num());
			v.add(c.getInfo());
			dft.addRow(v);
		}
		carDao.closeDao();
	}
	private void setAuthority(){
		if("客户".equals(MaimFrame.userType.getName())){
			deleteCarButton.setEnabled(false);
			editCarButton.setEnabled(false);
		}
	}
}
