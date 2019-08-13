# Write your MySQL query statement below
# Runtime: 222 ms, faster than 63.85% of MySQL online submissions for Combine Two Tables.


SELECT Person.FirstName, Person.LastName, Address.City, Address.State 
FROM Person 
LEFT JOIN Address
ON Person.PersonId = Address.PersonId;
