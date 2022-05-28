package Demo;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.knowm.xchart.style.markers.SeriesMarkers;

import SQL.connection;
import javaManageTest.InfoSave;

import org.knowm.xchart.*;
import org.knowm.xchart.internal.style.SeriesColorMarkerLineStyle;

public class SaleChart {
	
	SaleChart(){
		JFrame window2 = new JFrame("연도 차트");
		
		
	}
	
	
	
	
	public static void main(String [] args) throws SQLException {
		
		List charts = new ArrayList<>();
		
		XYChart chart1 = new XYChartBuilder().xAxisTitle("월별").width(600).height(400).build();
		XYSeries series1 = chart1.addSeries("판매금액", null, getRandomWalk2(12));
		series1.setMarker(SeriesMarkers.NONE);
		charts.add(chart1);
		
		XYChart chart2 = new XYChartBuilder().xAxisTitle("월별").width(600).height(400).build();
		XYSeries series2 = chart2.addSeries("판매권수", getRandomWalk1(12));
		series2.setMarker(SeriesMarkers.NONE);
		series2.setLineColor(new Color(255,0,0));
		charts.add(chart2);
		
		new SwingWrapper(charts).displayChartMatrix();
	}
	
	
	//		판매 권수ㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜ
	private static int[] getRandomWalk1(int numPoints) throws SQLException {
		
		String years = InfoSave.getPublicyears();
		
		int [] y = {0,0,0,0,0,0,0,0,0,0,0,0};
		
		Connection con = connection.makeConnection();
		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		
		for(int i = 1 ; i <13 ; i ++) {
			sql = "select sum(counts) as cnt from sale group by months having months = " + i + ";";			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			y[i-1] = rs.getInt(1);
		}
		return y;
	}
	
	//		판매 금애ㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱ
	private static int[] getRandomWalk2(int numPoints) throws SQLException {
		
		String years = InfoSave.getPublicyears();
		
		int [] y = {0,0,0,0,0,0,0,0,0,0,0,0};
		
		Connection con = connection.makeConnection();
		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		
		for(int i = 1 ; i <13 ; i ++) {
			sql = "select sum(total) as cnt from sale group by months having months = " + i + ";";			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			y[i-1] = rs.getInt(1);
		}
		return y;
	}
}
