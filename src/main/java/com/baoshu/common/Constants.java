package com.baoshu.common;

public class Constants {

	public static final String TAG_FUNCTION = "Function";//指令类型
	public static final String TAG_FLAG = "Flag";//交易类型
	public static final String TAG_FUNDID = "Fundid";//资金账户
	public static final String TAG_CHILSFUNDID = "ChildFundid";//子账户
	public static final String TAG_STKCODE = "StkCode";//证券代码
	public static final String TAG_QTY = "Qty";//委托数量
	public static final String TAG_PRICE = "Price";//交易价格
	public static final String TAG_MARKET = "Market";//市场代码
	public static final String TAG_QSFLAG = "QSFlag";//券商标志
	public static final String TAG_LSNO = "LSno";//委托编号
	public static final String TAG_DIVIDEORDERNO = "DivideOrderno";//拆单编号
	public static final String TAG_REQUESTID = "RequsetID";//请求ID
	//活动类型：JY：交易CX：查询
	public static final String FUNCTION_TYPE_JY = "JY";
	public static final String FUNCTION_TYPE_CX = "CX1";
	//交易类型:S:卖出，B：买入，CD：撤单
	public static final String FLAG_S = "S";
	public static final String FLAG_B = "B";
	public static final String FLAG_CD = "CD";
	
	//交易返回的结果
	public static final String RESULT_OK = "OK";
	public static final String RESULT_ERROR = "ERROR";
}
