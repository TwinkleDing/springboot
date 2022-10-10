package com.example.spring.serviceImpl;

import com.example.spring.bean.MenuRouter;
import com.example.spring.dao.MenuRouterDao;
import com.example.spring.service.MenuRouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuRouterServiceImpl implements MenuRouterService {
    @Autowired
    private MenuRouterDao menuRouterDao;

    @Override
    public List<MenuRouter> getRouterList() {
         return menuRouterDao.getRouterList();
    }
}
