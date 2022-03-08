package com.wvwv.mybatis01.dao;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wvwv.mybatis01.dto.ContentDTO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class ContentDaoTests {
	
	@Autowired
	private ContentDao dao;
	
	@Test
	public void testSelectTest() {
		
		ArrayList<Integer> mId = new ArrayList<Integer>();
		mId.add(2);
		mId.add(4);
		mId.add(6);
		
		ArrayList<ContentDTO> result = (ArrayList)dao.selectTest(mId);
	
		System.out.println(result.get(2));
	}
	
}
