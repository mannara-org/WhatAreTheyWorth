package model;

import orm.Constraints;
import orm.Table;

import static orm.Constraints.*;

import java.util.Vector;

public class Section extends Table {

    static {
        registerModel(Section.class);
    }

    @Constraints(type = UNDEFINED, nullable = false, foreignKey = true)
    private Specialty specialty;

    @Constraints(type = INT, nullable = false)
    private Integer number;

    public Section() {
    }

    public Section(Specialty specialty, Integer number) {
        this.specialty = specialty;
        this.number = number;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public Section setSpecialty(Specialty specialty) {
        this.specialty = specialty;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public static boolean isSearchable() {
        return isSearchable("Group");
    }

    public static Vector<Table> search() {
        return search(new Group());
    }

    public static Vector<Table> search(String attName, Object value) {
        return search("Group", attName, value);
    }

    public static Vector<Table> search(String boundedAttributeName, Object lowerBound, Object upperBound) {
        return search(new Group(), boundedAttributeName, lowerBound, upperBound);
    }

    public static Vector<Table> searchRanges(Vector<Range> boundedCriterias) {
        Vector<Table> tuples = new Vector<>();
        tuples.add(new Group());
        return search(tuples, boundedCriterias);
    }
}
