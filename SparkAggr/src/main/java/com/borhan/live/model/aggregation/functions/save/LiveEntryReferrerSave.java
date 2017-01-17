package com.borhan.live.model.aggregation.functions.save;

import com.borhan.live.infra.cache.SerializableSession;
import com.borhan.live.model.aggregation.dao.LiveEntryReferrerEventDAO;
import com.borhan.live.model.aggregation.dao.LiveEventDAO;

public class LiveEntryReferrerSave extends LiveEventSave {
	
	private static final long serialVersionUID = -3895411924827872374L;
	
	public LiveEntryReferrerSave(SerializableSession session) {
		super(session);
	}
	
	@Override
	protected LiveEventDAO createLiveEventDAO() {
		return new LiveEntryReferrerEventDAO();
	}


}
