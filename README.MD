# Longest Rectangular Sub-matrix in a Binary Matrix
Given a matrix consisting of 0s and 1s, you have to find the longest sub​matrix that contains only 1s.

## Building the application

1. Navigate to the root direcoty `web-clawler`.
2. On Linux or Mac, run `./gradlw clean build`. For windows `gradlew.bat clean build`. This will build the application.
3. Once the build is done, a uber jar will be created in `build/libs`.


## Running the application

We can run the application by using `java -jar build/libs/sub-matrix-finder-0.0.1-SNAPSHOT.jar`.

It will start the embedded Tomcat server on port `8080`.

The APIs can be quickly tested using Swagger which is available at `http://localhost:8080/swagger-ui.html`.

## APIs

The application exposes following REST endpoint:
* /api/v1/matrix

| Request | Http Method     | Response             |
| --------| :----- |:-------------:| -----:|
| Matrix  `{  "matrix": [ [ 0 ]  ]}` as body | POST     | Please see below for response details |

Response

|Code| Response example| Condition|
| :--------:| :------:|
| 200| ```{  "submatrix": {    "height": 0,    "width": 0,    "x": 0,    "y": 0  }}```| for all valid values|
| 400 | ``` "status": 400,"message": "Empty matrix..please input some data in matrix"}```| when matrix is empty|
|400 | ``` "status": 400,"message": "Matrix rows should contain same number of columns"}```| when the column size is varying for different rows

**_NOTE:_** I have used ```Lombok``` as for generating ```Getter, Setter and Constructors```. If plugin for it is not installed in your IDE(Eclipse or IntelliJ), please refer below link https://github.com/ahmadimt/javawithlombok
