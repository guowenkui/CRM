package com.xmg.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmg.crm.domain.SystemLog;
import com.xmg.crm.mapper.SystemLogMapper;
import com.xmg.crm.service.ISystemLogService;

@Service
public class SystemLogServiceImpl implements ISystemLogService{
	
	@Autowired
	private SystemLogMapper dao;
	public int save(SystemLog log) {
		return dao.insert(log);
	}

}
