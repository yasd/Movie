package com.tz.online.DDL;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class DDLTest {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
//		Configuration cfg = new Configuration().configure("/config/hibernate.cfg.xml");
		SchemaExport export = new SchemaExport(cfg);
		//第一个true,表示是否在控制台上显示sql
		//第二个true,表示去执行DDL语句
		export.create(true, true);
	}
}
