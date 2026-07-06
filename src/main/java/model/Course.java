package model;

import orm.Constraints;
import orm.Table;

import static orm.Constraints.*;

import java.util.Vector;

public class Course extends Table {

    static {
        registerModel(Course.class);
    }

    @Constraints(type = TEXT, nullable = false, searchedText = true)
    private String name;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

    public static boolean isSearchable() {
        return isSearchable("Course");
    }

    public static Vector<Table> search() {
        return search(new Course());
    }

    public static Vector<Table> search(String attName, Object value) {
        return search("Course", attName, value);
    }

    public static Vector<Table> search(String boundedAttributeName, Object lowerBound, Object upperBound) {
        return search(new Course(), boundedAttributeName, lowerBound, upperBound);
    }

    public static Vector<Table> searchRanges(Vector<Range> boundedCriterias) {
        Vector<Table> tuples = new Vector<>();
        tuples.add(new Course());
        return search(tuples, boundedCriterias);
    }
}
