
This app should be centered and used by a single professor to manage his classes.

<div align="center">
	<img src="./media/preliminary_modelization.svg">
</div>

# ⁠1. Pedagogical Structure

The structure is pretty straightforward. A specialty has sections which is divided in groups. Each group must have a teaching assistant.

<div align="center">
	<img src="./media/pedagogical_structure.svg">
</div>

## ⁠1.1. Student

| Column       |  Type  | Explanation                                                                  | Nullable |
| ------------ | :----: | ---------------------------------------------------------------------------- | -------- |
| name         |  TEXT  | duh                                                                          | NO       |
| surname      |  TEXT  | duh                                                                          | NO       |
| matricule    |  TEXT  | duh                                                                          | NO       |
| email        |  TEXT  | useful to keep track of                                                      | YES      |
| **group_id** | **FK** | **the group subsequently point to the section and specialty of the student** | **NO**   |

## ⁠1.2. Group

| Column                   | Type   | Explanation                                              | Nullable |
| ------------------------ | ------ | -------------------------------------------------------- | -------- |
| number                   | INT    | group number with the section                            | NO       |
| label                    | TEXT   | as in GL01 for "Group 01 Genie Logiciel"                 | NO       |
| **section_id**           | **FK** | **pointing to the section which just aggregates groups** | **NO**   |
| **teachingAssistant_id** | **FK** | **each group must have a TA**                            | **NO**   |

## ⁠1.3. Section

| Column           | Type    | Explanation                             | Nullable |
| ---------------- | ------- | --------------------------------------- | -------- |
| number           | INT     | the section number                      | NO       |
| **specialty_id** | **INT** | **a specialty is composed of sections** | **NO**   |

## ⁠1.4. Specialty

| Column   | Type | Explanation                                                                | Nullable |
| -------- | ---- | -------------------------------------------------------------------------- | -------- |
| name     | TEXT | specialty name e.g. "Intelligence Artificiel" or "Science et Technologies" | NO       |
| acronyme | TEXT | an abreviation of the name e.g. "AI" or "GL" for "Genie Logiciel"          | NO       |
| cycle    | TEXT | wether it's a Masters specialty or a Licence one                           | NO       |

## ⁠1.5. Teaching Assistant

| Column      | Type | Explanation | Nullable |
| ----------- | ---- | ----------- | -------- |
| name        | TEXT | duh         | NO       |
| surname     | TEXT | duh         | NO       |
| email       | TEXT | duh         | NO       |
| phoneNumber | TEXT | maybe?      | YES      |

# ⁠2. Curriculum Structure

Now this is where things start getting tricky. Each student is enrolled in many courses at the same time which belong to a semester. But there are also students who are retaking courses which do not belong in the semester they are currently studying in.

Most importantly, how do I know what semester the students are currently in? Where does time live here? Because I need that information to access the courses that they should be enrolled in.

<div align="center">
	<img src="./media/curriculum_structure.svg">
</div>
