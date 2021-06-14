# EmployeeProxy Service Project
Repository to communicate with "employee-db-manager" service and provide response to the HTTP requests.

## Configuration and Setup
## Local Host URL 
http://localhost:9000

## Resources and Endpoints
## Employee
### Add new employee. 
http://localhost:9000/addEmployee

Sample Response Body
````
{  
     "firstName": "John",
     "lastName": "Smith",
     "age": 24,
     "gender": "Male",
     "contactNumber": 1234567891,
     "emergencyContact": 1223455656,
     "currentAddress": {
        "houseNumber": 1,
        "streetName": "xyz test",
        "district": "tanjore",
        "state": "TN",
        "country": "Ind",
        "pinCode": 123456
     },
     "permanentAddress": {
         "houseNumber": 1,
         "streetName": "xyz test",
         "district": "tanjore",
         "state": "TN",
         "country": "Ind",
         "pinCode": 123456
    }
}
````

### GET all employee. 
http://localhost:9000/getAllEmployee

### GET all employee with maximum salary.
http://localhost:9000/getEmployeeWithMaxSalary
#### Query Params (Optional).
Integer year \
String month

Sample URL
http://localhost:9000/getEmployeeWithMaxSalary?year=2005&month=APRIL

### GET all employee count By given pinCode.
http://localhost:9000/getEmployeeCountByPincode/{pinCode}

### GET all employee count based on district.
http://localhost:9000/getEmployeeCountByDistrict

### GET all employee IDs based on given age range.
http://localhost:9000/getEmployeeByAgeRange
#### Query Params (Optional)
Integer start \
Integer end

Sample URL
http://localhost:9000/getEmployeeByAgeRange?start=20&end=40

### GET all employees with the least leaves count.
http://localhost:9000/getEmployeeWithLeastLeaves
