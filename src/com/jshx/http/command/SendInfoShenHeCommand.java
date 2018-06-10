package com.jshx.http.command;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.duanpf.http.comm.BaseResponse;
import com.duanpf.http.comm.Command;
import com.jshx.core.utils.SpringContextHolder;
import com.jshx.http.bean.SummaryBean;
import com.jshx.http.service.HttpService;
import com.jshx.module.admin.entity.User;
import com.jshx.module.admin.service.UserService;
import com.jshx.shjl.entity.CheckRecord;
import com.jshx.shjl.service.CheckRecordService;

public class SendInfoShenHeCommand implements Command{
	private HttpService httpService = (HttpService) SpringContextHolder.getBean("httpService");
	private CheckRecordService checkRecordService = (CheckRecordService) SpringContextHolder.getBean("checkRecordService");
	private UserService userService = (UserService) SpringContextHolder.getBean("userService");
	@SuppressWarnings("unchecked")
	@Override
	public BaseResponse execute(JSONObject obj) {
		SummaryBean bd = new  SummaryBean();
		String userId = obj.getString("userId");//用户id
		String Id = obj.getString("noticeId");//发文id
		String checkResult=obj.getString("checkResult");//审核结果
		String remark = obj.getString("remark");//备注
		User user = userService.findUserById(userId);
		String signName=user.getDisplayName();
		Date d=new Date();
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("id", Id);
		map.put("checkResult", checkResult);
		map.put("signName", signName);
		map.put("signTime", d);
		map.put("sqlID", "FwglFeedBackByMap");
		CheckRecord checkRecord = new CheckRecord();
		checkRecord.setCreateUserID(userId);
		checkRecord.setDelFlag(0);
		checkRecord.setCheckUserid(userId);
		checkRecord.setCheckResult(checkResult);
		checkRecord.setCheckRemark(remark);
		checkRecord.setInfoId(Id);
		checkRecord.setCheckUsername(user.getDisplayName());
		checkRecordService.save(checkRecord);
		try {	
			bd.setCode("0");
			bd.setMessage("审核成功!");
			JSONObject json = new JSONObject();
			bd.setContent(json.toString());
			httpService.updateMapByMap(map);//更新map 对象
		} catch (Exception e) {
			bd.setCode("1");
			bd.setMessage("审核失败!");
			e.printStackTrace();
		}
		return bd;
	}
}