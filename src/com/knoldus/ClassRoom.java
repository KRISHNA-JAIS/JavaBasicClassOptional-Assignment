package com.knoldus;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClassRoom {

    /**
     */
    private String roomId;

    /**
     */
    private Optional<List<Student>> studentList;

    /**
     * @param id
     * @param list
     */
    public ClassRoom(final String id,
                     final Optional<List<Student>> list) {
        roomId = id;
        studentList = list;
    }

    /**
     * @return withoutSubject
     */
    public List<Student> getStudentsWithoutSubjects() {
        List<Student> withoutSubject =
                studentList.get().stream().filter(student ->
                        student.subject.equals(
                                Optional.empty())).collect(Collectors.toList());
        return withoutSubject;
    }

    /**
     * @param id
     * @return distinctSubject
     */
    public  List<Optional<String>> getDistinctSubjectsByRoomId(
            final String id) {
        List<Optional<String>> distinctSubject =
                studentList.get().stream().filter(student ->
                                student.subject.isPresent())
                .map(student -> student.subject).distinct()
                .collect(Collectors.toList());
        return distinctSubject;
    }

    /**
     * @return "hello Student"
     */
    public String roomHasAssociatedStudents() {
        if (roomId != "" && studentList != null) {
            System.out.println("Room " + roomId + " has Student");
            return "hello Student";
        } else {
            return "No Student is Present";
        }
    }

    /**
     * @param args
     */
    public static void main(final String[] args) {

        int i;
        int studentWithoutSubjectSize;
        String str1;
        String str2;

        Student student1 =
                new Student("Krishna", 1, Optional.of("C"));
        Student student2 =
                new Student("Vijay", 2, Optional.empty());
        Student student3 =
                new Student("Rohit", 3, Optional.empty());
        Student student4 =
                new Student("Advik", 4, Optional.of("Java"));
        Student student5 =
                new Student("Shubham", 5, Optional.of("Python"));
        Student student6 =
                new Student("Govinda", 6, Optional.of("Python"));
        Student student7 =
                new Student("Gautam", 7, Optional.of("Javascript"));
        Student student8 =
                new Student("Naman", 8, Optional.of("Javascript"));
        Student student9 =
                new Student("Vishnu", 9, Optional.of("Javascript"));
        Student student10 =
                new Student("Vinish", 10, Optional.of("PHP"));
        Student student11 =
                new Student("Rohan", 10, Optional.of("PHP"));
        Student student12 =
                new Student("Shakti", 10, Optional.of("CSS"));


        Optional<List<Student>> studentList1 =
                Optional.of(Arrays.asList(
                        student1,
                        student2, student3, student4));

        Optional<List<Student>> studentList2 =
                Optional.of(Arrays.asList(
                        student5, student6, student7,
                        student8, student9, student10,
                        student11, student12));

        ClassRoom classRoom1 = new ClassRoom("abc", studentList1);

        ClassRoom classRoom2 = new ClassRoom("xyz", studentList2);

        List<Student> withoutSubject = classRoom1.getStudentsWithoutSubjects();

        studentWithoutSubjectSize = withoutSubject.size();

        System.out.println(
                "Students that have no subjects associated");
        for (i = 0; i <= studentWithoutSubjectSize - 1; i++) {
            System.out.println(withoutSubject.get(i).name);
        }

        str1 = classRoom1.roomHasAssociatedStudents();
        System.out.println(str1);
        System.out.println(
                "Unique subject list of the students in xyz");

        List<Optional<String>> studentList3 =
                classRoom2.getDistinctSubjectsByRoomId("xyz");

        System.out.println(studentList3);

        str2 = classRoom2.roomHasAssociatedStudents();
        System.out.println(str2);
    }
}
