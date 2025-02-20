package com.app.service;

import java.util.Date;
import java.util.List;

import com.app.entity.ActivityBean;
import com.app.entity.TaskBean;
import com.app.entity.UserInfo;


public interface ActivityService {
	/**
	 * 通过任务id 获取所属的活动
	 * @param tid
	 * @return
	 */
	public List<ActivityBean> getActivity(int tid);
	/**
	 * 通过活动id 获取相应成员
	 * @param aid
	 * @return
	 */
	public List<UserInfo> getMembers(int aid);
	
	/**
	 * 给关键活动添加任务成员
	 * @param aid
	 * @param tid
	 * @param selectedUids
	 * @return
	 */
	public Boolean addMembers(int aid, int tid, List<String> selectedUids);

	/**
	 * 改变activity的状态
	 * @param aid
	 * @param state
	 * @return
	 */
	public Boolean setFinish(int aid,int state);
	
	/**
	 * 通过用户accid数组获取用户数组
	 * @param Uids
	 * @return
	 */
	public List<UserInfo> getUsers(List<String> Uids);
	 
}
