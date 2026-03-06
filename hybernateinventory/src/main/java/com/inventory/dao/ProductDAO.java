package com.inventory.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

public class ProductDAO {

public void saveProduct(Product p){

Session s = HibernateUtil.getSessionFactory().openSession();
Transaction tx = s.beginTransaction();

s.save(p);

tx.commit();
s.close();
}

public Product getProduct(int id){

Session s = HibernateUtil.getSessionFactory().openSession();

Product p = s.get(Product.class,id);

s.close();
return p;
}

public void updateProduct(int id,double price,int quantity){

Session s = HibernateUtil.getSessionFactory().openSession();
Transaction tx = s.beginTransaction();

Product p = s.get(Product.class,id);

p.setPrice(price);
p.setQuantity(quantity);

s.update(p);

tx.commit();
s.close();
}

public void deleteProduct(int id){

Session s = HibernateUtil.getSessionFactory().openSession();
Transaction tx = s.beginTransaction();

Product p = s.get(Product.class,id);

s.delete(p);

tx.commit();
s.close();
}

}