import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

	public static void main(String[] args) {

		List<Student> students = Arrays.asList(new Student(1, "Shiva", 60.0, 15), new Student(1, "Ravi", 75.0, 16),
				new Student(1, "Vikram", 80.0, 17), new Student(1, "Rohit", 55.0, 14));

		double findMarks = 75.0;
		List<Student> result = searchStudentByMarks(students, findMarks);
		System.out.println(result);
		Student response = findStudentWithMaximumAge(students);
		System.out.println(response);

	}

	private static Student findStudentWithMaximumAge(List<Student> students) {
		int maxAge = 0;
		Student student1 = null;

		for (Student student : students) {
			if (student.getAge() > maxAge) {
				student1 = student;
				maxAge = student.getAge();
			}
		}
		if (null != student1) {
			return student1;
		} else {
			return null;
		}
	}

	private static List<Student> searchStudentByMarks(List<Student> students, double findMarks) {

		List<Student> studentList = new ArrayList<>();
		for (Student student : students) {
			if (student.getMarks() == findMarks) {
				studentList.add(student);
			}
		}
		if (!studentList.isEmpty()) {
			return studentList;
		} else {
			return null;
		}
	}
	
}