package com.restservices.app.dao.interfaces;

import com.restservices.app.domains.IpTable;

/**
 * Created by Priya on 28/4/18.
 */
public interface IpTableDao extends BaseDao<IpTable>{
    IpTable findNextInactiveIp();
}
