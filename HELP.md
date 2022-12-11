# Read Me First


# Getting Started

This project saves information for each sevadar into a CSV file so that it can be imported later into actual database.
This is done at samagams to avoid network issues as it could take a lot of time to upload one sevadar into database or avoid timeout issues.


# How to Run
This is a simle Spring Boot project. It requires minimum Spring Boot 2.7.5 and JAVA 11.
* Import this project into IDE like IntellJ.
* Update below properties as per the needs in application.properties file located at ${projectDir}/src/main/resources
  * bslnd.seva.card.localdata.directoryPath - to store seavdar deatils as cvs
  * bslnd.seva.card.localdata.recordsPerFile - number od sevadars in one csv file
  * bslnd.seva.card.localdata.fileName - name of csv file which stores sevadars, it will be apppended with a random uuid at the end
  * bslnd.seva.card.uploads.directoryPath to store user documents like image etc
* Run Application.java in Intellij as by right click run. No extra config is needed.