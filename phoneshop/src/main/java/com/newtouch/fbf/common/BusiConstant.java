package com.newtouch.fbf.common;
/**
 * 针对特定业务的常量
 * @author lm
 *
 */
public interface BusiConstant {
	/**
	 * 成功
	 */
	public final static String  STATUS_SUCCESS="1";
	/**
	 * 失败
	 */
	public final static String  STATUS_ERROR="0";
	
	/**
	 * 接口参数account 登录用户名
	 */
	public final static String  ACCOUNT_NAME="ACCOUNT_NAME";
	/**
	 * 接口参数 category 类型
	 */
	public final static String  JOBEDITOR="job_editor";
	public final static String  JOBMONITOR="job_monitor";
	/**
	 * 接口参数 导入 type类型
	 */
	public final static String JOBNET="job_net";
	/**
	 * 场景新增——顶级节点
	 */
	public final static String TOPNODE="3";
	
	
	/**
	 * 小类代码-场景库文件存储地址
	 */
	public final static String  LIBRARY_FILE_STORAGE="LIBRARY_FILE_STORAGE";
	/**
	 * 场景库导出时文件临时存放的地址
	 */
	public final static String  LIBRARY_FILE_TEMP="LIBRARY_FILE_TEMP";
	/**
	 * 大类代码-场景库文件存放地址组
	 */
	public final static String  LIBRARY_URL="LIBRARY_URL";
	
	
	/**
	 * 返回 page json key 
	 */
	public final static String PAGE="page";
	
	/**
	 * 消息
	 * @author guanhongwei
	 *
	 */
	public interface MSG {
		/**
		 * 操作成功
		 */
		final static String SUCCESS = "操作成功";
		
		/**
		 * 系统错误，请联系管理员
		 */
		final static String ERROR = "系统错误，请联系管理员";
	}
	
	/**
	 * 枚举值 key
	 * @author guanhongwei
	 *
	 */
	public interface ENUM_KEY {
		/**
		 * 场景类型
		 */
		final static String INSTANCE_TYPE = "instanceType";
		
		/**
		 * 场景参数类型
		 */
		final static String INSTANCE_PARAMS = "instanceParams";
		
		/**
		 * 作业类型
		 */
		final static String TASK_TYPE = "taskType";
		
		/**
		 * 作业注册状态
		 */
		final static String TASK_HAD_REGISTED = "taskHadRegisted";
		
		/**
		 * 场景审批状态
		 */
		final static String INSTANCE_AUDIT = "instanceAudit";
	}
	
	/**
	 * 场景库信息来源
	 * @author guanhongwei
	 *
	 */
	public interface LIBRARY_FROM {
		/**
		 * 本系统创建
		 */
		final static String LOCAL = "0";
		
		/**
		 * 脚本导入
		 */
		final static String SCRIPT = "1";
	}
}
