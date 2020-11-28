package com.car.view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.car.dao.CarDao;
import com.car.dao.CustomerDao;
import com.car.dao.RentalCarDao;
import com.car.model.Car;
import com.car.model.Customer;
import com.car.model.RentalCar;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RentalCarManageFrame extends JInternalFrame {
	private JTable table;
	private JComboBox searchCustomerComboBox;
	private JComboBox searchCarComboBox;
	private JComboBox editCustomerComboBox;
	private JComboBox editCarComboBox;
	private JButton returnButton;
	private JButton searchButton;
	private List<Customer> customerList = new ArrayList<Customer>();
	private List<Car> carList = new ArrayList<Car>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RentalCarManageFrame frame = new RentalCarManageFrame();
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
	public RentalCarManageFrame() {
		setTitle("\u79DF\u8D41\u4E1A\u52A1");
		setBounds(100, 100, 567, 423);
		setClosable(true);
		setIconifiable(true);
		
		JLabel label = new JLabel("\u5BA2\u6237\uFF1A");
		label.setIcon(new ImageIcon(RentalCarManageFrame.class.getResource("/images/\u7528\u6237\u540D.png")));
		
		searchCustomerComboBox = new JComboBox();
		searchCustomerComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				customerChangeAct(e);
			}
		});
		
		JLabel label_1 = new JLabel("\u6C7D\u8F66\uFF1A");
		label_1.setIcon(new ImageIcon(RentalCarManageFrame.class.getResource("/images/\u8F66.png")));
		
		searchCarComboBox = new JComboBox();
		
		searchButton = new JButton("\u79DF\u8F66");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmRentalCar(e);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u5F52\u8FD8\u8F66\u8F86", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 495, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 494, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(searchCustomerComboBox, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(label_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(searchCarComboBox, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
								.addComponent(searchButton)
								.addGap(37)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(searchCustomerComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(searchCarComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		
		JLabel label_2 = new JLabel("\u5BA2\u6237\uFF1A");
		label_2.setIcon(new ImageIcon(RentalCarManageFrame.class.getResource("/images/\u7528\u6237\u540D.png")));
		
		editCustomerComboBox = new JComboBox();
		
		JLabel label_3 = new JLabel("\u6C7D\u8F66\uFF1A");
		label_3.setIcon(new ImageIcon(RentalCarManageFrame.class.getResource("/images/\u8F66.png")));
		
		editCarComboBox = new JComboBox();
		
		returnButton = new JButton("\u8FD8\u8F66");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnCar(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(editCustomerComboBox, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addGap(51)
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(editCarComboBox, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(209)
							.addComponent(returnButton)))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(editCustomerComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_2))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(editCarComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_3)))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addComponent(returnButton)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectedCar(me);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BA2\u5355\u7F16\u53F7", "\u5BA2\u6237\u59D3\u540D", "\u6C7D\u8F66\u540D\u5B57", "\u79DF\u7528\u72B6\u6001"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		setCustomerCombox();
		setCarCombox();
		initTable();
		setAuthority();

	}
	protected void returnCar(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要归还的汽车！");
			return;
		}
		int selected_id = Integer.parseInt(table.getValueAt(row, 0).toString());
		String carName = table.getValueAt(row, 2).toString();
		RentalCar rc = new RentalCar();
		rc.setId(selected_id);
		RentalCarDao rcDao = new RentalCarDao();
		CarDao carDao = new CarDao();
		if(rcDao.delete(selected_id)){
			if(carDao.updateSelectedNum(getCarIdByName(carName), -1)){
				JOptionPane.showMessageDialog(this, "还车成功！");
			}else{
				JOptionPane.showMessageDialog(this, "还车成功，还车信息更新失败！");
			}
		}else{
			JOptionPane.showMessageDialog(this, "还车失败！");
		}
		rcDao.closeDao();
		carDao.closeDao();
		initTable();
	}

	protected void selectedCar(MouseEvent me) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		String customerName = table.getValueAt(row, 1).toString();
		String carName = table.getValueAt(row, 2).toString();
		for (int i = 0; i < editCustomerComboBox.getItemCount();i++) {
			Customer customer = (Customer) editCustomerComboBox.getItemAt(i);
			if(customerName.equals(customer.getName())){
				editCustomerComboBox.setSelectedIndex(i);
				break;
			}
		}
		for (int i = 0; i < editCarComboBox.getItemCount();i++) {
			Car car = (Car) editCarComboBox.getItemAt(i);
			if(carName.equals(car.getName())){
				editCarComboBox.setSelectedIndex(i);
				break;
			}
		}
	}

	protected void confirmRentalCar(ActionEvent e) {
		// TODO Auto-generated method stub
		Customer ccustomer = (Customer) searchCustomerComboBox.getSelectedItem();
		Car ccar = (Car) searchCarComboBox.getSelectedItem();
		String rentalCalRental_ststus = "正租用！".toString();
		RentalCar rc = new RentalCar();
		rc.setCustomer_id(ccustomer.getId());
		rc.setCar_id(ccar.getId());
		rc.setRental_ststus(rentalCalRental_ststus);
		CarDao carDao = new CarDao();
		if(!carDao.selectedEnable(ccar.getId())){
			JOptionPane.showMessageDialog(this, "该汽车已经全部租出，不能再租用!");
			return;
		}
		RentalCarDao rcDao = new RentalCarDao();
		if(rcDao.addRentalCar(rc)){
			if(carDao.updateSelectedNum(rc.getCar_id(),1)){
				JOptionPane.showMessageDialog(this, "租车成功！!");
			}else{
				JOptionPane.showMessageDialog(this, "租车成功，租车信息更新失败!");
			}
		}else{
			JOptionPane.showMessageDialog(this, "租车失败!");
		}
		carDao.closeDao();
		rcDao.closeDao();
		initTable();
	}

	protected void customerChangeAct(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getStateChange() == ItemEvent.SELECTED){
			initTable();
		}
	}

	private void setCustomerCombox(){
		CustomerDao customerDao = new CustomerDao();
		customerList = customerDao.getCustomerList(new Customer());
		customerDao.closeDao();
		for (Customer customer : customerList) {
			searchCustomerComboBox.addItem(customer);
			editCustomerComboBox.addItem(customer);
		}
		if("客户".equals(MaimFrame.userType.getName())){
			Customer user = (Customer) MaimFrame.userObject;
			for(int i = 0; i < searchCustomerComboBox.getItemCount();i++){
				Customer customer = (Customer) searchCustomerComboBox.getItemAt(i);
				if(customer.getId() == user.getId()){
					searchCustomerComboBox.setSelectedIndex(i);
					editCustomerComboBox.setSelectedIndex(i);
					break;
				}
			}
		}
	}
	private void setCarCombox(){
		CarDao carDao = new CarDao();
		carList = carDao.getCarList(new Car());
		carDao.closeDao();
		for (Car car : carList) {
			searchCarComboBox.addItem(car);
			editCarComboBox.addItem(car);
		}
	}
	private void getRentalCar(RentalCar rentalCar){
		RentalCarDao rentalCarDao = new RentalCarDao();
		List<RentalCar> rentalCarList = rentalCarDao.getRentalCarList(rentalCar);
		DefaultTableModel dft = (DefaultTableModel) table.getModel();
		dft.setRowCount(0);
		for (RentalCar rc : rentalCarList) {
			Vector v = new Vector();
			v.add(rc.getId());
			v.add(getCustomerNameById(rc.getCustomer_id()));
			v.add(getCarNameById(rc.getCar_id()));
			v.add(rc.getRental_ststus());
			dft.addRow(v);
		}
		rentalCarDao.closeDao();
	}
	private void initTable(){
		Customer customer = (Customer) searchCustomerComboBox.getSelectedItem();
		RentalCar rc = new RentalCar();
		rc.setCustomer_id(customer.getId());
		getRentalCar(rc);
	}
	private String getCustomerNameById(int id){
		for (int i = 0; i < customerList.size(); i++) {
			if(customerList.get(i).getId() == id)return customerList.get(i).getName();
		}
		return "";
	}
	private String getCarNameById(int id){
		for (int i = 0; i < carList.size(); i++) {
			if(id == carList.get(i).getId())return carList.get(i).getName();
		}
		return "";
	}
	private int getCarIdByName(String name){
		for (int i = 0; i < carList.size(); i++) {
			if(name.equals(carList.get(i).getName()))return carList.get(i).getId();
		}
		return 0;
	}
	private void setAuthority(){
		if("客户".equals(MaimFrame.userType.getName())){
			searchCustomerComboBox.setEnabled(false);
			editCustomerComboBox.setEnabled(false);
		}
		if("员工".equals(MaimFrame.userType.getName())) {
			returnButton.setEnabled(false);
			searchButton.setEnabled(false);
		}
	}
}
