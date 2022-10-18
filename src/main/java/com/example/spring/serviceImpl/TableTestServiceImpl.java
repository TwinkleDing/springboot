package com.example.spring.serviceImpl;

import com.example.spring.bean.TableTest;
import com.example.spring.dao.TableTestDao;
import com.example.spring.service.TableTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author TwinkleDing
 */
@Service
public class TableTestServiceImpl implements TableTestService {

    private TableTestDao tableTestDao = null;

    @Autowired
    public void tableTestController(TableTestDao tableTestDao) {
        this.tableTestDao = tableTestDao;
    }

    /**
     * 列表
     *
     * @param start 起始页码
     * @param end   结束页码
     * @return 列表
     */
    @Override
    public List<TableTest> getList(int start, int end) {
        return tableTestDao.getList(start, end);
    }

    /**
     * 列表数量
     *
     * @return 数量
     */
    @Override
    public int getListTotal() {
        return tableTestDao.getListTotal();
    }
}
