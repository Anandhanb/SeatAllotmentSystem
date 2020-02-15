# SeatAllotmentSystem
SeatAllotmentSystem prototype for Nokia

Please read this before using this application.

This is a POC or prototype of SeatAllotmentSystem so this will be continously updated with TestCases and features as needed and feasible.

Version:
--------
version : 2.0

System Requirement
-----------------
OS: Windwos or Linus
Language: Java 8.
Constraints:
-----------
>> This prototype supports only 2 usescases out of the 6.
    UsesCases:
     1. SeatClaimedByNewUser
     2. SeatChangeRequestInitiatedByOldUser_VacantSeat.
>> Only JavaAPIs are used no restapi or GUI those will be added in later point of time.
>> Uses simulater instead of DB data for prototyping purposes

Input/Start
-----------
>> Run App.class inside sas folder to run the system.

Sample Output:
------------

UseCase 1: New/User without a seat claiming a vacant seat
---------------------------------------------------------
SeatAllocationService:: User initiated seat claim
Admin notified of event: Seat: 2 claimed by new user 4
FacilityManager: updated seatId in User and userId in Seat
Admin notified of event: Migration for new user 4 to seat0 completed all assets transfered
Employee notified of event:Migration for new user 4 to seat0 completed all assets transfered
SeatAllocationService:: SeatChangeRequest sent
********************Complete********************

UseCase 2: Old user requesting a vacant seat.
---------------------------------------------
SeatAllocationService:: User initiated seat change
Admin notified of event: User 5 in seat 5 requested change to seat 3
Employee notified of event:User 5 in seat 5 requested change to seat 3
Admin notified of event: Admin approved user 5 seat change request to seat 3
FacilityManager: updated seatId in User and userId in Seat
Admin notified of event: Migration for user 5 to seat 5completed all assets transfered
Employee notified of event:Migration for user 5 to seat 5completed all assets transfered
Employee notified of event:Admin approved user 5 seat change request to seat 3
SeatAllocationService:: SeatChangeRequest sent and publisher notified
********************Complete********************



  
