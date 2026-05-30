# Optional

Optional saves us from the Pyramid of Doom

```java
// pyramid of doom
String status = null;
if (response != null) {
    Customer customer = response.getCustomer();
    if (customer != null) {
        Vehicle vehicle = customer.getVehicle();
        if (vehicle != null) {
            Fastag fastag = vehicle.getFastag();
            if (fastag != null) {
                status = fastag.getStatus();
            }
        }
    }
}

String status =
        Optional.ofNullable(response)
                .map(Response::getCustomer)
                .map(Customer::getVehicle)
                .map(Vehicle::getFastag)
                .map(Fastag::getStatus)
                .orElse(null);
```