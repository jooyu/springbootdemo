package com.zy.test.util;

import java.lang.reflect.Field;

/**
 * Object工具类
 * @author gogo
 *
 */
public class ObjectUtils
{
	/**
	 * 重写toString方法 
	 * @param o 对象
	 * @return String
	 */
	public static String overwriteToString(Object o)
	{
		StringBuilder sb = new StringBuilder();
		overwriteToString(o, sb);
		return sb.toString();
	}

	private static void overwriteToString(Object o, StringBuilder sb)
	{

		if (o == null)
		{
			return;
		}

		Class<?> clazz = o.getClass();
		if (clazz.getName().indexOf("java.lang") == 0)
		{
			sb.append(o);
			sb.append(", ");
			return;
		}

		Field[] fields = clazz.getDeclaredFields();
		if (fields == null || fields.length == 0)
		{
			return;
		}

		sb.append(clazz.getName()).append("={");
		try
		{
			for (Field field : fields)
			{
				field.setAccessible(true);
				sb.append(field.getName()).append("=");
				if ('[' == field.getType().getName().charAt(0))
				{
					processArray(field, o, sb);
				}
				else
				{
					sb.append(field.get(o));
				}
				sb.append(", ");
			}
			sb.setLength(sb.length() - 2);
			sb.append("}");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void processArray(Field field, Object o, StringBuilder sb)
	        throws Exception
	{

		Object[] array = null;
		try
		{
			array = (Object[]) field.get(o);
		}
		catch(ClassCastException e)
		{
			processBasicDataArray(field,o,sb);
			return;
		}
		if (array == null)
		{
			return;
		}

		for (Object a : array)
		{
			overwriteToString(a, sb);
		}

	}
	
	private static void processBasicDataArray(Field field, Object o, StringBuilder sb) throws Exception
	{
		if('B' == field.getType().getName().charAt(1))
		{
			byte[] result =  (byte[]) field.get(o);
			for(byte i : result)
			{
				sb.append(i);
				sb.append(", ");
			}
			
		}
		else if('S' == field.getType().getName().charAt(1))
		{
			short[] result =  (short[]) field.get(o);
			for(short i : result)
			{
				sb.append(i);
				sb.append(", ");
			}
		}
		else if('I' == field.getType().getName().charAt(1))
		{
			int[] result =  (int[]) field.get(o);
			for(int i : result)
			{
				sb.append(i);
				sb.append(", ");
			}
		}
		else if('J' == field.getType().getName().charAt(1))
		{
			long[] result =  (long[]) field.get(o);
			for(long i : result)
			{
				sb.append(i);
				sb.append(", ");
			}
		}
		else if('F' == field.getType().getName().charAt(1))
		{
			float[] result =  (float[]) field.get(o);
			for(float i : result)
			{
				sb.append(i);
				sb.append(", ");
			}
		}
		else if('D' == field.getType().getName().charAt(1))
		{
			double[] result =  (double[]) field.get(o);
			for(double i : result)
			{
				sb.append(i);
				sb.append(", ");
			}
		}
		else if('C' == field.getType().getName().charAt(1))
		{
			char[] result =  (char[]) field.get(o);
			for(char i : result)
			{
				sb.append(i);
				sb.append(", ");
			}
		}
		else if('Z' == field.getType().getName().charAt(1))
		{
			boolean[] result =  (boolean[]) field.get(o);
			for(boolean i : result)
			{
				sb.append(i);
				sb.append(", ");
			}
		}
		sb.setLength(sb.length() - 2);
	}

//	public static void main(String[] args)
//	{
//		UserInfo info = new UserInfo();
//		info.setId(1);
//		info.setName("gogo1");
//
//		List<UserInfo> list = new ArrayList<UserInfo>();
//		UserInfo u1 = new UserInfo();
//		UserInfo u2 = new UserInfo();
//		u1.setId(11);
//		u1.setName("gogo1_name1");
//		u2.setId(12);
//		u2.setName("gogo1_name2");
//		list.add(u1);
//		list.add(u2);
//		info.setDescs(list);
//
//		String[] addresss = new String[]{ "gogo1_address1", "gogo1_address2" };
//		info.setAddresss(addresss);
//
//		int[] ages = new int[]{ 11, 12 };
//		info.setAges(ages);
//
//		Object[] others = new Object[]{ new Integer(111), new Double(22.22D),
//		        new String("gogo-other"), new UserInfo() };
//		info.setOthers(others);
//
//		System.out.println(info);
//
//	}

}
