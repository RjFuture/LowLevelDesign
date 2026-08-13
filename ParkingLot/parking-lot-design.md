# Parking Lot — LLD Design

## Class Diagram (as designed)

### ParkingLot
```
- parkingLotId : String
- floors : List<Floor>
- address : String
- gates : List<Gate>
- allowedVehicles : List<VehicleType>
- status : ParkingStatus
- pricingStrategy : PricingStrategy
- allocationStrategy : AllocationStrategy
```

### Floor
```
- floorId : int
- floorNo : String
- slots : List<ParkingSlot>
```

### ParkingSlot
```
- id : int
- slotNo : String
- spotType : ParkingSpotType      (⚠ was "Vehicle type : VEHICLETYPE" — see open items)
- slotStatus : SlotStatus
- vehicle : Vehicle
- floorNumber : int
```

### Gate
```
- gateType : GateType
- gateNumber : int
- operator : Operator
- gateStatus : GateStatus
```

### Vehicle
```
- vehicleType : VehicleType
- vehicleNumber : String
- ownerName : String
```

### Token (entry record, formerly "Ticket")
```
- tokenNumber : int
- entryTime : long
- vehicle : Vehicle
- gate : Gate
- parkingSlot : ParkingSlot
```

### Bill
```
- id : int
- amount : int
- exitTime : long
- token : Token
- operator : Operator
- payments : List<Payment>
- gate : Gate
```

### Payment
```
- id : int
- mode : PaymentMode
- status : PaymentStatus
- amountPaid : double
- bill : Bill
```

### User
```
- id : int
- name : String
- contact : String
- vehicles : List<Vehicle>
```

### Operator
```
- employeeId : String
- gate : Gate
```

### «interface» PricingStrategy
```
+ calculateFee(token : Token) : double
```

### «interface» AllocationStrategy
```
+ findSpot(vehicle : Vehicle, floors : List<Floor>) : ParkingSlot
```

---

## Relationships

| From | To | Type |
|---|---|---|
| ParkingLot | Floor | Composition (owns list of floors) |
| ParkingLot | Gate | Composition (owns list of gates) |
| ParkingLot | PricingStrategy | Association (delegates fee calc) |
| ParkingLot | AllocationStrategy | Association (delegates spot assignment) |
| Floor | ParkingSlot | Composition (owns list of slots) |
| ParkingSlot | Vehicle | Association (currently parked vehicle, if any) |
| Token | Vehicle | Association |
| Token | Gate | Association |
| Token | ParkingSlot | Association |
| Bill | Token | Association |
| Bill | Payment | Composition (one bill, its payments) |
| Payment | Bill | Association (back-reference) |
| Operator | Gate | Association |
| User | Vehicle | Composition/Aggregation (owns list of vehicles) |

---

## Open items / to revisit
- [ ] `ParkingSlot`'s type field should reference `ParkingSpotType` (Motorcycle/Compact/Large), not `VehicleType` — currently mismatched
- [ ] `pricingStrategy` / `allocationStrategy` fields on `ParkingLot` need explicit interface types shown
- [ ] `PricingStrategy` / `AllocationStrategy` interfaces need method signatures added
- [ ] `Bill` ↔ `Payment` bidirectional reference (`Bill` has `List<Payment>`, `Payment` has `bill`) — confirm this is intentional (supports partial/split payments) rather than redundant
- [ ] Decide whether `VehicleType` and `ParkingSpotType` need an explicit mapping (e.g. which vehicle types fit in which spot types) and where that logic lives — likely inside `AllocationStrategy`
