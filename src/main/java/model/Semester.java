package model;

import orm.Constraints;
import orm.Table;

import static orm.Constraints.*;

import java.util.Vector;

public class Semester extends Table {

    static {
        registerModel(Semester.class);
    }

    public Semester() {
    }

    @Constraints(type = INT, nullable = false, foreignKey = true)
    Integer number;

    public Integer getNumber() {
        return number;
    }

    public Semester setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public static boolean isSearchable() {
        return isSearchable("Semester");
    }

    public static Vector<Table> search() {
        return search(new Semester());
    }

    public static Vector<Table> search(String attName, Object value) {
        return search("Semester", attName, value);
    }

    public static Vector<Table> search(String boundedAttributeName, Object lowerBound, Object upperBound) {
        return search(new Semester(), boundedAttributeName, lowerBound, upperBound);
    }

    public static Vector<Table> searchRanges(Vector<Range> boundedCriterias) {
        Vector<Table> tuples = new Vector<>();
        tuples.add(new Semester());
        return search(tuples, boundedCriterias);
    }
}
