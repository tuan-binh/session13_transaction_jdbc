package com.example.candidate_skill.dao;

import com.example.candidate_skill.entity.Candidates;

import java.sql.SQLException;

public interface ICandidateDao
{
	void addNewCandidate(Candidates candidates, Integer skillId) throws SQLException;
}
