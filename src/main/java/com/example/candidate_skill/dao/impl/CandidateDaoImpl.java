package com.example.candidate_skill.dao.impl;

import com.example.candidate_skill.dao.ICandidateDao;
import com.example.candidate_skill.entity.Candidates;
import com.example.candidate_skill.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class CandidateDaoImpl implements ICandidateDao
{
	@Override
	public void addNewCandidate(Candidates candidates, Integer skillId) throws SQLException
	{
		// mở kết nối
		Connection con = ConnectionDB.openConnection();
		try
		{
			con.setAutoCommit(false);
			CallableStatement call = con.prepareCall("{call INSERT_CANDIDATE(?,?,?,?,?,?)}");
			call.setString(1, candidates.getFirstName());
			call.setString(2, candidates.getLastName());
			call.setDate(3, new Date(candidates.getDob().getTime()));
			call.setString(4, candidates.getPhone());
			call.setString(5, candidates.getEmail());
			call.setInt(6, skillId);
			call.executeUpdate();
			con.commit();
		}
		catch (SQLException e)
		{
			con.rollback();
			throw new RuntimeException(e);
		}
		finally
		{
			ConnectionDB.closeConnection(con);
		}
	}
}
