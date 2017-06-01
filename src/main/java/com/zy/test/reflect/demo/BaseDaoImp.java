//package com.zy.test.reflect.demo;
//
//import java.lang.reflect.ParameterizedType;
//import java.sql.ResultSet;
//
//import com.mysql.jdbc.PreparedStatement;
//
//public class BaseDaoImp<T> implements BaseDao<T>
//{
//
//	
//	 /** 操作常量 */
//    public static final String SQL_INSERT = "insert";
//    public static final String SQL_UPDATE = "update";
//    public static final String SQL_DELETE = "delete";
//    public static final String SQL_SELECT = "select";
//
//    private Class<T> EntityClass; // 获取实体类
//
//    private PreparedStatement statement;
//
//    private String sql;          
//
//    private Object argType[];
//
//    private ResultSet rs;
//
//    @SuppressWarnings("unchecked")
//    public BaseDaoImp() {
//        
//        /**
//         *  传递User就是 com.example.daoimp.BaseDaoImp<com.example.bean.User>
//         *  传递Shop就是 com.example.daoimp.BaseDaoImp<com.example.bean.Shop>
//         * */
//        ParameterizedType type = (ParameterizedType) getClass()
//                .getGenericSuperclass();      
//        
//        /**
//         * 这里如果传递的是User.那么就是class com.example.bean.User 
//         * 如果传递的是Shop.       那么就是class com.example.bean.Shop
//         * */
//        EntityClass = (Class<T>) type.getActualTypeArguments()[0];  
//    }
//
//	@Override
//	public void add(T t) {
//		 sql = this.getSql(SQL_INSERT);   //获取sql.
//	        // 赋值.
//	        try {
//	            argType = setArgs(t, SQL_INSERT);
//	            statement = JdbcDaoHelper.getPreparedStatement(sql);  //实例化PreparedStatement.
//	            //为sql语句赋值.
//	            statement = JdbcDaoHelper.setPreparedStatementParam(statement,
//	                    argType);
//	            statement.executeUpdate(); //执行语句.
//	        } catch (Exception e) {
//	            // TODO Auto-generated catch block
//	            e.printStackTrace();
//	        } finally {
//	            JdbcDaoHelper.release(statement, null);  //释放资源.
//	        }
//		
//	}
//
//	@Override
//	public void delete(T t) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void update(T t) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public T select(T t) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	
//	
//}
