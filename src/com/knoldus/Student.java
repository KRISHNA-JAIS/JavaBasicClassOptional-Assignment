package com.knoldus;

import java.util.Optional;

class Student {

    /**
     */
    String name;

    /**
     */
    int rollNumber;

    /**
     */
    Optional<String> subject;

    /**
     * @param studentName
     * @param studentRollNumber
     * @param studentSubject
     */
    Student(final String studentName,
                   final int studentRollNumber,
                   final Optional<String> studentSubject) {
        name = studentName;
        rollNumber = studentRollNumber;
        subject = studentSubject;
    }
}
