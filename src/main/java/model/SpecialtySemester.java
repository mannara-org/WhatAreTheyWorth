package model;

import static orm.Constraints.UNDEFINED;

import java.util.Vector;

import orm.Constraints;
import orm.Table;

public class SpecialtySemester extends Table {

    static {
        registerModel(SpecialtySemester.class);
    }

    @Constraints(type = UNDEFINED, nullable = false, foreignKey = true)
    private Specialty specialty;
    @Constraints(type = UNDEFINED, nullable = false, foreignKey = true)
    private Semester semester;

    public Specialty getSpecialty() {
        return specialty;
    }

    public SpecialtySemester setSpecialty(Specialty specialty) {
        this.specialty = specialty;
        return this;
    }

    public Semester getSemester() {
        return semester;
    }

    public SpecialtySemester setSemester(Semester semester) {
        this.semester = semester;
        return this;
    }

    public static boolean isSearchable() {
        return isSearchable("SpecialtySemester");
    }

    public static Vector<Table> search() {
        return search(new SpecialtySemester());
    }

    public static Vector<Table> search(String attName, Object value) {
        return search("SpecialtySemester", attName, value);
    }

    public static Vector<Table> search(String boundedAttributeName, Object lowerBound, Object upperBound) {
        return search(new SpecialtySemester(), boundedAttributeName, lowerBound, upperBound);
    }

    public static Vector<Table> searchRanges(Vector<Range> boundedCriterias) {
        Vector<Table> tuples = new Vector<>();
        tuples.add(new SpecialtySemester());
        return search(tuples, boundedCriterias);
    }
}
