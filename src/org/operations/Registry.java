package org.operations;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.db.MyConnection;

public class Registry {

	public static void open() {
		MyConnection.getSession();
	}

	public static void close() {
		MyConnection.getSession().disconnect();
		MyConnection.getSessionFactory().close();
	}

	public static void updateGeneral() {
		open();
		updateSaleClientComboBox();
		updateSaleProductComboBox();
		close();
		System.err.println("Atualizacao concluida");
	}
	
	
	@SuppressWarnings("unchecked")
	public static void updateSaleClientComboBox() {
		Transaction tx = MyConnection.getSession().beginTransaction();

		SQLQuery query = MyConnection.getSession().createSQLQuery("select nome from clientes");

		List<Object[]> clientes = query.list();

		Iterator<Object[]> it = clientes.iterator();

		StringBuilder sql = new StringBuilder();

		sql.append("ALTER TABLE `vendas` CHANGE `cliente` `cliente` ENUM ( ' " + it.next() + " ' ");

		while (it.hasNext()) {
			sql.append(" , ' " + it.next() + " ' ");
		}

		sql.append(" ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL");

		MyConnection.getSession().createSQLQuery(sql.toString()).executeUpdate();

		tx.commit();
	}

	@SuppressWarnings("unchecked")
	public static void updateSaleProductComboBox() {
		Transaction tx = MyConnection.getSession().beginTransaction();

		SQLQuery query = MyConnection.getSession().createSQLQuery("select nome, descricao, tamanho from produtos");

		List<Object[]> clientes = query.list();

		Iterator<Object[]> it = clientes.iterator();

		StringBuilder sql = new StringBuilder();

		sql.append("ALTER TABLE `vendas` CHANGE `produto` `produto` ENUM ( ' "
				+ Arrays.toString(it.next()).replaceAll(",", "").replace("[", "").replace("]", "") + " ' ");

		while (it.hasNext()) {
			sql.append(
					" , ' " + Arrays.toString(it.next()).replaceAll(",", "").replace("[", "").replace("]", "") + " ' ");
		}

		sql.append(" ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL");

		MyConnection.getSession().createSQLQuery(sql.toString()).executeUpdate();

		tx.commit();
	}

}
