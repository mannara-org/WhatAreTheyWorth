
Let's take an approach where we start from the obvious and then derive what we need:

Let's start with the student:

```
student
    - name
    - surname
    - matricule
    - email
```

The group will basically represent the program that the student is enrolled in.

Then naturally we also get:

```
Group
	- label
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

<div align="center">
	<img src="./docs/media/preliminary_modelization.svg">
</div>
