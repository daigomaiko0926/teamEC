package com.internousdev.laravel.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.laravel.dao.UserInfoDAO;
import com.internousdev.laravel.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {
	private UserInfoDTO userInfoDTO = new UserInfoDTO();
	private Map<String, Object> session;

	public String execute() throws SQLException {

		UserInfoDAO userInfoDAO = new UserInfoDAO();

		// ログインしていなかったらログインエラー
		String tempLogined = String.valueOf(session.get("login_flg"));
		int logined = "null".equals(tempLogined) ? 0 : Integer.parseInt(tempLogined);

		if (logined != 1) {
			return "loginError";
		}

		// ユーザーIDに紐づくユーザー情報を取得
		userInfoDTO = userInfoDAO.getUserInfoId(session.get("user_id").toString());
		return SUCCESS;
	}

	public UserInfoDTO getUserInfoDTO() {
		return userInfoDTO;
	}

	public void setUserInfoDTO(UserInfoDTO userInfoDTO) {
		this.userInfoDTO = userInfoDTO;
	}

	public Map<String, Object> getSession() {
		return this.session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
