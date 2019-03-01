package com.vignet.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vignet.bo.VisitorsBO;

import com.vignet.dao.VisitordaoImpl;
import com.vignet.dao.VisitorsDAO;
import com.vignet.dto.VisitorsDTO;

public class SignUpService implements VisitorInterface {

	VisitorsDAO dao = null;

	public SignUpService() {
		// create visitor dao object
		dao = new VisitordaoImpl();
	}

	@Override
	public int result(VisitorsDTO dto) throws Exception {

		int count = 0;
		VisitorsBO bo = null;

		// prepare bo class obj having persistance data
		bo = new VisitorsBO();

		// validate name
		///String s1 = validateString(dto.getName());
		//if (s1.equalsIgnoreCase("right"))
			bo.setName(dto.getName());

		// validate mobile no
		//String s = validateMobile(dto.getMno());
		//if (s.equalsIgnoreCase("right"))
			bo.setMno(dto.getMno());

		bo.setName(dto.getName());
		bo.setMno(dto.getMno());
		bo.setUname(dto.getUname());
		bo.setPass(dto.getPass());
		bo.setRePass(dto.getRePass());
		bo.setRole(dto.getRole());

		// use DAO
		count = dao.insert(bo);
		System.out.println("SignUpService.result()" + count);
		return count;

	}
/*
	public String validateMobile(String mno) {

		System.out.println("SignUpService.validateMobile()");
		if ((mno.length() < 10) || (mno.length() > 10) || mno.contains("[a-z]")) {
			System.out.println("insert valid mobile no");
			mno = "wrong";
		} else {
			mno = "right";
		}
		return mno;
	}

	// validate String
	public String validateString(String s) {
		Pattern p = Pattern.compile("[^A-Za-z]");
		Matcher m = p.matcher(s);
		boolean b = m.find();

		String ss = null;

		if (s == null || s.trim().isEmpty()) {
			System.out.println("name could not be empty");
			System.out.println("Please enter valid name");

			s = "wrong";

		} else if (b == true) {
			s = "wrong";
		} else {
			s = "right";
		}
		return s;
	}
*/
}
