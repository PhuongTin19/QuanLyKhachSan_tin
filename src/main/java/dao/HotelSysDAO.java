/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author USUS
 */
public abstract class HotelSysDAO<E,K> {
   abstract public void insert(E entity);
   abstract public void update(E entity);
   abstract public void delete(K key);
   abstract public List<E> selectAll();
   abstract public E selectID(K key);
   abstract protected List<E> selectBySql(String sql,Object...args);
}
