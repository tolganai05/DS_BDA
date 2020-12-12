#!/usr/bin/python

import random
from random import randint

AMOUNT_OF_RECORDS = 50
RESULT_FILE = "sample.txt"
PASSPORTS = [10045, 34563, 67893]

def get_passport_number():
    return randint(1, 1000)

def get_month() -> int:
    return randint(1, 12)

def get_salary() -> int:
    return randint(50, 1000)

def get_age():
    return randint(18, 70)

def get_trips():
    return randint(0, 10)

def gen_trips():
    passport = random.choice(PASSPORTS)
    month = get_month()
    salary = get_salary()
    age = get_age()
    trips = get_trips()
    trips_line   = '%s,%s,%s,%s,%s' % (passport, month, salary, age, trips)
    return trips_line

def generator():
    lines = []
    for i in range(0, AMOUNT_OF_RECORDS):
        trips = gen_trips()
        lines.append(trips)
    with open(RESULT_FILE, "w") as file:
        for i in lines:
            file.write(i + '\n')
    file.close()
    print("File '%s' generated." % (RESULT_FILE))


if __name__ == "__main__":
    print("Generating...")
    generator()
    print("Done")
``