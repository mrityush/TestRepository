package com.restservices.app.dao.impl;

import com.restservices.app.dao.interfaces.IpTableDao;
import com.restservices.app.domains.IpTable;
import com.restservices.app.enums.EntityStatus;
import com.restservices.app.repositories.IpTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Calendar;

/**
 * Created by Priya on 28/4/18.
 */
@Repository
public class IpTableDaoImpl implements IpTableDao {
    @Autowired
    private IpTableRepository ipTableRepository;

    @Override
    public void save(IpTable ipTable) {
        ipTableRepository.save(ipTable);
    }

    @Override
    public void update(IpTable ipTable) {
        ipTable.setLastUpdated(Calendar.getInstance().getTime());
        ipTableRepository.save(ipTable);
    }

    @Override
    public IpTable get(Long id) {
        return ipTableRepository.findOne(id);
    }

    @Override
    public IpTable findNextInactiveIp() {
        return ipTableRepository.findByEntityStatus(EntityStatus.INACTIVE.getValue());
    }
}
