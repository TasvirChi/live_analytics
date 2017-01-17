package com.borhan.live.webservice.reporters;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.borhan.live.infra.cache.SerializableSession;
import com.borhan.live.infra.utils.LiveConfiguration;
import com.borhan.live.model.aggregation.dao.LivePartnerEntryDAO;
import com.borhan.live.webservice.model.LiveEntriesListResponse;

public class LivePartnerEntryService {

	protected static Logger logger = LoggerFactory.getLogger(LivePartnerEntryService.class);
	protected static SerializableSession session;
	
	public LivePartnerEntryService() {
		session = new SerializableSession(LiveConfiguration.instance().getCassandraNodeName());
	}

	public LiveEntriesListResponse getLiveEntries(Integer partnerId) {
		
		String query = "select * from borhan_live.live_partner_entry where partner_id = " + partnerId + ";";
		logger.debug(query);
		ResultSet results = session.getSession().execute(query);
        Date dateBefore36Hours = new Date(new Date().getTime() - 36 * 3600 * 1000L);
		List<String> result = new ArrayList<>();
		Iterator<Row> itr = results.iterator();
		while (itr.hasNext()) {
			LivePartnerEntryDAO dao = new LivePartnerEntryDAO(itr.next());
            if (dao.getEventTime().after(dateBefore36Hours)){
                result.add(dao.getEntryId());
            }
		}
		
		return new LiveEntriesListResponse(result);
	}

}
