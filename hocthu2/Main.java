package hocthu2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "hieu", 20, "Nam", 40));
        students.add(new Student(2, "chinh", 18, "Nu", 75));
        students.add(new Student(3, "hoang", 21, "Nam", 90));
        students.add(new Student(4, "Nguyen", 19, "Nu", 60));
        students.add(new Student(5, "huong", 20, "Nu", 80));

        Function<List<Student>, Double> averageAge = (s) -> {
            double sum = 0;
            for (Student student : s) {
                sum += student.getAge();
            }
            return sum / s.size();
        };

        Function<List<Student>, Double> maxMark = (s) -> {
            double max = 0;
            for (Student student : s) {
                if (student.getMark() > max) {
                    max = student.getMark();
                }
            }
            return max;
        };

        Function<List<Student>, Double> minMark = (s) -> {
            double min = 100;
            for (Student student : s) {
                if (student.getMark() < min) {
                    min = student.getMark();
                }
            }
            return min;
        };

        Function<List<Student>, Double> modeMark = (s) -> {
            Map<Double, Integer> freq = new HashMap<>();
            for (Student student : s) {
                double mark = student.getMark();
                freq.put(mark, freq.getOrDefault(mark, 0) + 1);
            }
            double mode = 0;
            int maxFreq = 0;
            for (Map.Entry<Double, Integer> entry : freq.entrySet()) {
                if (entry.getValue() > maxFreq) {
                    mode = entry.getKey();
                    maxFreq = entry.getValue();
                }
            }
            return mode;
        };

        Predicate<Student> ageGreaterThan19 = (s) -> s.getAge() > 19;

        Predicate<Student> femaleStudent = (s) -> s.getGender().equals("Female");

        Predicate<Student> lowMark = (s) -> s.getMark() < 50;

        Predicate<Student> lastNameNguyen = (s) -> s.getName().split(" ")[0].equals("Nguyen");

        System.out.println("Tuổi trung bình: " + averageAge.apply(students));
        System.out.println("Điểm tối đa: " + maxMark.apply(students));
        System.out.println("Điểm tối thiểu: " + minMark.apply(students));
        System.out.println("Điểm phổ biến: " + modeMark.apply(students));

        System.out.println("Những người có tuổi lớn hơn 19:");
        printStudents(students, ageGreaterThan19);

        System.out.println("Những nữ sinh viên:");
        printStudents(students, femaleStudent);

        System.out.println("Sinh viên có điểm dưới 50:");
        printStudents(students, lowMark);

        System.out.println("Có tên Nguyen:");
        printStudents(students, lastNameNguyen);
    }

    public static void printStudents(List<Student> students, Predicate<Student> predicate) {
        for (Student student : students) {
            if (predicate.test(student)) {
                System.out.println(student.getId() + " " + student.getName() + " " + student.getAge() + " " + student.getGender() + " " + student.getMark());
            }
        }
    }

}
