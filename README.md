
# Motivation

This is a professor aid tool to handle their day-to-day managing of student grades, attendance, homework, etc...

# Scope

The project should include:

- A list of students in each teaching day (could be customized, not rigid to a timetable or schedule) with their attendance status. A calendar as a primary view seems adequate.
- It should be fully excel compatible and should export to it.
- It should also handle test grades and homework. Assiduity should also be a metric somehow.
- I think all of this can be grouped using dates so 

# TODOs

## Pending

### GUI

- Engineer a mapping layer to map data types to their corresponding input UI

### ORM

- test the ORM with a new schema
	- Preliminary modelization of the new business purpose
	- Sample data generation 

## Done

- `./frontend/src/main/java/gui/util/Parser.java` does too much. Extract the string/name management into a separate class
    - FieldValueMapper
    - FieldLabelFormatter

- fix the `MyDialog` implementations

- Extract non-UI element classes out of the `gui` package

- Collapse the frontend/backend separation into a single project package
