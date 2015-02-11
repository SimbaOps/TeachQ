package com.bignerdranch.android.clickerquestions.structs;

//Teacher is-a SchoolMember, so Teacher extends SchoolMember
public class Teacher extends SchoolMember {

    //Creates a new Teacher in the database
    public static Teacher createNew (String username, String password) {
        return new Teacher(username, password);
    }

    //private so no one can use this constructor,
    //only functions in this class can use it.
    //So the createNew function uses this.
    //This is just to clarify that you are creating a new Teacher in the database, not just a new
    //Teacher object
    private Teacher (String username, String password) {
        //call the parent classes constructor
        //Set the type parameter to teacher as this is a teacher
        super(username, password, SchoolType.TEACHER);
    }

    //Creates a Question with 5 possible multiple choice answers,
    public void createQuestion(MC5Question question) {
        //Will create a qeustion on parse
    }
}
