package com.internousdev.laravel.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute() {

		// sessionからユーザーID保存フラグを取得する。
		// session.clearする。

		// ログイン認証の際、ID保存チェックが有だった場合は、ユーザーIDとID保存チェックを
		// DB以外の保存領域に保持しないといけないため、
		// sessionから取得した"user_id"をString型userIdに、
		// "saved_user_id"をString型str_savedUserIdに代入、退避しておく。

		// str_savedUserIdのチェックが空ならfalseを返す。
		// チェックが有ならstr_savedUserIdの値、trueを返す。
		// boolean型savedUserIdに代入。

		String userId = String.valueOf(session.get("user_id"));
		String str_savedUserId = String.valueOf(session.get("saved_user_id"));
		boolean savedUserId = "null".equals(str_savedUserId) ? false : Boolean.valueOf(str_savedUserId);

		// (1)DB以外の保存領域に保持していた情報を削除する。
		session.clear();

		// (2)もし、savedUserId(=true)ならsessionに"user_id"に紐づくuserIdと
		// "saved_user_id"に紐づくsavedUserIdをsessionに格納する。
		if (savedUserId) {
			session.put("user_id", userId);
			session.put("saved_user_id", savedUserId);
		}

		// (3)ホーム画面に遷移する。
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
