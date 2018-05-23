package com.restservices.app.repositories;

import com.restservices.app.domains.IpTable;
import com.restservices.app.enums.EntityStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Priya on 28/4/18.
 */
public interface IpTableRepository extends CrudRepository<IpTable, Long> {
    @Query(value = "select * from ip_table where status = :entityStatus limit 1", nativeQuery = true)
    IpTable findByEntityStatus(@Param("entityStatus") Integer entityStatus);
}
