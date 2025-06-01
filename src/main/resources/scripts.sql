CREATE TABLE cab_driver (
    id INT PRIMARY KEY COMMENT 'Unique identifier for the cab driver',
    driver_name VARCHAR(100) NOT NULL,
    driver_address VARCHAR(250) NOT NULL UNIQUE,
    phone_number VARCHAR(15) NOT NULL UNIQUE,
    gender VARCHAR(1)
);

INSERT INTO cab_driver VALUES(1, 'Uppili', 'North Street, Thirubuvanam', '9876543210', 'M');
INSERT INTO cab_driver VALUES(2, 'Srini', 'North Street, Thirubuvanam', '9988776655', 'M');

CREATE TABLE cab (
    id INT PRIMARY KEY,
    reg_no VARCHAR(10) NOT NULL UNIQUE COMMENT 'Unique registration number of the cab',
    model_name VARCHAR(100) NOT NULL,
    no_of_seat INT NOT NULL,
    is_ac_available VARCHAR(1) NOT NULL DEFAULT 'N',
    CONSTRAINT cab_ac_chk CHECK (is_ac_available IN ('Y', 'N'))
);

INSERT INTO cab VALUES(1, 'TN45BQ1234', 'Maruti Suzuki Swift', 4, 'Y');
INSERT INTO cab VALUES(2, 'TN05AM5678', 'Hyundai Creta', 5, 'Y');

CREATE TABLE trip_details (
    id INT PRIMARY KEY,
    customer_name VARCHAR(250) NOT NULL COMMENT 'Name of the customer booking the trip',
    cab_id INT NOT NULL COMMENT 'cab id references cab(id)',
    driver_id INT NOT NULL COMMENT 'driver id references cab_driver(id)',
    trip_start_time DATETIME NOT NULL,
    trip_end_time DATETIME NOT NULL,
    meter_start BIGINT NOT NULL,
    meter_end BIGINT NOT NULL,
    trip_fare DECIMAL NOT NULL,
    trip_toll DECIMAL NOT NULL,
    other_charges DECIMAL NOT NULL COMMENT 'Any additional charges for the trip',
    description VARCHAR(250) COMMENT 'place of pickup and drop, customer notes, and other charges info',
    CONSTRAINT trip_cab_fk FOREIGN KEY (cab_id) REFERENCES cab(id),
    CONSTRAINT trip_driver_fk FOREIGN KEY (driver_id) REFERENCES cab_driver(id)
);

CREATE TABLE payment_details (
    id INT PRIMARY KEY,
    trip_id INT NOT NULL COMMENT 'trip id references trip_details(id)',
    payment_from VARCHAR(100) NOT NULL COMMENT 'Name of the person making the payment',
    payment_mode VARCHAR(4) NOT NULL COMMENT 'Mode of payment (CASH, CARD, UPI)',
    payment_status VARCHAR(1) NOT NULL COMMENT 'I - Initial, P - Partial, C - Completed, R - Returned',
    payment_time DATETIME NOT NULL,
    CONSTRAINT pmt_trip_fk FOREIGN KEY (trip_id) REFERENCES trip_details(id),
    CONSTRAINT pmt_mode_chk CHECK (payment_mode IN ('CASH', 'CARD', 'UPI')),
    CONSTRAINT pmt_status_chk CHECK (payment_status IN ('I','P','C','R'))
);