package dao;

import java.util.HashSet;

/**
 * 由于 sqlite_master 表写保护，因此无法写入数据
 * @author future
 *
 */
public class SqliteMasterDao {
	public static final String C_TYPE 		= "type";
	public static final String C_NAME 		= "name";
	public static final String C_TBL_NAME 	= "tbl_name";
	public static final String C_ROOTPAGE 	= "rootpage";
	public static final String C_SQL 		= "sql";
	
	public static final String[] COLUMNS = {C_TYPE, C_NAME, C_TBL_NAME, C_ROOTPAGE, C_SQL};
	
	private String type = "";
	private String name = "";
	private String tbl_name = "";
	private int rootpage = 0;
	private String sql = "";
	
	public SqliteMasterDao(String type, String name, String tbl_name, int rootpage, String sql) {
		this.type = type;
		this.name = name;
		this.tbl_name = tbl_name;
		this.rootpage = rootpage;
		this.sql = sql;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * 返回该列的类型
	 * @param column
	 * @return
	 */
	public static String getColumnType(String column) {
		if( column == C_ROOTPAGE) {
			return "INTEGER";
		}
		return "TEXT";
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the tbl_name
	 */
	public String getTbl_name() {
		return tbl_name;
	}

	/**
	 * @return the rootpage
	 */
	public int getRootpage() {
		return rootpage;
	}

	/**
	 * @return the sql
	 */
	public String getSql() {
		return sql;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param tbl_name the tbl_name to set
	 */
	public void setTbl_name(String tbl_name) {
		this.tbl_name = tbl_name;
	}

	/**
	 * @param rootpage the rootpage to set
	 */
	public void setRootpage(int rootpage) {
		this.rootpage = rootpage;
	}

	/**
	 * @param sql the sql to set
	 */
	public void setSql(String sql) {
		this.sql = sql;
	}
	
	public static HashSet<SqliteMasterDao> getSetByType(HashSet<SqliteMasterDao> sm, String type) {
		HashSet<SqliteMasterDao> set = new HashSet<SqliteMasterDao>();
		for(SqliteMasterDao m : sm) {
			if(m.getType().toUpperCase().equals(type.toUpperCase())) {
				set.add(m);
			}
		}
		return set;
	}

}
