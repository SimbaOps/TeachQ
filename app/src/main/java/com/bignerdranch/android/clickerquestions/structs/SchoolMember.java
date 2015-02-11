package com.bignerdranch.android.clickerquestions.structs;

//Abstract means that you can't write new SchoolMember(...),
//This class is not meant to be instantiated but rather
//Used as a super class for Teacher and Student to put all their
//shared code in one place
public abstract class SchoolMember {
    //this creates a new SchoolMember in the database,
    //it is protected because only classes that inherit from SchoolMember
    //should be able to use it
    protected SchoolMember(String username, String password, SchoolType type) {

    }
}
