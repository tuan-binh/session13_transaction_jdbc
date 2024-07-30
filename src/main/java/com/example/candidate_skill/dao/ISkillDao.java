package com.example.candidate_skill.dao;

import com.example.candidate_skill.entity.Skills;

import java.util.List;

public interface ISkillDao
{
	List<Skills> findAll();
}
