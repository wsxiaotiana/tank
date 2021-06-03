package com.mashibing.tank.col;

import com.mashibing.tank.GameObject;
import com.mashibing.tank.PropertyMgr;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 碰撞器责任链
 * @author: yanxiaotian
 * @create: 2021-06-04 06:32
 **/
public class ColliderChain implements Collider{
    private List<Collider> colliders= new LinkedList<>();

    public ColliderChain(){
        String colliderNames=(String)PropertyMgr.get("colliders");
        String[] namesArray=colliderNames.split(",");
        try {
            for (int i = 0; i < namesArray.length; i++) {
                Collider collider=(Collider) Class.forName(namesArray[i]).getDeclaredConstructor().newInstance();
                colliders.add(collider);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(Collider collider){
        this.add(collider);
    }

    public void remove(Collider collider){
        this.remove(collider);
    }
    @Override
    public void collide(GameObject o1,GameObject o2){
        for(int i=0;i<colliders.size();i++){
            colliders.get(i).collide(o1,o2);
        }
    }
}
