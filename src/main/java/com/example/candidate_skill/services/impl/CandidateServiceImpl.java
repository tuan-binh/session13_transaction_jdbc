package com.example.candidate_skill.services.impl;

import com.example.candidate_skill.dao.ICandidateDao;
import com.example.candidate_skill.dao.impl.CandidateDaoImpl;
import com.example.candidate_skill.entity.Candidates;
import com.example.candidate_skill.services.ICandidateService;

import java.sql.SQLException;

public class CandidateServiceImpl implements ICandidateService
{
	ICandidateDao candidateDao = new CandidateDaoImpl();
	
	@Override
	public void addNewCandidate(Candidates candidates, Integer skillId) throws SQLException
	{
		candidateDao.addNewCandidate(candidates, skillId);
	}
}
