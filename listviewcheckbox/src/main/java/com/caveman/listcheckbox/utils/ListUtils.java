package com.caveman.listcheckbox.utils;

import com.caveman.listcheckbox.bean.Node;
import com.caveman.listcheckbox.bean.NodeData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/10/22.
 * <p>
 * Description:
 */
public class ListUtils<T> {


    public static ListUtils getInstance(){
        return SingletonHolder.sInstance;
    }

    private ListUtils(){}
    private static class SingletonHolder{
        private static ListUtils sInstance = new ListUtils();
    }

    public List<Node> toListObject(List<T> list){
        Gson gson = new Gson();
        String listJson = gson.toJson(list);
        List<Node> nodes = gson.fromJson(listJson, new TypeToken<List<Node>>(){}.getType());
        return nodes;
    }

    public List<T> toListT(List<Node> nodes){
        Gson gson = new Gson();
        String nodeJson = gson.toJson(nodes);
        List<T> t = gson.fromJson(nodeJson, new TypeToken<List<T>>(){}.getType());
        return t;
    }

}
