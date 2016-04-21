package com.app.UI.Manager.Query;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartPanel;

import com.app.UI.chart.PieChart;

import java.awt.BorderLayout;

public class ChartPanelForFlight extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ChartPanelForFlight() {
		setLayout(new BorderLayout(0, 0));
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// 创建图形
				ChartPanel chartPanel = new PieChart().createChart();
				add(chartPanel);
				setVisible(true);
			}
		});
		
	}

}
