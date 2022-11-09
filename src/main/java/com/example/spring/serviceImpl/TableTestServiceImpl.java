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
     * @param sort       排序方式
     * @param quantity   排序方式
     * @return 列表
     */
    @Override
    public List<TableTest> getList(int start, int end, String searchName, String sort, String quantity) {
        return tableTestDao.getList(start, end, searchName, quantity, sort);
    }

    /**
     * 列表数量
     *
     * @param searchName 搜索条件
     * @param sort       排序方式
     * @param quantity   排序方式
     * @return 数量
     */
    @Override
    public int getListTotal(String searchName, String sort, String quantity) {
        return tableTestDao.getListTotal(searchName, quantity);

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
            tableTestDao.addTable(createIdTime(tableTest));
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
                createIdTime(l);
            }
            tableTestDao.volumeIncrease(tableTests);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 批量删除
     *
     * @param list id列表
     * @return 删除结果
     */
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

    /**
     * 新增数据时创建id和create_time
     *
     * @param t table信息
     * @return table信息
     */
    private TableTest createIdTime(TableTest t) {
        String s = UUID.randomUUID().toString();
        String id = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
        t.setId(id);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String creatTime = df.format(new Date());
        t.setCreateTime(creatTime);
        return t;
    }
}
