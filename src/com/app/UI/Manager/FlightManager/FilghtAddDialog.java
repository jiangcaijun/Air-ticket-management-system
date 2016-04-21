package com.app.UI.Manager.FlightManager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import com.app.controller.flightControl.FlightAddDialogControl;
import com.eltima.components.ui.DatePicker;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class FilghtAddDialog extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField flightIdTextField;
	public JTextField originStationTextField;
	public JTextField originAirportTextField;
	public JTextField distanceTextField;
	public JTextField flightCompanytextField;
	public JTextField terminalStationTextField;
	public JTextField terminalAirportTextField;
	public JTextField planeTypeTextField;
	public JTextField economySeatTextField;
	public JTextField bordingGateTextField;
	public JTextField economyPriceTextField;
	public JTextField businessPriceTextField;
	public JTextField firstPriceTextField;
	public JTextField businessSeatTextField;
	public JTextField businessDiscountTextField;
	public JTextField economyDiscountTextField;
	public JTextField firstDiscountTextField;
	public DefaultTableModel dtm = new DefaultTableModel();
	public JButton okButton;
	public JTextField originShortTextField;
	public JTextField terminalShortTextField;
	public JTextField firstSeatTextField;
	public JRadioButton radioButton1;
	private FlightAddDialogControl fadc;
	public JButton cancelButton;
	public DatePicker StartTimeNewButton;
	public DatePicker endTimeNewButton;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public FilghtAddDialog() {
		setTitle("航班信息添加");
		setBounds(100, 100, 600, 550);
		getContentPane().setLayout(new BorderLayout());
		
	
		ButtonGroup bg = new ButtonGroup();
	
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{93, 210, 93, 93, 0};
		gbl_panel_1.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0,0.5};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		{
			JLabel lblNewLabel = new JLabel("航班号");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 1;
			panel_1.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			flightIdTextField = new JTextField();
			GridBagConstraints gbc_flightIdTextField = new GridBagConstraints();
			gbc_flightIdTextField.insets = new Insets(0, 0, 5, 5);
			gbc_flightIdTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_flightIdTextField.gridx = 1;
			gbc_flightIdTextField.gridy = 1;
			panel_1.add(flightIdTextField, gbc_flightIdTextField);
			flightIdTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("航空公司");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 2;
			gbc_lblNewLabel_1.gridy = 1;
			panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			flightCompanytextField = new JTextField();
			GridBagConstraints gbc_flightCompanytextField = new GridBagConstraints();
			gbc_flightCompanytextField.insets = new Insets(0, 0, 5, 5);
			gbc_flightCompanytextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_flightCompanytextField.gridx = 3;
			gbc_flightCompanytextField.gridy = 1;
			panel_1.add(flightCompanytextField, gbc_flightCompanytextField);
			flightCompanytextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("起点城市");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 2;
			panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 2;
			panel_1.add(panel, gbc_panel);
			panel.setLayout(new GridLayout(1, 0, 0, 0));
			{
				originStationTextField = new JTextField();
				panel.add(originStationTextField);
				originStationTextField.setColumns(7);
			}
			{
				JPanel panel_2 = new JPanel();
				panel.add(panel_2);
				panel_2.setLayout(new GridLayout(0, 2, 0, 0));
				{
					JLabel label = new JLabel("城市缩写");
					label.setHorizontalAlignment(SwingConstants.CENTER);
					panel_2.add(label);
				}
				{
					originShortTextField = new JTextField();
					panel_2.add(originShortTextField);
					originShortTextField.setColumns(5);
				}
			}
		}
		{
			JLabel lblNewLabel_3 = new JLabel("终点城市");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 2;
			gbc_lblNewLabel_3.gridy = 2;
			panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 3;
			gbc_panel.gridy = 2;
			panel_1.add(panel, gbc_panel);
			panel.setLayout(new GridLayout(1, 0, 0, 0));
			{
				terminalStationTextField = new JTextField();
				panel.add(terminalStationTextField);
				terminalStationTextField.setColumns(10);
			}
			{
				JPanel panel_2 = new JPanel();
				panel.add(panel_2);
				panel_2.setLayout(new GridLayout(0, 2, 0, 0));
				{
					JLabel lblNewLabel_21 = new JLabel("城市缩写");
					lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
					panel_2.add(lblNewLabel_21);
				}
				{
					terminalShortTextField = new JTextField();
					panel_2.add(terminalShortTextField);
					terminalShortTextField.setColumns(10);
				}
			}
		}
		{
			JLabel lblNewLabel_4 = new JLabel("起飞机场");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 0;
			gbc_lblNewLabel_4.gridy = 3;
			panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			originAirportTextField = new JTextField();
			GridBagConstraints gbc_originAirportTextField = new GridBagConstraints();
			gbc_originAirportTextField.insets = new Insets(0, 0, 5, 5);
			gbc_originAirportTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_originAirportTextField.gridx = 1;
			gbc_originAirportTextField.gridy = 3;
			panel_1.add(originAirportTextField, gbc_originAirportTextField);
			originAirportTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("到达机场");
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 2;
			gbc_lblNewLabel_5.gridy = 3;
			panel_1.add(lblNewLabel_5, gbc_lblNewLabel_5);
		}
		{
			terminalAirportTextField = new JTextField();
			GridBagConstraints gbc_terminalAirportTextField = new GridBagConstraints();
			gbc_terminalAirportTextField.insets = new Insets(0, 0, 5, 5);
			gbc_terminalAirportTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_terminalAirportTextField.gridx = 3;
			gbc_terminalAirportTextField.gridy = 3;
			panel_1.add(terminalAirportTextField, gbc_terminalAirportTextField);
			terminalAirportTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("出发时间");
			GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
			gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_6.gridx = 0;
			gbc_lblNewLabel_6.gridy = 4;
			panel_1.add(lblNewLabel_6, gbc_lblNewLabel_6);
		}
		{
			StartTimeNewButton = new DatePicker(this);
			StartTimeNewButton.setPattern("yyy-MM-d");
			GridBagConstraints gbc_StartTimeNewButton = new GridBagConstraints();
			gbc_StartTimeNewButton.fill = GridBagConstraints.HORIZONTAL;
			gbc_StartTimeNewButton.insets = new Insets(0, 0, 5, 5);
			gbc_StartTimeNewButton.gridx = 1;
			gbc_StartTimeNewButton.gridy = 4;
			panel_1.add(StartTimeNewButton, gbc_StartTimeNewButton);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("到达时间");
			GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
			gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_7.gridx = 2;
			gbc_lblNewLabel_7.gridy = 4;
			panel_1.add(lblNewLabel_7, gbc_lblNewLabel_7);
		}
		{
			endTimeNewButton = new DatePicker(this);
			endTimeNewButton.setPattern("yyy-MM-d");
			GridBagConstraints gbc_endTimeNewButton = new GridBagConstraints();
			gbc_endTimeNewButton.fill = GridBagConstraints.HORIZONTAL;
			gbc_endTimeNewButton.insets = new Insets(0, 0, 5, 5);
			gbc_endTimeNewButton.gridx = 3;
			gbc_endTimeNewButton.gridy = 4;
			panel_1.add(endTimeNewButton, gbc_endTimeNewButton);
		}
		{
			JLabel lblNewLabel_9 = new JLabel("航程距离");
			GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
			gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_9.gridx = 0;
			gbc_lblNewLabel_9.gridy = 5;
			panel_1.add(lblNewLabel_9, gbc_lblNewLabel_9);
		}
		{
			distanceTextField = new JTextField();
			GridBagConstraints gbc_distanceTextField = new GridBagConstraints();
			gbc_distanceTextField.insets = new Insets(0, 0, 5, 5);
			gbc_distanceTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_distanceTextField.gridx = 1;
			gbc_distanceTextField.gridy = 5;
			panel_1.add(distanceTextField, gbc_distanceTextField);
			distanceTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_8 = new JLabel("机型");
			GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
			gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_8.gridx = 2;
			gbc_lblNewLabel_8.gridy = 5;
			panel_1.add(lblNewLabel_8, gbc_lblNewLabel_8);
		}
		{
			planeTypeTextField = new JTextField();
			GridBagConstraints gbc_planeTypeTextField = new GridBagConstraints();
			gbc_planeTypeTextField.insets = new Insets(0, 0, 5, 5);
			gbc_planeTypeTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_planeTypeTextField.gridx = 3;
			gbc_planeTypeTextField.gridy = 5;
			panel_1.add(planeTypeTextField, gbc_planeTypeTextField);
			planeTypeTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_16 = new JLabel("是否提供飞机餐");
			GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
			gbc_lblNewLabel_16.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_16.gridx = 0;
			gbc_lblNewLabel_16.gridy = 6;
			panel_1.add(lblNewLabel_16, gbc_lblNewLabel_16);
		}
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 6;
		panel_1.add(panel, gbc_panel);
		{
			radioButton1 = new JRadioButton("提供");
			radioButton1.setSelected(true);
			bg.add(radioButton1);
			panel.add(radioButton1);
		}
		{
			JRadioButton radioButton2 = new JRadioButton("不提供");
			bg.add(radioButton2);
			panel.add(radioButton2);
		}
		{
			JLabel lblNewLabel_14 = new JLabel("登机口");
			GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
			gbc_lblNewLabel_14.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_14.gridx = 2;
			gbc_lblNewLabel_14.gridy = 6;
			panel_1.add(lblNewLabel_14, gbc_lblNewLabel_14);
		}
		{
			bordingGateTextField = new JTextField();
			GridBagConstraints gbc_bordingGateTextField = new GridBagConstraints();
			gbc_bordingGateTextField.insets = new Insets(0, 0, 5, 5);
			gbc_bordingGateTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_bordingGateTextField.gridx = 3;
			gbc_bordingGateTextField.gridy = 6;
			panel_1.add(bordingGateTextField, gbc_bordingGateTextField);
			bordingGateTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_17 = new JLabel("经济舱座位数");
			GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
			gbc_lblNewLabel_17.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_17.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_17.gridx = 0;
			gbc_lblNewLabel_17.gridy = 7;
			panel_1.add(lblNewLabel_17, gbc_lblNewLabel_17);
		}
		{
			economySeatTextField = new JTextField();
			GridBagConstraints gbc_economySeatTextField = new GridBagConstraints();
			gbc_economySeatTextField.insets = new Insets(0, 0, 5, 5);
			gbc_economySeatTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_economySeatTextField.gridx = 1;
			gbc_economySeatTextField.gridy = 7;
			panel_1.add(economySeatTextField, gbc_economySeatTextField);
			economySeatTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_12 = new JLabel("经济舱价格");
			GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
			gbc_lblNewLabel_12.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_12.gridx = 2;
			gbc_lblNewLabel_12.gridy = 7;
			panel_1.add(lblNewLabel_12, gbc_lblNewLabel_12);
		}
		{
			economyPriceTextField = new JTextField();
			GridBagConstraints gbc_economyPriceTextField = new GridBagConstraints();
			gbc_economyPriceTextField.insets = new Insets(0, 0, 5, 5);
			gbc_economyPriceTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_economyPriceTextField.gridx = 3;
			gbc_economyPriceTextField.gridy = 7;
			panel_1.add(economyPriceTextField, gbc_economyPriceTextField);
			economyPriceTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_15 = new JLabel("公务舱座位数");
			GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
			gbc_lblNewLabel_15.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_15.gridx = 0;
			gbc_lblNewLabel_15.gridy = 8;
			panel_1.add(lblNewLabel_15, gbc_lblNewLabel_15);
		}
		{
			businessSeatTextField = new JTextField();
			GridBagConstraints gbc_businessSeatTextField = new GridBagConstraints();
			gbc_businessSeatTextField.insets = new Insets(0, 0, 5, 5);
			gbc_businessSeatTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_businessSeatTextField.gridx = 1;
			gbc_businessSeatTextField.gridy = 8;
			panel_1.add(businessSeatTextField, gbc_businessSeatTextField);
			businessSeatTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_13 = new JLabel("公务舱价格");
			GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
			gbc_lblNewLabel_13.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_13.gridx = 2;
			gbc_lblNewLabel_13.gridy = 8;
			panel_1.add(lblNewLabel_13, gbc_lblNewLabel_13);
		}
		{
			businessPriceTextField = new JTextField();
			GridBagConstraints gbc_businessPriceTextField = new GridBagConstraints();
			gbc_businessPriceTextField.insets = new Insets(0, 0, 5, 5);
			gbc_businessPriceTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_businessPriceTextField.gridx = 3;
			gbc_businessPriceTextField.gridy = 8;
			panel_1.add(businessPriceTextField, gbc_businessPriceTextField);
			businessPriceTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_10 = new JLabel("头等舱座位数");
			GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
			gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_10.gridx = 0;
			gbc_lblNewLabel_10.gridy = 9;
			panel_1.add(lblNewLabel_10, gbc_lblNewLabel_10);
		}
		{
			firstSeatTextField = new JTextField();
			GridBagConstraints gbc_firstSeatTextField = new GridBagConstraints();
			gbc_firstSeatTextField.insets = new Insets(0, 0, 5, 5);
			gbc_firstSeatTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_firstSeatTextField.gridx = 1;
			gbc_firstSeatTextField.gridy = 9;
			panel_1.add(firstSeatTextField, gbc_firstSeatTextField);
			firstSeatTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_11 = new JLabel("头等舱价格");
			GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
			gbc_lblNewLabel_11.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_11.gridx = 2;
			gbc_lblNewLabel_11.gridy = 9;
			panel_1.add(lblNewLabel_11, gbc_lblNewLabel_11);
		}
		{
			firstPriceTextField = new JTextField();
			GridBagConstraints gbc_firstPriceTextField = new GridBagConstraints();
			gbc_firstPriceTextField.insets = new Insets(0, 0, 5, 5);
			gbc_firstPriceTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_firstPriceTextField.gridx = 3;
			gbc_firstPriceTextField.gridy = 9;
			panel_1.add(firstPriceTextField, gbc_firstPriceTextField);
			firstPriceTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_18 = new JLabel("头等舱折扣");
			GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
			gbc_lblNewLabel_18.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_18.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_18.gridx = 0;
			gbc_lblNewLabel_18.gridy = 10;
			panel_1.add(lblNewLabel_18, gbc_lblNewLabel_18);
		}
		{
			economyDiscountTextField = new JTextField();
			economyDiscountTextField.setText("10");
			GridBagConstraints gbc_economyDiscountTextField = new GridBagConstraints();
			gbc_economyDiscountTextField.insets = new Insets(0, 0, 5, 5);
			gbc_economyDiscountTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_economyDiscountTextField.gridx = 1;
			gbc_economyDiscountTextField.gridy = 10;
			panel_1.add(economyDiscountTextField, gbc_economyDiscountTextField);
			economyDiscountTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_19 = new JLabel("公务舱折扣");
			GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
			gbc_lblNewLabel_19.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_19.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_19.gridx = 2;
			gbc_lblNewLabel_19.gridy = 10;
			panel_1.add(lblNewLabel_19, gbc_lblNewLabel_19);
		}
		{
			businessDiscountTextField = new JTextField();
			businessDiscountTextField.setText("10");
			GridBagConstraints gbc_businessDiscountTextField = new GridBagConstraints();
			gbc_businessDiscountTextField.insets = new Insets(0, 0, 5, 5);
			gbc_businessDiscountTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_businessDiscountTextField.gridx = 3;
			gbc_businessDiscountTextField.gridy = 10;
			panel_1.add(businessDiscountTextField, gbc_businessDiscountTextField);
			businessDiscountTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_20 = new JLabel("经济舱折扣");
			GridBagConstraints gbc_lblNewLabel_20 = new GridBagConstraints();
			gbc_lblNewLabel_20.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_20.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_20.gridx = 0;
			gbc_lblNewLabel_20.gridy = 11;
			panel_1.add(lblNewLabel_20, gbc_lblNewLabel_20);
		}
		{
			firstDiscountTextField = new JTextField();
			firstDiscountTextField.setText("10");
			GridBagConstraints gbc_firstDiscountTextField = new GridBagConstraints();
			gbc_firstDiscountTextField.insets = new Insets(0, 0, 5, 5);
			gbc_firstDiscountTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_firstDiscountTextField.gridx = 1;
			gbc_firstDiscountTextField.gridy = 11;
			panel_1.add(firstDiscountTextField, gbc_firstDiscountTextField);
			firstDiscountTextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("提交航线信息");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("取消");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
		}
		fadc = new FlightAddDialogControl(this);
		fadc.init();
	}

}
