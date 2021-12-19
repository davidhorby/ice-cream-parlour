# ice-cream-parlour
App for pricing ice creams of different flavours with types of different discounts. 

## Design
The concept of functional decomposition was used to isolate business rules allowing for unit testing of these functions

## Assumptions

 - Discounts apply to purchasing a further item. e.g. when buying two items which allow a discount you'd need to buy a third item on which that discount would apply
 - Discounts are applied to two decimal places


## Libraries
In addition to the standard Kotlin libraries, the following were also user:

 - JUnit 5 : for new features 
 - Hamcrest for Kotlin : for improved test assertions and messages

## Test
./gradlew clean test

## Build
./gradlew clean build

## Run
./gradlew run


