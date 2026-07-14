package model;

import orm.Constraints;
import orm.Table;

import static orm.Constraints.*;

public class AcademicLevel extends Table {

    static {
        registerModel(AcademicLevel.class);
    }

    @Constraints(type = INT, nullable = false, foreignKey = true)
    Specialty specialty;

    @Constraints(type = INT, nullable = false)
    Integer number;

    public AcademicLevel() {
    }

    public AcademicLevel(Specialty specialty, Integer number) {
        this.specialty = specialty;
        this.number = number;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public AcademicLevel setSpecialty(Specialty specialty) {
        this.specialty = specialty;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public AcademicLevel setNumber(Integer number) {
        this.number = number;
        return this;
    }

}
