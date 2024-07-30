package com.example.candidate_skill.entity;

public class CandidateSkills
{
	private Long candidateId;
	private Long skillId;
	
	public CandidateSkills()
	{
	}
	
	public CandidateSkills(Long candidateId, Long skillId)
	{
		this.candidateId = candidateId;
		this.skillId = skillId;
	}
	
	public Long getCandidateId()
	{
		return candidateId;
	}
	
	public void setCandidateId(Long candidateId)
	{
		this.candidateId = candidateId;
	}
	
	public Long getSkillId()
	{
		return skillId;
	}
	
	public void setSkillId(Long skillId)
	{
		this.skillId = skillId;
	}
}
