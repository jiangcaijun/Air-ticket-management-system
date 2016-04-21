package com.app.controller.flightControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.app.UI.Manager.FlightManager.FilghtAddDialog;
import com.app.UI.Manager.FlightManager.FlightPanel;
import com.app.UI.Manager.FlightManager.FlightUpdateDialog;
import com.app.UI.singleton.ManagerSingleton;
import com.app.bean.Flight;

public class FlightPanellControl extends FlightControlModel{
	
	private FlightPanel fp;

	private FilghtAddDialog fad ;
	
	private FlightUpdateDialog fud;
	
	public FlightPanellControl() {
		super();
	}

	public FlightPanellControl(FlightPanel fp){
		this.fp = fp;
	}
	
	public void init(){
		setModelType();
		setTable(model, null);
		fp.dtm = model;
		query();
		delete();
		add();
		update();
	}
	
	public void query(){
		fp.queryButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String flightId = fp.flightIdTextField.getText().trim();
				String company = fp.flightCompanyTextField.getText().trim();
				String originStation = fp.originStationTextField.getText().trim().toUpperCase();
				String terminalStation = fp.TerminalStationTextField.getText().trim().toUpperCase();
				Flight flight = new Flight();
				if(flightId.equals("")){
					flightId = null;
				}
				if(company.equals("")){
					company = null;
				}
				if(originStation.equals("")){
					originStation = null;
				}
				if(terminalStation.equals("")){
					terminalStation = null;
				}
				flight.setFlightId(flightId);
				flight.setFlightCompany(company);
				flight.setOriginStation(originStation);
				flight.setTerminalStation(terminalStation);
				Vector<Flight> ve = edi.queryFlight(flight);
				vv = new Vector<Vector<Object>>();
				vv = toVector(ve);
				setTable(model, vv);
				fp.dtm = model;
			}
		});
	}
	
	public void delete(){
		fp.deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] rows = fp.table.getSelectedRows();
				if(rows.length==0){
					JOptionPane.showMessageDialog(null, "请选定信息行");
				}else{
					int k = JOptionPane.showConfirmDialog(null, "确定删除？");
					if(k==0){
						int len = rows.length;
						Vector<Flight> e1 = new Vector<Flight>();
						for (int i = 0; i < len; i++) {
							Flight emp = new Flight();
							emp.setFlightId((String) fp.dtm.getValueAt(rows[i], 0));
							if(!e1.contains(emp)){
								e1.add(emp);
							}
						}
						edi.deleteFlight(e1);
						int size = fp.dtm.getRowCount();
						for (int i = size-1; i >= 0; i--) {
							for (int j = 0; j < len; j++) {
								if(i==rows[j]){
									fp.dtm.removeRow(i);
								}
							}
						}
					}
				}
			}
		});
	}
	
	public void add(){
		fp.addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fad = new FilghtAddDialog();
				fp.setEnabled(false);
				fad.setVisible(true);
			}
		});
	}
	
	public void update(){
		fp.updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] rows = fp.table.getSelectedRows();
				if(rows.length==0){
					JOptionPane.showMessageDialog(null, "请选定信息行");
				}else{
					int len = rows.length;
					Vector<Flight> e1 = new Vector<Flight>();
					vv = new Vector<Vector<Object>>();
					int column = fp.dtm.getColumnCount();
					for (int i = 0; i < len; i++) {
						Vector<Object> v = new Vector<Object>();
						for (int j = 0; j < column; j++){
							v.add(fp.dtm.getValueAt(rows[i], j));
						}
						vv.addElement(v);
					}
					e1 = toFlight(vv);
					ManagerSingleton.getInstance().setVf(e1);
					fud  = new FlightUpdateDialog();
					fp.setEnabled(false);
					fud.setVisible(true);
				}
			}
		});
	}
	
	public void setModelType(){
		model = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return getValueAt(0, columnIndex).getClass();
			}
		};
	}
}
