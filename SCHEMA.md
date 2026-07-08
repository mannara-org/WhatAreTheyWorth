
# Pedagogical Structure

## High-Level Schema

<div align="center">
	<img src="./media/pedagogical_structure.svg">
</div>

## Student

| Column       |  Type  | Explanation                                                                  | Nullable |
| ------------ | :----: | ---------------------------------------------------------------------------- | -------- |
| name         |  TEXT  | duh                                                                          | NO       |
| surname      |  TEXT  | duh                                                                          | NO       |
| matricule    |  TEXT  | duh                                                                          | NO       |
| email        |  TEXT  | useful to keep track of                                                      | YES      |
| **group_id** | **FK** | **the group subsequently point to the section and specialty of the student** | **NO**   |
## Group

| Column                   | Type   | Explanation                                              | Nullable |
| ------------------------ | ------ | -------------------------------------------------------- | -------- |
| number                   | INT    | group number with the section                            | NO       |
| label                    | TEXT   | as in GL01 for "Group 01 Genie Logiciel"                 | NO       |
| **section_id**           | **FK** | **pointing to the section which just aggregates groups** | **NO**   |
| **teachingAssistant_id** | **FK** | **each group must have a TA**                            | **NO**   |


```
Group
	- number
	- label ()
	- specialty (foreign key)
	- Teaching assistante (foreigh key)
Specialty
	- name
	- cycle
```

Deriving once again:

```
TA
	- name
	- surname

	- email
	- phone number
```

we also shouldn't forget about classes. Classes are important they are the thing that the grades depend on.

```
course
	- name

enrollment
	- student (foreign key)
	- course (foreign key)
```

thus yielding the following modelization:
