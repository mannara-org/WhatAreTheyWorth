
This app should be centered and used by a single professor to manage his classes.

All of this can become a lot really quickly. So it should help to define clearly each use case that the user will use this software in. Let's start by a simple list of what the user can do:

**Have multiple courses**
What does a 'course' mean? Will he teach a group of that course? I guess that in each course, he'll be able to manage multiple groups within it.

**Courses change with the semester**
Since the 'resit' sessions come at the end of the year that means that the software must operate on a year. What that means is that you should be able to manage courses according to the current semester of the cycle and specialty.

The selection menu would therefore work in the following order:

- Semester
- Course
	**Result:** list of groups that the user is responsible for in that specific course/semester!

- Section
- Group
	**Result:** list of students!


> [!important] Remark
since specialties can share courses among them there shouldn't be a separation by specialty.

## ⁠1. TL;DR Diagram

<div align="center">
	<img src="./media/preliminary_modelization.svg">
</div>

# ⁠2. Pedagogical Structure

The structure is pretty straightforward. A specialty has sections which is divided in groups. Each group must have a teaching assistant.

<div align="center">
	<img src="./media/pedagogical_structure.svg">
</div>

## ⁠2.1. Student

| Column       |  Type  | Explanation                                                                  | Nullable |
| ------------ | :----: | ---------------------------------------------------------------------------- | -------- |
| name         |  TEXT  | duh                                                                          | NO       |
| surname      |  TEXT  | duh                                                                          | NO       |
| matricule    |  TEXT  | duh                                                                          | NO       |
| email        |  TEXT  | useful to keep track of                                                      | YES      |
| **group_id** | **FK** | **the group subsequently point to the section and specialty of the student** | **NO**   |

## ⁠2.2. Group

| Column                   | Type   | Explanation                                              | Nullable |
| ------------------------ | ------ | -------------------------------------------------------- | -------- |
| number                   | INT    | group number with the section                            | NO       |
| label                    | TEXT   | as in GL01 for "Group 01 Genie Logiciel"                 | NO       |
| **section_id**           | **FK** | **pointing to the section which just aggregates groups** | **NO**   |
| **teachingAssistant_id** | **FK** | **each group must have a TA**                            | **NO**   |

## ⁠2.3. Section

| Column           | Type    | Explanation                             | Nullable |
| ---------------- | ------- | --------------------------------------- | -------- |
| number           | INT     | the section number                      | NO       |
| **specialty_id** | **INT** | **a specialty is composed of sections** | **NO**   |

## ⁠2.4. Specialty

| Column   | Type | Explanation                                                                | Nullable |
| -------- | ---- | -------------------------------------------------------------------------- | -------- |
| name     | TEXT | specialty name e.g. "Intelligence Artificiel" or "Science et Technologies" | NO       |
| acronyme | TEXT | an abreviation of the name e.g. "AI" or "GL" for "Genie Logiciel"          | NO       |
| cycle    | TEXT | wether it's a Masters specialty or a Licence one                           | NO       |

## ⁠2.5. Teaching Assistant

| Column      | Type | Explanation                                    | Nullable |
| ----------- | ---- | ---------------------------------------------- | -------- |
| name        | TEXT | duh                                            | NO       |
| surname     | TEXT | duh                                            | NO       |
| email       | TEXT | duh                                            | NO       |
| phoneNumber | TEXT | maybe? It would be useful we could annoy them! | YES      |

# ⁠3. Curriculum Structure

Now this is where things start getting tricky. Each student is enrolled in many courses at the same time which belong to a semester. A specialty's curriculum is defined by the semesters that compose the specialty.

It would seem at first that we can just enroll student in the courses that belong in the current semester but there are also students who are retaking courses which do not belong in the semester they are currently studying in. So the enrollment can't depend solely on the current semester.

Let's draw this much already:

<div align="center">
	<img src="./media/enrollment_structure.svg">
</div>

Now a professor should obviously work on the courses within the *current* semester. So we must automatically enroll students in all of the courses of the current semester that they should be enrolled in according to their group's specialty. But for that I must know which academic year and semester they are currently in to be able to enroll them.

The questions we must now answer is: where does time live here? Because I need that information to access the courses that they should be enrolled in. I need to know:

- **What academic year they're currently in:** via a new relation?
- **Their specialty:** I already have via their group

If I just add a table `academic_level`... or maybe it only needs to be a field within the `student` relation? The problem is that the `group` changes according to the academic level. the truth is that the `academic_level` is already assumed in

<div align="center">
	<img src="./media/pedagogical_structure.svg">
</div>

The `section` relation doesn't directly compose the specialty, it's the academic level that gives that to it. How do I model `L1`, `L2`, `L3`, etc...?

