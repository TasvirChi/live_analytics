package com.borhan.Live.infra

import com.datastax.driver.core.{ConsistencyLevel, QueryOptions, Cluster}
import com.borhan.Live.model.Consts

/**
 * Created by didi on 3/24/15.
 */
object SerializedSession extends Serializable
{
     val cluster = Cluster.builder().addContactPoint(ConfigurationManager.get("cassandra.node_name")).withQueryOptions(new QueryOptions().setConsistencyLevel(ConsistencyLevel.QUORUM)).build()
     val session = cluster.connect(Consts.BorhanKeySpace)
}
