package com.example.spring.utils;

import com.example.spring.bean.MenuRouter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class ZoneUtils {
    public static List<MenuRouter> buildTree1(List<MenuRouter> menuList) {
        List<MenuRouter> resultList = new ArrayList<>();
        for (MenuRouter menuRouter : menuList) {
            if (menuRouter.getParentId().equals("0")) {
                resultList.add(menuRouter);
                setChildren(menuList, menuRouter);
            }
        }
        return resultList;
    }

    public static List<MenuRouter> buildTree2(List<MenuRouter> menuList) {
        List<MenuRouter> resultList = new ArrayList<>();
        for (MenuRouter menuRouter : menuList) {
            if (menuRouter.getParentId().equals("0")) {
                resultList.add(menuRouter);
            }
            for (MenuRouter child : menuList) {
                if (child.getParentId().equals(menuRouter.getMenuId())) {
                    List<MenuRouter> children = menuRouter.getChildren();
                    if (children == null) {
                        children = new ArrayList<>();
                        menuRouter.setChildren(children);
                    }
                    children.add(child);
                }
            }
        }
        return resultList;
    }

    public static List<MenuRouter> buildTree3(List<MenuRouter> menuList) {
        Map<String, List<MenuRouter>> routerMap = new HashMap<>();
        menuList.forEach(menuRouter -> {
            List<MenuRouter> children = routerMap.getOrDefault(menuRouter.getParentId(), new ArrayList<>());
            children.add(menuRouter);
            routerMap.put(menuRouter.getParentId(), children);
        });
        menuList.forEach(menuRouter -> {
            menuRouter.setChildren(routerMap.get(menuRouter.getMenuId()));
        });
        return menuList.stream().filter(v -> v.getParentId().equals("0")).collect(Collectors.toList());
    }

    public static List<MenuRouter> buildTree4(List<MenuRouter> menuList) {
        Map<String, List<MenuRouter>> routerMap = menuList.stream().collect(Collectors.groupingBy(MenuRouter::getParentId));
        menuList.forEach(menuRouter -> {
            menuRouter.setChildren(routerMap.get(menuRouter.getMenuId()));
        });
        return menuList.stream().filter(v -> v.getParentId().equals("0")).collect(Collectors.toList());
    }

    private static void setChildren(List<MenuRouter> list, MenuRouter parent) {
        for (MenuRouter menuRouter : list) {
            if (parent.getMenuId().equals(menuRouter.getParentId())) {
                log.info("555555555555");

                List<MenuRouter> children = parent.getChildren();
                log.info(String.valueOf(children == null));
                log.info("123123123123");
                if (children == null) {
                    children = new ArrayList<>();
                    parent.setChildren(children);
                }
                children.add(menuRouter);
            }
            if (parent.getChildren() == null || parent.getChildren().isEmpty()) {
                return;
            }
            for (MenuRouter menu : parent.getChildren()) {
                setChildren(list, menu);
            }
        }
    }
}
