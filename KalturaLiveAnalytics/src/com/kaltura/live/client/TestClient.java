package com.borhan.live.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.borhan.live.webservice.LiveAnalytics;
import com.borhan.live.webservice.model.AnalyticsException;
import com.borhan.live.webservice.model.LiveEventsListResponse;
import com.borhan.live.webservice.model.LiveReportInputFilter;
import com.borhan.live.webservice.model.LiveReportPager;
import com.borhan.live.webservice.model.LiveReportType;

public class TestClient{
	
	private static final String HOST_NAME = "@HOST_NAME@";
	
	public static void main(String[] args) throws Exception {
	   
		URL url = new URL("http://" + HOST_NAME + "/BorhanLiveAnalytics/BorhanLiveAnalytics?wsdl");
        QName qname = new QName("http://webservice.live.borhan.com/", "LiveAnalyticsImplService");

        Service service = Service.create(url, qname);
        LiveAnalytics hello = service.getPort(LiveAnalytics.class);
        
        testTimeLine(hello);
    }
	
	private static void testTimeLine(LiveAnalytics hello) throws AnalyticsException {
		LiveReportType reportType = LiveReportType.ENTRY_TIME_LINE;
		LiveReportInputFilter filter = new LiveReportInputFilter();
		filter.setEntryIds("1_lcn2avg8");
		filter.setFromTime(1387100000);
		filter.setToTime(1387200000);
		
		LiveReportPager pager = new LiveReportPager();
		
		LiveEventsListResponse z = hello.getEvents(reportType, filter, pager);
		System.out.println(z.getTotalCount());
	}
	
}
