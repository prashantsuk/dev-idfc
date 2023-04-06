package com.edms.util;

import java.util.HashMap;
import java.util.Map;

public class Constants {
	
	public static final String EXP_400="EXP_400";
	public static final String EXP_415="EXP_415";
	public static final String EXP_404="EXP_404";
	public static final String EXP_405="EXP_405";
	public static final String EXP_503="EXP_503";
	public static final String EXP_500="EXP_500";
	public static final String EXP_504="EXP_504";
	
	public static final String SYS_400="SYS_400";
	public static final String SYS_415="SYS_415";
	public static final String SYS_404="SYS_404";
	public static final String SYS_405="SYS_405";
	public static final String SYS_503="SYS_503";
	public static final String SYS_500="SYS_500";
	public static final String SYS_504="SYS_504";
	
	
	protected static final Map<String, String> errorDef=new HashMap<>();
	
	static {
		errorDef.put(EXP_400, "Bad Request");
		errorDef.put(SYS_400, "Bad Request");
		errorDef.put(EXP_404, "Resource not found");
		errorDef.put(SYS_404, "Resource not found");
		errorDef.put(EXP_415, "Unsupported Media type");
		errorDef.put(SYS_415, "Unsupported Media type");
		errorDef.put(EXP_405, "Method not allowed");
		errorDef.put(SYS_405, "Method not allowed");
		errorDef.put(EXP_503, "Connectivity Error");
		errorDef.put(SYS_503, "Connectivity Error");
		errorDef.put(EXP_500, "Internal Server error");
		errorDef.put(SYS_500, "Internal Server error");
		errorDef.put(EXP_504, "HTTP Request timeout");
		errorDef.put(SYS_504, "HTTP Request timeout");
	}
	
	public static final String UPLOAD_SUCCESS="Keep DocumentIndex,IsIndex and FolderIndex for future reference.";
	
	public static final String ADD_FOLDER_SUCCESS="Folder added successfully. Keep FolderIndex for future reference.";
	
	public static final String OK="OK";
	
	public static final String ERROR="ERROR";
	
	public static final String SUCCESS="Success";
	
	public static final String FAIL="FAIL";
	
	public static final String FILE_NOT_EXISTS="File not exists";
	
	public static final String VERSION="1.0.0";
	
	public static final String REPLY="Reply";
	
	public static final String EXCEPTION_OCCURED="Exception occured: {}";
	
	public static final String VIEW_DOC="viewDoc";
	
	public static final String DOC_MGMT="doc-mgmt";
	
}
