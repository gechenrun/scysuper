package com.jshx.mxbz.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.struts2.ServletActionContext;
import org.hibernate.LobHelper;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import com.jshx.core.base.action.BaseAction;
import com.jshx.core.base.vo.Pagination;
import com.jshx.core.exception.BasalException;
import com.jshx.core.utils.Constants;
import com.jshx.core.utils.Struts2Util;
import com.jshx.map.service.TbMapService;
import com.jshx.module.admin.entity.Department;
import com.jshx.module.admin.entity.User;
import com.jshx.module.admin.entity.UserRight;
import com.jshx.module.admin.service.CodeService;
import com.jshx.module.admin.service.UserService;
import com.jshx.module.form.service.AttachfileService;
import com.jshx.core.json.CodeJsonValueProcessor;
import com.jshx.core.json.DateJsonValueProcessor;
import com.jshx.http.service.HttpService;
import com.jshx.mxbz.entity.Signs;
import com.jshx.mxbz.service.SignsService;
import com.jshx.photoPic.entity.PhotoPic;
import com.jshx.photoPic.service.PhotoPicService;
import com.jshx.qyjbxx.entity.EntBaseInfo;
import com.jshx.qyjbxx.service.EntBaseInfoService;
import com.jshx.tzzyry.entity.SpeJobPer;

public class SignsAction extends BaseAction
{

	/**
	 * 主键ID列表，用于接收页面提交的多条主键ID信息
	 */
	private String ids;

	/**
	 * 实体类
	 */
	private Signs signs = new Signs();

	/**
	 * 业务类
	 */
	@Autowired
	private SignsService signsService;
	
	@Autowired
	private EntBaseInfoService entBaseInfoService;
	@Autowired
	private CodeService codeService;
	@Autowired
	private HttpService httpService;
	@Autowired
	private TbMapService tbMapService;
	@Autowired
	private PhotoPicService photoPicService;
   
	private String companyCode;//企业的组织机构代码 lj 2015-11-17

	/**
	 * 修改新增标记，add为新增、mod为修改
	 */
	private String flag;

	/**
	 * 分页信息
	 */
	private Pagination pagination;
	
	private String roleName;
	
	private File userFile;
	private String message;
	
	private List<PhotoPic> picList = new ArrayList<PhotoPic>();
	private int pageNo;
	private int pageSize;
	private String searchLike;
	@Autowired
	private UserService userService;
	
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getSearchLike() {
		return searchLike;
	}
	public void setSearchLike(String searchLike) {
		this.searchLike = searchLike;
	}
	@Autowired()
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	public String init(){
		//判断登录人的角色 
		List<UserRight> list =  (List<UserRight>) this.getLoginUser().getUserRoles();
		for(UserRight ur:list)
		{
			
			if(ur.getRole().getRoleCode().equals("A23")) 
			{
				roleName = "0";
				break;
			}
		}
		return SUCCESS;
	}
	
	/**
	 * 执行查询的方法，返回json数据
	 */
	public void list() throws Exception{
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap=httpService.addParamByRole(paraMap,this.getLoginUser().getId(), this.getLoginUser().getDeptCode());
		String userId=this.getLoginUser().getId();
		if(httpService.judgeRoleCode(userId, "A23")){
			paraMap.put("createUserId", userId);
		}
		if(pagination==null)
		    pagination = new Pagination(this.getRequest());
		    
		if(null != signs){
		    //设置查询条件，开发人员可以在此增加过滤条件
			if ((null != signs.getAreaId()) && (0 < signs.getAreaId().trim().length())){
				paraMap.put("areaId", signs.getAreaId().trim());
			}

			if ((null != signs.getCompanyName()) && (0 < signs.getCompanyName().trim().length())){
				paraMap.put("companyName", "%" + signs.getCompanyName().trim() + "%");
			}

			if ((null != signs.getSignsNo()) && (0 < signs.getSignsNo().trim().length())){
				paraMap.put("signsNo", "%" + signs.getSignsNo().trim() + "%");
			}

			if ((null != signs.getSignsName()) && (0 < signs.getSignsName().trim().length())){
				paraMap.put("signsName", "%" + signs.getSignsName().trim() + "%");
			}

			if ((null != signs.getSignsType()) && (0 < signs.getSignsType().trim().length())){
				paraMap.put("signsType", signs.getSignsType().trim());
			}

		}
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(java.util.Date.class,new DateJsonValueProcessor());  
		Map<String, String> codeMap = new HashMap<String, String>();
		//此处添加需要转换的一维代码，key是一维代码在数据对象中的属性名，value是一维代码的codeId

		config.registerJsonValueProcessor(String.class,new CodeJsonValueProcessor(codeMap)); 
		final String filter = "id|signsType|areaName|companyName|signsNo|signsName|";
		if (filter != null && filter.length() > 1) {
			config.setJsonPropertyFilter(new PropertyFilter() {
				public boolean apply(Object source, String name, Object value) {
					if (filter.indexOf(name + "|") != -1)
						return false;
					else
						return true;
				}
			});
		}
		pagination = signsService.findByPage(pagination, paraMap);
		
		convObjectToJson(pagination, config);
	}

