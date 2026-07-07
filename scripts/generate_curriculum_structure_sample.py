
import json

from hardcoded import SEMESTERS

with open('src/test/resources/samples/curriculum_structure.json', 'w') as f:
    json.dump(SEMESTERS, f, indent=2)
