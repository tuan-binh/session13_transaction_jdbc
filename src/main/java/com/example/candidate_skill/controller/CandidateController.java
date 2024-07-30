package com.example.candidate_skill.controller;

import com.example.candidate_skill.entity.Candidates;
import com.example.candidate_skill.services.ICandidateService;
import com.example.candidate_skill.services.ISkillService;
import com.example.candidate_skill.services.impl.CandidateServiceImpl;
import com.example.candidate_skill.services.impl.SkillServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CandidateController", value = "/candidate-controller")
public class CandidateController extends HttpServlet
{
	ISkillService skillService = new SkillServiceImpl();
	ICandidateService candidateService = new CandidateServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String action = req.getParameter("action");
		action = action == null ? "" : action;
		switch (action)
		{
			case "add":
			{
				req.setAttribute("skills", skillService.findAll());
				req.getRequestDispatcher("/WEB-INF/views/add_candidate.jsp").forward(req, resp);
				break;
			}
			case "edit":
			{
				break;
			}
			default:
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		action = action == null ? "" : action;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		switch (action)
		{
			case "add":
			{
				String firstName = req.getParameter("firstName");
				String lastName = req.getParameter("lastName");
				String dobString = req.getParameter("dob");
				Date dob;
				try
				{
					dob = sdf.parse(dobString);
				}
				catch (ParseException e)
				{
					throw new RuntimeException(e);
				}
				String phone = req.getParameter("phone");
				String email = req.getParameter("email");
				Integer skillId = Integer.parseInt(req.getParameter("skillId"));
				Candidates candidates = new Candidates(null, firstName, lastName, dob, phone, email);
				try
				{
					candidateService.addNewCandidate(candidates, skillId);
				}
				catch (SQLException e)
				{
					throw new RuntimeException(e);
				}
				break;
			}
			case "edit":
			{
				break;
			}
			default:
		}
	}
}
