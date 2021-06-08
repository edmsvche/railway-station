CREATE TABLE IF NOT EXISTS category
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(64),
    function VARCHAR(256)
);
CREATE TABLE IF NOT EXISTS locomotive
(
    id           BIGSERIAL PRIMARY KEY,
    condition    VARCHAR(64) NOT NULL,
    numberWagons INTEGER,
    type         VARCHAR(64)
);
CREATE TABLE IF NOT EXISTS route
(
    id                 BIGSERIAL PRIMARY KEY,
    race               VARCHAR(64),
    mainStations       VARCHAR(256),
    initialDestination VARCHAR(256),
    finalDestination   VARCHAR(256)
);
CREATE TABLE IF NOT EXISTS users
(
    id       BIGSERIAL PRIMARY KEY,
    fullName VARCHAR(128),
    email    VARCHAR(128),
    password VARCHAR(128),
    role     VARCHAR(64),
    status   VARCHAR(64)
);
CREATE TABLE IF NOT EXISTS schedule
(
    id         BIGSERIAL PRIMARY KEY,
    arrivalDay     VARCHAR(64) NOT NULL,
    departureDay     VARCHAR(64) NOT NULL,
    arrivalDate       date             NOT NULL,
    departureDate       date             NOT NULL,
    locomotiveId    bigint,
    CONSTRAINT FK_LocomotiveSchedule FOREIGN KEY (locomotiveId )
        REFERENCES locomotive (id),
    routeId bigint,
    CONSTRAINT FK_RouteSchedule FOREIGN KEY (routeId)
        REFERENCES route (id)
);

CREATE TABLE IF NOT EXISTS ticket
(
    id         BIGSERIAL PRIMARY KEY,
    price     DOUBLE PRECISION NOT NULL,
    purchaseMethod     VARCHAR(64) NOT NULL,
    status     VARCHAR(64) NOT NULL,
    scheduleId    bigint,
    CONSTRAINT FK_TicketSchedule FOREIGN KEY (scheduleId)
        REFERENCES schedule (id)
);
CREATE TABLE IF NOT EXISTS repair
(
    id         BIGSERIAL PRIMARY KEY,
    kind     VARCHAR(64) NOT NULL,
    locomotiveId    bigint,
    CONSTRAINT FK_RepairLocomotive FOREIGN KEY (locomotiveId)
        REFERENCES locomotive(id)
);
CREATE TABLE IF NOT EXISTS preparation
(
    id         BIGSERIAL PRIMARY KEY,
    service     VARCHAR(64) NOT NULL,
    technical     VARCHAR(64) NOT NULL,
    locomotiveId    bigint,
    CONSTRAINT FK_PreparationLocomotive FOREIGN KEY (locomotiveId)
        REFERENCES locomotive(id)
);
CREATE TABLE IF NOT EXISTS passenger
(
    id         BIGSERIAL PRIMARY KEY,
    weightGoods     DOUBLE PRECISION NOT NULL,
    phone     VARCHAR(64) NOT NULL,
    fullName     VARCHAR(128) NOT NULL,
    luggageCompartment     VARCHAR(64) NOT NULL,
    ticketId    bigint,
    CONSTRAINT FK_PassengerTicket FOREIGN KEY (ticketId)
        REFERENCES ticket (id)
);
CREATE TABLE IF NOT EXISTS delay
(
    id         BIGSERIAL PRIMARY KEY,
    hoursSpent     DOUBLE PRECISION NOT NULL,
    cause     VARCHAR(64) NOT NULL,
    scheduleId    bigint,
    CONSTRAINT FK_DelaySchedule FOREIGN KEY (scheduleId)
        REFERENCES schedule (id)
);
CREATE TABLE IF NOT EXISTS department
(
    id         BIGSERIAL PRIMARY KEY,
    region    VARCHAR(256) NOT NULL,
    userId    bigint,
    CONSTRAINT FK_DepartmentUsers FOREIGN KEY (userId)
        REFERENCES users (id)
);
CREATE TABLE IF NOT EXISTS brigade
(
    id         BIGSERIAL PRIMARY KEY,
    type    VARCHAR(256) NOT NULL,
    locomotiveId    bigint,
    CONSTRAINT FK_BrigadeLocomotive FOREIGN KEY (locomotiveId )
        REFERENCES locomotive (id),
    departmentId bigint,
    CONSTRAINT FK_BrigadeDepartment FOREIGN KEY (departmentId)
        REFERENCES department (id)
);
CREATE TABLE IF NOT EXISTS employee
(
    id         BIGSERIAL PRIMARY KEY,
    age INTEGER NOT NULL,
    childrenNumber INTEGER NOT NULL,
    fullName    VARCHAR(256) NOT NULL,
    gender    VARCHAR(64) NOT NULL,
    salary DOUBLE PRECISION NOT NULL,
    skills   VARCHAR(256) NOT NULL,
    town    VARCHAR(256) NOT NULL,
    brigadeId    bigint,
    CONSTRAINT FK_EmployeeBrigade FOREIGN KEY (brigadeId )
        REFERENCES brigade (id),
    categoryId bigint,
    CONSTRAINT FK_EmployeeCategory FOREIGN KEY (categoryId)
        REFERENCES category (id)
);
CREATE TABLE IF NOT EXISTS examination
(
    id         BIGSERIAL PRIMARY KEY,
    date DATE NOT NULL,
    estimation    VARCHAR(64) NOT NULL,
    employeeId    bigint,
    CONSTRAINT FK_ExaminationEmployee FOREIGN KEY (employeeId)
        REFERENCES employee (id)
);