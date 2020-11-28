package com.car.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.car.dao.QuestionDao;
import com.car.model.Question;
import com.car.util.StringUtil;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuestionManageFrame extends JInternalFrame {
	private JTable table;
	private JTextPane addQuestionTextPane;
	private JTextPane editAnswerTextPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionManageFrame frame = new QuestionManageFrame();
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
	public QuestionManageFrame() {
		setTitle("\u7591\u95EE\u89E3\u7B54");
		setBounds(100, 100, 557, 387);
		setClosable(true);
		setIconifiable(true);
		
		JLabel lblNewLabel = new JLabel("\u7591\u95EE\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(QuestionManageFrame.class.getResource("/images/\u5E2E \u52A9.png")));
		
		JButton submitQuestionButton = new JButton("\u786E\u8BA4");
		submitQuestionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addQuestionAct(e);
			}
		});
		
		JLabel label = new JLabel("\u56DE\u7B54\uFF1A");
		label.setIcon(new ImageIcon(QuestionManageFrame.class.getResource("/images/\u56DE\u7B54.png")));
		
		JButton submitAnswerButton = new JButton("\u786E\u8BA4");
		submitAnswerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editAnswerAct(e);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		addQuestionTextPane = new JTextPane();
		
		editAnswerTextPane = new JTextPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(addQuestionTextPane, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
							.addGap(54)
							.addComponent(submitQuestionButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(15)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editAnswerTextPane, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
									.addComponent(submitAnswerButton)))))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(33)
									.addComponent(submitQuestionButton))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(21)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(addQuestionTextPane, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel))))
							.addGap(172)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(44)
									.addComponent(submitAnswerButton))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(31)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(editAnswerTextPane, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addComponent(label))))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(90)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedTableRow(e);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u95EE\u9898", "\u89E3\u7B54"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(36);
		table.getColumnModel().getColumn(1).setPreferredWidth(186);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		setTable(new Question());

	}

	protected void editAnswerAct(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要回答的问题！");
			return;
		}
		String questionAnswer = editAnswerTextPane.getText().toString();
		if(StringUtil.isEmpty(questionAnswer)){
			JOptionPane.showMessageDialog(this, "请回答问题！");
			return;
		}
		
		Question question = new Question();
		question.setAnswer(questionAnswer);
		question.setId(Integer.parseInt(table.getValueAt(row, 0).toString()));
		QuestionDao questionDao = new QuestionDao();
		if(questionDao.update(question)){
			JOptionPane.showMessageDialog(this, "更新成功！");
		}else{
			JOptionPane.showMessageDialog(this, "更新失败！");
		}
		questionDao.closeDao();
		setTable(new Question());
	}

	protected void addQuestionAct(ActionEvent e) {
		// TODO Auto-generated method stub
		String questionQuestion = addQuestionTextPane.getText().toString();
		String questionAnswer = "待回答！".toString();
		if(StringUtil.isEmpty(questionQuestion)){
			JOptionPane.showMessageDialog(this, "请输入问题!");
			return;
		}
		Question question = new Question();
		question.setQuestion(questionQuestion);
		question.setAnswer(questionAnswer);
		QuestionDao questionDao = new QuestionDao();
		if(questionDao.addEmployee(question)){
			JOptionPane.showMessageDialog(this, "添加成功!");
		}else{
			JOptionPane.showMessageDialog(this, "添加失败!");
		}
		questionDao.closeDao();
		setTable(new Question());
	}
	private void setTable(Question question){
		DefaultTableModel dft = (DefaultTableModel) table.getModel();
		dft.setRowCount(0);
		QuestionDao questionDao = new QuestionDao();
		List<Question> questionList = questionDao.getQuestionList(question);
		for (Question q : questionList) {
			Vector v = new Vector();
			v.add(q.getId());
			v.add(q.getQuestion());
			v.add(q.getAnswer());
			dft.addRow(v);
		}
		questionDao.closeDao();
	}
	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) table.getModel();
		editAnswerTextPane.setText(dft.getValueAt(table.getSelectedRow(), 2).toString());
	}
}
