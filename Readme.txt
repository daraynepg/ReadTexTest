                                 # Java Read Text


	## What is it?
	--------------

       ReadTex is an application programmed in java, with the objective of searching for information contained in a file,
       taking into account several search parameters, say ID or CITY. This application returns the data in STDOUT.

	## Input data Sample, stored in a *.txt file
	----------------------------------------
        F1
        D Erica Burns,BARCELONA,93654902Y
        D Lucy Mcgee,LONDON,51011156P
        F2
        D Mitchell Newton ; LAS VEGAS ; 25384390-A
        D Margarita Richards ; NEW YORK ; 09877359-D

	### Requirements
	    java jdk 1.8 must be installed

	## Usage
        java -jar data-reader.jar {FILE} CITY {CITY_NAME} → Will print the list of names and ID's belonging to people that have been in that city
        java -jar data-reader.jar {FILE} ID {ID_VALUE} → (ID format example for input: 12345678Z) → Will print the list of cities that this person has been to.


    ## Tests
    ---------------------
    All methods was tested, some problems are detected in all the functionalities, were corrected in a second iteration where the code was modified.
    the methods were planned beforehand, where the results that they had to offer were established, starting from there the code was elaborated.

	## Autor
	    Darayne Pérez González
