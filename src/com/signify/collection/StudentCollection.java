/**
 * 
 */
package com.signify.collection;

import java.util.HashSet;
import java.util.Set;

import com.signify.bean.Student;

/**
 * @author BHAVISH
 *
 */
public class StudentCollection {
	
		Set<Student> studentDataset = new HashSet<>();
		public void add(Student stu)
		{
			studentDataset.add(stu);
		}
		public void print()
		{
			for(Student stu: studentDataset)
			{
				System.out.println(stu.getUserId());
				System.out.println(stu.getStudentName());
			}
		}

}
