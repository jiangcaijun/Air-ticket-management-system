package com.app.UI.operator;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartPanel;

import com.app.UI.chart.LineChart;

public class OperatorPanelLineChart extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public OperatorPanelLineChart() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// ����ͼ��
				ChartPanel chartPanel = new LineChart().createChart();
				add(chartPanel);
				setVisible(true);
			}
		});
	}

}
