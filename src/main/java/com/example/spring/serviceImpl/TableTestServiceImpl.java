package com.example.spring.serviceImpl;

import com.example.spring.bean.TableTest;
import com.example.spring.dao.TableTestDao;
import com.example.spring.service.TableTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author TwinkleDing
 */
@Slf4j
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
     * @param start      起始页码
     * @param end        结束页码
     * @param searchName 搜索条件
     * @return 列表
     */
    @Override
    public List<TableTest> getList(int start, int end, String searchName) {
        String name = "%" + searchName + "%";
        return tableTestDao.getList(start, end, name);
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

    /**
     * 新增
     *
     * @param tableTest 添加的数据
     * @return 新增结果
     */
    @Override
    public boolean addTable(TableTest tableTest) {
        boolean flag = false;
        try {
            tableTestDao.addTable(createId(tableTest));
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 修改数据
     *
     * @param tableTest 修改数据
     * @return 修改结果
     */
    @Override
    public boolean updateTable(TableTest tableTest) {
        boolean flag = false;
        try {
            tableTestDao.updateTable(tableTest);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 批量新增
     *
     * @param tableTests 列表
     * @return 新增结果
     */
    @Override
    public boolean volumeInsertTable(List<TableTest> tableTests) {
        boolean flag = false;
        try {
            for (TableTest l : tableTests) {
                createId(l);
            }
            tableTestDao.volumeIncrease(tableTests);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean batchDelete(String[] list) {
        boolean flag = false;
        try {
            tableTestDao.batchDelete(list);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    private TableTest createId(TableTest t) {
        String s = UUID.randomUUID().toString();
        String id = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
        t.setId(id);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String creatTime = df.format(new Date());
        t.setCreateTime(creatTime);
        return t;
    }
}
