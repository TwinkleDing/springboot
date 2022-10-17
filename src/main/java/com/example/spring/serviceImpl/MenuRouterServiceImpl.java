package com.example.spring.serviceImpl;

import com.example.spring.bean.MenuRouter;
import com.example.spring.dao.MenuRouterDao;
import com.example.spring.service.MenuRouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TwinkleDing
 */
@Service
public class MenuRouterServiceImpl implements MenuRouterService {

    private MenuRouterDao menuRouterDao = null;

    @Autowired
    public void menuRouterController(MenuRouterDao menuRouterDao) {
        this.menuRouterDao = menuRouterDao;
    }

    /**
     * 获取路由列表
     *
     * @return 路由列表
     */
    @Override
    public List<MenuRouter> getRouterList() {
        return menuRouterDao.getRouterList();
    }
}
