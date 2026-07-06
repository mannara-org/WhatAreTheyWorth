
import json
import random

from hardcoded import SPECIALTIES
from faker import Faker


def gen_matricule():
    return str(random.randint(100_000_000_000, 999_999_999_999))


fake = Faker('fr_DZ')

specialties = []

for specialty_data in SPECIALTIES:

    sections = []
    specialty = {
        'name': specialty_data['name'],
        'acronyme': specialty_data['acronyme'],
        'cycle': specialty_data['cycle'],
        'sections': sections,
    }
    specialties.append(specialty)

    for section_number in range(1, specialty_data['nb_sections'] + 1):

        groups = []
        section = {
            'number': section_number,
            'groups': groups,
        }
        sections.append(section)

        for group_number in range(1, specialty_data['nb_groups_per_section'] + 1):

            students = []
            group = {
                'number': group_number,
                'students': students,
            }
            groups.append(group)

            for student_number in range(1, specialty_data['nb_students_per_group'] + 1):
                [surname, name] = fake.name().split(" ")
                student = {
                    'name': name,
                    'surname': surname,
                    'matricule': gen_matricule(),
                    'email': name + "." + surname + "@gmail.com",
                }
                students.append(student)


print(f"{specialties=}", end='\n\n')

with open('src/test/resources/samples/specialties.json', 'w') as f:
    json.dump(specialties, f, indent=2)
    pass
