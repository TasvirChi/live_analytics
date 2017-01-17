package com.borhan.live.model.aggregation.functions.map;

import scala.Tuple2;

import com.borhan.live.infra.utils.DateUtils;
import com.borhan.live.model.aggregation.StatsEvent;
import com.borhan.live.model.aggregation.keys.EventKey;
import com.borhan.live.model.aggregation.keys.PartnerHourlyKey;

public class PartnerHourlyMap extends LiveEventMap {

	private static final long serialVersionUID = 1637851651266754171L;

	@Override
	public Tuple2<EventKey, StatsEvent> call(StatsEvent s) throws Exception {
		return new Tuple2<EventKey, StatsEvent>(new PartnerHourlyKey(s.getPartnerId(), DateUtils.roundHourDate(s.getEventTime())), s);
	}

}
