package com.borhan.live.model.aggregation.functions.save;

import com.borhan.live.infra.cache.SerializableSession;
import com.borhan.live.model.aggregation.dao.LiveEntryEventDAO;
import com.borhan.live.model.aggregation.dao.LiveEventDAO;
import com.borhan.live.model.aggregation.dao.PartnerEventDAO;

public class PartnerHourlySave extends LiveEventSave {

	private static final long serialVersionUID = 5230447429205620876L;
	
	private static final String TABLE_NAME = "borhan_live.hourly_live_events_partner";
	
	public PartnerHourlySave(SerializableSession session) {
		super(session);
	}

	@Override
	protected LiveEventDAO createLiveEventDAO() {
		return new PartnerEventDAO(TABLE_NAME, PartnerEventDAO.HOURLY_AGGR_TTL);
	}

}
