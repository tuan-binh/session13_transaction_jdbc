package com.example.candidate_skill.services.impl;

import com.example.candidate_skill.dao.ISkillDao;
import com.example.candidate_skill.dao.impl.SkillDaoImpl;
import com.example.candidate_skill.entity.Skills;
import com.example.candidate_skill.services.ISkillService;

import java.util.List;

public class SkillServiceImpl implements ISkillService
{
	ISkillDao skillDao = new SkillDaoImpl();
	
	@Override
	public List<Skills> findAll()
	{
		return skillDao.findAll();
	}
}
