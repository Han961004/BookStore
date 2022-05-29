package chart;

import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.knowm.xchart.style.markers.SeriesMarkers;

import SQL.connection;
import javaManageTest.InfoSave;

import org.knowm.xchart.*;
import org.knowm.xchart.internal.style.SeriesColorMarkerLineStyle;

public class SaleChart extends JFrame{
	
	public SaleChart() throws SQLException {
		
		
		XYChart chart2 = new XYChartBuilder().xAxisTitle("����").width(600).height(400).build();
		XYSeries series2 = chart2.addSeries("�ǸűǼ�", getRandomWalk1(12));
		series2.setMarker(SeriesMarkers.DIAMOND);
		series2.setLineColor(new Color(255,0,0));
		
		
		XYChart chart1 = new XYChartBuilder().xAxisTitle("����").width(600).height(400).build();
		XYSeries series1 = chart1.addSeries("�Ǹűݾ�", getRandomWalk2(12));
		series1.setMarker(SeriesMarkers.DIAMOND);
		series1.setLineColor(new Color(0,255,0));
		
		
		
		JPanel panel1 = new XChartPanel(chart1);
		JPanel panel2 = new XChartPanel(chart2);
		JFrame f1 = new JFrame();
		JFrame f2 = new JFrame();
		
		f1.add(panel1);
		f1.pack();
		f1.setVisible(true);
		f1.setResizable(false);
		f2.add(panel2);
		f2.pack();
		f2.setVisible(true);
		f2.setResizable(false);
		
	}
	
	//		�Ǹ� �Ǽ��̤̤̤̤̤̤̤̤̤̤̤̤̤̤̤̤̤̤̤̤̤̤̤�
	private static int[] getRandomWalk1(int numPoints) throws SQLException {
		
		String years = InfoSave.getPublicyears();
		
		int []y = new int [12];
		
		Connection con = connection.makeConnection();
		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		
		for(int i = 1 ; i <13 ; i ++) {
			
			try {
				sql = "select sum(counts) from sale group by dates having month(dates) = "+ i + " and year(dates) = " + years + " ;";			
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				rs.next();
				
				y[i-1] = rs.getInt(1);
			
			} catch(Exception e) {
				y[i-1] = 0;
			}
		}
		return y;
	}
	
	//		�Ǹ� �ݾ֤�����������������������������������������������
	private static int[] getRandomWalk2(int numPoints) throws SQLException {
		
		String years = InfoSave.getPublicyears();
		
		int []y = new int [12];
		
		Connection con = connection.makeConnection();
		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		
		for(int i = 1 ; i <13 ; i ++) {
			
			try {
				sql = "select sum(total) from sale group by dates having month(dates) = "+ i + " and year(dates) = " + years + " ;";			
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				rs.next();
				
				y[i-1] = rs.getInt(1);
			
			} catch(Exception e) {
				y[i-1] = 0;
			}
		}
		return y;
	}
}
