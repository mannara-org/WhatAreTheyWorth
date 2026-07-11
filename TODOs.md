

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
