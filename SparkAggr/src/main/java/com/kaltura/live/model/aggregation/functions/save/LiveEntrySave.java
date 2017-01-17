package com.borhan.live.model.aggregation.functions.save;

import com.borhan.live.infra.cache.SerializableSession;
import com.borhan.live.model.aggregation.dao.LiveEntryEventDAO;
import com.borhan.live.model.aggregation.dao.LiveEventDAO;

/**
 * Save function wrapping for Live entry
 */
public class LiveEntrySave extends LiveEventSave {
	
	private static final long serialVersionUID = 3189544783672808202L;
	
	private static final String TABLE_NAME = "borhan_live.live_events";
	
	public LiveEntrySave(SerializableSession session) {
		super(session);
	}
	
	@Override
	protected LiveEventDAO createLiveEventDAO() {
		return new LiveEntryEventDAO(TABLE_NAME, LiveEntryEventDAO.AGGR_TTL);
	}
}
