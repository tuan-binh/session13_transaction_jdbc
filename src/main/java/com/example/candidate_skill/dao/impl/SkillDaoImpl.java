package com.example.candidate_skill.dao.impl;

import com.example.candidate_skill.dao.ISkillDao;
import com.example.candidate_skill.entity.Skills;
import com.example.candidate_skill.utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl implements ISkillDao
{
	@Override
	public List<Skills> findAll()
	{
		Connection con = ConnectionDB.openConnection();
		List<Skills> skills = new ArrayList<>();
		try
		{
			PreparedStatement ps = con.prepareStatement("select * from skills");
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				Skills skill = new Skills();
				skill.setId(rs.getInt("id"));
				skill.setName(rs.getString("name"));
				skills.add(skill);
			}
		}
		catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			ConnectionDB.closeConnection(con);
		}
		return skills;
	}
}