	/**
	 * 查看详细信息
	 */
	public String view() throws Exception{
		if((null != signs)&&(null != signs.getId())){
			signs = signsService.getById(signs.getId());
			if(signs.getMapkey() == null || "".equals(signs.getMapkey()))
			{
				String mapKey = java.util.UUID.randomUUID().toString();
				signs.setMapkey(mapKey);
			}
			else
			{
				try {
					Map map = new HashMap();
					map.put("linkId",signs.getMapkey());
					map.put("mkType", "aqbs");
					map.put("picType","aqbsfj");
					picList = photoPicService.findPicPath(map);//获取执法文书材料
				} catch (Exception e) {
						// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else{
			String mapKey = java.util.UUID.randomUUID().toString();
			signs.setMapkey(mapKey);
		}
		return VIEW;
	}

	/**
	 * 初始化修改信息
	 */
	public String initEdit() throws Exception{
		view();
	    return EDIT;
	}

	/**
	 * 保存信息（包括新增和修改）
	 */
	public String save() throws Exception{
		FileInputStream in = null;
		try
		{
			//设置Blob字段
			setBlobField(in);
		}
		finally
		{
			if (null != in)
			{
				try
				{
					in.close();
				}
				catch (Exception ex)
				{
				}
			}
		}		
		Map map = new HashMap();
		map.put("loginId", this.getLoginUser().getLoginId());
		EntBaseInfo enBaseInfo = entBaseInfoService.findEntBaseInfoByMap(map);
		signs.setAreaId(enBaseInfo.getEnterprisePossession());
		Map m = new HashMap();
		m.put("codeName", "企业属地");
		m.put("itemValue", enBaseInfo.getEnterprisePossession());
		signs.setAreaName(codeService.findCodeValueByMap(m).getItemText());
		signs.setCompanyId(enBaseInfo.getId());
		signs.setCompanyName(enBaseInfo.getEnterpriseName());
		if ("add".equalsIgnoreCase(this.flag)){
			signs.setDeptId(this.getLoginUserDepartmentId());
			signs.setDelFlag(0);

			signsService.save(signs);
		}else{
			signsService.update(signs);
		}
		
		return RELOAD;
	}

	/**
	 * 将File对象转换为Blob对象，并设置到实体类中
	 * 如果没有File对象，可删除此方法，并一并删除save方法中调用此方法的代码
	 */
	private void setBlobField(FileInputStream in)
	{
		if (null != signs)
		{
			try
			{
				//此处将File对象转换成blob对象，并设置到signs中去
				
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

	/**
	 * 删除信息
	 */
	public String delete() throws Exception{
	    try{
			signsService.deleteWithFlag(ids);
			this.getResponse().getWriter().println("{\"result\":true}");
		}catch(Exception e){
			this.getResponse().getWriter().println("{\"result\":false}");
		}
		return null;
	}
	
	
	
	public String zwtInit(){
			
//			String url="http://172.25.127.9/services/authorization/validateredirect";
//	    	Map<String,String> dataMap = new HashMap<String,String>();
//	        dataMap.put("token", "2dbe362a536d4311931a7ea22b4b2095");
//	        dataMap.put("appId", "1DBE552B23D440128A12BA5D6ECE72B2");
//	        JSONObject j=HttpRequestUtils.httpPost(url,JSONObject.fromObject(dataMap));
//	        if("200".equals(j.get("code").toString())){
//	        	String loginName=j.get("username").toString();
//	        	User u=userService.findUserByLoginId(loginName);
//				setSessionAttribute("curr_user", u);
//	        	ids=u.getId();
//	        	String deptCode =u.getDeptCode();
//	    		if(httpService.judgeRoleCode(ids, "A17")){
//	    			userType="1";
//	    		}else if(httpService.judgeRoleCode(ids, "A12")){//此处修改为安监中队队员才可以上报整改信息 lj 2015-12-14
//	    			userType= "2";
//	    		}else if(httpService.judgeRoleCode(ids, "A11")){
//	    			userType= "3";
//	    		}else if(httpService.judgeRoleCode(ids, "A09")){
//	    			userType= "4";
//	    		}else if(httpService.judgeRoleCode(ids, "A02")){
//	    			userType= "5";
//	    		}else if(deptCode.startsWith("002")&&deptCode.length()==6&&!"002001".equals(deptCode)){
//	    			userType= "6";
//	    		}else{
//	    			userType= "7";
//	    		}
//	        	return SUCCESS;
//	        }else{
//	        	return ERROR;
//	        }
			User user=userService.findUserByLoginId("zdz1");
			setSessionAttribute("curr_user", user);
			String userId=user.getId();
			if(httpService.judgeRoleCode(userId, "A23")){
				roleName = "0";
			}
			return SUCCESS;
		}

	    public String mxbz(){
	    	return SUCCESS;
	    }

		public void zwtList() throws Exception{
			Map<String, Object> paraMap = new HashMap<String, Object>();
			paraMap=httpService.addParamByRole(paraMap,this.getLoginUser().getId(), this.getLoginUser().getDeptCode());
			String userId=this.getLoginUser().getId();
			if(httpService.judgeRoleCode(userId, "A23")){
				paraMap.put("createUserId", userId);
			}
			if(pagination==null)
			    pagination = new Pagination(this.getRequest());
			    
			if(null != signs){
			    //设置查询条件，开发人员可以在此增加过滤条件
				if ((null != signs.getAreaId()) && (0 < signs.getAreaId().trim().length())){
					paraMap.put("areaId", signs.getAreaId().trim() );
				}

				if ((null != signs.getCompanyName()) && (0 < signs.getCompanyName().trim().length())){
					paraMap.put("companyName", "%" + signs.getCompanyName().trim() + "%");
				}

				if ((null != signs.getSignsNo()) && (0 < signs.getSignsNo().trim().length())){
					paraMap.put("signsNo", "%" + signs.getSignsNo().trim() + "%");
				}

				if ((null != signs.getSignsName()) && (0 < signs.getSignsName().trim().length())){
					paraMap.put("signsName", "%" + signs.getSignsName().trim() + "%");
				}

				if ((null != signs.getSignsType()) && (0 < signs.getSignsType().trim().length())){
					paraMap.put("signsType", signs.getSignsType().trim());
				}

			}
			JsonConfig config = new JsonConfig();
			config.registerJsonValueProcessor(java.util.Date.class,new DateJsonValueProcessor());  
			Map<String, String> codeMap = new HashMap<String, String>();
			//此处添加需要转换的一维代码，key是一维代码在数据对象中的属性名，value是一维代码的codeId

			config.registerJsonValueProcessor(String.class,new CodeJsonValueProcessor(codeMap)); 
			final String filter = "id|signsType|areaName|companyName|signsNo|signsName|";
			if (filter != null && filter.length() > 1) {
				config.setJsonPropertyFilter(new PropertyFilter() {
					public boolean apply(Object source, String name, Object value) {
						if (filter.indexOf(name + "|") != -1)
							return false;
						else
							return true;
					}
				});
			}
			
			
			if(null!=searchLike&&!"".equals(searchLike)){
				paraMap.put("companyName", "%" + searchLike.trim() + "%");
			}
			pagination.setPageNumber(pageNo);
			pagination.setPageSize(pageSize);
			pagination = signsService.findByPage(pagination, paraMap);
			
			JSONObject json=new JSONObject();
			JSONArray ja = JSONArray.fromObject(pagination.getListOfObject(),
					config);
			json.put("result", ja);
			json.put("count", pagination.getTotalCount());
			int totalPage;
			totalPage = (pagination.getTotalCount()%pageSize==0?pagination.getTotalCount()/pageSize:(pagination.getTotalCount()/pageSize+1));
			json.put("totalPage", totalPage);
			json.put("pageNo", pageNo);
			try {
				this.getResponse().getWriter().println(json.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	public String getIds(){
		return ids;
	}

	public void setIds(String ids){
		this.ids = ids;
	}

	public Pagination getPagination(){
		return pagination;
	}

	public void setPagination(Pagination pagination){
		this.pagination = pagination;
	}

	public Signs getSigns(){
		return this.signs;
	}

	public void setSigns(Signs signs){
		this.signs = signs;
	}

	public String getFlag(){
		return flag;
	}

    public void setFlag(String flag){
        this.flag = flag;
    }

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public File getUserFile() {
		return userFile;
	}

	public void setUserFile(File userFile) {
		this.userFile = userFile;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<PhotoPic> getPicList() {
		return picList;
	}

	public void setPicList(List<PhotoPic> picList) {
		this.picList = picList;
	}
       
    
}
