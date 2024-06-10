ReadMe

Name: Leandra Da Silva

Student Number: ST10438375

Link to my GitHub repository: https://github.com/ST10438375-LeandraInaraFrancoDaSilva/MyWeatherApplication.git 

The Weather Application

This app looks forward promote an easy way for professionals inside of a forecast organization to store the maximum and minimum temperatures achieved on several days as well as weather conditions. It displays comprehensive details by the input of day, maximum temperature and minimum temperature both in gradus Celsius and condition of weather on the specific day, average of temperature is also displayed by adding the maximum and minimum one and dividing it by 2.
The app makes use of three pages, the first one is only responsible to direct users to the next page or exit the app, is the welcome one.
 
Once the start button is pressed the page responsible for taking the information inputted by the users takes place in there 4 details can be added by clicking in the add button, information can be cleared in order for other to be re-entered by clicking on the clear button, access to the next page is granted by clicking on the details button and the user can exit the app by clicking the exit button.
 
In this page toasts were also placed in order for users to interact more clearly with app, if information was missing the users would get a message on that, if it was successfully added another toast would take place and so on.
 
The third one is where the details inputted are displayed as well as the average, the user also gets to go back to the previous page by clicking in the respective button, the information is shown in a specific format stipulated in the code and the average calculated by a formula also placed there. 
 

 

Pseudocode:

// Declare variables for UI elements and data storage

DECLARE dayEditText AS EditText

DECLARE minTempEditText AS EditText

DECLARE maxTempEditText AS EditText

DECLARE weatherCondEditText AS EditText

DECLARE Day AS ArrayList of String

DECLARE MinTemp AS ArrayList of Int

DECLARE MaxTemp AS ArrayList of Int

DECLARE WeatherCond AS ArrayList of String

// Function called when activity is created

FUNCTION onCreate(savedInstanceState)

    CALL enableEdgeToEdge()
    
    SET the content view to activity_main2 layout
    
    SET padding for system bars using insets
    
    // Initialize EditText and Button elements
    
    SET dayEditText TO findViewById(R.id.dayEditText)
    
    SET minTempEditText TO findViewById(R.id.minTempEditText)
    
    SET maxTempEditText TO findViewById(R.id.maxTempEditText)
    
    SET weatherCondEditText TO findViewById(R.id.weatherCondEditText)
    
    SET detailsButton TO findViewById(R.id.detailsButton)
    
    SET addButton TO findViewById(R.id.addButton)
    
    SET clearButton TO findViewById(R.id.clearButton)
    
    SET exitButton2 TO findViewById(R.id.exitButton2)

    // Set onClick listener for addButton
    
    ON addButton CLICK
    
        CALL addData()

    // Set onClick listener for clearButton
    
    ON clearButton CLICK
    
        CALL clearData()

    // Set onClick listener for detailsButton to start a new activity
    
    ON detailsButton CLICK
    
        CREATE intent FOR MainActivity3
        
        ADD Day list to intent with key "Day Of the Week"
        
        ADD MinTemp list to intent with key "Minimum Temperature"
        
        ADD MaxTemp list to intent with key "Maximum Temperature"

        ADD WeatherCond list to intent with key "Weather Conditions"
        
        START MainActivity3 with intent

    // Set onClick listener for exitButton2 to finish the activity
    
    ON exitButton2 CLICK
    
        CALL finish()

// Function to add data from EditTexts to lists

FUNCTION addData()

    GET day FROM dayEditText
    
    GET minTemp FROM minTempEditText AS Integer
    
    GET maxTemp FROM maxTempEditText AS Integer
    
    GET weatherCond FROM weatherCondEditText

    // Check if all fields are filled correctly
    
    IF day IS NOT EMPTY AND minTemp IS NOT NULL AND maxTemp IS NOT NULL THEN
    
        ADD day TO Day list
        
        ADD minTemp TO MinTemp list
        
        ADD maxTemp TO MaxTemp list
        
        ADD weatherCond TO WeatherCond list

        CLEAR text in dayEditText
        
        CLEAR text in minTempEditText
        
        CLEAR text in maxTempEditText
        
        CLEAR text in weatherCondEditText

        SHOW toast "Information added successfully"
        
    ELSE
    
        SHOW toast "Please fill all fields correctly"

// Function to clear data from lists and EditTexts

FUNCTION clearData()

    CLEAR Day list
    
    CLEAR MinTemp list
    
    CLEAR MaxTemp list
    
    CLEAR WeatherCond list

    CLEAR text in dayEditText
    
    CLEAR text in minTempEditText
    
    CLEAR text in maxTempEditText
    
    CLEAR text in weatherCondEditText

    SHOW toast "Information cleared"
