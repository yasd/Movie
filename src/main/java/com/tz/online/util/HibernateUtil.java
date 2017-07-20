package com.tz.online.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * ����������ȡHIbernate�е�Session�����Լ��ر�Session
 * @author Chris
 *
 * 2017��3��6������1:51:37
 */
public class HibernateUtil {

    private static SessionFactory sf;
    
    static {
        try {
            Configuration cfg = new Configuration().configure();
            ServiceRegistry sr = new StandardServiceRegistryBuilder()
                    .applySettings(cfg.getProperties()).build();
            sf = cfg.buildSessionFactory(sr);
        } catch(HibernateException hex) {
            hex.printStackTrace();
        }
    }
    
    /**
     * ���ݳ�ʼ����ɵĻỰ�������󷵻�һ���Ự����
     * @return �Ự����ʵ��Session
     */
    public static Session getSession() {
        return sf == null ? null : sf.openSession();
    }
    
    /**
     * �رմ���ĻỰ����
     * @param ses ��Ҫ�رյĻỰ����ʵ��
     */
    public static void close(Session ses) {
        try {
            if (ses != null) {
                ses.close();
            }
        } catch(HibernateException hex) {
            hex.printStackTrace();
        }
    }
    
}
