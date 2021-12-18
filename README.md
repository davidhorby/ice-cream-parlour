# ice-cream-parlour
App for pricing ice creams of different flavours with types of different discounts

## Design
The concept of functional decomposition was used to isolate business rules. 

This allows for unit testing of these functions in isolation

##Assumptions

 - Discounts apply to purchasing a further item. e.g. when buying two items which allow a discount you'd need to buy a third item on which that discount would apply
 - Discounts are applied to two decimal places


## Libraries
In addition to the standard Kotlin libraries, the following were also user:

 - JUnit 5 : for new features such a apramaterised tests
 - Hamcrest for Kotlin : for improved test assertions and messages

## Testing
./gradlew clean test

## Building
./gradlew clean build


